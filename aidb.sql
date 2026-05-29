/*
 Navicat Premium Dump SQL

 Source Server         : wz
 Source Server Type    : MySQL
 Source Server Version : 80045 (8.0.45)
 Source Host           : localhost:3306
 Source Schema         : aidb

 Target Server Type    : MySQL
 Target Server Version : 80045 (8.0.45)
 File Encoding         : 65001

 Date: 29/05/2026 19:57:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `role_id` int NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', '06779f96-6970-4e55-9cd5-5cb1489a0ec9', '123', '女', '123', NULL);
INSERT INTO `user` VALUES ('111', '25bd8232-5b0c-4bb2-be88-2e6247403b90', '1234', '女', 'admin', NULL);
INSERT INTO `user` VALUES ('111', '3ced0f9f-575d-4508-9eab-69e21507d4d5', '1234', '女', '1111', NULL);
INSERT INTO `user` VALUES ('111', '5edcd142-5850-4fae-ac03-e7bf38fcbdef', '1234', '女', 'admin', NULL);
INSERT INTO `user` VALUES ('qqq', '817f235b-a840-4b95-81c2-6eaf101f9822', '123', '女', 'qqq', NULL);
INSERT INTO `user` VALUES ('abcd', '8613ba86-5ca2-4774-ae87-0cf6ea6805ec', '1234', '女', 'admin', NULL);
INSERT INTO `user` VALUES ('qqqqq', 'b24bae15-9cfc-446a-bb2a-1f735c637ddc', '123', '男', 'qqqqq', NULL);
INSERT INTO `user` VALUES ('qqqq', 'd0961035-1c5c-4e42-b8b5-3eb915cc7789', '123', '女', 'qqqq', NULL);
INSERT INTO `user` VALUES ('wwww', 'e2f69d36-e18d-472b-825c-25b7607a90ea', '123', '男', 'wwww', NULL);

SET FOREIGN_KEY_CHECKS = 1;
