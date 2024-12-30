package com.github.mmo.game;


import java.util.ArrayList;

public class QuestPOIBlobData {
    public int blobIndex;
    public int objectiveIndex;
    public int questObjectiveID;
    public int questObjectID;
    public int mapID;
    public int uiMapID;
    public int priority;
    public int flags;
    public int worldEffectID;
    public int playerConditionID;
    public int navigationPlayerConditionID;
    public int spawnTrackingID;
    public ArrayList<QuestPOIBlobPoint> points;
    public boolean alwaysAllowMergingBlobs;

    public QuestPOIBlobData(int blobIndex, int objectiveIndex, int questObjectiveID, int questObjectID, int mapID, int uiMapID, int priority, int flags, int worldEffectID, int playerConditionID, int navigationPlayerConditionID, int spawnTrackingID, ArrayList<QuestPOIBlobPoint> points, boolean alwaysAllowMergingBlobs) {
        this.blobIndex = blobIndex;
        this.objectiveIndex = objectiveIndex;
        this.questObjectiveID = questObjectiveID;
        this.questObjectID = questObjectID;
        this.mapID = mapID;
        this.uiMapID = uiMapID;
        this.priority = priority;
        this.flags = flags;
        this.worldEffectID = worldEffectID;
        this.playerConditionID = playerConditionID;
        this.navigationPlayerConditionID = navigationPlayerConditionID;
        this.spawnTrackingID = spawnTrackingID;
        this.points = points;
        this.alwaysAllowMergingBlobs = alwaysAllowMergingBlobs;
    }
}
