/*
Navicat MySQL Data Transfer

Source Server         : 本地地址
Source Server Version : 50129
Source Host           : localhost:3306
Source Database       : aurora

Target Server Type    : MYSQL
Target Server Version : 50129
File Encoding         : 65001

Date: 2020-05-15 18:20:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `log_id` int(22) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `log_user` varchar(255) DEFAULT NULL COMMENT '登录用户',
  `log_role` varchar(255) DEFAULT NULL COMMENT '登录用户的角色',
  `log_module` varchar(255) DEFAULT NULL COMMENT '访问模块名',
  `log_method` varchar(255) DEFAULT NULL COMMENT '访问的方法',
  `log_url` varchar(255) DEFAULT NULL COMMENT '被请求后台的URL',
  `log_ip` varchar(255) DEFAULT NULL COMMENT '请求的ip地址',
  `log_desc` varchar(1000) DEFAULT NULL COMMENT '日志描述',
  `log_create_time` datetime DEFAULT NULL COMMENT '记录时间',
  `log_type` int(11) DEFAULT NULL COMMENT '1 表示普通日志 2表示异常日志',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=432 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '资源主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '资源名称',
  `module` varchar(255) NOT NULL DEFAULT '' COMMENT '模块key 资源唯一标识',
  `url` varchar(100) DEFAULT NULL COMMENT '模块url',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `pid` bigint(19) DEFAULT NULL COMMENT '父级ID',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态 0可用 1不可用',
  `sys_resourcetype` tinyint(2) NOT NULL DEFAULT '0' COMMENT '资源类型',
  `createdate` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=222 DEFAULT CHARSET=utf8 COMMENT='资源';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '系统管理', 'system', '', '系统管理', 'icon-company', '0', '0', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('2', '首页', 'home', '/home/HomeAll', '首页', 'home', '0', '0', '0', '0', '0000-00-00 00:00:00');
INSERT INTO `sys_resource` VALUES ('11', '资源管理', 'resourceManage', '/system/resourceManage', '资源管理', 'icon-folder', '1', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('12', '角色管理', 'roleManage', '/system/roleManage', '角色管理', 'icon-folder', '1', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('13', '用户管理', 'userManage', '/system/userManage', '用户管理', 'icon-folder', '1', '3', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('221', '日志管理', 'logManage', '/system/logManage', '日志管理', 'icon-company', '1', '4', '0', '0', '2015-12-01 11:44:20');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '角色名称',
  `seq` tinyint(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态 0可用 1不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系統管理员', '0', '系統管理员', '0');
INSERT INTO `sys_role` VALUES ('14', '测试', '0', '111', '0');

-- ----------------------------
-- Table structure for `sys_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '角色资源表主键',
  `role_id` bigint(19) NOT NULL DEFAULT '0' COMMENT '角色主键',
  `resource_id` bigint(19) DEFAULT NULL COMMENT '资源主键',
  `resource_module` varchar(255) NOT NULL DEFAULT '' COMMENT '资源key 资源唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1720 DEFAULT CHARSET=utf8 COMMENT='角色资源表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1653', '1', '1', 'system');
INSERT INTO `sys_role_resource` VALUES ('1654', '1', '11', 'resourceManage');
INSERT INTO `sys_role_resource` VALUES ('1655', '1', '12', 'roleManage');
INSERT INTO `sys_role_resource` VALUES ('1656', '1', '13', 'userManage');
INSERT INTO `sys_role_resource` VALUES ('1695', '1', '221', 'logManage');
INSERT INTO `sys_role_resource` VALUES ('1716', '14', null, 'system');
INSERT INTO `sys_role_resource` VALUES ('1717', '14', null, 'userManage');
INSERT INTO `sys_role_resource` VALUES ('1718', '14', null, 'roleManage');
INSERT INTO `sys_role_resource` VALUES ('1719', '14', null, 'logManage');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `username` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `sex` tinyint(2) DEFAULT '0' COMMENT '性别',
  `age` tinyint(3) DEFAULT '0' COMMENT '年龄',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态 0 可用 1不可用',
  `createdate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'adminTest', '098f6bcd4621d373cade4e832627b4f6', '0', '25', '0', '2015-12-06 13:14:05');
INSERT INTO `sys_user` VALUES ('39', 'panhuaqing', '$2a$10$s5A.60Vk09jattjKcQPulu8O.JtHb33bLxtyAVt6QbkzjeYQBzy/O', '0', '0', '0', null);
INSERT INTO `sys_user` VALUES ('40', 'admin', '$2a$10$RkQ4tEN9SRyJJ.yVPSF.4uUYvDxy47gPeQBkjYZQTaPEjvTLozc0.', '0', '0', '0', '2020-05-11 13:53:21');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '用户角色主键',
  `user_id` bigint(19) NOT NULL DEFAULT '0' COMMENT '用户主键',
  `role_id` bigint(19) NOT NULL DEFAULT '0' COMMENT '角色主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '39', '1');
INSERT INTO `sys_user_role` VALUES ('64', '1', '1');
INSERT INTO `sys_user_role` VALUES ('65', '40', '1');
