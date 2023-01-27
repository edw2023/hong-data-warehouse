package com.hong.dwh.database.query.connector.impl;

import com.hong.dwh.database.common.BeanFactory;
import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.connector.DatabaseConnector;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
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

    public Connection createNewDataSource(ApiDto context) throws SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setAcquireIncrement(1);
        dataSource.setTestConnectionOnCheckout(true);
        dataSource.setCheckoutTimeout(1000*60*5);
        dataSource.setJdbcUrl(context.getConnectionUrl());
        dataSource.setInitialPoolSize(5);
        dataSource.setMaxPoolSize(10);
        dataSource.setMaxIdleTime(1200);
        try {
            dataSource.setDriverClass(context.getDriverClassName());
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return dataSource.getConnection();
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
