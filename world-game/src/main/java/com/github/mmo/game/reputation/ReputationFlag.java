package com.github.mmo.game.reputation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ReputationFlag {
    None                        (0x0000),
    Visible                     (0x0001),                   // makes visible in client (set or can be set at interaction with target of this faction)
    AtWar                       (0x0002),                   // enable AtWar-button in client. player controlled (except opposition team always war state), Flag only set on initial creation
    Hidden                      (0x0004),                   // hidden faction from reputation pane in client (player can gain reputation, but this update not sent to client)
    Header                      (0x0008),                   // Display as header in UI
    Peaceful                    (0x0010),
    Inactive                    (0x0020),                   // player controlled (CMSG_SET_FACTION_INACTIVE)
    ShowPropagated              (0x0040),
    HeaderShowsBar              (0x0080),                   // Header has its own reputation bar
    CapitalCityForRaceChange    (0x0100),
    Guild                       (0x0200),
    GarrisonInvasion            (0x0400);

    public final int value;
}
