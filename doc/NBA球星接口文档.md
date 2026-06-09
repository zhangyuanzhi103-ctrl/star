# NBA球星接口文档

## 一、接口总览

实际开发共 7 个接口：

| 端   | 接口功能 | 请求方式 | 接口路径 |
| --- | --- | --- | --- |
| APP / 小程序 | 球星列表 | GET | `/star/list` |
| APP / 小程序 | 球星详情 | GET | `/star/info` |
| 管理后台 | 球星列表 | GET | `/star/list` |
| 管理后台 | 球星详情 | GET | `/star/info` |
| 管理后台 | 球星新增 | POST | `/star` |
| 管理后台 | 球星修改 | PUT | `/star` |
| 管理后台 | 球星删除 | DELETE | `/star` |

---

# 二、球星 APP / 小程序端

baseUrl: `http://localhost:8085`

## 1、球星列表

`/star/list`

参数：

无

返回：

```text
{
    list:[
        {
            id:[Int],
            image:[String],
            name:[String],
            team:[String]
        }
    ]
}
```

## 2、球星详情

`/star/info`

参数：

```text
id:[Int]
```

返回：

```text
{
    id:[Int],
    images:[String[]],
    name:[String],
    team:[String],
    position:[String],
    detailIntro:[String]
}
```

---

# 三、球星 CONSOLE / 管理后台

baseUrl: `http://localhost:8086`

## 1、球星列表

`/star/list`

参数：

```text
page:[Int]
```

返回：

```text
{
    list:[
        {
            id:[Int],
            image:[String],
            name:[String],
            team:[String],
            position:[String]
        }
    ],
    total:[Long],
    pageSize:[Int]
}
```

说明：

管理后台列表返回的 `list` 数据结构和 APP / 小程序列表一致，额外返回 `total` 和 `pageSize`。

## 2、球星详情

`/star/info`

参数：

```text
id:[Int]
```

返回：

```text
{
    id:[Int],
    images:[String[]],
    name:[String],
    team:[String],
    position:[String],
    detailIntro:[String],
    createTime:[String],
    updateTime:[String]
}
```

说明：

管理后台详情返回数据结构和 APP / 小程序详情一致，额外增加 `createTime` 和 `updateTime`。

时间格式：`yyyy-MM-dd HH:mm:ss`

## 3、球星新增

`POST /star`

参数：

```text
images:[String]
name:[String]
team:[String]
position:[String]
detailIntro:[String]
```

返回：

```text
添加成功，自增id为：[Int]
```

或：

```text
添加失败：该球星已存在
```

## 4、球星修改

`PUT /star`

参数：

```text
id:[Int]
images:[String]
name:[String]
team:[String]
position:[String]
detailIntro:[String]
```

返回：

```text
修改成功
```

或：

```text
修改失败
```

## 5、球星删除

`DELETE /star`

参数：

```text
id:[Int]
```

返回：

```text
删除成功
```

或：

```text
删除失败
```

---

# 四、数据库设计

```sql
CREATE TABLE `star` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '球星ID',
  `images` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '轮播图，多个图片地址使用$拼接',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '球星姓名',
  `team` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '所属球队',
  `position` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '场上位置',
  `detailIntro` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '球星简介',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0未删除，1已删除',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='NBA球星信息表';
```