package com.github.mmo.defines;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PetNameInvalidReason {
    // custom, not send
    SUCCESS(0),

    INVALID(1),
    NO_NAME(2),
    TOO_SHORT(3),
    TOO_LONG(4),
    MIXED_LANGUAGES(6),
    PROFANE(7),
    RESERVED(8),
    THREE_CONSECUTIVE(11),
    INVALID_SPACE(12),
    CONSECUTIVE_SPACES(13),
    RUSSIAN_CONSECUTIVE_SILENT_CHARACTERS(14),
    RUSSIAN_SILENT_CHARACTER_AT_BEGINNING_OR_END(15),
    DECLENSION_DOESNT_MATCH_BASE_NAME(16);
    public final int value;
}
