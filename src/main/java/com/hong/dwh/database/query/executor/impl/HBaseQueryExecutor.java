package com.hong.dwh.database.query.executor.impl;

import com.hong.dwh.database.dto.DatabaseContextDto;
import com.hong.dwh.database.query.executor.QueryExecutor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

public class HBaseQueryExecutor implements QueryExecutor {

    @Override
    public Object execute(DatabaseContextDto context) {
        ResultScanner scanner = null;
        Connection connection = null;
        String tableName = context.getTableName();
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
