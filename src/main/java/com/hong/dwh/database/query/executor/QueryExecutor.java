package com.hong.dwh.database.query.executor.impl;

import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.connector.impl.MySQLConnector;
import com.hong.dwh.database.query.executor.QueryExecutor;

import java.sql.Connection;
import java.sql.Statement;

public class MySQLQueryExecutor implements QueryExecutor {

    public Object execute(ApiDto context) {
        String sql = context.getSql();
        Connection connection = null;
        Statement pstmt = null;
        try{
            connection = MySQLConnector.getInstance().getDataSource(context);
        } catch (Exception e){
            log.error(e.getMessage());
        }

        return null;

    }
}
