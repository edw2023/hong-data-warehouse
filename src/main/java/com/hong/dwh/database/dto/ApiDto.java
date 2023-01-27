package com.hong.dwh.database.dto;

import lombok.Data;

@Data
public class ApiDto {
    String dataBaseType;
    String tableName;
    String sql;
    String driverClassName;
    String connectionUrl;
}
