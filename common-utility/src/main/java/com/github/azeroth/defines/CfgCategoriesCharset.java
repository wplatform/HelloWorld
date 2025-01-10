package com.github.azeroth.defines;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CfgCategoriesCharset implements EnumFlag.FlagValue {

    ANY     (0x00),
    LATIN1  (0x01),
    ENGLISH (0x02),
    RUSSIAN (0x04),
    KOREAN  (0x08),
    CHINESE (0x10);

    public final int value;
}
