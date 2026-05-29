package com.zyz.star.module.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Star {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 轮播图，使用 $ 拼接
     */
    private String images;

    /**
     * 球星姓名
     */
    private String name;

    /**
     * 所属球队
     */
    private String team;

    /**
     * 场上位置
     */
    private String position;

    /**
     * 球星简介
     */
    private String detailIntro;

    /**
     * 创建时间，Unix 时间戳
     */
    private Long createTime;

    /**
     * 更新时间，Unix 时间戳
     */
    private Long updateTime;

    /**
     * 是否删除：0 未删除，1 已删除
     */
    private Integer isDeleted;
}