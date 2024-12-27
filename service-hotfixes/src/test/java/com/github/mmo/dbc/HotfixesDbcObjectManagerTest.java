package com.github.mmo.dbc;

import com.github.mmo.hotfixes.HotfixesDbcObjectManager;
import com.github.mmo.dbc.domain.SpellPower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HotfixesDbcObjectManagerTest.class)
@SpringBootApplication
class HotfixesDbcObjectManagerTest {
    @Autowired
    HotfixesDbcObjectManager hotfixesDbcObjectManager;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("spring.config.location", "../test-resources/etc/worldserver.conf");
    }

    @Test
    void loadEntityStores() {
        //hotfixesDbcObjectManager.loadEntityStores(Set.of(DbcObjects.PlayerCondition));
        hotfixesDbcObjectManager.loadDbcObjects();
        SpellPower spellPower = hotfixesDbcObjectManager.spellPower(11507);
        Assertions.assertNotNull(spellPower);
        Assertions.assertEquals(212613, spellPower.getRequiredAuraSpellID());

    }
}