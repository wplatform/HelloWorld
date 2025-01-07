package com.github.azeroth.game.scripting.interfaces;


import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.spell.*;

public interface IAuraScript extends IBaseSpellScript {
    Aura getAura();

    Difficulty getCastDifficulty();

    Unit getCaster();

    ObjectGuid getCasterGUID();

    int getDuration();

    void setDuration(int duration);

    GameObject getGObjCaster();

    int getId();

    int getMaxDuration();

    void setMaxDuration(int value);

    WorldObject getOwner();

    SpellInfo getSpellInfo();

    byte getStackAmount();

    Unit getTarget();

    AuraApplication getTargetApplication();

    Unit getOwnerAsUnit();

    boolean isExpired();

    AuraEffect getEffect(byte effIndex);

    SpellEffectInfo getEffectInfo(int effIndex);

    boolean hasEffect(byte effIndex);

    boolean modStackAmount(int num);

    boolean modStackAmount(int num, AuraRemoveMode removeMode);

    void preventDefaultAction();

    void remove();

    void remove(AuraRemoveMode removeMode);

    void setDuration(int duration, boolean withMods);

    void _FinishScriptCall();

    boolean _IsDefaultActionPrevented();

    boolean _Load(Aura aura);

    void _PrepareScriptCall(AuraScriptHookType hookType);

    void _PrepareScriptCall(AuraScriptHookType hookType, AuraApplication aurApp);
}
