package com.gtjh.router_compiler.processor;

/**
 * @author Lance
 * @date 2018/2/22
 */


import com.google.auto.service.AutoService;
import com.gtjh.router_annotation.ActivityHook;
import com.gtjh.router_annotation.model.RouteMeta;
import com.gtjh.router_compiler.utils.Consts;
import com.gtjh.router_compiler.utils.Log;
import com.gtjh.router_compiler.utils.Utils;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import static javax.lang.model.element.Modifier.PUBLIC;


@AutoService(Processor.class)
/**
 * 处理器接收的参数 替代 {@link AbstractProcessor#getSupportedOptions()} 函数
 */
@SupportedOptions(Consts.ARGUMENTS_NAME)
/**
 * 指定使用的Java版本 替代 {@link AbstractProcessor#getSupportedSourceVersion()} 函数
 */
@SupportedSourceVersion(SourceVersion.RELEASE_7)
/**
 * 注册给哪些注解的  替代 {@link AbstractProcessor#getSupportedAnnotationTypes()} 函数
 */
@SupportedAnnotationTypes({Consts.ANN_TYPE_ACTIVITY})
public class ActivityProcessor extends AbstractProcessor {


    /**
     * key:组名 value:类名
     */
    private Map<String, String> rootMap = new TreeMap<>();
    /**
     * 节点工具类 (类、函数、属性都是节点)
     */
    private Elements elementUtils;

    /**
     * type(类信息)工具类
     */
    private Types typeUtils;
    /**
     * 文件生成器 类/资源
     */
    private Filer filerUtils;
    /**
     * 参数
     */
    private String moduleName;

    private Log log;

    /**
     * 初始化 从 {@link ProcessingEnvironment} 中获得一系列处理器工具
     *
     * @param processingEnvironment
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        //获得apt的日志输出
        log = Log.newLog(processingEnvironment.getMessager());
        elementUtils = processingEnv.getElementUtils();
        typeUtils = processingEnvironment.getTypeUtils();
        filerUtils = processingEnv.getFiler();
        //参数是模块名 为了防止多模块/组件化开发的时候 生成相同的 xx$$ROOT$$文件
        Map<String, String> options = processingEnv.getOptions();
        if (!Utils.isEmpty(options)) {
            moduleName = options.get(Consts.ARGUMENTS_NAME);
        }
        log.i("RouteProcessor Parmaters:" + moduleName);
        if (Utils.isEmpty(moduleName)) {
            throw new RuntimeException("Not set Processor Parmaters.");
        }
    }

    /**
     * 相当于main函数，正式处理注解
     *
     * @param set              使用了支持处理注解  的节点集合
     * @param roundEnvironment 表示当前或是之前的运行环境,可以通过该对象查找找到的注解。
     * @return true 表示后续处理器不会再处理(已经处理)
     */
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        //使用了需要处理的注解
        if (!Utils.isEmpty(set)) {
            //获取所有被 Route 注解的元素集合
            Set<? extends Element> routeElements = roundEnvironment.getElementsAnnotatedWith
                    (ActivityHook.class);
            //处理 Route 注解
            if (!Utils.isEmpty(routeElements)) {
                try {
                    parseRoutes(routeElements);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }

    private void parseRoutes(Set<? extends Element> routeElements) throws IOException {


        generatedGroup(routeElements);

    }

    private void generatedGroup(Set<? extends Element> routeElements) throws IOException {

        ParameterizedTypeName atlas = ParameterizedTypeName.get(
                ClassName.get(Map.class),
                ClassName.get(String.class),
                ClassName.get(Class.class)
        );
        ParameterSpec groupParamSpec = ParameterSpec.builder(atlas, "classList")
                .build();

        MethodSpec.Builder loadIntoMethodOfGroupBuilder = MethodSpec.methodBuilder
                (Consts.METHOD_LOAD_INTO)
                .addAnnotation(Override.class)
                .addModifiers(PUBLIC)
                .addParameter(groupParamSpec);

        //支持配置路由类的类型
        TypeElement activity = elementUtils.getTypeElement(Consts.ACTIVITY);
        //节点自描述 Mirror
        TypeMirror type_Activity = activity.asType();
        for (Element element : routeElements) {
            //路由信息
            RouteMeta routeMeta;
            // 使用Route注解的类信息
            TypeMirror tm = element.asType();
            log.i("activity Class: " +  element.getSimpleName());
            ActivityHook a = element.getAnnotation(ActivityHook.class);
            //是否是 Activity 使用了Route注解
            if (typeUtils.isSubtype(tm, type_Activity)) {
                loadIntoMethodOfGroupBuilder.addStatement(
                        "classList.put($S,$T.class)",
                        element.getSimpleName(),
                        tm);
            } else {
                throw new RuntimeException("[Just Support Activity/IService Route] :" + element);
            }

        }
        log.i("activity Class: 11111");
        TypeElement iActivity = elementUtils.getTypeElement(Consts.IROUTE_ACTIVITY);
        String groupClassName = Consts.NAME_OF_ACTIVITY + moduleName;
        JavaFile.builder(Consts.PACKAGE_OF_GENERATE_FILE,
                TypeSpec.classBuilder(groupClassName)
                        .addSuperinterface(ClassName.get(iActivity))
                        .addModifiers(PUBLIC)
                        .addMethod(loadIntoMethodOfGroupBuilder.build())
                        .build()
        ).build().writeTo(filerUtils);
        log.i("activity Class: 22222");
    }


}
