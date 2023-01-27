package com.hong.dwh.database.query.executor;

import com.hong.dwh.database.dto.ApiDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public interface QueryExecutor {
    public Object execute(ApiDto context) throws IOException;
    static Logger log = LoggerFactory.getLogger(QueryExecutor.class);

}
