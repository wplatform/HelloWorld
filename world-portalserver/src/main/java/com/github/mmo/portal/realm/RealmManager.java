package com.github.mmo.portal.realm;

import java.util.Set;

public interface RealmManager {

    ClientBuild getBuildInfo(int build);


    Set<RealmKey> realmKeys();


    Realm getRealmByKey(RealmKey key);



}