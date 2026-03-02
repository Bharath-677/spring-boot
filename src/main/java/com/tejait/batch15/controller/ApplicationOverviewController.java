package com.tejait.batch15.controller;


import com.tejait.batch15.model.ApplicationOverview;
import com.tejait.batch15.service.ApplicationOverviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("loans")

public class ApplicationOverviewController {

    ApplicationOverviewService service;

    @GetMapping("getOverviewDeatils/{appid}")
    public ApplicationOverview getOverViewId(@PathVariable int appid) {
        return service.getOverviewByAppId(appid);
    }

}
