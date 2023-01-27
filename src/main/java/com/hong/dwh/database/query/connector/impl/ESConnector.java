package com.hong.dwh.database.query.connector.impl;

import com.hong.dwh.database.common.BeanFactory;
import com.hong.dwh.database.query.connector.DatabaseConnector;

public class ESConnector implements DatabaseConnector {

    private static ESConnector instance = null;

    private ESConnector() throws Exception {
        throw new Exception("Not allowed to instantiate");
    }

    public static ESConnector getInstance() {
        if(instance == null){
            instance = BeanFactory.getBean(ESConnector.class);
        }
        return instance;
    }

    @Override
    public void closeConnection() {

    }
}
