package com.github.azeroth.game.scripting;


import com.github.azeroth.game.domain.misc.WaypointNode;
import com.github.azeroth.game.domain.misc.WaypointPath;
import com.github.azeroth.game.ai.UnitAI;
import com.github.azeroth.game.chat.Channel;
import com.github.azeroth.game.entity.areatrigger.AreaTrigger;
import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.extendability.*;
import com.github.azeroth.game.group.PlayerGroup;
import com.github.azeroth.game.guild.Guild;
import com.github.azeroth.game.movement.SplineChainLink;
import com.github.azeroth.game.scripting.activators.IScriptActivator;
import com.github.azeroth.game.scripting.interfaces.IClassRescriction;
import com.github.azeroth.game.scripting.interfaces.IScriptAutoAdd;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;
import com.github.azeroth.game.scripting.interfaces.iareatrigger.IAreaTriggerScriptLoaderGetTriggerScriptScript;
import com.github.azeroth.game.scripting.interfaces.iaura.IAuraScriptLoaderGetAuraScript;
import com.github.azeroth.game.scripting.interfaces.iplayer.*;
import com.github.azeroth.game.scripting.interfaces.ispell.ISpellScriptLoaderGetSpellScript;
import com.github.azeroth.game.scripting.registers.IScriptRegister;
import com.github.azeroth.game.spell.Aura;
import com.github.azeroth.game.spell.Spell;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


// Manages registration, loading, and execution of Scripts.
public class ScriptManager {
    private final ArrayList<IScriptObject> blankList = new ArrayList<>();

    // creature entry + chain ID
    private final MultiMap<Tuple<Integer, SHORT>, SplineChainLink> mSplineChainsMap = new MultiMap<Tuple<Integer, SHORT>, SplineChainLink>(); // spline chains

    private final HashMap<class,HashMap<PlayerClass, ArrayList<IScriptObject>>>scriptClassByType =new HashMap<class,HashMap<PlayerClass, ArrayList<IScriptObject>>>();
    private final HashMap<class,ArrayList<IScriptObject>>scriptByType =new HashMap<class,ArrayList<IScriptObject>>();
    private final HashMap<class,ScriptRegistry>scriptStorage =new HashMap<class,ScriptRegistry>();
    private final HashMap<Integer, waypointPath> waypointStore = new HashMap<Integer, waypointPath>();
    private int scriptCount;

    private ScriptManager() {
    }

    private static void registerActivators(HashMap<String, IScriptActivator> activators, Class type) {
        if (IOHelpers.doesTypeSupportInterface(type, IScriptActivator.class)) {
            var asa = (IScriptActivator) type.newInstance();

            for (var t : asa.getScriptBaseTypes()) {
                activators.put(t, asa);
            }
        }
    }

    private static void registerRegistors(HashMap<class, IScriptRegister>registers, Class type) {
        if (IOHelpers.doesTypeSupportInterface(type, IScriptRegister.class)) {
            var newReg = (IScriptRegister) type.newInstance();
            registers.put(newReg.getAttributeType(), newReg);
        }
    }


    ///#region Main Script API

    //Initialization
    public final void initialize() {
        var oldMSTime = System.currentTimeMillis();

        loadDatabase();

        Log.outInfo(LogFilter.ServerLoading, "Loading C# scripts");

        fillSpellSummary();

        //Load Scripts.dll
        loadScripts();

        // MapScripts
        global.getMapMgr().AddSC_BuiltInScripts();

        Log.outInfo(LogFilter.ServerLoading, String.format("Loaded %1$s C# scripts in %2$s ms", getScriptCount(), time.GetMSTimeDiffToNow(oldMSTime)));
    }

    //AreaTriggerScript
    public final boolean onAreaTrigger(Player player, AreaTriggerRecord trigger, boolean entered) {
        if (entered) {
            for (var script : global.getObjectMgr().getAreaTriggerScriptIds(trigger.id)) {
                return RunScriptRet < IAreaTriggerOnTrigger > (a -> a.OnTrigger(player, trigger),script);
            }
        } else {
            for (var script : global.getObjectMgr().getAreaTriggerScriptIds(trigger.id)) {
                return RunScriptRet < IAreaTriggerOnExit > (p -> p.OnExit(player, trigger),script);
            }
        }

        return false;
    }

    public final <T extends IScriptObject> void forEach(tangible.Action1Param<T> a) {
        TValue ifaceImp;
        if (scriptByType.containsKey(T.class) && (ifaceImp = scriptByType.get(T.class)) == ifaceImp) {
            for (T s : ifaceImp) {
                try {
                    a.invoke(s);
                } catch (RuntimeException ex) {
                    Log.outException(ex, "");
                }
            }
        }
    }

    public final <T extends IScriptObject & IClassRescriction> void forEach(PlayerClass playerClass, tangible.Action1Param<T> a) {
        TValue classKvp;
        if (scriptClassByType.containsKey(T.class) && (classKvp = scriptClassByType.get(T.class)) == classKvp) {
            var ifaceImp;

            if (classKvp.TryGetValue(playerClass, out ifaceImp)) {
                for (T s : ifaceImp) {
                    try {
                        a.invoke(s);
                    } catch (RuntimeException ex) {
                        Log.outException(ex, "");
                    }
                }
            }

            var ifaceImpNone;

            if (classKvp.TryGetValue(playerClass.NONE, out ifaceImpNone)) {
                for (T s : ifaceImpNone) {
                    try {
                        a.invoke(s);
                    } catch (RuntimeException ex) {
                        Log.outException(ex, "");
                    }
                }
            }
        }
    }

    public final <T extends IScriptObject> boolean runScriptRet(Func<T, Boolean> func, int id) {
        return runScriptRet(func, id, false);
    }

    public final <T extends IScriptObject> boolean runScriptRet(tangible.Func1Param<T, Boolean> func, int id, boolean ret) {
        return this.<T, Boolean>RunScriptRet(func, id, ret);
    }

    public final <T extends IScriptObject, U> U runScriptRet(Func<T, U> func, int id) {
        return runScriptRet(func, id, null);
    }

    public final <T extends IScriptObject, U> U runScriptRet(tangible.Func1Param<T, U> func, int id, U ret) {
        var script = this.<T>GetScript(id);

        if (script == null) {
            return ret;
        }

        try {
            return func.invoke(script);
        } catch (RuntimeException e) {
            Log.outException(e, "");
        }

        return ret;
    }

    public final <T extends IScriptObject> void runScript(tangible.Action1Param<T> a, int id) {
        var script = this.<T>GetScript(id);

        if (script != null) {
            try {
                a.invoke(script);
            } catch (RuntimeException ex) {
                Log.outException(ex, "");
            }
        }
    }

    public final <T extends IScriptObject> void addScript(T script) {
        var interfaces = script.getClass().getInterfaces();
        var hasClass = interfaces.Any(iface -> iface.name.equals("IClassRescriction"));

        TValue scriptReg;
        if (!(scriptStorage.containsKey(script.getClass()) && (scriptReg = scriptStorage.get(script.getClass())) == scriptReg)) {
            scriptReg = new ScriptRegistry();
            scriptStorage.put(script.getClass(), scriptReg);
        }

        scriptReg.addScript(script);

        for (var iface : interfaces) {
            addInterface(iface, script, hasClass);
        }
    }

    private <T extends IScriptObject> void addInterface(Class iface, T script, boolean hasClass) {
        if (Objects.equals(iface.getSimpleName(), "IScriptObject")) {
            return;
        }

        TValue scriptReg;
        if (!(scriptStorage.containsKey(iface) && (scriptReg = scriptStorage.get(iface)) == scriptReg)) {
            scriptReg = new ScriptRegistry();
            scriptStorage.put(iface, scriptReg);
        }

        scriptReg.addScript(script);
        scriptByType.AddIf(iface, script, (existing, newSc) -> existing.getName() != newSc.getName());

        if (IOHelpers.doesTypeSupportInterface(iface, IScriptObject.class)) {
            scriptStorage.put(iface, scriptReg);
        }

        if (hasClass) {
            TValue classDict;
            if (!(scriptClassByType.containsKey(iface) && (classDict = scriptClassByType.get(iface)) == classDict)) {
                classDict = new HashMap<PlayerClass, ArrayList<IScriptObject>>();
                scriptClassByType.put(iface, classDict);
            }

            classDict.AddIf(((IClassRescriction) script).getPlayerClass(), script, (existing, newSc) -> existing.getName() != newSc.getName());
        }

        for (var f : iface.getInterfaces()) {
            addInterface(f, script, hasClass);
        }
    }


    ///#endregion


    ///#region Loading and Unloading

    public final <T> ScriptRegistry getScriptRegistry() {
        TValue scriptReg;
        if (scriptStorage.containsKey(T.class) && (scriptReg = scriptStorage.get(T.class)) == scriptReg) {
            return scriptReg;
        }

        return null;
    }

    public final <T extends IScriptObject> T getScript(int id) {
        TValue scriptReg;
        if (scriptStorage.containsKey(T.class) && (scriptReg = scriptStorage.get(T.class)) == scriptReg) {
            return scriptReg.<T>GetScriptById(id);
        }

        return null;
    }

    public final void loadScripts() {
        var assemblies = IOHelpers.getAllAssembliesInDir(Paths.get(AppContext.BaseDirectory).resolve("Scripts").toString());

        if ((new file(AppContext.BaseDirectory + "Scripts.dll")).isFile()) {
            var scrAss = Assembly.LoadFile(AppContext.BaseDirectory + "Scripts.dll");

            if (scrAss != null) {
                assemblies.add(scrAss);
            }
        }

        HashMap<String, IScriptActivator> activators = new HashMap<String, IScriptActivator>();
        HashMap < class,IScriptRegister > registers = new HashMap< class,IScriptRegister > ();

        for (var asm : assemblies) {
            for (var type : asm.GetTypes()) {
                registerActivators(activators, type);
                registerRegistors(registers, type);
            }
        }

        for (var assembly : assemblies) {
            for (var type : assembly.GetTypes()) {
                var attributes = (ScriptAttribute[]) type.<ScriptAttribute>GetCustomAttributes(true);

                if (!attributes.isEmpty()) {
                    var constructors = type.GetConstructors(BindingFlags.NonPublic.getValue() | BindingFlags.Public.getValue().getValue() | BindingFlags.instance.getValue().getValue().getValue() | BindingFlags.CreateInstance.getValue().getValue().getValue());
                    var numArgsMin = 99;

                    for (var attribute : attributes) {
                        var name = type.name;
                        Class paramType = null;
                        var validArgs = true;
                        var i = 0;

                        for (var constructor : constructors) {
                            var parameters = constructor.GetParameters();

                            if (parameters.length < numArgsMin) {
                                numArgsMin = parameters.length;

                                if (numArgsMin == 1) {
                                    paramType = parameters.FirstOrDefault().ParameterType;
                                }
                            }

                            if (parameters.length != attribute.getArgs().length) {
                                continue;
                            }

                            for (var arg : parameters) {
                                if (arg.ParameterType != attribute.getArgs()[i++].getClass()) {
                                    validArgs = false;

                                    break;
                                }
                            }

                            if (validArgs) {
                                break;
                            }
                        }

                        if (!validArgs) {
                            Log.outError(LogFilter.Scripts, "Script: {0} contains no Public Constructors with the right parameter types. Can't load script.", type.name);

                            continue;
                        }

                        if (!attribute.getName().isEmpty()) {
                            name = attribute.getName();
                        }

                        IScriptObject activatedObj = null;

                        var typeIfaces = type.GetInterfaces();
                        var basetypes = new ArrayList<>();
                        var baseType = type.getSuperclass();

                        while (baseType != null) {
                            basetypes.add(baseType);
                            baseType = baseType.getSuperclass();
                        }


                        for (var baseT : basetypes) {
                            TValue scriptActivator;
                            if (!StringUtil.isEmpty(baseT.getSimpleName()) && (activators.containsKey(baseT.getSimpleName()) && (scriptActivator = activators.get(baseT.getSimpleName())) == scriptActivator)) {
                                activatedObj = scriptActivator.activate(type, name, attribute);

                                if (activatedObj != null) {
                                    break;
                                }
                            }
                        }

                        if (activatedObj == null) {
                            for (var intFace : typeIfaces) {
                                TValue scriptActivator;
                                if (!StringUtil.isEmpty(intFace.name) && (activators.containsKey(intFace.name) && (scriptActivator = activators.get(intFace.name)) == scriptActivator)) {
                                    activatedObj = scriptActivator.activate(type, name, attribute);

                                    if (activatedObj != null) {
                                        break;
                                    }
                                }
                            }
                        }

                        if (activatedObj == null) {
                            if (attribute.getArgs().isEmpty()) {
                                if (numArgsMin == 0 || numArgsMin == 99) {
                                    Object tempVar = type.newInstance();
                                    activatedObj = tempVar instanceof IScriptObject ? (IScriptObject) tempVar : null;
                                } else if (numArgsMin == 1 && paramType != null && paramType == String.class) {
                                    Object tempVar2 = system.Activator.CreateInstance(type, name);
                                    activatedObj = tempVar2 instanceof IScriptObject ? (IScriptObject) tempVar2 : null;
                                }
                            } else {
                                if (numArgsMin == 1 && paramType != null && paramType != String.class) {
                                    Object tempVar3 = system.Activator.CreateInstance(type, attribute.getArgs());
                                    activatedObj = tempVar3 instanceof IScriptObject ? (IScriptObject) tempVar3 : null;
                                } else {
                                    Object tempVar4 = system.Activator.CreateInstance(type, new Object[]{name}.Combine(attribute.getArgs()));
                                    activatedObj = tempVar4 instanceof IScriptObject ? (IScriptObject) tempVar4 : null;
                                }
                            }
                        }

                        if (activatedObj != null && IOHelpers.doesTypeSupportInterface(activatedObj.getClass(), IScriptAutoAdd.class)) {
                            global.getScriptMgr().addScript(activatedObj);
                        }

                        TValue reg;
                        if (registers.containsKey(attribute.getClass()) && (reg = registers.get(attribute.getClass())) == reg) {
                            reg.register(attribute, activatedObj, name);
                        }
                    }
                }
            }
        }
    }

    public final void loadDatabase() {
        loadScriptWaypoints();
        loadScriptSplineChains();
    }

    private void loadScriptWaypoints() {
        var oldMSTime = System.currentTimeMillis();

        // Drop Existing Waypoint list
        waypointStore.clear();

        long entryCount = 0;

        // Load Waypoints
        var result = DB.World.query("SELECT COUNT(entry) FROM script_waypoint GROUP BY entry");

        if (!result.isEmpty()) {
            entryCount = result.<Integer>Read(0);
        }

        Log.outInfo(LogFilter.ServerLoading, String.format("Loading Script Waypoints for %1$s creature(s)...", entryCount));

        //                                0       1         2           3           4           5
        result = DB.World.query("SELECT entry, pointid, location_x, location_y, location_z, waittime FROM script_waypoint ORDER BY pointid");

        if (result.isEmpty()) {
            Log.outInfo(LogFilter.ServerLoading, "Loaded 0 Script Waypoints. DB table `script_waypoint` is empty.");

            return;
        }

        int count = 0;

        do {
            var entry = result.<Integer>Read(0);
            var id = result.<Integer>Read(1);
            var x = result.<Float>Read(2);
            var y = result.<Float>Read(3);
            var z = result.<Float>Read(4);
            var waitTime = result.<Integer>Read(5);

            var info = global.getObjectMgr().getCreatureTemplate(entry);

            if (info == null) {
                Logs.SQL.error(String.format("SystemMgr: DB table script_waypoint has waypoint for non-existant creature entry %1$s", entry));

                continue;
            }

            if (info.scriptID == 0) {
                Logs.SQL.error(String.format("SystemMgr: DB table script_waypoint has waypoint for creature entry %1$s, but creature does not have ScriptName defined and then useless.", entry));
            }

            if (!waypointStore.containsKey(entry)) {
                waypointStore.put(entry, new waypointPath());
            }

            var path = waypointStore.get(entry);
            path.id = entry;
            path.nodes.add(new WaypointNode(id, x, y, z, null, waitTime));

            ++count;
        } while (result.NextRow());

        Log.outInfo(LogFilter.ServerLoading, "Loaded {0} Script Waypoint nodes in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
    }

    private void loadScriptSplineChains() {
        var oldMSTime = System.currentTimeMillis();

        mSplineChainsMap.clear();

        //                                             0      1        2         3                 4            5
        var resultMeta = DB.World.query("SELECT entry, chainId, splineId, expectedDuration, msUntilNext, velocity FROM script_spline_chain_meta ORDER BY entry asc, chainId asc, splineId asc");
        //                                           0      1        2         3    4  5  6
        var resultWP = DB.World.query("SELECT entry, chainId, splineId, wpId, x, y, z FROM script_spline_chain_waypoints ORDER BY entry asc, chainId asc, splineId asc, wpId asc");

        if (resultMeta.isEmpty() || resultWP.isEmpty()) {
            Log.outInfo(LogFilter.ServerLoading, "Loaded spline chain _data for 0 chains, consisting of 0 splines with 0 waypoints. DB tables `script_spline_chain_meta` and `script_spline_chain_waypoints` are empty.");
        } else {
            int chainCount = 0, splineCount = 0, wpCount = 0;

            do {
                var entry = resultMeta.<Integer>Read(0);
                var chainId = resultMeta.<SHORT>Read(1);
                var splineId = resultMeta.<Byte>Read(2);

                var key = Tuple.create(entry, chainId);

                if (!mSplineChainsMap.ContainsKey(key)) {
                    mSplineChainsMap.set(key, new ArrayList<SplineChainLink>());
                }

                var chain = mSplineChainsMap.get(Tuple.create(entry, chainId));

                if (splineId != chain.count) {
                    Log.outWarn(LogFilter.ServerLoading, "Creature #{0}: Chain {1} has orphaned spline {2}, skipped.", entry, chainId, splineId);

                    continue;
                }

                var expectedDuration = resultMeta.<Integer>Read(3);
                var msUntilNext = resultMeta.<Integer>Read(4);
                var velocity = resultMeta.<Float>Read(5);
                chain.add(new SplineChainLink(expectedDuration, msUntilNext, velocity));

                if (splineId == 0) {
                    ++chainCount;
                }

                ++splineCount;
            } while (resultMeta.NextRow());

            do {
                var entry = resultWP.<Integer>Read(0);
                var chainId = resultWP.<SHORT>Read(1);
                var splineId = resultWP.<Byte>Read(2);
                var wpId = resultWP.<Byte>Read(3);
                var posX = resultWP.<Float>Read(4);
                var posY = resultWP.<Float>Read(5);
                var posZ = resultWP.<Float>Read(6);
                var chain = mSplineChainsMap.get(Tuple.create(entry, chainId));

                if (chain == null) {
                    Log.outWarn(LogFilter.ServerLoading, "Creature #{0} has waypoint _data for spline chain {1}. No such chain exists - entry skipped.", entry, chainId);

                    continue;
                }

                if (splineId >= chain.count) {
                    Log.outWarn(LogFilter.ServerLoading, "Creature #{0} has waypoint _data for spline ({1},{2}). The specified chain does not have a spline with this index - entry skipped.", entry, chainId, splineId);

                    continue;
                }

                var spline = chain[splineId];

                if (wpId != spline.points.count) {
                    Log.outWarn(LogFilter.ServerLoading, "Creature #{0} has orphaned waypoint _data in spline ({1},{2}) at index {3}. Skipped.", entry, chainId, splineId, wpId);

                    continue;
                }

                spline.points.add(new Vector3(posX, posY, posZ));
                ++wpCount;
            } while (resultWP.NextRow());

            Log.outInfo(LogFilter.ServerLoading, "Loaded spline chain _data for {0} chains, consisting of {1} splines with {2} waypoints in {3} ms", chainCount, splineCount, wpCount, time.GetMSTimeDiffToNow(oldMSTime));
        }
    }

    public final void fillSpellSummary() {
        UnitAI.fillAISpellInfo();
    }

    public final WaypointPath getPath(int creatureEntry) {
        return waypointStore.get(creatureEntry);
    }

    public final ArrayList<SplineChainLink> getSplineChain(Creature who, short chainId) {
        return getSplineChain(who.getEntry(), chainId);
    }

    private ArrayList<SplineChainLink> getSplineChain(int entry, short chainId) {
        return mSplineChainsMap.get(Tuple.create(entry, chainId));
    }

    public final String scriptsVersion() {
        return "Integrated Cypher Scripts";
    }

    public final void incrementScriptCount() {
        ++scriptCount;
    }

    public final int getScriptCount() {
        return scriptCount;
    }

    //Reloading
    public final void reload() {
        unload();
        loadScripts();
    }

    //Unloading
    public final void unload() {
        for (var entry : scriptStorage.entrySet()) {
            var scriptRegistry = entry.getValue();
            scriptRegistry.unload();
        }

        scriptStorage.clear();
        scriptByType.clear();
        scriptClassByType.clear();
    }


    ///#endregion


    ///#region Spells and Auras

    //SpellScriptLoader
    public final ArrayList<SpellScript> createSpellScripts(int spellId, Spell invoker) {
        var scriptList = new ArrayList<>();
        var bounds = global.getObjectMgr().getSpellScriptsBounds(spellId);

        var reg = this.<ISpellScriptLoaderGetSpellScript>GetScriptRegistry();

        if (reg == null) {
            return scriptList;
        }

        for (var id : bounds) {
            var tmpscript = reg.<ISpellScriptLoaderGetSpellScript>GetScriptById(id);

            if (tmpscript == null) {
                continue;
            }

            var script = tmpscript.getSpellScript();

            if (script == null) {
                continue;
            }

            script._Init(tmpscript.getName(), spellId);

            if (!script._Load(invoker)) {
                continue;
            }

            scriptList.add(script);
        }

        return scriptList;
    }

    public final ArrayList<AuraScript> createAuraScripts(int spellId, Aura invoker) {
        var scriptList = new ArrayList<>();
        var bounds = global.getObjectMgr().getSpellScriptsBounds(spellId);

        var reg = this.<IAuraScriptLoaderGetAuraScript>GetScriptRegistry();

        if (reg == null) {
            return scriptList;
        }

        for (var id : bounds) {
            var tmpscript = reg.<IAuraScriptLoaderGetAuraScript>GetScriptById(id);

            if (tmpscript == null) {
                continue;
            }

            var script = tmpscript.getAuraScript();

            if (script == null) {
                continue;
            }

            script._Init(tmpscript.getName(), spellId);

            if (!script._Load(invoker)) {
                continue;
            }

            scriptList.add(script);
        }

        return scriptList;
    }

    public final HashMap<ISpellScriptLoaderGetSpellScript, Integer> createSpellScriptLoaders(int spellId) {
        var scriptDic = new HashMap<ISpellScriptLoaderGetSpellScript, Integer>();
        var bounds = global.getObjectMgr().getSpellScriptsBounds(spellId);

        var reg = this.<ISpellScriptLoaderGetSpellScript>GetScriptRegistry();

        if (reg == null) {
            return scriptDic;
        }

        for (var id : bounds) {
            var tmpscript = reg.<ISpellScriptLoaderGetSpellScript>GetScriptById(id);

            if (tmpscript == null) {
                continue;
            }

            scriptDic.put(tmpscript, id);
        }

        return scriptDic;
    }

    public final HashMap<IAuraScriptLoaderGetAuraScript, Integer> createAuraScriptLoaders(int spellId) {
        var scriptDic = new HashMap<IAuraScriptLoaderGetAuraScript, Integer>();
        var bounds = global.getObjectMgr().getSpellScriptsBounds(spellId);

        var reg = this.<IAuraScriptLoaderGetAuraScript>GetScriptRegistry();

        if (reg == null) {
            return scriptDic;
        }

        for (var id : bounds) {
            var tmpscript = reg.<IAuraScriptLoaderGetAuraScript>GetScriptById(id);

            if (tmpscript == null) {
                continue;
            }

            scriptDic.put(tmpscript, id);
        }

        return scriptDic;
    }


    ///#endregion


    ///#region AreaTriggers

    public final ArrayList<AreaTriggerScript> createAreaTriggerScripts(int areaTriggerId, AreaTrigger invoker) {
        var scriptList = new ArrayList<>();
        var bounds = global.getObjectMgr().getAreaTriggerScriptIds(areaTriggerId);

        var reg = this.<IAreaTriggerScriptLoaderGetTriggerScriptScript>GetScriptRegistry();

        if (reg == null) {
            return scriptList;
        }

        for (var id : bounds) {
            var tmpscript = reg.<IAreaTriggerScriptLoaderGetTriggerScriptScript>GetScriptById(id);

            if (tmpscript == null) {
                continue;
            }

            var script = tmpscript.getAreaTriggerScript();

            if (script == null) {
                continue;
            }

            script._Init(tmpscript.getName(), areaTriggerId);

            if (!script._Load(invoker)) {
                continue;
            }

            scriptList.add(script);
        }

        return scriptList;
    }

    public final HashMap<IAreaTriggerScriptLoaderGetTriggerScriptScript, Integer> createAreaTriggerScriptLoaders(int areaTriggerId) {
        var scriptDic = new HashMap<IAreaTriggerScriptLoaderGetTriggerScriptScript, Integer>();
        var bounds = global.getObjectMgr().getAreaTriggerScriptIds(areaTriggerId);

        var reg = this.<IAreaTriggerScriptLoaderGetTriggerScriptScript>GetScriptRegistry();

        if (reg == null) {
            return scriptDic;
        }

        for (var id : bounds) {
            var tmpscript = reg.<IAreaTriggerScriptLoaderGetTriggerScriptScript>GetScriptById(id);

            if (tmpscript == null) {
                continue;
            }

            scriptDic.put(tmpscript, id);
        }

        return scriptDic;
    }


    ///#endregion


    ///#region Player Chat

    public final void onPlayerChat(Player player, ChatMsg type, Language lang, String msg) {
        this.<IPlayerOnChat>ForEach(p -> p.OnChat(player, type, lang, msg));
    }

    public final void onPlayerChat(Player player, ChatMsg type, Language lang, String msg, Player receiver) {
        this.<IPlayerOnChatWhisper>ForEach(p -> p.OnChat(player, type, lang, msg, receiver));
    }

    public final void onPlayerChat(Player player, ChatMsg type, Language lang, String msg, PlayerGroup group) {
        this.<IPlayerOnChatGroup>ForEach(p -> p.OnChat(player, type, lang, msg, group));
    }

    public final void onPlayerChat(Player player, ChatMsg type, Language lang, String msg, Guild guild) {
        this.<IPlayerOnChatGuild>ForEach(p -> p.OnChat(player, type, lang, msg, guild));
    }

    public final void onPlayerChat(Player player, ChatMsg type, Language lang, String msg, Channel channel) {
        this.<IPlayerOnChatChannel>ForEach(p -> p.OnChat(player, type, lang, msg, channel));
    }


    ///#endregion
}
