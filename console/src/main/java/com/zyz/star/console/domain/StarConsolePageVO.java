package com.zyz.star.console.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class StarConsolePageVO {

    private List<StarConsoleListVO> list;

    private Long total;

    private Integer pageSize;
}