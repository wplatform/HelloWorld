package com.github.azeroth.defines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class PlayerClassMask {


    public static final PlayerClassMask ALL_PLAYABLE = PlayerClassMask.of(
            (1 << (PlayerClass.WARRIOR.ordinal() - 1))
                    | (1 << (PlayerClass.PALADIN.ordinal() - 1))
                    | (1 << (PlayerClass.HUNTER.ordinal() - 1))
                    | (1 << (PlayerClass.ROGUE.ordinal() - 1))
                    | (1 << (PlayerClass.PRIEST.ordinal() - 1))
                    | (1 << (PlayerClass.DEATH_KNIGHT.ordinal() - 1))
                    | (1 << (PlayerClass.SHAMAN.ordinal() - 1))
                    | (1 << (PlayerClass.MAGE.ordinal() - 1))
                    | (1 << (PlayerClass.WARLOCK.ordinal() - 1))
                    | (1 << (PlayerClass.MONK.ordinal() - 1))
                    | (1 << (PlayerClass.DRUID.ordinal() - 1))
                    | (1 << (PlayerClass.DEMON_HUNTER.ordinal() - 1))
    );


    public static final PlayerClassMask WAND_USERS = PlayerClassMask.of(
            (1 << (PlayerClass.PRIEST.ordinal() - 1))
                    | (1 << (PlayerClass.MAGE.ordinal() - 1))
                    | (1 << (PlayerClass.WARLOCK.ordinal() - 1))
    );



    private int rawValue;

    public boolean hasPlayerClass(PlayerClass klass) {
        return (rawValue & (1 << (klass.ordinal() -1))) != 0;
    }

    public boolean hasPlayerClassMask(int allowableClasses) {
        return (rawValue & allowableClasses) != 0;
    }

    public boolean hasPlayerClassMask(PlayerClassMask right) {
        return (rawValue & right.rawValue) != 0;
    }

    public static PlayerClassMask of(int rawValue) {
        return new PlayerClassMask(rawValue);
    }


    public boolean isEmpty() {
        return rawValue == 0;
    }
}
