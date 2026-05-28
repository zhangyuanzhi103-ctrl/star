package com.itheima.app.controller;

import com.itheima.common.Result;
import com.itheima.service.StarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/stars")
public class StarController {

    @Autowired
    private StarService starService;

    @GetMapping("/list")
    public Result findAll() {
        log.info("进入瀑布流列表...");
        return Result.success(starService.listAppStars());
    }

    @GetMapping("/info/{id}")
    public Result findById(@PathVariable Long id) {
        log.info("进入球星详情...");
        return Result.success(starService.getAppStarDetail(id));
    }
}