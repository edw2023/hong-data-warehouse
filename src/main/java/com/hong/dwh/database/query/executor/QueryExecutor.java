package com.hong.dwh.database.query.executor;

import com.hong.dwh.database.dto.ApiContextDto;

public interface QueryExecutor {
    public Object execute(ApiContextDto context);
}
