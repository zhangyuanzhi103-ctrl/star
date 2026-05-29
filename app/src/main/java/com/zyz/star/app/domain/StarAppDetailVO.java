package com.zyz.star.app.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class StarAppDetailVO {

    private Long id;

    /**
     * 详情页可以返回完整轮播图，前端再按 $ 分割
     */
    private List<String> images;

    private String name;

    private String team;

    private String position;

    private String detailIntro;
}