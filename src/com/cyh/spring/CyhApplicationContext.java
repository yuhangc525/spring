package com.cyh.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

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
        if (configClass.isAnnotationPresent(ComponentScan.class)) {// 判断是否包含指定注解
            ComponentScan configClassAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            // 获取注解上的路径
            String path = configClassAnnotation.value();
            path = path.replace(".", "/");
            // 获取上下文的classloader
            ClassLoader classLoader = CyhApplicationContext.class.getClassLoader();
            // 根据相对路径获取绝对路径
            URL resource = classLoader.getResource(path);
            // 将绝对路径转为file对象
            File file = new File(resource.getFile());
            // 如果file对象是一个文件夹，则通过反射执行加载流程
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    // 获取绝对路径，F:\study\out\production\study\com\cyh\service\AppConfig.class
                    String fileName = f.getAbsolutePath();
                    if (fileName.endsWith(".class")) {

                        // 此处进行了简单的转换，将绝对路径转为了com.cyh.service.AppConfig
                        String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                        className = className.replace("\\", ".");

                        // 使用反射判断类中是否存在Component注解
                        Class<?> aClass = null;
                        try {
                            // 加载的时候要获取全限定名
                            aClass = classLoader.loadClass(className);
                            if (aClass.isAnnotationPresent(Component.class)) {
                                // 如果有Component注解，则进行加载
                                // 不应直接加载bean，而是加载beandefinition
                                BeanDefinition beanDefinition = new BeanDefinition();


                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    /**
     * 根据名称获取bean
     *
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        return null;
    }
}
