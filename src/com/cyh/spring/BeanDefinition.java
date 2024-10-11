package com.cyh.spring;

/**
 * @author 程宇航
 * @version 1.0
 * @date 2024-10-12 0:27
 * @description bean元数据
 */
public class BeanDefinition {

    // 名称
    private String type;

    // 类型，单例或多例
    private String scope;

    public BeanDefinition(){

    }

    public BeanDefinition(String type, String scope) {
        this.type = type;
        this.scope = scope;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
