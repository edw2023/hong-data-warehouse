package com.hong.dwh.database.query.builder.impl;

import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.builder.QueryBuilder;
import org.elasticsearch.action.search.SearchRequest;

public class ElasticSearchQueryBuilder implements QueryBuilder {
    public static void buildBulkSearchRequest(ApiDto context) {

    }

    public static SearchRequest getSearchRequest(ApiDto context) {
        return null;
    }
}
