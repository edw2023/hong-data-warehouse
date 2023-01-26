package com.hong.dwh.database.query.executor;

import com.hong.dwh.database.common.HongBeanFactory;
import com.hong.dwh.database.query.executor.impl.HBaseQueryExecutor;

public class QueryExecutorFactory {

    public QueryExecutor getQueryExecutor(String dataBaseType){

        if("ElasticSearch".equalsIgnoreCase(dataBaseType)){
            return HongBeanFactory.getBean(ElasticSearchQueryExecutor.class);
        } else if("HBase".equalsIgnoreCase(dataBaseType)){
            return HongBeanFactory.getBean(HBaseQueryExecutor.class);
        } else {
            return null;
        }
    }
}
