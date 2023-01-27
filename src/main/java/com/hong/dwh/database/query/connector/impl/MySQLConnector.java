package com.hong.dwh.database.query.connector.impl;

import com.hong.dwh.database.common.BeanFactory;
import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.connector.DatabaseConnector;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MySQLConnector implements DatabaseConnector {

    private static MySQLConnector instance = null;

    private DataSource dataSource;

    private  MySQLConnector() throws Exception {
        throw new Exception("Not allowed to instantiate");
    }

    public static MySQLConnector getInstance() {
        if(instance == null){
            instance = BeanFactory.getBean(MySQLConnector.class);
        }
        return instance;
    }

    public Connection createNewDataSource(ApiDto context) {
        return null;
    }

    public Connection getDataSource(ApiDto context) {
        try {
            Connection connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void closeConnection() {

    }
}
