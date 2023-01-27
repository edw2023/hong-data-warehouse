package com.hong.dwh.database.query.executor.impl;

import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.query.builder.impl.ElasticSearchQueryBuilder;
import com.hong.dwh.database.query.connector.impl.ESConnector;
import com.hong.dwh.database.query.executor.QueryExecutor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ESQueryExecutor implements QueryExecutor {
    @Override
    public Object execute(ApiDto context) throws IOException {
        List<Map<String, Object>> result = new ArrayList<>();
        if((Boolean) context.getRequestParams().getOrDefault("Bulk_Search",false)){
            return bulkSearch(context,result);
        }
        RestHighLevelClient client = ESConnector.getInstance().getClient(context);
        SearchResponse response = null;
        try {
            SearchRequest searchRequest = ElasticSearchQueryBuilder.getSearchRequest(context);
            response = client.search(searchRequest);
        } catch (Exception e){
            client.close();
        }

        return response;
    }

    private Object bulkSearch(ApiDto context, List<Map<String, Object>> result) {
        ElasticSearchQueryBuilder.buildBulkSearchRequest(context);

    }
}
