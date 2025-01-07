package com.github.azeroth.defines;

public enum AiReaction {
    AI_REACTION_ALERT,                               // pre-aggro (used in client packet handler)
    AI_REACTION_FRIENDLY,                               // (NOT used in client packet handler)
    AI_REACTION_HOSTILE,                               // sent on every attack, triggers aggro sound (used in client packet handler)
    AI_REACTION_AFRAID,                               // seen for polymorph (when AI not in control of self?) (NOT used in client packet handler)
    AI_REACTION_DESTROY                                  // used on object destroy (NOT used in client packet handler)
}
