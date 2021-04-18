package com.rainbowland.enums;

//To all Immune system, if target has immunes,
//some spell that related to ImmuneToDispel or ImmuneToSchool or ImmuneToDamage type can't cast to it,
//some spell_effects that related to ImmuneToEffect<effect>(only this effect in the spell) can't cast to it,
//some aura(related to Mechanics or ImmuneToState<aura>) can't apply to it.
public enum SpellImmunity {
    IMMUNITY_EFFECT,                     // public enum SpellEffects
    IMMUNITY_STATE,                     // public enum AuraType
    IMMUNITY_SCHOOL,                     // public enum SpellSchoolMask
    IMMUNITY_DAMAGE,                     // public enum SpellSchoolMask
    IMMUNITY_DISPEL,                     // public enum DispelType
    IMMUNITY_MECHANIC,                     // public enum Mechanics
    IMMUNITY_ID,
    MAX_SPELL_IMMUNITY
}
