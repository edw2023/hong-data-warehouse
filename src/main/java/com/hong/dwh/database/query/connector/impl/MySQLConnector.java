package com.hong.dwh.database.query.connector.impl;

import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.connector.DatabaseConnector;
import org.apache.hadoop.hbase.client.Connection;

public class MySQLConnector implements DatabaseConnector {

    @Override
    public Connection createNewConnection(ApiDto context) {
        return null;
    }

    @Override
    public Connection getConnection(ApiDto context) {
        return null;
    }

    @Override
    public void closeConnection() {

    }
}
