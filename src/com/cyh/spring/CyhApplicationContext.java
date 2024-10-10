package com.cyh.spring;

import java.lang.annotation.Annotation;

/**
 * @author 程宇航
 * @version 1.0
 * @date 2024-10-10 23:57
 * @description IOC容器
 */
public class CyhApplicationContext {

    private Class configClass;

    public CyhApplicationContext(Class configClass) {
        this.configClass = configClass;
        // 扫描
        if (configClass.isAnnotationPresent(ComponentScan.class)){// 判断是否包含指定注解
            ComponentScan configClassAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            // 获取注解上的路径
            String path = configClassAnnotation.value();

        }
    }

    /**
     * 根据名称获取bean
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        return null;
    }
}
