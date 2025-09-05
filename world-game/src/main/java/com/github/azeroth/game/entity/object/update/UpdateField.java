package com.github.azeroth.game.entity.object.update;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public class UpdateField<T> {
    private T value;
    private final int blockBit;
    private final int bit;
    public T get() {
        return value;
    }

    public void set(T value) {
        if (!Objects.equals(this.value, value)) {
            this.value = value;
        }
    }

    public boolean wasNull() {
        return value == null;
    }
}
