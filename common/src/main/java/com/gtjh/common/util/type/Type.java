package com.gtjh.common.util.type;

import android.util.Log;

import com.gtjh.common.util.type.typeimpl.TypeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2018/6/29.
 */

public class Type {
    private List<Class<?>> list = new ArrayList<>();
    private TypeBuilder builder;

    public void addClass(Class clazz) {
        list.add(clazz);
    }

    public static Type newInstance() {
        return new Type();
    }

    public Type() {
    }
    public Type getGeneticClass(Object object) {
        //获得带有泛型的直接父类的type   ModelCallback
        java.lang.reflect.Type genericSuperclass = object.getClass().getGenericSuperclass();
        // ParameterizedType 带参数的类型 泛型
        //getActualTypeArguments 参数的类型 泛型类型
        java.lang.reflect.Type type = ((java.lang.reflect.ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        getGeneticClass(type);
        return this;
    }


    protected void getGeneticClass(java.lang.reflect.Type type) {
        if (type instanceof Class) {
            this.addClass((Class) type);
        } else {
            this.addClass((Class) ((java.lang.reflect.ParameterizedType) type).getRawType());
            getGeneticClass(((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0]);

        }
    }
    public java.lang.reflect.Type build() {
        if (list.size() == 2) {
            builder= TypeBuilder.newInstance(list.get(0))
                    .addTypeParam(list.get(1));
        } else if (list.size() > 2) {

            builder= TypeBuilder.newInstance(list.get(0))
                    .beginSubType(list.get(1))
                    .addTypeParam(list.get(2)).endSubType();
        }
        return builder.build();
    }
}
