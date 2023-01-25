package com.hong.dwh.database.query.executor;

import com.hong.dwh.database.common.HongBeanFactory;
import com.hong.dwh.database.query.executor.impl.ElasticSearchQueryExecutor;

public class QueryExecutorFactory {

    public QueryExecutor getQueryExecutor(Object context){
        String dataBaseType = null;

        if("ElasticSearch".equalsIgnoreCase(dataBaseType)){
            return HongBeanFactory.getBean(ElasticSearchQueryExecutor.class);
        } else {
            return null;
        }
    }
}
