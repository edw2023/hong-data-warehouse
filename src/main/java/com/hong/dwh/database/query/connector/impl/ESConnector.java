package com.hong.dwh.database.query.connector.impl;

import co.elastic.clients.elasticsearch.graph.Connection;
import com.hong.dwh.database.common.BeanFactory;
import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.connector.DatabaseConnector;
import com.mysql.cj.util.StringUtils;
import javafx.scene.effect.SepiaTone;
import org.elasticsearch.client.RestHighLevelClient;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public RestHighLevelClient getClient(ApiDto context){
        Map<String, Object> clientPoolParams = context.getClientPoolParams();
        if(!StringUtils.isNullOrEmpty((String) clientPoolParams.getOrDefault("renewalTime",""))){
            renewalTime = Long.parseLong((String) clientPoolParams.get(renewalTime));
        }
        String connectionName = context.getConnectionName();
        if(clientPool.containsKey(connectionName)){
            return returnNewestClient(clientPool.get(connectionName),context);
        }
        return null;
    }

    private RestHighLevelClient returnNewestClient(Map<Long, RestHighLevelClient> map, ApiDto context) {
        Long clientKey = null;
        if(map.keySet().size() == 1){
            for(Long key : map.keySet()){
                clientKey = key;
            }
        } else if (map.keySet().size() > 1) {
            Set<Long> keys = map.keySet();
            Long max = Collections.max(keys);
            if(!map.containsKey(max)){
                max = keys.iterator().next();
            }
            clientKey = max;
        }


        return map.get(clientKey);
    }

    @Override
    public void closeConnection() {

    }
}
