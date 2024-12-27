package com.github.mmo.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

// indexes of BattlemasterList.dbc (7.1.5.23360)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum BattlegroundTypeId {
    BATTLEGROUND_TYPE_NONE(0),   // None
    BATTLEGROUND_AV(1),   // Alterac Valley
    BATTLEGROUND_WS(2),   // Warsong Gulch
    BATTLEGROUND_AB(3),   // Arathi Basin
    BATTLEGROUND_NA(4),   // Nagrand Arena
    BATTLEGROUND_BE(5),   // Blade's Edge Arena
    BATTLEGROUND_AA(6),   // All Arenas
    BATTLEGROUND_EY(7),   // Eye of the Storm
    BATTLEGROUND_RL(8),   // Ruins of Lordaernon
    BATTLEGROUND_SA(9),   // Strand of the Ancients
    BATTLEGROUND_DS(10),  // Dalaran Sewers
    BATTLEGROUND_RV(11),  // The Ring of Valor
    BATTLEGROUND_IC(30),  // Isle of Conquest
    BATTLEGROUND_RB(32),  // Random Battleground
    BATTLEGROUND_RATED_10_VS_10(100), // Rated Battleground 10 vs 10
    BATTLEGROUND_RATED_15_VS_15(101), // Rated Battleground 15 vs 15
    BATTLEGROUND_RATED_25_VS_25(102), // Rated Battleground 25 vs 25
    BATTLEGROUND_TP(108), // Twin Peaks
    BATTLEGROUND_BFG(120), // Battle For Gilneas
    // 656 = "Rated Eye of the Storm"
    BATTLEGROUND_TK(699), // Temple of Kotmogu
    // 706 = "CTF3"
    BATTLEGROUND_SM(708), // Silvershard Mines
    BATTLEGROUND_TVA(719), // Tol'Viron Arena
    BATTLEGROUND_DG(754), // Deepwind Gorge
    BATTLEGROUND_TTP(757), // The Tiger's Peak
    BATTLEGROUND_SS_VS_TM(789), // Southshore vs. Tarren Mill
    BATTLEGROUND_SMALL_D(803), // Small Battleground D
    BATTLEGROUND_BRH(808), // Black Rook Hold Arena
    // 809 = "New Nagrand Arena (Legion)"
    BATTLEGROUND_AF(816), // Ashamane's Fall
    // 844 = "New Blade's Edge Arena (Legion)"
    BATTLEGROUND_RANDOM_EPIC(901);

    public final int value;
}
