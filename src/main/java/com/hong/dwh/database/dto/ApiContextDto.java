package com.hong.dwh.database.dto;

import lombok.Data;

@Data
public class ApiContextDto {
    String dataBaseType;
    String tableName;
    String sql;
}
