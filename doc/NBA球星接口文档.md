# 球星 APP

baseUrl: `http://localhost:8081`

## 1、球星列表

接口地址：

```text
GET /star/list
```

参数：

无

返回：

```json
{
  "list": [
    {
      "image": "https://example.com/star.jpg",
      "name": "勒布朗·詹姆斯",
      "team": "LAL",
      "id": 1
    }
  ]
}
```

字段说明：

| 字段名   | 类型      | 说明     |
| ----- | ------- | ------ |
| list  | Array   | 球星列表   |
| image | String  | 球星图片   |
| name  | String  | 球星姓名   |
| team  | String  | 所属球队简称 |
| id    | Integer | 球星 ID  |

## 2、球星详情

接口地址：

```text
GET /star/info
```

参数：

| 参数名 | 类型      | 是否必填 | 说明    |
| --- | ------- | ---- | ----- |
| id  | Integer | 是    | 球星 ID |

返回：

```json
{
  "images": [
    "https://example.com/star1.jpg",
    "https://example.com/star2.jpg"
  ],
  "name": "勒布朗·詹姆斯",
  "team": "LAL",
  "position": "前锋",
  "detailIntro": "勒布朗·詹姆斯，美国职业篮球运动员，司职前锋。"
}
```

字段说明：

| 字段名         | 类型     | 说明     |
| ----------- | ------ | ------ |
| images      | Array  | 球星轮播图  |
| name        | String | 球星姓名   |
| team        | String | 所属球队简称 |
| position    | String | 场上位置   |
| detailIntro | String | 球星简介   |

# 球星 CONSOLE

baseUrl: `http://localhost:8082`

## 1、球星新增

接口地址：

```text
POST /star/create
```

参数：

```json
{
  "images": "https://example.com/star1.jpg$https://example.com/star2.jpg",
  "name": "勒布朗·詹姆斯",
  "team": "LAL",
  "position": "前锋",
  "detailIntro": "勒布朗·詹姆斯，美国职业篮球运动员，司职前锋。"
}
```

字段说明：

| 字段名         | 类型     | 是否必填 | 说明                  |
| ----------- | ------ | ---- | ------------------- |
| images      | String | 是    | 轮播图，多个图片地址使用 `$` 拼接 |
| name        | String | 是    | 球星姓名                |
| team        | String | 是    | 所属球队简称              |
| position    | String | 是    | 场上位置                |
| detailIntro | String | 否    | 球星简介                |

返回：

```text
成功
```

或：

```text
失败
```

## 2、球星修改

接口地址：

```text
PUT /star/update/{id}
```

参数：

路径参数：

| 参数名 | 类型      | 是否必填 | 说明    |
| --- | ------- | ---- | ----- |
| id  | Integer | 是    | 球星 ID |

请求体：

```json
{
  "images": "https://example.com/star1.jpg$https://example.com/star2.jpg",
  "name": "勒布朗·詹姆斯",
  "team": "LAL",
  "position": "前锋",
  "detailIntro": "勒布朗·詹姆斯，美国职业篮球运动员，司职前锋。"
}
```

字段说明：

| 字段名         | 类型     | 是否必填 | 说明                  |
| ----------- | ------ | ---- | ------------------- |
| images      | String | 是    | 轮播图，多个图片地址使用 `$` 拼接 |
| name        | String | 是    | 球星姓名                |
| team        | String | 是    | 所属球队简称              |
| position    | String | 是    | 场上位置                |
| detailIntro | String | 否    | 球星简介                |

返回：

```text
成功
```

或：

```text
失败
```

## 3、球星删除

接口地址：

```text
DELETE /star/delete/{id}
```

参数：

路径参数：

| 参数名 | 类型      | 是否必填 | 说明    |
| --- | ------- | ---- | ----- |
| id  | Integer | 是    | 球星 ID |

返回：

```text
成功
```

或：

```text
失败
```

# 数据库设计

```sql
CREATE TABLE `star` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='NBA球星信息表';
```
