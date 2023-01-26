package com.hong.dwh.database.query.connector;

import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.connector.impl.HBaseConnector;
import org.apache.hadoop.hbase.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DatabaseConnector {
    static Logger log = LoggerFactory.getLogger(DatabaseConnector.class);

    public Connection createNewConnection(ApiDto context);
    public Connection getConnection(ApiDto context);
    public void closeConnection();
}
