package com.github.azeroth.game.domain.player;


import com.github.azeroth.common.LocalizedString;

import java.util.ArrayList;

public class PlayerChoice {
    public int choiceId;
    public int uiTextureKitId;
    public int soundKitId;
    public int closeSoundKitId;
    public long duration;
    public LocalizedString question = new LocalizedString();
    public String pendingChoiceText;
    public ArrayList<PlayerChoiceResponse> responses = new ArrayList<>();
    public boolean hideWarboardHeader;
    public boolean keepOpenAfterChoice;

    public final PlayerChoiceResponse getResponse(int responseId) {
        return responses.stream().filter(e -> e.responseID == responseId).findFirst().orElse(null);
    }

    public final PlayerChoiceResponse getResponseByIdentifier(int responseIdentifier) {
        return responses.stream().filter(e -> e.responseIdentifier == responseIdentifier).findFirst().orElse(null);
    }
}
