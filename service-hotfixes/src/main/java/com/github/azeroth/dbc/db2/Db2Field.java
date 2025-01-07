package com.github.azeroth.dbc.db2;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Retention(RUNTIME)
public @interface Db2Field {
    String[] name();
    Db2Type type();

    boolean signed() default false;
}
