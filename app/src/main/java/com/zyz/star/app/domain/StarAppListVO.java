package com.zyz.star.app.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StarAppListVO {

    private Long id;

    /**
     * app端只需要展示一张图片
     */
    private String image;

    private String name;

    private String team;
}