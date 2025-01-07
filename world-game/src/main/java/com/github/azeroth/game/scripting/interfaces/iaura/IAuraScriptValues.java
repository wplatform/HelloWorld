package com.github.azeroth.game.scripting.interfaces.iaura;

import com.github.azeroth.game.scripting.interfaces.IAuraScript;

import java.util.HashMap;


public interface IAuraScriptValues extends IAuraScript {
    HashMap<String, object> getScriptValues();
}
