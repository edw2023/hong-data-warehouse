package com.hong.dwh.database.query.executor.impl;

import com.hong.dwh.database.query.connector.impl.HBaseConnector;
import com.hong.dwh.database.dto.ApiDto;
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
    public Object execute(ApiDto context) {
        ResultScanner scanner = null;
        Connection connection = null;
        String tableName = context.getTableName();
        try {
            connection = HBaseConnector.getInstance().getConnection(context);
            Table table = connection.getTable(TableName.valueOf(tableName));
            Scan scan = HBaseQueryBuilder.getScan(context);
            log.info(" - Scan Object from HBase");
            scanner = table.getScanner(scan);
            log.info(" - Response received from HBase");
        } catch (IOException e) {
            log.error(" - Error in getting data from HBase" + e.getMessage());
            HBaseConnector.getInstance().closeConnection();
            throw new RuntimeException(e);
        }

        return scanner;
    }
}
