package com.hong.dwh.database.query.builder.impl;

import com.hong.dwh.database.dto.ApiContextDto;
import com.hong.dwh.database.query.builder.QueryBuilder;
import org.apache.hadoop.hbase.client.Scan;

public class HBaseQueryBuilder implements QueryBuilder {
    public static Scan getScan(ApiContextDto context){
        Scan scan = new Scan();
        scan.setMaxResultSize(1000);
        scan.setLimit(10000);
        scan.setRowPrefixFilter(null);
        scan.setFilter(null);
        return scan;
    }
}
