package com.hong.dwh.database.query.executor;

import com.hong.dwh.database.common.BeanFactory;
import com.hong.dwh.database.query.executor.impl.HBaseQueryExecutor;
import com.hong.dwh.database.query.executor.impl.MySQLQueryExecutor;

public class QueryExecutorFactory {

    public QueryExecutor getQueryExecutor(String dataBaseType){

        if("HBase".equalsIgnoreCase(dataBaseType)){
            return BeanFactory.getBean(HBaseQueryExecutor.class);
        } else if("MySQL".equalsIgnoreCase(dataBaseType)){
            return BeanFactory.getBean(MySQLQueryExecutor.class);
        }else {
            return null;
        }
    }
}
