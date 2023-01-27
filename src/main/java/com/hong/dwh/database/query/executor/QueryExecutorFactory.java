package com.hong.dwh.database.query.executor;

import com.hong.dwh.database.common.BeanFactory;
import com.hong.dwh.database.query.executor.impl.ESQueryExecutor;
import com.hong.dwh.database.query.executor.impl.HBaseQueryExecutor;
import com.hong.dwh.database.query.executor.impl.JDBCQueryExecutor;

public class QueryExecutorFactory {

    public QueryExecutor getQueryExecutor(String dataBaseType){

        if("HBase".equalsIgnoreCase(dataBaseType)){
            return BeanFactory.getBean(HBaseQueryExecutor.class);
        } else if("MySQL".equalsIgnoreCase(dataBaseType)){
            return BeanFactory.getBean(JDBCQueryExecutor.class);
        } else if("ElasticSearch".equalsIgnoreCase(dataBaseType)){
            return BeanFactory.getBean(ESQueryExecutor.class);
        } else {
            return null;
        }
    }
}
