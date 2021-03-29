package com.rainbowland.proto.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RaceClassAvailability {

    private int raceID;//uint8
    private List<ClassAvailability> classes;


    @Data
    @Builder
   public static class ClassAvailability {
       private int classID = 0;//uint8
       private int activeExpansionLevel = 0;//uint8
       private int accountExpansionLevel = 0;//uint8
   }

}
