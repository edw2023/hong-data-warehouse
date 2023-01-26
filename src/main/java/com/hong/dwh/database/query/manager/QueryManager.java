package com.hong.dwh.database.query.manager;

import com.hong.dwh.database.dto.ApiContextDto;
import com.hong.dwh.database.query.executor.QueryExecutor;
import com.hong.dwh.database.query.executor.QueryExecutorFactory;

public class QueryManager {

    private QueryExecutor queryExecutor = null;
    private QueryExecutorFactory queryExecutorFactory = new QueryExecutorFactory();
    public Object executeSQL(ApiContextDto context){
        queryExecutor = queryExecutorFactory.getQueryExecutor(context.getDataBaseType());
        return queryExecutor.execute(context);
    }
}