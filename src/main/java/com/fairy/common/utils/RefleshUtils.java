package com.fairy.common.utils;

import java.lang.reflect.Field;

/**
 * @author huanglulu
 * @version 1.0
 * @createTime 2022/4/2 20:59
 */
public class RefleshUtils {

    // 给定一个类，构造出一个对象。
    public Object create(Class clazz) throws Exception {
        Object obj = clazz.newInstance(); // 构造出对象
        return obj;
    }

    /**
     * @param obj
     * @param propertyName
     * @param value
     * @throws Exception
     */
    public void setProperty(Object obj, String propertyName, Object value) {
        Class clazz = obj.getClass();   //获取字节码对象
        Field field = null; //暴力反射获取字段  propertyName 字段名
        try {
            field = clazz.getDeclaredField(propertyName);
            field.setAccessible(true); //设置访问权限
            field.set(obj, value);   //设置值
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String firstUpper(String property) {
        return ("" + property.charAt(0)).toUpperCase() + property.substring(1);
    }

    public Object getFiled(Object obj, String propertyName) {
        Class clazz = obj.getClass();
        try {
            Object value = clazz.getMethod("get" + firstUpper(propertyName)).invoke(obj);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    public Object getProperty(Object obj, String propertyName) {
        Class clazz = obj.getClass();
        Field field = null;
        Object o = null;
        try {
            field = clazz.getDeclaredField(propertyName);
            field.setAccessible(true);
            o = field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }


}
