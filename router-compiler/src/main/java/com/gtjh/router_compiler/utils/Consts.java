package com.gtjh.router_compiler.utils;


import com.squareup.javapoet.ClassName;

/**
 * @author Lance
 * @date 2018/2/22
 */

public class Consts {


    public static final ClassName ROUTER = ClassName.get("com.gtjh.router_core", "GTJHRouter");

    public static final String ARGUMENTS_NAME = "moduleName";
    public static final String ANN_TYPE_ROUTE = "com.gtjh.router_annotation.Route";
    public static final String ANN_TYPE_EXTRA = "com.gtjh.router_annotation.Extra";
    public static final String ANN_TYPE_BINDVIEW = "com.gtjh.router_annotation.BindView";
    public static final String ANN_TYPE_ACTIVITY = "com.gtjh.router_annotation.ActivityHook";

    public static final String IROUTE_GROUP = "com.gtjh.router_core.template.IRouteGroup";
    public static final String IROUTE_ROOT = "com.gtjh.router_core.template.IRouteRoot";
    public static final String IROUTE_ACTIVITY= "com.gtjh.router_core.template.IActivity";
    public static final String IEXTRA = "com.gtjh.router_core.template.IExtra";
    public static final String IBINDFRAGMENT = "com.gtjh.router_core.template.IBindFragment";
    public static final String METHOD_LOAD_INTO = "loadInto";
    public static final String METHOD_LOAD_INTENT= "loadIntentValue";
    public static final String METHOD_LOAD_View= "loadViewValue";
    public static final String ACTIVITY = "android.app.Activity";
    public static final String FRAGMENT = "android.support.v4.app.Fragment";
    public static final String ISERVICE = "com.gtjh.router_core.template.IService";


    private static final String LANG = "java.lang";
    public static final String BYTE = LANG + ".Byte";
    public static final String SHORT = LANG + ".Short";
    public static final String INTEGER = LANG + ".Integer";
    public static final String LONG = LANG + ".Long";
    public static final String FLOAT = LANG + ".Float";
    public static final String DOUBEL = LANG + ".Double";
    public static final String BOOLEAN = LANG + ".Boolean";
    public static final String STRING = LANG + ".String";
    public static final String ARRAY = "ARRAY";

    public static final String BYTEARRAY = "byte[]";
    public static final String SHORTARRAY = "short[]";
    public static final String BOOLEANARRAY = "boolean[]";
    public static final String CHARARRAY = "char[]";
    public static final String DOUBLEARRAY = "double[]";
    public static final String FLOATARRAY = "float[]";
    public static final String INTARRAY = "int[]";
    public static final String LONGARRAY = "long[]";
    public static final String STRINGARRAY = "java.lang.String[]";

    public static final String ARRAYLIST = "java.util.ArrayList";
    public static final String LIST = "java.util.List";


    public static final String PARCELABLE = "android.os.Parcelable";


    public static final String SEPARATOR = "_";
    public static final String PROJECT = "GTJHRouter";
    public static final String NAME_OF_ROOT = PROJECT + SEPARATOR + "Root" + SEPARATOR;
    public static final String NAME_OF_GROUP = PROJECT + SEPARATOR + "Group" + SEPARATOR;
    public static final String NAME_OF_ACTIVITY = PROJECT + SEPARATOR + "Activity" + SEPARATOR;
    public static final String NAME_OF_EXTRA = SEPARATOR + "Activity";
    public static final String NAME_OF_FRAGMENT = SEPARATOR + "Fragment";
    public static final String NAME_OF_VIEW = SEPARATOR + "View";
    public static final String PACKAGE_OF_GENERATE_FILE = "com.gtjh.router.routes";

}
