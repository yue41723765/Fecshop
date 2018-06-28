package com.gtjh.router_compiler.utils;

import com.gtjh.router_annotation.BindView;
import com.gtjh.router_annotation.Extra;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;

import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;


/**
 * @author Lance
 * @date 2018/2/26
 */

public class LoadFragmentBuilder {

    private static final String INJECT_TARGET = "$T t = ($T)target";
    private MethodSpec.Builder builder;
    private Elements elementUtils;
    private Types typeUtils;

    //
    private TypeMirror parcelableType;
    private TypeMirror iServiceType;

    public LoadFragmentBuilder(ParameterSpec parameterSpec) {
        // 函数 public void loadExtra(Object target)
        builder=  MethodSpec.methodBuilder(Consts
                .METHOD_LOAD_View)
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .addParameter(parameterSpec);
    }
    /***
     * findViewById方法体
     *
     *
     * **/
    public void buildFindViewByIdBody(Element element) {
        TypeMirror typeMirror = element.asType();
        //属性名 String text 获得text
        String fieldName = element.getSimpleName().toString();
        //获得注解 name值
        int redId = element.getAnnotation(BindView.class).value();
        String defaultValue = "t." + fieldName;
        String statement = defaultValue +"=t.findViewById($L)";
        builder.addStatement(statement, redId);
    }
    public void setElementUtils(Elements elementUtils) {
        this.elementUtils = elementUtils;
        parcelableType = elementUtils.getTypeElement(Consts
                .PARCELABLE).asType();
        iServiceType = elementUtils.getTypeElement(Consts
                .ISERVICE).asType();
    }

    public void setTypeUtils(Types typeUtils) {
        this.typeUtils = typeUtils;
    }



    /**
     * 加入 $T t = ($T)target
     *
     * @param className
     */
    public void injectTarget(ClassName className) {
        builder.addStatement(INJECT_TARGET, className, className);

    }

    public MethodSpec build() {
        return builder.build();

    }
}
