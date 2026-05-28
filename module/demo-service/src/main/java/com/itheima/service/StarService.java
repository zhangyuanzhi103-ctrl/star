package com.itheima.service;

import com.itheima.entity.Star;
import com.itheima.entity.domain.StarAppDetailVO;
import com.itheima.entity.domain.StarAppListVO;

import java.util.List;

public interface StarService {

    List<StarAppListVO> listAppStars();

    StarAppDetailVO getAppStarDetail(Long id);

    Boolean deleteById(Integer id);

    Boolean insert(Star star);

    Boolean update(Star star);
}