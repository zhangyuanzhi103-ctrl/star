package com.itheima.mapper;

import com.itheima.entity.Star;
import com.itheima.entity.domain.StarAppListVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StarMapper {


    List<StarAppListVO> listAppStars();

    Star getAppStarDetail(Long id);

    Integer deleteById(Integer id);

    Integer insert(Star star);

    Integer update(Star star);
}