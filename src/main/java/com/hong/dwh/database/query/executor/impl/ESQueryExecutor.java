package com.hong.dwh.database.query.executor.impl;

import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.builder.impl.ElasticSearchQueryBuilder;
import com.hong.dwh.database.query.executor.QueryExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ESQueryExecutor implements QueryExecutor {
    @Override
    public Object execute(ApiDto context) {
        List<Map<String, Object>> result = new ArrayList<>();
        if((Boolean) context.getRequestParams().getOrDefault("Bulk_Search",false)){
            return bulkSearch(context,result);
        }


        return null;
    }

    private Object bulkSearch(ApiDto context, List<Map<String, Object>> result) {
        ElasticSearchQueryBuilder.buildBulkSearchRequest(context);
    }
}
