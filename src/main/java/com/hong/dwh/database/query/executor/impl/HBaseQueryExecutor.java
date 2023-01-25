package com.hong.dwh.database.query.executor.impl;

import com.hong.dwh.database.query.executor.QueryExecutor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Table;

public class HBaseQueryExecutor implements QueryExecutor {

    @Override
    public Object execute(Object context) {
        ResultScanner scanner = null;
        Connection connection = null;
        String tableName = null;
        Table table = connection.getTable(TableName.valueOf(tableName));

        return null;
    }
}
