/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/06/2020 22:55:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `customer_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产地',
  `public_time` int(0) NULL DEFAULT NULL COMMENT '评论时间',
  `score` int(0) NULL DEFAULT NULL COMMENT '评分等级',
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `vx_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` int(0) NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `addr` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `head_portrait` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('a1234567', 'dddd', '张三', 1, '15086646009', '淡淡的', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_customer` VALUES ('sQFUPs7G', '123', '123', NULL, '130', '11111', '1111111', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_files
-- ----------------------------
DROP TABLE IF EXISTS `t_files`;
CREATE TABLE `t_files`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路径',
  `size` int(0) NULL DEFAULT NULL COMMENT '大小B',
  `ext` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '后缀名',
  `extrafield_A` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `original_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件上传前名字',
  `operator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `location` int(0) NULL DEFAULT NULL COMMENT '图片位置0title 1banner 2property',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_files
-- ----------------------------
INSERT INTO `t_files` VALUES ('0cSBnnqw', 'd167a2670e1241878f7d50c56c9bc520', 'F:\\workspace_idea\\onlineshop\\images\\d167a2670e1241878f7d50c56c9bc520', 32631, '.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'admin', NULL);
INSERT INTO `t_files` VALUES ('1hhES0Aq', '93f293b31e2d43618c39f1767bf8ced5', 'F:\\workspace_idea\\onlineshop\\images\\93f293b31e2d43618c39f1767bf8ced5', 32631, 'jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_files` VALUES ('9i0EGtpJ', '9d952de6d42043ceb4b1a5e4a3480742', 'F:\\workspace_idea\\onlineshop\\images\\9d952de6d42043ceb4b1a5e4a3480742', 24741, '.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'admin', NULL);
INSERT INTO `t_files` VALUES ('9w70uwzB', 'd167a2670e1241878f7d50c56c9bc520', 'F:\\workspace_idea\\onlineshop\\images\\d167a2670e1241878f7d50c56c9bc520', 44205, '.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'admin', NULL);
INSERT INTO `t_files` VALUES ('IRvp7HFK', 'b004703bf81e4b6e97e61c4b586723db', 'F:\\workspace_idea\\onlineshop\\images\\b004703bf81e4b6e97e61c4b586723db', 32631, 'jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_files` VALUES ('IWlHW2D0', '9d952de6d42043ceb4b1a5e4a3480742', 'F:\\workspace_idea\\onlineshop\\images\\9d952de6d42043ceb4b1a5e4a3480742', 44205, '.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'admin', NULL);
INSERT INTO `t_files` VALUES ('kdOULY3G', 'b9edfb0f680640ef9b94352d305dee49', 'F:\\workspace_idea\\onlineshop\\images\\b9edfb0f680640ef9b94352d305dee49', 44205, 'jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_files` VALUES ('mInQxjWS', 'd167a2670e1241878f7d50c56c9bc520', 'F:\\workspace_idea\\onlineshop\\images\\d167a2670e1241878f7d50c56c9bc520', 24741, '.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'admin', NULL);
INSERT INTO `t_files` VALUES ('n0fVd3Ck', '9d952de6d42043ceb4b1a5e4a3480742', 'F:\\workspace_idea\\onlineshop\\images\\9d952de6d42043ceb4b1a5e4a3480742', 32631, '.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'admin', NULL);
INSERT INTO `t_files` VALUES ('RzsLwpn5', 'fbdb0a854b514497b7af2378e5a779e4', 'F:\\workspace_idea\\onlineshop\\images\\fbdb0a854b514497b7af2378e5a779e4', 24741, 'jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `t_files` VALUES ('TFcV8EPo', '63b4648eb963413297674564a6fdf182', 'F:\\workspace_idea\\onlineshop\\images\\63b4648eb963413297674564a6fdf182', 41248, 'jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_files` VALUES ('w7F7xho2', '02c8c40b2f664200b4ba311113a84054', 'F:\\workspace_idea\\onlineshop\\images\\02c8c40b2f664200b4ba311113a84054', 24741, 'jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_files` VALUES ('WIRsNNJz', '0ba899b13ff7441c8296b55f3fd5ea7a', 'F:\\workspace_idea\\onlineshop\\images\\0ba899b13ff7441c8296b55f3fd5ea7a', 41248, 'jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_files` VALUES ('XWI3WPK8', 'b425849a8ac64d1eb568efc24a8dcf9e', 'F:\\workspace_idea\\onlineshop\\images\\b425849a8ac64d1eb568efc24a8dcf9e', 44205, 'jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_good2comment
-- ----------------------------
DROP TABLE IF EXISTS `t_good2comment`;
CREATE TABLE `t_good2comment`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `left_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `right_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_good2comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_good2introduction
-- ----------------------------
DROP TABLE IF EXISTS `t_good2introduction`;
CREATE TABLE `t_good2introduction`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `left_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `right_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_good2introduction
-- ----------------------------

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产地',
  `inventory` int(0) NULL DEFAULT NULL COMMENT '库存',
  `sales_volume` int(0) NULL DEFAULT NULL COMMENT '销量',
  `specifications` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '规格',
  `kind_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Introduction_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `custom_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `banner_img` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `title_img` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sell_way` int(0) NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `creator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `published` int(0) NULL DEFAULT NULL,
  `detail_msg` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('7yJIvU1R', '333', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-05-24 10:50:39', 1, NULL);
INSERT INTO `t_goods` VALUES ('admin', '大西瓜', 1.25, '5', NULL, NULL, '五斤', '1', NULL, '5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '5', '2020-05-24 10:16:20', 1, NULL);
INSERT INTO `t_goods` VALUES ('AO0hf5BI', '大家好', 2.84, 'dddddddddd', 1, 1, '三斤', '11111111', NULL, '33333333', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 'admin', '2020-05-23 20:29:32', 1, NULL);
INSERT INTO `t_goods` VALUES ('iT4WIYGb', '111', NULL, '1', NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '2020-05-23 23:42:31', 1, NULL);
INSERT INTO `t_goods` VALUES ('nszr3SKl', '222', NULL, '111', NULL, NULL, NULL, NULL, NULL, '111', NULL, NULL, NULL, '111', NULL, NULL, NULL, NULL, '111', '2020-05-23 23:28:06', 1, NULL);
INSERT INTO `t_goods` VALUES ('QhAezZCe', '大家好1', 2.84, 'dddddddddd', 1, 1, '三斤', '11111111', NULL, '33333333', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 'admin', '2020-05-23 20:58:40', 0, NULL);

-- ----------------------------
-- Table structure for t_goods2files
-- ----------------------------
DROP TABLE IF EXISTS `t_goods2files`;
CREATE TABLE `t_goods2files`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `left_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `right_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `goods_count` int(0) NULL DEFAULT NULL,
  `extrafield_A` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_goods2files
-- ----------------------------
INSERT INTO `t_goods2files` VALUES ('5yNVQ3fQ', 'AO0hf5BI', 'RzsLwpn5', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('6s7cCOTR', 'NoFFXKkj', 'n0fVd3Ck', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('9jFJHXC2', 'AO0hf5BI', 'XWI3WPK8', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('BAVAxryl', 'AO0hf5BI', 'IRvp7HFK', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('Gnq42JB3', 'NoFFXKkj', '9i0EGtpJ', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('hMNPk4bA', 'QhAezZCe', 'w7F7xho2', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('nIrerRva', 'AO0hf5BI', 'WIRsNNJz', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('qmSCq2qM', 'QhAezZCe', 'TFcV8EPo', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('sw3HErUz', '7MWNzhTK', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('UBUKxhqP', 'NoFFXKkj', 'IWlHW2D0', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('VUel8wB7', 'QhAezZCe', 'kdOULY3G', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_goods2files` VALUES ('WC5lbhdr', 'QhAezZCe', '1hhES0Aq', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_introduction
-- ----------------------------
DROP TABLE IF EXISTS `t_introduction`;
CREATE TABLE `t_introduction`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `imgs` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_introduction
-- ----------------------------

-- ----------------------------
-- Table structure for t_kind2goods
-- ----------------------------
DROP TABLE IF EXISTS `t_kind2goods`;
CREATE TABLE `t_kind2goods`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `left_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `right_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_kind2goods
-- ----------------------------
INSERT INTO `t_kind2goods` VALUES ('11111111', 'TqrJTw5y', 'admin', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_kinds
-- ----------------------------
DROP TABLE IF EXISTS `t_kinds`;
CREATE TABLE `t_kinds`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_kinds
-- ----------------------------
INSERT INTO `t_kinds` VALUES ('TqrJTw5y', '水果', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_kinds` VALUES ('zWZ4pDnD', '土特产', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `customer_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `order_time` datetime(0) NULL DEFAULT NULL,
  `pay_way` int(0) NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('VM23egHO', 'admin', 1, '20200615700034328480596', '2020-06-05 00:03:43', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `left_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `right_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `goods_count` int(0) NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
INSERT INTO `t_order_detail` VALUES ('7207Gbmb', 'VM23egHO', 'QhAezZCe', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_order_detail` VALUES ('dsTDm3vO', 'VM23egHO', 'admin', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_order_detail` VALUES ('NAq5EL2O', 'VM23egHO', 'nszr3SKl', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_order_detail` VALUES ('OCzgh1nT', 'VM23egHO', 'AO0hf5BI', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_order_detail` VALUES ('RQyBDlyS', 'VM23egHO', 'iT4WIYGb', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_order_detail` VALUES ('VsSk8onx', 'VM23egHO', '7yJIvU1R', 1, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_send
-- ----------------------------
DROP TABLE IF EXISTS `t_send`;
CREATE TABLE `t_send`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键id',
  `type` int(0) NULL DEFAULT NULL COMMENT '配送方式',
  `company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '快递公司',
  `receive_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人地址',
  `receive_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货人名称',
  `extrafield_A` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_send
-- ----------------------------

-- ----------------------------
-- Table structure for t_shopping_car
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping_car`;
CREATE TABLE `t_shopping_car`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `customer_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shopping_car
-- ----------------------------
INSERT INTO `t_shopping_car` VALUES ('pUuxNDcK', 'a1234567', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_shoppingcar2good
-- ----------------------------
DROP TABLE IF EXISTS `t_shoppingcar2good`;
CREATE TABLE `t_shoppingcar2good`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `left_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `right_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Good_count` int(0) NULL DEFAULT NULL COMMENT '商品数量',
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_shoppingcar2good
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(110) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `level` int(0) NULL DEFAULT NULL,
  `extrafield_A` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_B` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_C` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_D` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `extrafield_E` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('BS8OPcuA', '李四', '123456', '18680863525,15086646009', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_user` VALUES ('ZqrB74MF', '张三', '123456', '18680863525,15086646009', 1, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
