package com.github.mmo.game.service.mapper;

import com.github.mmo.defines.SharedDefine;
import com.github.mmo.game.service.model.misc.NpcText;
import com.github.mmo.game.service.model.reputation.RepSpilloverTemplate;
import org.springframework.jdbc.core.RowMapper;

public interface RowMappers {

    RowMapper<RepSpilloverTemplate> REP_SPILLOVER_TEMPLATE_RESULT_SET_EXTRACTOR = (rs, rowNum) -> {
        RepSpilloverTemplate repTemplate = new RepSpilloverTemplate();
        int index = 1;
        repTemplate.factionId = rs.getInt(index++);
        repTemplate.faction[0] = rs.getInt(index++);
        repTemplate.factionRate[0] = rs.getFloat(index++);
        repTemplate.factionRank[0] = rs.getInt(index++);
        repTemplate.faction[1] = rs.getInt(index++);
        repTemplate.factionRate[1] = rs.getFloat(index++);
        repTemplate.factionRank[1] = rs.getInt(index++);
        repTemplate.faction[2] = rs.getInt(index++);
        repTemplate.factionRate[2] = rs.getFloat(index++);
        repTemplate.factionRank[2] = rs.getInt(index++);
        repTemplate.faction[3] = rs.getInt(index++);
        repTemplate.factionRate[3] = rs.getFloat(index++);
        repTemplate.factionRank[3] = rs.getInt(index++);
        repTemplate.faction[4] = rs.getInt(index++);
        repTemplate.factionRate[4] = rs.getFloat(index++);
        repTemplate.factionRank[4] = rs.getInt(index++);
        return repTemplate;
    };


    RowMapper<NpcText> NPC_TEXT_SET_EXTRACTOR = (rs, rowNum) -> {
        NpcText npcText = new NpcText();
        npcText.id = rs.getInt(1);
        for (int i = 0; i < SharedDefine.MAX_NPC_TEXT_OPTIONS; ++i) {
            npcText.data[i].probability = rs.getFloat(2 + i);
            npcText.data[i].broadcastTextID = rs.getInt(2 + SharedDefine.MAX_NPC_TEXT_OPTIONS + i);
        }
        return npcText;
    };
}
