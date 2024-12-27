package com.github.mmo.game.scripting.interfaces.igroup;

import com.github.mmo.game.group.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IGroupOnInviteMember extends IScriptObject
{
	void onInviteMember(PlayerGroup group, ObjectGuid guid);
}
