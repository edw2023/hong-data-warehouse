package com.hong.dwh.database.query.executor.impl;

import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.builder.impl.SqlQueryBuilder;
import com.hong.dwh.database.query.connector.impl.JDBCConnector;
import com.hong.dwh.database.query.executor.QueryExecutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCQueryExecutor implements QueryExecutor {

    private SqlQueryBuilder sqlQueryBuilder;

    public Object execute(ApiDto context) {
        String sql = sqlQueryBuilder.buildSQL(context);
        Statement statement = null;
        Connection connection = JDBCConnector.getInstance().getDataSource(context);
            try {
                if(connection != null) {
                    statement = connection.createStatement();
                    return statement.executeQuery(sql);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        return null;

    }
}
