package com.zyz.star.module.mapper;


import com.zyz.star.module.entity.Star;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StarMapper {


    List<Star> listAppStars(
            @Param("offset") Integer offset,
            @Param("limit") Integer limit
    );

    Star getAppStarDetail(Long id);

    List<Star> listConsoleStars(
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize
    );

    Long countConsoleStars();

    Star getConsoleStarDetail(Long id);

    Integer deleteById(Integer id);

    Integer insert(Star star);

    //针对insert方法的查重
    Integer countByNameTeamPosition(
            @Param("name") String name,
            @Param("team") String team,
            @Param("position") String position
    );

    Integer update(Star star);
}