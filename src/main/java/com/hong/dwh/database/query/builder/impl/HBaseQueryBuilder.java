package com.hong.dwh.database.query.builder.impl;

import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.builder.QueryBuilder;
import org.apache.hadoop.hbase.client.Scan;

public class HBaseQueryBuilder implements QueryBuilder {
    public static Scan getScan(ApiDto context){
        Scan scan = new Scan();
        scan.setMaxResultSize(1000);
        scan.setLimit(10000);
        scan.setRowPrefixFilter(null);
        scan.setFilter(null);
        return scan;
    }
}
