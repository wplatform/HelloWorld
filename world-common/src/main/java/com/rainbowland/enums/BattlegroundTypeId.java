package com.rainbowland.enums;

// Indexes of BattlemasterList.db2 (9.0.2.37176)
public enum BattlegroundTypeId {
    BATTLEGROUND_TYPE_NONE(0),        // None
    BATTLEGROUND_AV(1),        // Alterac Valley
    BATTLEGROUND_WS(2),        // Warsong Gulch
    BATTLEGROUND_AB(3),        // Arathi Basin
    BATTLEGROUND_NA(4),        // Nagrand Arena
    BATTLEGROUND_BE(5),        // Blade's Edge Arena
    BATTLEGROUND_AA(6),        // All Arenas
    BATTLEGROUND_EY(7),        // Eye of the Storm
    BATTLEGROUND_RL(8),        // Ruins of Lordaernon
    BATTLEGROUND_SA(9),        // Strand of the Ancients
    BATTLEGROUND_DS(10),       // Dalaran Sewers
    BATTLEGROUND_RV(11),       // The Ring of Valor
    BATTLEGROUND_IC(30),       // Isle of Conquest
    BATTLEGROUND_RB(32),       // Random Battleground
    BATTLEGROUND_RATED_10_VS_10(100),      // Rated Battleground 10 vs 10
    BATTLEGROUND_RATED_15_VS_15(101),      // Rated Battleground 15 vs 15
    BATTLEGROUND_RATED_25_VS_25(102),      // Rated Battleground 25 vs 25
    BATTLEGROUND_TP(108),      // Twin Peaks
    BATTLEGROUND_BFG(120),      // Battle For Gilneas
    // 656 ( "Rated Eye of the Storm"
    BATTLEGROUND_TK(699),      // Temple of Kotmogu
    // 706 ( "CTF3"
    BATTLEGROUND_SM(708),      // Silvershard Mines
    BATTLEGROUND_TVA(719),      // Tol'Viron Arena
    BATTLEGROUND_DG(754),      // Deepwind Gorge
    BATTLEGROUND_TTP(757),      // The Tiger's Peak
    BATTLEGROUND_SS_VS_TM(789),      // Southshore vs. Tarren Mill
    BATTLEGROUND_SMALL_D(803),      // Small Battleground D
    BATTLEGROUND_BRH(808),      // Black Rook Hold Arena
    // 809 ( "New Nagrand Arena (Legion)"
    BATTLEGROUND_AF(816),      // Ashamane's Fall
    // 844 ( "New Blade's Edge Arena (Legion)"
    BATTLEGROUND_BRAWL_TBG(846),      // Brawl - The Battle for Gilneas (Old City Map)
    BATTLEGROUND_BRAWL_ABW(847),      // Brawl - Arathi Basin Winter
    // 848 ( "AI Test - Arathi Basin"
    BATTLEGROUND_BRAWL_DD(849),      // Brawl - Deepwind Dunk
    BATTLEGROUND_BRAWL_SPS(853),      // Brawl - Shadow-Pan Showdown
    // 856 ( "[TEMP] RaceTrackBG"
    BATTLEGROUND_BR(857),      // Blackrock
    BATTLEGROUND_BRAWL_TH(858),      // Brawl - Temple of Hotmogu
    BATTLEGROUND_BRAWL_GL(859),      // Brawl - Gravity Lapse
    BATTLEGROUND_BRAWL_DD2(860),      // Brawl - Deepwind Dunk
    BATTLEGROUND_BRAWL_WS(861),      // Brawl - Warsong Scramble
    BATTLEGROUND_BRAWL_EH(862),      // Brawl - Eye of the Horn
    BATTLEGROUND_BRAWL_AA(866),      // Brawl - All Arenas
    BATTLEGROUND_RL2(868),      // Ruins of Lordaeron
    BATTLEGROUND_DS2(869),      // Dalaran Sewers
    BATTLEGROUND_TVA2(870),      // Tol'Viron Arena
    BATTLEGROUND_TTP2(871),      // The Tiger's Peak
    BATTLEGROUND_BRHA2(872),      // Black Rook Hold Arena
    BATTLEGROUND_NA2(873),      // Nagrand Arena
    BATTLEGROUND_AF2(874),      // Ashamane's Fall
    BATTLEGROUND_BEA2(875),      // Blade's Edge Arena
    // 878 ( "AI Test - Warsong Gulch"
    BATTLEGROUND_BRAWL_DS(879),      // Brawl - Deep Six
    BATTLEGROUND_BRAWL_AB(880),      // Brawl - Arathi Basin
    BATTLEGROUND_BRAWL_DG(881),      // Brawl - Deepwind Gorge
    BATTLEGROUND_BRAWL_ES(882),      // Brawl - Eye of the Storm
    BATTLEGROUND_BRAWL_SM(883),      // Brawl - Silvershard Mines
    BATTLEGROUND_BRAWL_TK(884),      // Brawl - Temple of Kotmogue
    BATTLEGROUND_BRAWL_TBG2(885),      // Brawl - The Battle for Gilneas
    BATTLEGROUND_BRAWL_WG(886),      // Brawl - Warsong Gulch
    BATTLEGROUND_CI(887),      // Cooking: Impossible
    BATTLEGROUND_DOM_SS(890),      // Domination - Seething Strand
    // 893 ( "8.0 BG Temp"
    BATTLEGROUND_SS(894),      // Seething Shore
    BATTLEGROUND_HP(897),      // Hooking Point
    BATTLEGROUND_RANDOM_EPIC(901),      // Random Epic Battleground
    BATTLEGROUND_TTP3(902),      // The Tiger's Peak
    BATTLEGROUND_MB(903),      // Mugambala
    BATTLEGROUND_BRAWL_AA2(904),      // Brawl - All Arenas
    BATTLEGROUND_BRAWL_AASH(905),      // Brawl - All Arenas - Stocked House
    BATTLEGROUND_AF3(906),      // Ashamane's Fall
    BATTLEGROUND_BEA3(907),      // Blade's Edge Arena
    BATTLEGROUND_BE2(908),      // Blade's Edge
    BATTLEGROUND_DS3(909),      // Dalaran Sewers
    BATTLEGROUND_NA3(910),      // Nagrand Arena
    BATTLEGROUND_RL3(911),      // Ruins of Lordaeron
    BATTLEGROUND_TVA3(912),      // Tol'Viron Arena
    BATTLEGROUND_BRHA3(913),      // Black Rook Hold Arena
    BATTLEGROUND_WG_CTF(1014),     // Warsong Gulch Capture the Flag
    BATTLEGROUND_EB_BW(1017),     // Epic Battleground - Battle for Wintergrasp
    BATTLEGROUND_DOM_AB(1018),     // Domination - Arathi Basin
    BATTLEGROUND_AB_CS(1019),     // Arathi Basin Comp Stomp
    BATTLEGROUND_EB_A(1020),     // Epic Battleground - Ashran
    BATTLEGROUND_CA(1021),     // Classic Ashran (Endless)
    BATTLEGROUND_BRAWL_AB2(1022),     // Brawl - Arathi Basin
    BATTLEGROUND_TR(1025),     // The Robodrome (Arena)
    BATTLEGROUND_RANDOM_BG(1029),     // Random Battleground
    BATTLEGROUND_EB_BW2(1030),     // Epic Battleground - Battle for Wintergrasp
    // 1031 ( "Programmer Map - Battlefield"
    BATTLEGROUND_KR(1033),     // Korrak's Revenge
    BATTLEGROUND_EPIC_BG_WF(1036),     // Epic Battleground - Warfront Arathi (PvP)
    BATTLEGROUND_DOM_DG(1037),     // Domination - Deepwind Gorge
    BATTLEGROUND_DOM_DG2(1039),     // Domination - Deepwind Gorge
    BATTLEGROUND_ED(1041);     // Empyrean Domain

    private final int value;

    BattlegroundTypeId(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
