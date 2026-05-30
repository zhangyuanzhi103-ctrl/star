# 球星APP

baseUrl: http://localhost:8085

### 1、球星列表

/star/list

参数：

返回：

```text
{
    list:[
        {
            image:[String],
            name:[String],
            team:[String],
            id:[Int]
        }
    ]
}
```

### 2、球星详情

/star/info

参数：

id:[Int]

返回：

```text
{
    images:[String[]],
    name:[String], 
    team:[String],
    position:[String], 
    detailIntro:[String]
}
```

# 商城CONSOLE

baseUrl: http://localhost:8086

### 1、球星新增

POST /star

参数：

images:[String]

name:[String]

team:[String]

position:[String]

detailIntro:[String]

返回：

添加成功，自增id为：[Int] or 添加失败：该球星已存在

### 2、产品修改

PUT /star

参数：

id:[Int]

images:[String]

name:[String]

team:[String]

position:[String]

detailIntro:[String]

返回：

成功 or 失败

### 3、产品删除

DELETE /star

参数：

id:[Int]

返回：

成功 or 失败

# 数据库设计

```sql
CREATE TABLE `nba_star` (
                            `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                            `images` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '轮播图，$拼接',
                            `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '球星姓名',
                            `team` varchar(100) NOT NULL COMMENT '所属球队',
                            `position` varchar(100) NOT NULL COMMENT '场上位置',
                            `detailIntro` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '球星简介',
                            `create_time` int unsigned NOT NULL,
                            `update_time` int unsigned NOT NULL,
                            `is_deleted` tinyint unsigned NOT NULL DEFAULT '0',
                            PRIMARY KEY (`id`),
                            KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='NBA球星信息表'
```
