package com.rainbowland.service.realm;

import java.util.Set;

public interface RealmManager {

    RealmBuildInfo getBuildInfo(int build);


    Set<RealmKey> realmKeys();


    Realm getRealmByKey(RealmKey key);



}
