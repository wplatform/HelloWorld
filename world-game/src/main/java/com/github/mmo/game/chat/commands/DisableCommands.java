package com.github.mmo.game.chat.commands;


import com.github.mmo.game.DisableType;
import com.github.mmo.game.chat.CommandHandler;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class DisableCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class DisableAddCommands {
        private static boolean handleAddDisables(int entry, int flags, String disableComment, CommandHandler handler, DisableType disableType) {
            if (entry == 0) {
                return false;
            }

            if (disableComment.isEmpty()) {
                return false;
            }

            switch (disableType) {
                case Spell: {
                    if (!global.getSpellMgr().hasSpellInfo(entry, Difficulty.NONE)) {
                        handler.sendSysMessage(CypherStrings.CommandNospellfound);

                        return false;
                    }

                    break;
                }
                case Quest: {
                    if (global.getObjectMgr().getQuestTemplate(entry) == null) {
                        handler.sendSysMessage(CypherStrings.CommandNoquestfound, entry);

                        return false;
                    }

                    break;
                }
                case Map: {
                    if (!CliDB.MapStorage.containsKey(entry)) {
                        handler.sendSysMessage(CypherStrings.CommandNomapfound);

                        return false;
                    }

                    break;
                }
                case Battleground: {
                    if (!CliDB.BattlemasterListStorage.containsKey(entry)) {
                        handler.sendSysMessage(CypherStrings.CommandNoBattlegroundFound);

                        return false;
                    }

                    break;
                }
                case Criteria: {
                    if (global.getCriteriaMgr().getCriteria(entry) == null) {
                        handler.sendSysMessage(CypherStrings.CommandNoAchievementCriteriaFound);

                        return false;
                    }

                    break;
                }
                case OutdoorPVP: {
                    if (entry > OutdoorPvPTypes.max.getValue()) {
                        handler.sendSysMessage(CypherStrings.CommandNoOutdoorPvpForund);

                        return false;
                    }

                    break;
                }
                case VMAP: {
                    if (!CliDB.MapStorage.containsKey(entry)) {
                        handler.sendSysMessage(CypherStrings.CommandNomapfound);

                        return false;
                    }

                    break;
                }
                case MMAP: {
                    if (!CliDB.MapStorage.containsKey(entry)) {
                        handler.sendSysMessage(CypherStrings.CommandNomapfound);

                        return false;
                    }

                    break;
                }
                default:
                    break;
            }

            var stmt = DB.World.GetPreparedStatement(WorldStatements.SEL_DISABLES);
            stmt.AddValue(0, entry);
            stmt.AddValue(1, (byte) disableType.getValue());
            var result = DB.World.query(stmt);

            if (!result.isEmpty()) {
                handler.sendSysMessage(String.format("This %1$s (Id: %2$s) is already disabled.", disableType, entry));

                return false;
            }

            stmt = DB.World.GetPreparedStatement(WorldStatements.INS_DISABLES);
            stmt.AddValue(0, entry);
            stmt.AddValue(1, (byte) disableType.getValue());
            stmt.AddValue(2, flags);
            stmt.AddValue(3, disableComment);
            DB.World.execute(stmt);

            handler.sendSysMessage(String.format("Add Disabled %1$s (Id: %2$s) for reason %3$s", disableType, entry, disableComment));

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAddDisableSpellCommand(CommandHandler handler, int entry, int flags, String disableComment) {
            return handleAddDisables(entry, flags, disableComment, handler, DisableType.spell);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAddDisableQuestCommand(CommandHandler handler, int entry, int flags, String disableComment) {
            return handleAddDisables(entry, flags, disableComment, handler, DisableType.Quest);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAddDisableMapCommand(CommandHandler handler, int entry, int flags, String disableComment) {
            return handleAddDisables(entry, flags, disableComment, handler, DisableType.Map);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAddDisableBattlegroundCommand(CommandHandler handler, int entry, int flags, String disableComment) {
            return handleAddDisables(entry, flags, disableComment, handler, DisableType.Battleground);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAddDisableCriteriaCommand(CommandHandler handler, int entry, int flags, String disableComment) {
            return handleAddDisables(entry, flags, disableComment, handler, DisableType.criteria);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAddDisableOutdoorPvPCommand(CommandHandler handler, int entry, int flags, String disableComment) {
            return handleAddDisables(entry, flags, disableComment, handler, DisableType.OutdoorPVP);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAddDisableVmapCommand(CommandHandler handler, int entry, int flags, String disableComment) {
            return handleAddDisables(entry, flags, disableComment, handler, DisableType.VMAP);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleAddDisableMMapCommand(CommandHandler handler, int entry, int flags, String disableComment) {
            return handleAddDisables(entry, flags, disableComment, handler, DisableType.MMAP);
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class DisableRemoveCommands {
        private static boolean handleRemoveDisables(int entry, CommandHandler handler, DisableType disableType) {
            if (entry == 0) {
                return false;
            }

            var stmt = DB.World.GetPreparedStatement(WorldStatements.SEL_DISABLES);
            stmt.AddValue(0, entry);
            stmt.AddValue(1, (byte) disableType.getValue());
            var result = DB.World.query(stmt);

            if (result.isEmpty()) {
                handler.sendSysMessage(String.format("This %1$s (Id: %2$s) is not disabled.", disableType, entry));

                return false;
            }

            stmt = DB.World.GetPreparedStatement(WorldStatements.DEL_DISABLES);
            stmt.AddValue(0, entry);
            stmt.AddValue(1, (byte) disableType.getValue());
            DB.World.execute(stmt);

            handler.sendSysMessage(String.format("Remove Disabled %1$s (Id: %2$s)", disableType, entry));

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRemoveDisableSpellCommand(CommandHandler handler, int entry) {
            return handleRemoveDisables(entry, handler, DisableType.spell);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRemoveDisableQuestCommand(CommandHandler handler, int entry) {
            return handleRemoveDisables(entry, handler, DisableType.Quest);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRemoveDisableMapCommand(CommandHandler handler, int entry) {
            return handleRemoveDisables(entry, handler, DisableType.Map);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRemoveDisableBattlegroundCommand(CommandHandler handler, int entry) {
            return handleRemoveDisables(entry, handler, DisableType.Battleground);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRemoveDisableCriteriaCommand(CommandHandler handler, int entry) {
            return handleRemoveDisables(entry, handler, DisableType.criteria);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRemoveDisableOutdoorPvPCommand(CommandHandler handler, int entry) {
            return handleRemoveDisables(entry, handler, DisableType.OutdoorPVP);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRemoveDisableVmapCommand(CommandHandler handler, int entry) {
            return handleRemoveDisables(entry, handler, DisableType.VMAP);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRemoveDisableMMapCommand(CommandHandler handler, int entry) {
            return handleRemoveDisables(entry, handler, DisableType.MMAP);
        }
    }
}
