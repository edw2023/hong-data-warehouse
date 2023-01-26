package com.hong.dwh.database.controller;

import com.hong.dwh.database.dto.ApiDto;
import com.hong.dwh.database.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QueryController {

    @Autowired
    private QueryService queryService;

    public void queryFromDB(ApiDto context){
        queryService.executeQuery(context);
    }
}
