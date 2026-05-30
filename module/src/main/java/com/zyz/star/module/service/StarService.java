package com.zyz.star.module.service;

import com.zyz.star.module.entity.Star;
import com.zyz.star.module.mapper.StarMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StarService {

    @Autowired
    private StarMapper starMapper;

    public List<Star> listAppStars() {
        return starMapper.listAppStars();
    }

    public Star getAppStarDetail(Long id) {
        return starMapper.getAppStarDetail(id);
    }

    public Boolean deleteById(Integer id) {
        Integer rows = starMapper.deleteById(id);
        return rows != null && rows > 0;
    }

    /**
     * 新增球星，并返回自增 id
     */
    public String insert(Star star) {
        Integer count = starMapper.countByNameTeamPosition(
                star.getName(),
                star.getTeam(),
                star.getPosition()
        );

        if (count != null && count > 0) {
            return "添加失败：该球星已存在";
        }

        Integer rows = starMapper.insert(star);

        if (rows != null && rows > 0) {
            return "添加成功，自增id为：" + star.getId();
        }

        return "添加失败";
    }

    public Boolean update(Star star) {
        Integer rows = starMapper.update(star);
        return rows != null && rows > 0;
    }
}