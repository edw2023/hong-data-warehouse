package com.hong.dwh.database.query.executor;

import com.hong.dwh.database.dto.ApiContextDto;
import com.hong.dwh.database.query.executor.impl.HBaseQueryExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface QueryExecutor {
    public Object execute(ApiContextDto context);
    static Logger log = LoggerFactory.getLogger(QueryExecutor.class);
}
