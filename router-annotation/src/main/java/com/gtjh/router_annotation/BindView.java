package com.gtjh.router_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by android on 2018/5/24.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface BindView {
    int value();
}
