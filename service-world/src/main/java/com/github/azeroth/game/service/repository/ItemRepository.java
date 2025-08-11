package com.github.azeroth.game.service.repository;


import com.github.azeroth.game.domain.misc.SystemText;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ItemRepository {

    @Query("SELECT Id, FlagsCu, FoodType, MinMoneyLoot, MaxMoneyLoot, SpellPPMChance, RandomBonusListTemplateId, QuestLogItemId FROM item_template_addon")
    Stream<int[]> streamAllItemTemplateAddons();
}
