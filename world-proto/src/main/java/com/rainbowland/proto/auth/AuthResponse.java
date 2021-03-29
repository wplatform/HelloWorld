package com.rainbowland.proto.auth;

import com.rainbowland.proto.SendPacketOpcode;
import com.rainbowland.proto.SendWorldPacket;
import com.rainbowland.proto.model.*;
import com.rainbowland.utils.Bits;
import io.netty.buffer.ByteBuf;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class AuthResponse extends SendWorldPacket {

    private AuthSuccessInfo successInfo; ///< contains the packet data in case that it has account information (It is never set when WaitInfo is set), otherwise its contents are undefined.
    private AuthWaitInfo waitInfo; ///< contains the queue wait information in case the account is in the login queue.
    private int result; ///< the result of the authentication process, possible values are @ref BattlenetRpcErrorCode

    public AuthResponse() {
        super(SendPacketOpcode.SMSG_AUTH_RESPONSE);
    }


    @Override
    public void serialize(ByteBuf buf) {

        buf.writeIntLE(result);


        buf.writeBytes(Bits.empty()
                .addBit(successInfo != null)
                .addBit(waitInfo != null).values());

        Optional.ofNullable(successInfo).ifPresent(e -> {
            buf.writeInt(e.virtualRealmAddress);
            buf.writeInt(e.virtualRealms.size());
            buf.writeInt(e.timeRested);
            buf.writeByte(e.activeExpansionLevel);
            buf.writeByte(e.accountExpansionLevel);
            buf.writeInt(e.timeSecondsUntilPCKick);
            buf.writeInt(e.availableClasses.size());
            buf.writeInt(e.templates.size());
            buf.writeInt(e.currencyID);
            buf.writeInt(e.time);
            e.availableClasses.forEach(availableClass -> {
                buf.writeByte(availableClass.getRaceID());
                buf.writeInt(availableClass.getClasses().size());
                availableClass.getClasses().forEach(classAvailability -> {
                    buf.writeByte(classAvailability.getClassID());
                    buf.writeByte(classAvailability.getActiveExpansionLevel());
                    buf.writeByte(classAvailability.getAccountExpansionLevel());
                });
            });

            buf.writeBytes(Bits.empty()
                    .addBit(e.expansionTrial)
                    .addBit(e.forceCharacterTemplate)
                    .addBit(e.numPlayersHorde > 0)
                    .addBit(e.numPlayersAlliance > 0)
                    .addBit(e.expansionTrialExpiration > 0).values());

            buf.writeInt(e.gameTimeInfo.billingPlan);
            buf.writeInt(e.gameTimeInfo.timeRemain);
            buf.writeInt(e.gameTimeInfo.unknown735);
            // 3x same bit is not a mistake - preserves legacy client behavior of BillingPlanFlags::SESSION_IGR
            buf.writeBytes(Bits.empty()
                    .addBit(e.gameTimeInfo.inGameRoom)
                    .addBit(e.gameTimeInfo.inGameRoom)
                    .addBit(e.gameTimeInfo.inGameRoom).values());
            if (e.numPlayersHorde > 0) {
                buf.writeShort(e.numPlayersHorde);
            }
            if (e.numPlayersAlliance > 0) {
                buf.writeShort(e.numPlayersAlliance);
            }
            if (e.expansionTrialExpiration > 0) {
                buf.writeInt(e.expansionTrialExpiration);
            }

            e.virtualRealms.forEach(virtualRealmInfo -> {
                buf.writeInt(virtualRealmInfo.realmAddress);
                buf.writeBytes(Bits.empty()
                        .addBit(virtualRealmInfo.local)
                        .addBit(virtualRealmInfo.internalRealm)
                        .addBits(virtualRealmInfo.realmNameActual.length(),8)
                        .addBits(virtualRealmInfo.realmNameNormalized.length(),8).values());
            });

            e.templates.forEach(characterTemplate -> {
                //buf.writeInt(characterTemplate)
            });

        });


    }



    @Data
    @Builder
    public static class VirtualRealmInfo {
        private int realmAddress;             ///< the virtual address of this realm, constructed as RealmHandle::Region << 24 | RealmHandle::Battlegroup << 16 | RealmHandle::Index
        private boolean local;                    ///< true if the realm is the same as the account's home realm
        private boolean internalRealm;            ///< @todo research
        private String realmNameActual;     ///< the name of the realm
        private String realmNameNormalized; ///< the name of the realm without spaces
    }

    @Data
    @Builder
    public static class GameTime {
        private int billingPlan;
        private int timeRemain;
        private int unknown735;
        private boolean inGameRoom;
    }

    @Data
    @Builder
    public static class AuthSuccessInfo {
        private byte activeExpansionLevel; ///< the current server expansion, the possible values are in @ref Expansions
        private byte accountExpansionLevel; ///< the current expansion of this account, the possible values are in @ref Expansions
        private int timeRested;

        private int virtualRealmAddress; ///< a special identifier made from the Index, BattleGroup and Region.
        private int timeSecondsUntilPCKick; ///< @todo research
        private int currencyID; ///< this is probably used for the ingame shop. @todo implement
        private int time;
        private GameTime gameTimeInfo;

        private List<VirtualRealmInfo> virtualRealms;     ///< list of realms connected to this one (inclusive) @todo implement
        private List<CharacterTemplate> templates; ///< list of pre-made character templates.

        private List<RaceClassAvailability> availableClasses; ///< the minimum AccountExpansion required to select race/class combinations

        private boolean expansionTrial;
        private boolean forceCharacterTemplate; ///< forces the client to always use a character template when creating a new character. @see Templates. @todo implement
        private short numPlayersHorde; ///< number of horde players in this realm. @todo implement
        private short numPlayersAlliance; ///< number of alliance players in this realm. @todo implement
        private int expansionTrialExpiration; ///< expansion trial expiration unix timestamp

    }

    @Data
    @Builder
    public static class AuthWaitInfo {
        private int waitCount; ///< position of the account in the login queue
        private int waitTime; ///< Wait time in login queue in minutes, if sent queued and this value is 0 client displays "unknown time"
        private boolean hasFCM; ///< true if the account has a forced character migration pending. @todo implement
    }

}
