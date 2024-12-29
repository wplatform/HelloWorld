package com.github.mmo.converter;

import com.github.mmo.common.EnumFlag;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Set;

public class IntToEnumFlagConverterFactory extends Converter<EnumFlag, Integer> {

    @Override
    public Integer convert(EnumFlag source) {
        return null;
    }
}
