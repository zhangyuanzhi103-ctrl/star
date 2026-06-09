package com.zyz.star.console.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class StarConsoleListVO {

    private Long id;

    private String image;

    private String name;

    private String team;

    private String position;
}