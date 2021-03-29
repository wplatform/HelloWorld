package com.rainbowland.service.realm;

import com.rainbowland.service.auth.AuthService;
import com.rainbowland.service.auth.domain.BuildInfo;
import com.rainbowland.service.auth.domain.Realmlist;
import com.rainbowland.utils.SecureUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@RequiredArgsConstructor
public class LocalRealmManager implements RealmManager {

    private final AuthService authService;

    private final CopyOnWriteArrayList<RealmBuildInfo> builds = new CopyOnWriteArrayList<>();

    private final ConcurrentHashMap<RealmKey, Realm> realmMap = new ConcurrentHashMap<>();


    @Override
    public RealmBuildInfo getBuildInfo(int build) {
        return builds.stream().filter(v -> v.getBuild() == build).findFirst().orElse(null);
    }

    @Override
    public Set<RealmKey> realmKeys() {
        return realmMap.keySet();
    }

    @Override
    public Realm getRealmByKey(RealmKey key) {
        return realmMap.get(key);
    }

    public void init() {
        loadRealmBuildInfo().zipWith(loadRealmList(),(v1,v2)-> {
            v1.forEach(builds::add);
            v2.forEach(this::addRealm);
            return Void.TYPE;
        }).subscribe();
    }


    public Mono<List<RealmBuildInfo>> loadRealmBuildInfo() {
        return authService.select(BuildInfo.class).all()
                .map(v -> {
                    RealmBuildInfo realmBuildInfo = new RealmBuildInfo();
                    realmBuildInfo.setBuild(v.getBuild().intValue());
                    realmBuildInfo.setBugfixVersion(v.getBugfixVersion());
                    realmBuildInfo.setMinorVersion(v.getMinorVersion());
                    realmBuildInfo.setMajorVersion(v.getMajorVersion());

                    char[] hotfixVersion = new char[RealmBuildInfo.HOTFIX_VERSION_LENGTH];
                    String vHotfixVersion = v.getHotfixVersion();
                    if (StringUtils.hasText(vHotfixVersion)) {
                        char[] chars = vHotfixVersion.toCharArray();
                        System.arraycopy(chars, 0, hotfixVersion, 0, Math.min(chars.length, hotfixVersion.length));
                    }
                    realmBuildInfo.setHotfixVersion(hotfixVersion);

                    byte[] win64AuthSeed = Optional.ofNullable(v.getWin64AuthSeed())
                            .map(SecureUtils::hexStringToByteArray)
                            .filter(e -> e.length == RealmBuildInfo.AUTH_SEED_LENGTH)
                            .orElse(null);
                    realmBuildInfo.setWin64AuthSeed(win64AuthSeed);

                    byte[] mac64AuthSeed = Optional.ofNullable(v.getMac64AuthSeed())
                            .map(SecureUtils::hexStringToByteArray)
                            .filter(e -> e.length == RealmBuildInfo.AUTH_SEED_LENGTH)
                            .orElse(null);
                    realmBuildInfo.setMac64AuthSeed(mac64AuthSeed);
                    return realmBuildInfo;
                }).collectList()
                .doOnError(throwable -> log.error("Load realm build info error.", throwable));
    }

    public Mono<List<Realm>> loadRealmList() {
        return authService.select(Query.query(Criteria.where("flag").not(3)), Realmlist.class)
                .map(v -> {
                    Realm realm = new Realm();
                    realm.setId(RealmKey.createRealmKey(v.getRegion().byteValue(), v.getBattlegroup().byteValue(), v.getId().intValue()));
                    realm.setBuild(v.getGamebuild().intValue());
                    realm.setName(v.getName());
                    realm.setExternalAddress(toInetAddress(v.getAddress()));
                    realm.setLocalAddress(toInetAddress(v.getLocalAddress()));
                    realm.setLocalSubnetMask(toInetAddress(v.getLocalSubnetMask()));
                    int icon = v.getIcon() == null ? 0 : v.getIcon();
                    icon = icon == Realm.REALM_TYPE_FFA_PVP ? Realm.REALM_TYPE_PVP : icon;
                    icon = icon >= Realm.REALM_TYPE_FFA_PVP ? Realm.REALM_TYPE_NORMAL : icon;
                    realm.setType(icon);
                    realm.setTimezone(v.getTimezone());
                    realm.setAllowedSecurityLevel(v.getAllowedSecurityLevel());
                    realm.setPort(v.getPort());
                    realm.setPopulationLevel(v.getPopulation());
                    return realm;
                }).doOnNext(realm -> {
                    log.info("Load realm {} {}:{}", realm.getName(), realm.getExternalAddress(), realm.getPort());
                }).collectList()
                .doOnError(throwable -> {
                    log.error("Load realm error.", throwable);
                });
    }

    private InetAddress toInetAddress(String hostName) {
        try {
            return Inet4Address.getByName(hostName);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(e);
        }
    }


    private void addRealm(Realm realm) {
        realmMap.put(realm.getId(), realm);
    }


}
