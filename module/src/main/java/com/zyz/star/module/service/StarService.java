package com.zyz.star.module.service;


import com.zyz.star.module.entity.Star;

import java.util.List;

public interface StarService {

    List<Star> listAppStars();

    Star getAppStarDetail(Long id);

    Boolean deleteById(Integer id);

    Boolean insert(Star star);

    Boolean update(Star star);
}