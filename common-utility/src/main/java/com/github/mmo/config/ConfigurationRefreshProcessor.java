package com.github.mmo.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBean;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindHandlerAdvisor;
import org.springframework.boot.context.properties.bind.*;
import org.springframework.boot.context.properties.bind.handler.IgnoreErrorsBindHandler;
import org.springframework.boot.context.properties.bind.handler.IgnoreTopLevelConverterNotFoundBindHandler;
import org.springframework.boot.context.properties.bind.handler.NoUnboundElementsBindHandler;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.boot.context.properties.source.UnboundElementsSourceFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.Assert;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
public class ConfigurationRefreshProcessor implements BeanPostProcessor, ApplicationContextAware, ApplicationListener<ConfigurationRefreshEvent> {

    private ApplicationContext applicationContext;
    private MutablePropertySources propertySources;
    private Binder binder;


    private final Map<String, ConfigurationPropertiesBean> refreshBeans = new HashMap<>();


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (hasReBoundValueObject(beanName)) {
            ConfigurationPropertiesBean propertiesBean = ConfigurationPropertiesBean.get(this.applicationContext, bean, beanName);
            if (propertiesBean != null) {
                refreshBeans.put(propertiesBean.getAnnotation().prefix(), propertiesBean);
            }
        }
        return bean;
    }

    @Override
    public void onApplicationEvent(ConfigurationRefreshEvent event) {
        Map<String, Object> source = event.getSource();
        propertySources.addFirst(new MapPropertySource(event.getFileName(), source));
        refreshBeans.forEach((prefix, bean) -> {
            List<Map.Entry<String, Object>> updatedKeyValue = source.entrySet().stream().filter(e -> e.getKey().startsWith(prefix)).collect(Collectors.toList());
            log.debug("Refresh the Configuration properties {} whit {}", bean.getInstance().getClass().getName(), updatedKeyValue);
            if (!updatedKeyValue.isEmpty()) {
                bind(bean);
            }
        });


    }

    private boolean hasReBoundValueObject(String beanName) {
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) this.applicationContext.getAutowireCapableBeanFactory();

        if (!registry.containsBeanDefinition(beanName)) {
            return false;
        }

        BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
        if (beanDefinition instanceof AnnotatedBeanDefinition annotated) {

            boolean present = annotated.getMetadata().getAnnotations().isPresent(RefreshableValue.class);

            Boolean presentOnBeanFactory = Optional.ofNullable(annotated.getFactoryMethodMetadata())
                    .map(AnnotatedTypeMetadata::getAnnotations)
                    .map(e -> e.isPresent(RefreshableValue.class)).orElse(false);

            if (!present && !presentOnBeanFactory) {
                return false;
            }

            return !BindMethod.VALUE_OBJECT.equals(beanDefinition.getAttribute(BindMethod.class.getName()));

        }

        return false;

    }

    private void bind(ConfigurationPropertiesBean bean) {
        if (bean == null) {
            return;
        }
        Assert.state(bean.asBindTarget().getBindMethod() != BindMethod.VALUE_OBJECT,
                "Cannot bind @ConfigurationProperties for bean '" + bean.getName()
                        + "'. Ensure that @ConstructorBinding has not been applied to regular bean");
        try {
            Bindable<?> target = bean.asBindTarget();
            ConfigurationProperties annotation = bean.getAnnotation();
            BindHandler bindHandler = getBindHandler(target, annotation);
            getBinder().bind(annotation.prefix(), target, bindHandler);
        } catch (Exception ex) {
            throw new RuntimeException("Refresh " + bean + " values error", ex);
        }
    }


    private Binder getBinder() {
        if (this.binder == null) {
            this.binder = new Binder(getConfigurationPropertySources(), getPropertySourcesPlaceholdersResolver(),
                    getConversionServices(), getPropertyEditorInitializer(), null, null);
        }
        return this.binder;
    }


    private <T> BindHandler getBindHandler(Bindable<T> target, ConfigurationProperties annotation) {
        BindHandler handler = getHandler();
        if (annotation.ignoreInvalidFields()) {
            handler = new IgnoreErrorsBindHandler(handler);
        }
        if (!annotation.ignoreUnknownFields()) {
            UnboundElementsSourceFilter filter = new UnboundElementsSourceFilter();
            handler = new NoUnboundElementsBindHandler(handler, filter);
        }

        for (ConfigurationPropertiesBindHandlerAdvisor advisor : getBindHandlerAdvisors()) {
            handler = advisor.apply(handler);
        }
        return handler;
    }

    private IgnoreTopLevelConverterNotFoundBindHandler getHandler() {
        return new IgnoreTopLevelConverterNotFoundBindHandler();
    }

    private Iterable<ConfigurationPropertySource> getConfigurationPropertySources() {
        return ConfigurationPropertySources.from(propertySources);
    }

    private PropertySourcesPlaceholdersResolver getPropertySourcesPlaceholdersResolver() {
        return new PropertySourcesPlaceholdersResolver(this.propertySources);
    }

    private List<ConversionService> getConversionServices() {
        String beanName = ConfigurableApplicationContext.CONVERSION_SERVICE_BEAN_NAME;
        boolean hasUserDefinedConfigurationServiceBean = this.applicationContext.containsBean(beanName) && this.applicationContext.getAutowireCapableBeanFactory()
                .isTypeMatch(beanName, ConversionService.class);
        if (hasUserDefinedConfigurationServiceBean) {
            return Collections.singletonList(this.applicationContext
                    .getBean(ConfigurableApplicationContext.CONVERSION_SERVICE_BEAN_NAME, ConversionService.class));
        }
        if (this.applicationContext instanceof ConfigurableApplicationContext configurableContext) {
            List<ConversionService> conversionServices = new ArrayList<>();
            if (configurableContext.getBeanFactory().getConversionService() != null) {
                conversionServices.add(configurableContext.getBeanFactory().getConversionService());
            }
            return conversionServices;
        }
        return null;
    }

    private Consumer<PropertyEditorRegistry> getPropertyEditorInitializer() {
        if (this.applicationContext instanceof ConfigurableApplicationContext configurableContext) {
            return configurableContext.getBeanFactory()::copyRegisteredEditorsTo;
        }
        return null;
    }


    private List<ConfigurationPropertiesBindHandlerAdvisor> getBindHandlerAdvisors() {
        return this.applicationContext.getBeanProvider(ConfigurationPropertiesBindHandlerAdvisor.class)
                .orderedStream()
                .toList();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        Configuration.getInstance().setReloadEventPublisher(applicationContext);
        Environment environment = this.applicationContext.getEnvironment();
        if (environment instanceof ConfigurableEnvironment configurableEnvironment) {
            this.propertySources = configurableEnvironment.getPropertySources();
        }
    }
}


