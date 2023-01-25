package com.hong.dwh.database.common;


import org.springframework.beans.factory.BeanFactory;

public class HongBeanFactory {

    private static BeanFactory beanFactory;

    public static void  setBeanFactory(BeanFactory factory){
        beanFactory = factory;
    }

    public static <T> T getBean(String beanName){
        if(beanFactory == null){
        }
        return (T)beanFactory.getBean(beanName);
    }

    public static <T> T getBean(Class<T> type){
        if(beanFactory == null){
        }
        return (T)beanFactory.getBean((Class) type);
    }


 }
