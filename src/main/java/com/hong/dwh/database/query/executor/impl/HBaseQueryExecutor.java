package com.hong.dwh.database.query.executor.impl;

import com.hong.dwh.database.connection.HBaseConnectionManager;
import com.hong.dwh.database.dto.ApiContextDto;
import com.hong.dwh.database.query.builder.impl.HBaseQueryBuilder;
import com.hong.dwh.database.query.executor.QueryExecutor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

public class HBaseQueryExecutor implements QueryExecutor {

    @Override
    public Object execute(ApiContextDto context) {
        ResultScanner scanner = null;
        Connection connection = null;
        String tableName = context.getTableName();
        try {
            connection = HBaseConnectionManager.getInstance().getConnection(context);
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = HBaseQueryBuilder.getScan(context);
            scanner = table.getScanner(scan);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return scanner;
    }
}
