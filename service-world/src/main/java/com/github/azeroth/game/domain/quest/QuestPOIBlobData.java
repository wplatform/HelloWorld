package com.github.azeroth.game.domain.quest;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestPOIBlobData {
    public int questID;
    public int idx1;
    public int blobIndex;
    public int objectiveIndex;
    public int questObjectiveID;
    public int questObjectID;
    public int mapID;
    public int uiMapID;
    public int priority;
    public int floor;
    public int flags;
    public int worldEffectID;
    public int playerConditionID;
    public int navigationPlayerConditionID;
    public int spawnTrackingID;
    @Transient
    public List<QuestPOIBlobPoint> points;
    public boolean alwaysAllowMergingBlobs;
}
