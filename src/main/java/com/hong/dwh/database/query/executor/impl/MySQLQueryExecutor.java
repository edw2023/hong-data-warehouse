package com.hong.dwh.database.query.executor.impl;

import com.hong.dwh.database.dto.ApiContextDto;
import com.hong.dwh.database.query.executor.QueryExecutor;

import java.sql.Connection;
import java.sql.Statement;

public class MySQLQueryExecutor implements QueryExecutor {

    @Override
    public Object execute(ApiContextDto context) {
        String sql = context.getSql();
        Connection connection = null;
        Statement pstmt = null;

        return null;

    }
}
