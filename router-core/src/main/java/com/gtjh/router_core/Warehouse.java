package com.gtjh.router_core;


import com.gtjh.router_annotation.ActivityHook;
import com.gtjh.router_annotation.model.RouteMeta;
import com.gtjh.router_core.template.IRouteGroup;
import com.gtjh.router_core.template.IService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lance
 * @date 2018/2/22
 */

public class Warehouse {

    // root 映射表 保存分组信息
    public static Map<String, Class<? extends IRouteGroup>> groupsIndex = new HashMap<>();

    // group 映射表 保存组中的所有数据
    public static Map<String, RouteMeta> routes = new HashMap<>();

    // group 映射表 保存组中的所有数据
    public static Map<Class, IService> services = new HashMap<>();


    /**
     * 保存着需要登陆才能跳转的Activityclass
     * key是类的简称
     **/
    public static Map<String, Class> activityClass = new HashMap<>();
}
