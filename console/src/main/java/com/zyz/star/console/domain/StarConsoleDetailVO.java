package com.zyz.star.console.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class StarConsoleDetailVO {

    private Long id;

    private List<String> images;

    private String name;

    private String team;

    private String position;

    private String detailIntro;

    private String createTime;

    private String updateTime;
}