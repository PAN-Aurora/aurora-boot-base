/*
Navicat MySQL Data Transfer

Source Server         : 本地地址
Source Server Version : 50129
Source Host           : localhost:3306
Source Database       : aurora

Target Server Type    : MYSQL
Target Server Version : 50129
File Encoding         : 65001

Date: 2020-05-16 18:05:27
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
) ENGINE=InnoDB AUTO_INCREMENT=500 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('432', 'admin', '系統管理员', '角色管理模块', '保存角色', '/api/role/saveRole', '192.168.109.100', '保存角色', '2020-05-15 18:28:48', '1');
INSERT INTO `sys_log` VALUES ('433', 'admin', '系統管理员', '角色管理模块', '保存角色', '/api/role/saveRole', '192.168.109.100', '保存角色', '2020-05-15 18:28:52', '1');
INSERT INTO `sys_log` VALUES ('434', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-15 18:28:53', '1');
INSERT INTO `sys_log` VALUES ('435', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-16 16:59:19', '1');
INSERT INTO `sys_log` VALUES ('436', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 16:59:20', '1');
INSERT INTO `sys_log` VALUES ('437', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 16:59:29', '1');
INSERT INTO `sys_log` VALUES ('438', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 16:59:30', '1');
INSERT INTO `sys_log` VALUES ('439', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:00:16', '1');
INSERT INTO `sys_log` VALUES ('440', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:01:44', '1');
INSERT INTO `sys_log` VALUES ('441', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:08:17', '1');
INSERT INTO `sys_log` VALUES ('442', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:09:55', '1');
INSERT INTO `sys_log` VALUES ('443', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:12:24', '1');
INSERT INTO `sys_log` VALUES ('444', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:12:34', '1');
INSERT INTO `sys_log` VALUES ('445', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:13:05', '1');
INSERT INTO `sys_log` VALUES ('446', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:13:06', '1');
INSERT INTO `sys_log` VALUES ('447', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:13:43', '1');
INSERT INTO `sys_log` VALUES ('448', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:13:43', '1');
INSERT INTO `sys_log` VALUES ('449', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:14:23', '1');
INSERT INTO `sys_log` VALUES ('450', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:14:23', '1');
INSERT INTO `sys_log` VALUES ('451', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:14:27', '1');
INSERT INTO `sys_log` VALUES ('452', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:15:00', '1');
INSERT INTO `sys_log` VALUES ('453', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:15:00', '1');
INSERT INTO `sys_log` VALUES ('454', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:15:39', '1');
INSERT INTO `sys_log` VALUES ('455', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:15:39', '1');
INSERT INTO `sys_log` VALUES ('456', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:15:43', '1');
INSERT INTO `sys_log` VALUES ('457', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:34:43', '1');
INSERT INTO `sys_log` VALUES ('458', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:34:43', '1');
INSERT INTO `sys_log` VALUES ('459', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:34:43', '1');
INSERT INTO `sys_log` VALUES ('460', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:34:45', '1');
INSERT INTO `sys_log` VALUES ('461', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:34:45', '1');
INSERT INTO `sys_log` VALUES ('462', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:34:50', '1');
INSERT INTO `sys_log` VALUES ('463', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:35:14', '1');
INSERT INTO `sys_log` VALUES ('464', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:35:14', '1');
INSERT INTO `sys_log` VALUES ('465', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:35:45', '1');
INSERT INTO `sys_log` VALUES ('466', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:35:45', '1');
INSERT INTO `sys_log` VALUES ('467', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:37:09', '1');
INSERT INTO `sys_log` VALUES ('468', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:37:09', '1');
INSERT INTO `sys_log` VALUES ('469', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:38:51', '1');
INSERT INTO `sys_log` VALUES ('470', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:38:51', '1');
INSERT INTO `sys_log` VALUES ('471', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:39:03', '1');
INSERT INTO `sys_log` VALUES ('472', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:39:03', '1');
INSERT INTO `sys_log` VALUES ('473', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:39:43', '1');
INSERT INTO `sys_log` VALUES ('474', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:39:43', '1');
INSERT INTO `sys_log` VALUES ('475', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:40:47', '1');
INSERT INTO `sys_log` VALUES ('476', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:40:47', '1');
INSERT INTO `sys_log` VALUES ('477', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:40:58', '1');
INSERT INTO `sys_log` VALUES ('478', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:40:58', '1');
INSERT INTO `sys_log` VALUES ('479', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:41:04', '1');
INSERT INTO `sys_log` VALUES ('480', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:41:08', '1');
INSERT INTO `sys_log` VALUES ('481', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:46:52', '1');
INSERT INTO `sys_log` VALUES ('482', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:46:52', '1');
INSERT INTO `sys_log` VALUES ('483', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:46:52', '1');
INSERT INTO `sys_log` VALUES ('484', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:46:52', '1');
INSERT INTO `sys_log` VALUES ('485', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:47:57', '1');
INSERT INTO `sys_log` VALUES ('486', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:47:57', '1');
INSERT INTO `sys_log` VALUES ('487', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:48:33', '1');
INSERT INTO `sys_log` VALUES ('488', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:48:33', '1');
INSERT INTO `sys_log` VALUES ('489', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:48:44', '1');
INSERT INTO `sys_log` VALUES ('490', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:48:44', '1');
INSERT INTO `sys_log` VALUES ('491', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:50:39', '1');
INSERT INTO `sys_log` VALUES ('492', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:50:39', '1');
INSERT INTO `sys_log` VALUES ('493', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:51:20', '1');
INSERT INTO `sys_log` VALUES ('494', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:51:20', '1');
INSERT INTO `sys_log` VALUES ('495', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:51:23', '1');
INSERT INTO `sys_log` VALUES ('496', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:51:30', '1');
INSERT INTO `sys_log` VALUES ('497', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:51:30', '1');
INSERT INTO `sys_log` VALUES ('498', 'admin', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '192.168.109.100', '获取用户分页列表数据', '2020-05-16 17:53:02', '1');
INSERT INTO `sys_log` VALUES ('499', 'admin', '系統管理员', '角色管理模块', '获取角色列表', '/api/role/getRoleList', '192.168.109.100', '获取角色列表', '2020-05-16 17:53:02', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系統管理员', '0', '系統管理员', '0');
INSERT INTO `sys_role` VALUES ('14', '测试', '0', '111', '0');
INSERT INTO `sys_role` VALUES ('15', '测试1', '0', null, '0');

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
  `real_name` varchar(255) NOT NULL DEFAULT '' COMMENT '真实姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'adminTest', '098f6bcd4621d373cade4e832627b4f6', '0', '25', '0', '2015-12-06 13:14:05', '测试');
INSERT INTO `sys_user` VALUES ('39', 'panhuaqing', '$2a$10$s5A.60Vk09jattjKcQPulu8O.JtHb33bLxtyAVt6QbkzjeYQBzy/O', '0', '0', '0', null, '小潘');
INSERT INTO `sys_user` VALUES ('40', 'admin', '$2a$10$RkQ4tEN9SRyJJ.yVPSF.4uUYvDxy47gPeQBkjYZQTaPEjvTLozc0.', '0', '0', '0', '2020-05-11 13:53:21', '系统管理员');

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
