package com.hong.dwh.database.common;


public class BeanFactory {

    private static org.springframework.beans.factory.BeanFactory beanFactory;

    public static void  setBeanFactory(org.springframework.beans.factory.BeanFactory factory){
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
