package com.zyz.star.console.controller;

import com.zyz.star.console.domain.StarConsoleDetailVO;
import com.zyz.star.console.domain.StarConsoleListVO;
import com.zyz.star.console.domain.StarConsolePageVO;
import com.zyz.star.module.entity.Star;
import com.zyz.star.module.service.StarService;
import com.zyz.star.module.util.StarImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/star")
public class StarController {

    @Autowired
    private StarService starService;

    @GetMapping("/list")
    public StarConsolePageVO findPage(@RequestParam Integer page) {
        log.info("进入console球星列表接口，page={}", page);

        List<StarConsoleListVO> list = starService.listConsoleStars(page)
                .stream()
                .map(star -> new StarConsoleListVO()
                        .setId(star.getId())
                        .setImage(StarImageUtil.getFirstImage(star.getImages()))
                        .setName(star.getName())
                        .setTeam(star.getTeam())
                        .setPosition(star.getPosition()))
                .toList();

        return new StarConsolePageVO()
                .setList(list)
                .setTotal(starService.countConsoleStars())
                .setPageSize(starService.getConsolePageSize());
    }

    @GetMapping("/info")
    public StarConsoleDetailVO findById(@RequestParam Long id) {
        log.info("进入console球星详情接口，id={}", id);

        Star star = starService.getConsoleStarDetail(id);

        if (star == null) {
            return null;
        }

        return new StarConsoleDetailVO()
                .setId(star.getId())
                .setImages(StarImageUtil.splitImages(star.getImages()))
                .setName(star.getName())
                .setTeam(star.getTeam())
                .setPosition(star.getPosition())
                .setDetailIntro(star.getDetailIntro())
                .setCreateTime(StarImageUtil.formatTime(star.getCreateTime()))
                .setUpdateTime(StarImageUtil.formatTime(star.getUpdateTime()));
    }

    @DeleteMapping
    public String deleteById(@RequestParam Integer id) {
        log.info("删除的ID为：{}", id);
        Boolean flag = starService.deleteById(id);
        return flag ? "删除成功" : "删除失败";
    }

    @PostMapping
    public String insert(@RequestBody Star star) {
        log.info("添加的球星信息为：{}", star);
        return starService.insert(star);
    }

    @PutMapping
    public String update(@RequestBody Star star) {
        log.info("修改的球星信息为：{}", star);
        Boolean flag = starService.update(star);
        return flag ? "修改成功" : "修改失败";
    }
}