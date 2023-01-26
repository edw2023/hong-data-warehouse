package com.hong.dwh.database.controller;

import com.hong.dwh.database.dto.ApiContextDto;
import com.hong.dwh.database.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QueryController {

    @Autowired
    private QueryService queryService;

    public void queryFromDB(ApiContextDto context){
        queryService.executeQuery(context);
    }
}
