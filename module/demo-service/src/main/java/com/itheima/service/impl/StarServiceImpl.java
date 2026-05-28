package com.itheima.service.impl;

import com.itheima.entity.Star;
import com.itheima.entity.domain.StarAppDetailVO;
import com.itheima.entity.domain.StarAppListVO;
import com.itheima.mapper.StarMapper;
import com.itheima.service.StarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class StarServiceImpl implements StarService {

    @Autowired
    private StarMapper starMapper;

    @Override
    public List<StarAppListVO> listAppStars() {
        return starMapper.listAppStars();
    }

    @Override
    public StarAppDetailVO getAppStarDetail(Long id) {
        Star star = starMapper.getAppStarDetail(id);
        log.info("查询球星详情，id={}", id);
        if (star == null) {
            log.info("球星不存在，id={}", id);
            return null;
        }

        //链式调用
        StarAppDetailVO vo = new StarAppDetailVO()
                .setId(star.getId())
                .setName(star.getName())
                .setTeam(star.getTeam())
                .setPosition(star.getPosition())
                .setDetailIntro(star.getDetailIntro());

        if (star.getImages() == null || star.getImages().isBlank()) {
            vo.setImages(Collections.emptyList());
        } else {
            vo.setImages(Arrays.asList(star.getImages().split("\\$")));
        }

        return vo;
    }

    @Override
    public Boolean deleteById(Integer id) {
        Integer rows = starMapper.deleteById(id);
        return rows > 0;
    }

    @Override
    public Boolean insert(Star star) {
        Integer rows = starMapper.insert(star);
        return rows > 0;
    }

    @Override
    public Boolean update(Star student) {
        Integer rows = starMapper.update(student);
        return rows > 0;
    }
}