package com.hong.dwh.database.query.executor;

import com.hong.dwh.database.dto.ApiDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface QueryExecutor {
    public Object execute(ApiDto context);
    static Logger log = LoggerFactory.getLogger(QueryExecutor.class);
}
