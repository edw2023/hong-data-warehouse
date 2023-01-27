package com.hong.dwh.database.query.connector.impl;

import com.hong.dwh.database.common.BeanFactory;
import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.connector.DatabaseConnector;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class HBaseConnector implements DatabaseConnector {

    private static HBaseConnector instance = null;
    private static Connection connection = null;

    private  HBaseConnector() throws Exception {
        throw new Exception("Not allowed to instantiate");
    }

    public static HBaseConnector getInstance() {
        if(instance == null){
            instance = BeanFactory.getBean(HBaseConnector.class);
        }
        return instance;
    }

    @Override
    public Connection getConnection(ApiDto context){
        if(connection == null){
            log.info("Creating new HBase connection");
            connection = createNewConnection(context);
        } else if (connection.isClosed()) {
            closeConnection();
            log.info("Creating new HBase connection");
            connection = createNewConnection(context);
        }
        return connection;
    }

    @Override
    public void closeConnection() {
        if(connection != null) {
            try {
                log.info("Closing old HBase connection");
                connection.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        connection = null;
    }
    @Override
    public Connection createNewConnection(ApiDto context) {
        Configuration hBaseConfig = new Configuration();
        try {
            connection = ConnectionFactory.createConnection(hBaseConfig);
        } catch (IOException e) {
            log.error(" - Error in connecting to HBase",e);
            closeConnection();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return connection;
    }
}
