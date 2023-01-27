package com.hong.dwh.database.query.connector.impl;

import co.elastic.clients.elasticsearch.graph.Connection;
import com.hong.dwh.database.common.BeanFactory;
import com.hong.dwh.database.query.connector.DatabaseConnector;
import org.elasticsearch.client.RestHighLevelClient;

import java.util.HashMap;
import java.util.Map;

public class ESConnector implements DatabaseConnector {

    private static ESConnector instance = null;
    Long renewalTime = 30*1000*1000L;
    Long closeIntervalTime = 60*1000*1000L;
    private Map<String,Map<Long, RestHighLevelClient>> clientPool = new HashMap<>();
    private Map<Long,RestHighLevelClient> disconnectedClients = new HashMap<>();

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
