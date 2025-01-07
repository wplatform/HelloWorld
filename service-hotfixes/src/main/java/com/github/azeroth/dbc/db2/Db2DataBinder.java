package com.github.azeroth.dbc.db2;


import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.Locale;
import com.github.azeroth.common.LocalizedString;
import com.github.azeroth.exeception.ValueOverflowException;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.Set;

class Db2DataBinder<T extends DbcEntity> {

    private final Db2DataBind meta;

    private Db2Field idMeta;

    private Db2Field parentIdMeta;

    private final Db2Field[] fieldMetas;

    private final Class<T> clazz;

    private BeanWrapper beanWrapper;

    Db2DataBinder(Class<T> clazz) {
        this.clazz = clazz;
        this.meta = clazz.getAnnotation(Db2DataBind.class);
        if (meta == null) {
            throw new DB2FileException("@Db2FileMate is not present on class.");
        }
        this.fieldMetas = meta.fields();
        Set<String> classFields = new LinkedHashSet<>();
        ReflectionUtils.doWithFields(clazz, field -> classFields.add(field.getName()));

        for (Db2Field fieldMeta : fieldMetas) {
            for (String name : fieldMeta.name()) {
                if (!classFields.contains(name)) {
                    throw new DB2FileException(name + " is not present on class " + clazz.getName());
                }
            }
        }

        if (meta.indexField() > -1 && meta.indexField() < fieldMetas.length) {
            idMeta = fieldAt(meta.indexField());
        } else if (meta.indexField() >= fieldMetas.length) {
            throw new DB2FileException("indexField  " + meta.indexField() + " didn't define in class " + clazz.getName());
        }

        if (meta.parentIndexField() > -1 && meta.parentIndexField() < fieldMetas.length) {
            parentIdMeta = fieldAt(meta.parentIndexField());
        } else if (meta.parentIndexField() >= fieldMetas.length) {
            throw new DB2FileException("parentIndexField  " + meta.parentIndexField() + " didn't define in class " + clazz.getName());
        }

    }


    String name() {
        return meta.name();
    }

    int layoutHash() {
        return meta.layoutHash();
    }

    int indexField() {
        return meta.indexField();
    }

    int parentIndexField() {
        return meta.parentIndexField();
    }

    Db2Field fieldAt(final int index) {
        return fieldMetas[index];
    }

    int fieldCount() {
        return fieldMetas.length;
    }

    boolean hasIndexField() {
        return idMeta != null;
    }

    boolean hasParentIndexField() {
        return parentIdMeta != null;
    }

    T newInstance() {
        T entity;
        try {
            entity = clazz.getConstructor().newInstance();
            this.beanWrapper = new BeanWrapperImpl(entity);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    int arraySize(int index) {
        return fieldAt(index).name().length;
    }

    boolean isArray(int index) {
        return fieldAt(index).name().length > 1;
    }

    void bind(String field, Object fieldVal) {
        try {
            beanWrapper.setPropertyValue(field, fieldVal);
        } catch (RuntimeException e) {
            throw new ValueOverflowException("property %s in %s is overflowed.".formatted(field , getEntityClass()), e);
        }
    }

    void bindLocalizedString(String field, Locale locale, String fieldVal) {
        Object propertyValue = beanWrapper.getPropertyValue(field);
        LocalizedString string = (LocalizedString) propertyValue;
        if (string != null) {
            string.set(locale, fieldVal);
        } else {
            string = new LocalizedString();
            string.set(locale, fieldVal);
        }
        beanWrapper.setPropertyValue(field, string);
    }

    Class<T> getEntityClass() {
        return clazz;
    }

}