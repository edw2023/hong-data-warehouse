package com.hong.dwh.database.query.connector;

import com.hong.dwh.database.common.HongBeanFactory;
import com.hong.dwh.database.dto.ApiDto;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class HBaseConnector {

    private static HBaseConnector instance = null;
    private static Connection connection = null;

    private static Logger log = LoggerFactory.getLogger(HBaseConnector.class);

    public static HBaseConnector getInstance() {
        if(instance == null){
            instance = HongBeanFactory.getBean(HBaseConnector.class);
        }
        return instance;
    }

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

    public static void closeConnection() {
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

    private Connection createNewConnection(ApiDto context) {
        Configuration hBaseConfig = new Configuration();
        try {
            ConnectionFactory.createConnection(hBaseConfig);
        } catch (IOException e) {
            log.error(" - Error in connecting to HBase",e);
            closeConnection();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return null;
    }
}
