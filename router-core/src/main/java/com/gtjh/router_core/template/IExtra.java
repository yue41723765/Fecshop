package com.gtjh.router_core.template;

import android.view.View;

/**
 * 注入
 */
public interface IExtra {
    void loadIntentValue(Object target);
    void loadViewValue(Object target);
}
