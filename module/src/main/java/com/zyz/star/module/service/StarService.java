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

    private static final int APP_PAGE_SIZE = 10;

    public List<Star> listAppStars(Integer page) {
        int currentPage = page == null || page < 1 ? 1 : page;
        int offset = (currentPage - 1) * APP_PAGE_SIZE;

        // 多查询一条，用来判断是否还有下一页
        return starMapper.listAppStars(
                offset,
                APP_PAGE_SIZE + 1
        );
    }

    public Integer getAppPageSize() {
        return APP_PAGE_SIZE;
    }

    public Star getAppStarDetail(Long id) {
        return starMapper.getAppStarDetail(id);
    }

    private static final int CONSOLE_PAGE_SIZE = 10;

    public List<Star> listConsoleStars(Integer page) {
        int offset = (page - 1) * CONSOLE_PAGE_SIZE;
        return starMapper.listConsoleStars(offset, CONSOLE_PAGE_SIZE);
    }

    public Long countConsoleStars() {
        return starMapper.countConsoleStars();
    }

    public Star getConsoleStarDetail(Long id) {
        return starMapper.getConsoleStarDetail(id);
    }

    public Integer getConsolePageSize() {
        return CONSOLE_PAGE_SIZE;
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