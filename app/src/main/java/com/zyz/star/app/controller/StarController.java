package com.zyz.star.app.controller;

import com.zyz.star.app.domain.StarAppDetailVO;
import com.zyz.star.app.domain.StarAppListVO;
import com.zyz.star.app.domain.StarListVO;
import com.zyz.star.module.entity.Star;
import com.zyz.star.module.service.StarService;
import com.zyz.star.module.util.StarImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/star")
public class StarController {

    @Autowired
    private StarService starService;

    @GetMapping("/list")
    public StarListVO findAll(@RequestParam Integer page) {
        log.info("进入APP球星列表接口，page={}", page);

        List<Star> stars = starService.listAppStars(page);
        int pageSize = starService.getAppPageSize();

        boolean isEnd = stars.size() <= pageSize;

        if (!isEnd) {
            stars = new ArrayList<>(stars.subList(0, pageSize));
        }

        List<StarAppListVO> voList = stars.stream()
                .map(star -> new StarAppListVO()
                        .setId(star.getId())
                        .setImage(StarImageUtil.getFirstImage(star.getImages()))
                        .setName(star.getName())
                        .setTeam(star.getTeam()))
                .toList();

        StarListVO result = new StarListVO();
        result.setList(voList);
        result.setIsEnd(isEnd);

        return result;
    }

    @GetMapping("/info")
    public StarAppDetailVO findById(@RequestParam Long id) {
        log.info("进入球星详情接口，id={}", id);

        Star star = starService.getAppStarDetail(id);

        if (star == null) {
            return null;
        }

        return new StarAppDetailVO()
                .setId(star.getId())
                .setImages(StarImageUtil.splitImages(star.getImages()))
                .setName(star.getName())
                .setTeam(star.getTeam())
                .setPosition(star.getPosition())
                .setDetailIntro(star.getDetailIntro());
    }
}