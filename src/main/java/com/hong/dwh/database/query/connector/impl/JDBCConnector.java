package com.hong.dwh.database.query.connector.impl;

import com.hong.dwh.database.common.BeanFactory;
import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.connector.DatabaseConnector;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConnector implements DatabaseConnector {

    private static JDBCConnector instance = null;

    private DataSource dataSource;

    private JDBCConnector() throws Exception {
        throw new Exception("Not allowed to instantiate");
    }

    public static JDBCConnector getInstance() {
        if(instance == null){
            instance = BeanFactory.getBean(JDBCConnector.class);
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
