package com.github.azeroth.game.domain.phasing;


import com.badlogic.gdx.utils.IntMap;
import com.github.azeroth.game.condition.Condition;
import com.github.azeroth.game.domain.object.ObjectGuid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class PhaseShift {
    public PhaseShiftFlag flags;
    ;
    public ObjectGuid personalGuid = ObjectGuid.EMPTY;
    public IntMap<PhaseRef> phases = new IntMap<>();
    public IntMap<VisibleMapIdRef> visibleMapIds = new IntMap<>(10);
    public IntMap<UiMapPhaseIdRef> uiMapPhaseIds = new IntMap<>(10);
    public int personalReferences;
    public boolean isDbPhaseShift;

    private int nonCosmeticReferences;
    private int cosmeticReferences;
    private int defaultReferences;

    public final boolean getHasPersonalPhase() {
        for (var phaseRef : phases.values()) {
            if (phaseRef.isPersonal()) {
                return true;
            }
        }

        return false;
    }


    public final boolean addPhase(int phaseId, PhaseFlag flags, ArrayList<Condition> areaConditions) {
        return addPhase(phaseId, flags, areaConditions, 1);
    }

    public final boolean addPhase(int phaseId, PhaseFlag flags, ArrayList<Condition> areaConditions, int references) {
        var newPhase = false;

        if (!phases.containsKey(phaseId)) {
            newPhase = true;
            phases.put(phaseId, new PhaseRef(flags, null));
        }

        var phase = phases.get(phaseId);
        modifyPhasesReferences(phaseId, phase, references);

        if (areaConditions != null) {
            phase.areaConditions = areaConditions;
        }

        return newPhase;
    }

    public final boolean removePhase(int phaseId) {
        var phaseRef = phases.get(phaseId);

        if (phaseRef != null) {
            modifyPhasesReferences(phaseId, phaseRef, -1);

            if (phaseRef.references == 0) {
                phases.remove(phaseId);

                return true;
            }
        }

        return false;
    }


    public final boolean addVisibleMapId(int visibleMapId, TerrainSwapInfo visibleMapInfo) {
        return addVisibleMapId(visibleMapId, visibleMapInfo, 1);
    }

    public final boolean addVisibleMapId(int visibleMapId, TerrainSwapInfo visibleMapInfo, int references) {
        if (visibleMapIds.containsKey(visibleMapId)) {
            return false;
        }

        visibleMapIds.put(visibleMapId, new VisibleMapIdRef(references, visibleMapInfo));

        return true;
    }

    public final boolean removeVisibleMapId(int visibleMapId) {
        if (visibleMapIds.containsKey(visibleMapId)) {
            var mapIdRef = visibleMapIds.get(visibleMapId);

            if ((--mapIdRef.references) == 0) {
                visibleMapIds.remove(visibleMapId);

                return true;
            }
        }

        return false;
    }


    public final boolean addUiMapPhaseId(int uiMapPhaseId) {
        return addUiMapPhaseId(uiMapPhaseId, 1);
    }

    public final boolean addUiMapPhaseId(int uiMapPhaseId, int references) {
        if (uiMapPhaseIds.containsKey(uiMapPhaseId)) {
            return false;
        }

        uiMapPhaseIds.put(uiMapPhaseId, new UiMapPhaseIdRef(references));

        return true;
    }

    public final boolean removeUiMapPhaseId(int uiWorldMapAreaId) {
        if (uiMapPhaseIds.containsKey(uiWorldMapAreaId)) {
            var value = uiMapPhaseIds.get(uiWorldMapAreaId);

            if ((--value.references) == 0) {
                uiMapPhaseIds.remove(uiWorldMapAreaId);

                return true;
            }
        }

        return false;
    }

    public final void clear() {
        clearPhases();
        visibleMapIds.clear();
        uiMapPhaseIds.clear();
    }

    public final void clearPhases() {
        flags = PhaseShiftFlag.forValue(flags.getValue() & PhaseShiftFlag.ALWAYSVISIBLE.getValue() | PhaseShiftFlag.INVERSE.getValue());
        personalGuid.clear();
        phases.clear();
        nonCosmeticReferences = 0;
        cosmeticReferences = 0;
        personalReferences = 0;
        defaultReferences = 0;
        updateUnphasedFlag();
    }

    public final boolean canSee(PhaseShift other) {
        if (flags.hasFlag(PhaseShiftFlag.UNPHASED) && other.flags.hasFlag(PhaseShiftFlag.UNPHASED)) {
            return true;
        }

        if (flags.hasFlag(PhaseShiftFlag.ALWAYSVISIBLE) || other.flags.hasFlag(PhaseShiftFlag.ALWAYSVISIBLE)) {
            return true;
        }

        if (flags.hasFlag(PhaseShiftFlag.INVERSE) && other.flags.hasFlag(PhaseShiftFlag.INVERSE)) {
            return true;
        }

        var excludePhasesWithFlag = phaseFlags.NONE;

        if (flags.hasFlag(PhaseShiftFlag.NOCOSMETIC) && other.flags.hasFlag(PhaseShiftFlag.NOCOSMETIC)) {
            excludePhasesWithFlag = phaseFlags.COSMETIC;
        }

        if (!flags.hasFlag(PhaseShiftFlag.INVERSE) && !other.flags.hasFlag(PhaseShiftFlag.INVERSE)) {
            var ownerGuid = personalGuid;
            var otherPersonalGuid = other.personalGuid;

            return phases.Intersect(other.phases, (myPhase, otherPhase) ->
            {
                if (myPhase.key != otherPhase.key) {
                    return false;
                }

                return !myPhase.value.flags.hasFlag(excludePhasesWithFlag) && (!myPhase.value.flags.hasFlag(phaseFlags.PERSONAL) || Objects.equals(ownerGuid, otherPersonalGuid));
            }).Any();
        }

        var checkInversePhaseShift = (PhaseShift arg1, PhaseShift arg2) ->
        {
            if (phaseShift.flags.hasFlag(PhaseShiftFlag.UNPHASED) && excludedPhaseShift.flags.hasFlag(PhaseShiftFlag.INVERSEUNPHASED)) {
                return false;
            }

            for (var pair : phaseShift.phases) {
                if (pair.value.flags.hasFlag(excludePhasesWithFlag)) {
                    continue;
                }

                var ExcludedPhaseRef = excludedPhaseShift.phases.get(pair.key);

                if (ExcludedPhaseRef != null || !ExcludedPhaseRef.flags.hasFlag(excludePhasesWithFlag)) {
                    return false;
                }
            }

            return true;
        };

        if (other.flags.hasFlag(PhaseShiftFlag.INVERSE)) {
            return checkInversePhaseShift.invoke(this, other);
        }

        return checkInversePhaseShift.invoke(other, this);
    }

    public final void modifyPhasesReferences(int phaseId, PhaseRef phaseRef, int references) {
        phaseRef.references += references;

        if (!isDbPhaseShift) {
            if (phaseRef.flags.hasFlag(phaseFlags.COSMETIC)) {
                cosmeticReferences += references;
            } else if (phaseId != 169) {
                nonCosmeticReferences += references;
            } else {
                defaultReferences += references;
            }

            if (phaseRef.flags.hasFlag(phaseFlags.PERSONAL)) {
                personalReferences += references;
            }

            if (cosmeticReferences != 0) {
                flags = PhaseShiftFlag.forValue(flags.getValue() | PhaseShiftFlag.NOCOSMETIC.getValue());
            } else {
                flags = PhaseShiftFlag.forValue(flags.getValue() & ~PhaseShiftFlag.NOCOSMETIC.getValue());
            }

            updateUnphasedFlag();
            updatePersonalGuid();
        }
    }

    public final void updateUnphasedFlag() {
        var unphasedFlag = !flags.hasFlag(PhaseShiftFlag.INVERSE) ? PhaseShiftFlag.Unphased : PhaseShiftFlag.INVERSEUNPHASED;
        flags = PhaseShiftFlag.forValue(flags.getValue() & ~(!flags.hasFlag(PhaseShiftFlag.INVERSE) ? PhaseShiftFlag.InverseUnphased : PhaseShiftFlag.UNPHASED).getValue());

        if (nonCosmeticReferences != 0 && defaultReferences == 0) {
            flags = PhaseShiftFlag.forValue(flags.getValue() & ~unphasedFlag.getValue());
        } else {
            flags = PhaseShiftFlag.forValue(flags.getValue() | unphasedFlag.getValue());
        }
    }

    public final boolean hasPhase(int phaseId) {
        return phases.containsKey(phaseId);
    }

    public final boolean hasVisibleMapId(int visibleMapId) {
        return visibleMapIds.containsKey(visibleMapId);
    }

    public final HashMap<Integer, VisibleMapIdRef> getVisibleMapIds() {
        return visibleMapIds;
    }

    public final boolean hasUiWorldMapAreaIdSwap(int uiWorldMapAreaId) {
        return uiMapPhaseIds.containsKey(uiWorldMapAreaId);
    }

    private void updatePersonalGuid() {
        if (personalReferences == 0) {
            personalGuid.clear();
        }
    }
}
