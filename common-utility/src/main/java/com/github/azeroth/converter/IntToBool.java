package com.github.azeroth.converter;


import org.springframework.core.convert.converter.Converter;

public class IntToBool implements Converter<Number, Boolean> {
    @Override
    public Boolean convert(Number source) {
        return source.intValue() != 0;
    }
}
