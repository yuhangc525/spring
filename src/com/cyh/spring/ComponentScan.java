package com.cyh.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 程宇航
 * @version 1.0
 * @date 2024-10-11 0:00
 * @description 扫描类路径
 */
@Retention(RetentionPolicy.RUNTIME) // 运行时
@Target(ElementType.TYPE) // 该注解只能在类上使用
public @interface ComponentScan {
    String value() default ""; // 属性value，默认为value，扫描路径
}
