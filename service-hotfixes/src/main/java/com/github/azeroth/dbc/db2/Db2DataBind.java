package com.github.azeroth.dbc.db2;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
public @interface Db2DataBind {
    String name() default "";
    int layoutHash() default -1;
    int indexField() default -1;
    int parentIndexField() default -1;
    Db2Field[] fields();
}
