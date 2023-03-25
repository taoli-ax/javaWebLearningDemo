
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
`name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '',
`password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '',
`avator` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '头像',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';



DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
`order_serial` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '订单号',
`user_id` bigint(20) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT 'FK',
`order_at` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '下单时间',
`receiver` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '收件人',
`pay_method` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '支付方式',
`totoal_price` decimal(10,2) COLLATE utf8mb4_unicode_ci DEFAULT 0.00 COMMENT '总金额',
`order_status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '订单状态',
`phone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '',
`address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '',
PRIMARY KEY (`id`) USING BTREE,
constraint fk_order_user foreign key(`user_id`) references user(`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='订单表';



DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
`id` bigint(20) not null AUTO_INCREMENT COMMENT '序号',
`name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '',
PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='分类表';


DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
`id` bigint(20) not null AUTO_INCREMENT COMMENT '序号',
`serial` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '商品编号',
`name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '商品名',
`author` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '作者',
`publisher` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '出版社',
`public_time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '出版时间',
`category_id` bigint(10) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT 'FK',
`caption` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '商品描述',
`image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '商品图片',
`inventory` int(10) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '库存数量',
`market_price` decimal(10,2) COLLATE utf8mb4_unicode_ci DEFAULT 0.00 COMMENT '市场价',
`retail_price` decimal(10,2) COLLATE utf8mb4_unicode_ci DEFAULT 0.00 COMMENT '销售价',
`comment_socre` double(10,2) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '评分',
`comment_num` int(10) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '评论数量',
`availability_time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '上架时间',
`sales` int(10) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '销量',
`is_new` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '是否新品',
`is_sale_well` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '是否畅销',
`goods_states` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '商品状态',
PRIMARY KEY (`id`) USING BTREE,
constraint fk_goods foreign key(`category_id`) references  category(`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='商品表';

DROP TABLE IF EXISTS `order_option`;
CREATE TABLE `order_option` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
`order_id` bigint(20) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT 'FK:订单ID',
`goods_id` bigint(20) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT 'FK:商品ID',
`goods_quantity` int(10) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '商品数量',
`subtotal` decimal(10,2) COLLATE utf8mb4_unicode_ci DEFAULT 0.00 COMMENT '小计',
PRIMARY KEY (`id`) USING BTREE,
foreign key(`goods_id`) references goods(`id`) ON DELETE CASCADE,
foreign key(`order_id`) references `order`(`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='订单项表';

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
`user_id` bigint(20) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT 'FK',
`goods_id` bigint(20) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT 'FK',
`goods_quantity` int(10) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '商品数量',
`subtotal` decimal(10,2) COLLATE utf8mb4_unicode_ci DEFAULT 0.00 COMMENT '小计',
PRIMARY KEY (`id`) USING BTREE,
constraint fk_cart_goods foreign key(`goods_id`) references goods(`id`) ON DELETE CASCADE,
constraint fk_cart_user foreign key(`user_id`) references user(`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='';

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
`name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '地址名',
`user_id` bigint(20) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT ' FK:用户i=ID',
`receiver` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '收件人',
`province` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '省份',
`city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '城市',
`street` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '街道',
`tel` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '电话',
PRIMARY KEY (`id`) USING BTREE,
constraint fk_address_user foreign key(`user_id`) references user(`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='地址表';


DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '序号',
`goods_id` bigint(20) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT 'FK:商品ID',
`user_id` bigint(20) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT ' FK:用户i=ID',
`content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '评论内容',
`create_at` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '评论时间',
`comment_socre` int(10) COLLATE utf8mb4_unicode_ci DEFAULT null COMMENT '评分',
PRIMARY KEY (`id`) USING BTREE,
constraint fk_comment_user foreign key(`user_id`) references user(`id`) ON DELETE CASCADE,
constraint fk_comment_goods foreign key(`goods_id`) references goods(`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='评论表';














