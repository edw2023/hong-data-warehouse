package com.hong.dwh.database.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ApiDto {
    String dataBaseType;
    String tableName;
    String sql;
    String driverClassName;
    String connectionUrl;
    Map<String,Object> requestParams;
}
