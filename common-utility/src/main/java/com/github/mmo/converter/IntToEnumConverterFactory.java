package com.github.mmo.converter;

import com.github.mmo.common.EnumFlag;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class IntToEnumConverterFactory implements ConverterFactory<String, Enum<?>> {


    @Override
    public <T extends Enum<?>> Converter<String, T> getConverter(Class<T> targetType) {
        return new IntToEnumConverter(targetType);
    }

    private static final class IntToEnumConverter<T extends Enum<T>> implements Converter<String, T> {

        private Class<T> enumType;

        public IntToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        public T convert(String source) {

            return Enum.valueOf(this.enumType, source.trim());
        }
    }
}
