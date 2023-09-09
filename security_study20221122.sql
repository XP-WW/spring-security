/*
 Navicat Premium Data Transfer

 Source Server         : myhost
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : security_study

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 22/11/2022 09:11:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` int NULL DEFAULT NULL COMMENT '父级编号',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称',
  `code` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '权限编码',
  `type` int NULL DEFAULT NULL COMMENT '0代表菜单1权限2 url',
  `delete_flag` tinyint NULL DEFAULT 0 COMMENT '0代表未删除，1 代表已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '学生管理', '/student/**', 0, 0);
INSERT INTO `sys_menu` VALUES (2, 1, '学生查询', 'student:query', 1, 0);
INSERT INTO `sys_menu` VALUES (3, 1, '学生添加', 'student:add', 1, 0);
INSERT INTO `sys_menu` VALUES (4, 1, '学生修改', 'student:update', 1, 0);
INSERT INTO `sys_menu` VALUES (5, 1, '学生删除', 'student:delete', 1, 0);
INSERT INTO `sys_menu` VALUES (6, 1, '导出学生信息', 'student:export', 1, 0);
INSERT INTO `sys_menu` VALUES (7, 0, '教师管理', '/teacher/**', 0, 0);
INSERT INTO `sys_menu` VALUES (9, 7, '教师查询', 'teacher:query', 1, 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `rolename` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '角色名称，英文名称',
  `remark` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ROLE_ADMIN', '管理员');
INSERT INTO `sys_role` VALUES (2, 'ROLE_TEACHER', '老师');
INSERT INTO `sys_role` VALUES (3, 'ROLE_STUDENT', '学生');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `rid` int NOT NULL COMMENT '角色表的编号',
  `mid` int NOT NULL COMMENT '菜单表的编号',
  PRIMARY KEY (`mid`, `rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (3, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (3, 2);
INSERT INTO `sys_role_menu` VALUES (1, 3);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (1, 4);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (1, 5);
INSERT INTO `sys_role_menu` VALUES (2, 5);
INSERT INTO `sys_role_menu` VALUES (3, 6);
INSERT INTO `sys_role_menu` VALUES (1, 9);
INSERT INTO `sys_role_menu` VALUES (2, 9);
INSERT INTO `sys_role_menu` VALUES (3, 9);
INSERT INTO `sys_role_menu` VALUES (1, 10);
INSERT INTO `sys_role_menu` VALUES (1, 17);

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `uid` int NOT NULL COMMENT '用户编号',
  `rid` int NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`uid`, `rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES (1, 1);
INSERT INTO `sys_role_user` VALUES (2, 2);
INSERT INTO `sys_role_user` VALUES (3, 3);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '登陆名',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '地址',
  `enabled` int NULL DEFAULT 1 COMMENT '是否启动账户0禁用 1启用',
  `account_no_expired` int NULL DEFAULT 1 COMMENT '账户是否没有过期0已过期 1 正常',
  `credentials_no_expired` int NULL DEFAULT 1 COMMENT '密码是否没有过期0已过期 1 正常',
  `account_no_locked` int NULL DEFAULT 1 COMMENT '账户是否没有锁定0已锁定 1 正常',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'obama', '$2a$10$KyXAnVcsrLaHMWpd3e2xhe6JmzBi.3AgMhteFq8t8kjxmwL8olEDq', '男', '武汉', 1, 1, 1, 1);
INSERT INTO `sys_user` VALUES (2, 'thomas', '$2a$10$KyXAnVcsrLaHMWpd3e2xhe6JmzBi.3AgMhteFq8t8kjxmwL8olEDq', '男', '北京', 1, 1, 1, 1);
INSERT INTO `sys_user` VALUES (3, 'eric', '$2a$10$KyXAnVcsrLaHMWpd3e2xhe6JmzBi.3AgMhteFq8t8kjxmwL8olEDq', '男', '成都', 1, 1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
