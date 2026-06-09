package com.zyz.star.app.domain;

import lombok.Data;

import java.util.List;

@Data
public class StarListVO {
    private List<StarAppListVO> list;

    private Boolean isEnd;

}
