package com.zyz.star.module.mapper;


import com.zyz.star.module.entity.Star;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StarMapper {


    List<Star> listAppStars();

    Star getAppStarDetail(Long id);

    Integer deleteById(Integer id);

    Integer insert(Star star);

    Integer update(Star star);
}