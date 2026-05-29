package com.zyz.star.module.service.impl;


import com.zyz.star.module.entity.Star;
import com.zyz.star.module.mapper.StarMapper;
import com.zyz.star.module.service.StarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class StarServiceImpl implements StarService {

    @Autowired
    private StarMapper starMapper;

    @Override
    public List<Star> listAppStars() {
        return starMapper.listAppStars();
    }

    @Override
    public Star getAppStarDetail(Long id) {
        return starMapper.getAppStarDetail(id);
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