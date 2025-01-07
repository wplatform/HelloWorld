package com.github.azeroth.net.http;

import com.github.azeroth.net.router.Router;
import io.netty.handler.codec.http.HttpMethod;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpServerRouter extends Router<HttpServerRouter, HttpServerRequest, HttpServerResponse> {

    static HttpServerRouter newRoutes() {
        return new HttpServerRouter();
    }


    public HttpServerRouter delete(String path, BiConsumer<? super HttpServerRequest, ? super HttpServerResponse> handler) {
        return http(HttpMethod.DELETE, path, handler);
    }


    public HttpServerRouter directory(String uri, Path directory) {
        return directory(uri, directory, null);
    }


    public HttpServerRouter directory(String uri, Path directory, Function<HttpServerResponse, HttpServerResponse> interceptor) {
        Path absPath = directory.toAbsolutePath().normalize();
        return route(req -> {
            String target = uri.startsWith("/") ? uri : "/".concat(uri);
            return HttpMethod.GET.equals(req.method()) && req.uri().startsWith(target);
        }, (req, resp) -> {
            String prefix = URI.create(req.uri()).getPath().replaceFirst(uri, "");
            if (!prefix.isEmpty() && prefix.charAt(0) == '/') {
                prefix = prefix.substring(1);
            }

            Path p = absPath.resolve(prefix).toAbsolutePath().normalize();
            if (Files.isReadable(p) && p.startsWith(absPath)) {

                if (interceptor != null) {
                    interceptor.apply(resp).sendFile(p);
                }
                resp.sendFile(p);
            }
            resp.sendNotFound();
        });
    }

    public HttpServerRouter file(String uri, Path path) {
        return file(uri, path, null);
    }

    public HttpServerRouter file(String uri, String path) {
        return file(uri, Paths.get(path), null);
    }


    public HttpServerRouter file(String uri, Path path, Function<HttpServerResponse, HttpServerResponse> interceptor) {
        return route(request -> HttpMethod.GET.equals(request.method()) && new UriPathTemplate(uri).matches(request.uri()), (req, resp) -> {
            if (interceptor != null) {
                interceptor.apply(resp).sendFile(path);
            }
            resp.sendFile(path);
        });
    }


    public HttpServerRouter get(String path, BiConsumer<? super HttpServerRequest, ? super HttpServerResponse> handler) {
        return http(HttpMethod.GET, path, handler);
    }


    public HttpServerRouter head(String path, BiConsumer<? super HttpServerRequest, ? super HttpServerResponse> handler) {
        return http(HttpMethod.HEAD, path, handler);
    }


    public HttpServerRouter index(final BiConsumer<? super HttpServerRequest, ? super HttpServerResponse> handler) {
        return route(req -> {
            URI uri = URI.create(req.uri());
            return Objects.equals(req.method(), HttpMethod.GET) && (uri.getPath().endsWith("/") || uri.getPath().indexOf('.', uri.getPath().lastIndexOf('/')) == -1);
        }, handler);
    }


    public HttpServerRouter options(String path, BiConsumer<? super HttpServerRequest, ? super HttpServerResponse> handler) {
        return http(HttpMethod.OPTIONS, path, handler);
    }


    public HttpServerRouter post(String path, BiConsumer<? super HttpServerRequest, ? super HttpServerResponse> handler) {
        return http(HttpMethod.POST, path, handler);
    }


    public HttpServerRouter put(String path, BiConsumer<? super HttpServerRequest, ? super HttpServerResponse> handler) {
        return http(HttpMethod.PUT, path, handler);
    }

    private HttpServerRouter http(HttpMethod httpMethod, String path, BiConsumer<? super HttpServerRequest, ? super HttpServerResponse> handler) {
        Objects.requireNonNull(httpMethod, "httpMethod");
        Objects.requireNonNull(path, "path");
        Objects.requireNonNull(handler, "handler");
        UriPathTemplate uriPathTemplate = new UriPathTemplate(path);
        Function<String, Map<String,String>> paramsResolver = uriPathTemplate::match;
        BiConsumer<? super HttpServerRequest, ? super HttpServerResponse> newHandler = (req, resp) -> handler.accept(req.paramsResolver(paramsResolver),resp);
        return route(request -> httpMethod.equals(request.method()) && uriPathTemplate.matches(request.uri()), newHandler);
    }


    static final class UriPathTemplate {

        private static final Pattern FULL_SPLAT_PATTERN = Pattern.compile("[*][*]");
        private static final String FULL_SPLAT_REPLACEMENT = ".*";

        private static final Pattern NAME_SPLAT_PATTERN = Pattern.compile("\\{([^/]+?)}[*][*]");

        private static final Pattern NAME_PATTERN = Pattern.compile("\\{([^/]+?)}");
        // JDK 6 doesn't support named capture groups

        private static final Pattern URL_PATTERN = Pattern.compile("(?:(\\w+)://)?(\\[.+?]|(?<!\\[)[^/?]+?)(?::(\\d{2,5}))?([/?].*)?");

        private final List<String> pathVariables = new ArrayList<>();

        private final Pattern uriPattern;

        private static String getNameSplatReplacement(String name) {
            return "(?<" + name + ">.*)";
        }

        private static String getNameReplacement(String name) {
            return "(?<" + name + ">[^\\/]*)";
        }

        static String filterQueryParams(String uri) {
            int hasQuery = uri.lastIndexOf('?');
            if (hasQuery != -1) {
                return uri.substring(0, hasQuery);
            } else {
                return uri;
            }
        }

        static String filterHostAndPort(String uri) {
            if (uri.startsWith("/")) {
                return uri;
            } else {
                Matcher matcher = URL_PATTERN.matcher(uri);
                if (matcher.matches()) {
                    String path = matcher.group(4);
                    return path == null ? "/" : path;
                } else {
                    throw new IllegalArgumentException("Unable to parse url [" + uri + "]");
                }
            }
        }

        UriPathTemplate(String uriPattern) {
            String s = "^" + filterQueryParams(filterHostAndPort(uriPattern));

            Matcher m = NAME_SPLAT_PATTERN.matcher(s);
            while (m.find()) {
                for (int i = 1; i <= m.groupCount(); i++) {
                    String name = m.group(i);
                    pathVariables.add(name);
                    s = m.replaceFirst(getNameSplatReplacement(name));
                    m.reset(s);
                }
            }

            m = NAME_PATTERN.matcher(s);
            while (m.find()) {
                for (int i = 1; i <= m.groupCount(); i++) {
                    String name = m.group(i);
                    pathVariables.add(name);
                    s = m.replaceFirst(getNameReplacement(name));
                    m.reset(s);
                }
            }

            m = FULL_SPLAT_PATTERN.matcher(s);
            while (m.find()) {
                s = m.replaceAll(FULL_SPLAT_REPLACEMENT);
                m.reset(s);
            }

            this.uriPattern = Pattern.compile(s + "$");
        }

        public boolean matches(String uri) {
            return matcher(uri).matches();
        }


        final Map<String, String> match(String uri) {
            Map<String, String> pathParameters = HashMap.newHashMap(pathVariables.size());

            Matcher m = matcher(uri);
            if (m.matches()) {
                int i = 1;
                for (String name : pathVariables) {
                    String val = m.group(i++);
                    pathParameters.put(name, val);
                }
            }
            return pathParameters;
        }

        private Matcher matcher(String uri) {
            uri = filterQueryParams(filterHostAndPort(uri));
            return uriPattern.matcher(uri);
        }

    }

}
