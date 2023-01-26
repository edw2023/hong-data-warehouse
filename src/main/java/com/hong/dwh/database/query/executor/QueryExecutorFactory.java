package com.hong.dwh.database.query.executor;

import com.hong.dwh.database.common.HongBeanFactory;
import com.hong.dwh.database.query.executor.impl.HBaseQueryExecutor;
import com.hong.dwh.database.query.executor.impl.MySQLQueryExecutor;

public class QueryExecutorFactory {

    public QueryExecutor getQueryExecutor(String dataBaseType){

        if("HBase".equalsIgnoreCase(dataBaseType)){
            return HongBeanFactory.getBean(HBaseQueryExecutor.class);
        } else if("MySQL".equalsIgnoreCase(dataBaseType)){
            return HongBeanFactory.getBean(MySQLQueryExecutor.class);
        }else {
            return null;
        }
    }
}
