package com.github.mmo.game.chat.commands;


import com.github.mmo.game.account.RBACData;
import com.github.mmo.game.chat.AccountIdentifier;
import com.github.mmo.game.chat.CommandHandler;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class RbacComands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleRBACListPermissionsCommand(CommandHandler handler, Integer permId) {
        if (permId == null) {
            var permissions = global.getAccountMgr().getRBACPermissionList();
            handler.sendSysMessage(CypherStrings.RbacListPermissionsHeader);

// C# TO JAVA CONVERTER TASK: Java has no equivalent to C# deconstruction declarations:
            for (var(_, permission) : permissions) {
                handler.sendSysMessage(CypherStrings.RbacListElement, permission.id, permission.name);
            }
        } else {
            var permission = global.getAccountMgr().getRBACPermission(permId.intValue());

            if (permission == null) {
                handler.sendSysMessage(CypherStrings.RbacWrongParameterId, permId.intValue());

                return false;
            }

            handler.sendSysMessage(CypherStrings.RbacListPermissionsHeader);
            handler.sendSysMessage(CypherStrings.RbacListElement, permission.getId(), permission.getName());
            handler.sendSysMessage(CypherStrings.RbacListPermsLinkedHeader);

            for (var linkedPerm : permission.getLinkedPermissions()) {
                var rbacPermission = global.getAccountMgr().getRBACPermission(linkedPerm);

                if (rbacPermission != null) {
                    handler.sendSysMessage(CypherStrings.RbacListElement, rbacPermission.getId(), rbacPermission.getName());
                }
            }
        }

        return true;
    }

    private static RBACCommandData getRBACData(AccountIdentifier account) {
        if (account.isConnected()) {
            RBACCommandData tempVar = new RBACCommandData();
            tempVar.rbac = account.getConnectedSession().getRBACData();
            tempVar.needDelete = false;
            return tempVar;
        }

        RBACData rbac = new RBACData(account.getID(), account.getName(), (int) global.getWorldMgr().getRealmId().index, (byte) global.getAccountMgr().getSecurity(account.getID(), (int) global.getWorldMgr().getRealmId().index).getValue());
        rbac.loadFromDB();

        RBACCommandData tempVar2 = new RBACCommandData();
        tempVar2.rbac = rbac;
        tempVar2.needDelete = true;
        return tempVar2;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class RbacAccountCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRBACPermDenyCommand(CommandHandler handler, AccountIdentifier account, int permId, Integer realmId) {
            if (account == null) {
                account = AccountIdentifier.fromTarget(handler);
            }

            if (account == null) {
                return false;
            }

            if (handler.hasLowerSecurityAccount(null, account.getID(), true)) {
                return false;
            }

            if (realmId == null) {
                realmId = -1;
            }

            var data = getRBACData(account);

            var result = data.rbac.denyPermission(permId, realmId.intValue());
            var permission = global.getAccountMgr().getRBACPermission(permId);

            switch (result) {
                case CantAddAlreadyAdded:
                    handler.sendSysMessage(CypherStrings.RbacPermDeniedInList, permId, permission.getName(), realmId.intValue(), data.rbac.getId(), data.rbac.getName());

                    break;
                case InGrantedList:
                    handler.sendSysMessage(CypherStrings.RbacPermDeniedInGrantedList, permId, permission.getName(), realmId.intValue(), data.rbac.getId(), data.rbac.getName());

                    break;
                case OK:
                    handler.sendSysMessage(CypherStrings.RbacPermDenied, permId, permission.getName(), realmId.intValue(), data.rbac.getId(), data.rbac.getName());

                    break;
                case IdDoesNotExists:
                    handler.sendSysMessage(CypherStrings.RbacWrongParameterId, permId);

                    break;
                default:
                    break;
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRBACPermGrantCommand(CommandHandler handler, AccountIdentifier account, int permId, Integer realmId) {
            if (account == null) {
                account = AccountIdentifier.fromTarget(handler);
            }

            if (account == null) {
                return false;
            }

            if (handler.hasLowerSecurityAccount(null, account.getID(), true)) {
                return false;
            }

            if (realmId == null) {
                realmId = -1;
            }

            var data = getRBACData(account);

            var result = data.rbac.grantPermission(permId, realmId.intValue());
            var permission = global.getAccountMgr().getRBACPermission(permId);

            switch (result) {
                case CantAddAlreadyAdded:
                    handler.sendSysMessage(CypherStrings.RbacPermGrantedInList, permId, permission.getName(), realmId.intValue(), data.rbac.getId(), data.rbac.getName());

                    break;
                case InDeniedList:
                    handler.sendSysMessage(CypherStrings.RbacPermGrantedInDeniedList, permId, permission.getName(), realmId.intValue(), data.rbac.getId(), data.rbac.getName());

                    break;
                case OK:
                    handler.sendSysMessage(CypherStrings.RbacPermGranted, permId, permission.getName(), realmId.intValue(), data.rbac.getId(), data.rbac.getName());

                    break;
                case IdDoesNotExists:
                    handler.sendSysMessage(CypherStrings.RbacWrongParameterId, permId);

                    break;
                default:
                    break;
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRBACPermListCommand(CommandHandler handler, AccountIdentifier account) {
            if (account == null) {
                account = AccountIdentifier.fromTarget(handler);
            }

            if (account == null) {
                return false;
            }

            var data = getRBACData(account);

            handler.sendSysMessage(CypherStrings.RbacListHeaderGranted, data.rbac.getId(), data.rbac.getName());
            var granted = data.rbac.getGrantedPermissions();

            if (granted.isEmpty()) {
                handler.sendSysMessage(CypherStrings.RbacListEmpty);
            } else {
                for (var id : granted) {
                    var permission = global.getAccountMgr().getRBACPermission(id);
                    handler.sendSysMessage(CypherStrings.RbacListElement, permission.getId(), permission.getName());
                }
            }

            handler.sendSysMessage(CypherStrings.RbacListHeaderDenied, data.rbac.getId(), data.rbac.getName());
            var denied = data.rbac.getDeniedPermissions();

            if (denied.isEmpty()) {
                handler.sendSysMessage(CypherStrings.RbacListEmpty);
            } else {
                for (var id : denied) {
                    var permission = global.getAccountMgr().getRBACPermission(id);
                    handler.sendSysMessage(CypherStrings.RbacListElement, permission.getId(), permission.getName());
                }
            }

            handler.sendSysMessage(CypherStrings.RbacListHeaderBySecLevel, data.rbac.getId(), data.rbac.getName(), data.rbac.getSecurityLevel());
            var defaultPermissions = global.getAccountMgr().getRBACDefaultPermissions(data.rbac.getSecurityLevel());

            if (defaultPermissions.isEmpty()) {
                handler.sendSysMessage(CypherStrings.RbacListEmpty);
            } else {
                for (var id : defaultPermissions) {
                    var permission = global.getAccountMgr().getRBACPermission(id);
                    handler.sendSysMessage(CypherStrings.RbacListElement, permission.getId(), permission.getName());
                }
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleRBACPermRevokeCommand(CommandHandler handler, AccountIdentifier account, int permId, Integer realmId) {
            if (account == null) {
                account = AccountIdentifier.fromTarget(handler);
            }

            if (account == null) {
                return false;
            }

            if (handler.hasLowerSecurityAccount(null, account.getID(), true)) {
                return false;
            }

            if (realmId == null) {
                realmId = -1;
            }

            var data = getRBACData(account);

            var result = data.rbac.revokePermission(permId, realmId.intValue());
            var permission = global.getAccountMgr().getRBACPermission(permId);

            switch (result) {
                case CantRevokeNotInList:
                    handler.sendSysMessage(CypherStrings.RbacPermRevokedNotInList, permId, permission.getName(), realmId.intValue(), data.rbac.getId(), data.rbac.getName());

                    break;
                case OK:
                    handler.sendSysMessage(CypherStrings.RbacPermRevoked, permId, permission.getName(), realmId.intValue(), data.rbac.getId(), data.rbac.getName());

                    break;
                case IdDoesNotExists:
                    handler.sendSysMessage(CypherStrings.RbacWrongParameterId, permId);

                    break;
                default:
                    break;
            }

            return true;
        }
    }

    private static class RBACCommandData {
        public RBACData rbac;
        public boolean needDelete;
    }
}
