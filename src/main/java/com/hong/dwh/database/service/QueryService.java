package com.hong.dwh.database.service;

import com.hong.dwh.database.dto.ApiContextDto;
import com.hong.dwh.database.query.executor.QueryExecutor;
import com.hong.dwh.database.query.executor.QueryExecutorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
    @Autowired
    private QueryExecutorFactory queryExecutorFactory;

    @Async("sqlExecutor")
    public Object executeQuery(ApiContextDto context){
        QueryExecutor queryExecutor = queryExecutorFactory.getQueryExecutor(context.getDataBaseType());
        return queryExecutor.execute(context);
    }
}
