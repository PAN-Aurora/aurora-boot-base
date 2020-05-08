/*
Navicat MySQL Data Transfer

Source Server         : 本地地址
Source Server Version : 50129
Source Host           : localhost:3306
Source Database       : aurora

Target Server Type    : MYSQL
Target Server Version : 50129
File Encoding         : 65001

Date: 2020-05-08 18:03:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `log_id` int(22) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `log_user` varchar(255) DEFAULT NULL COMMENT '登录用户',
  `log_role` varchar(255) DEFAULT NULL COMMENT '登录用户角色',
  `log_module` varchar(255) DEFAULT NULL COMMENT '访问模块名',
  `log_method` varchar(255) DEFAULT NULL COMMENT '访问的方法',
  `log_url` varchar(255) DEFAULT NULL COMMENT '被请求的URL',
  `log_ip` varchar(255) DEFAULT NULL COMMENT '请求的ip地址',
  `log_desc` varchar(1000) DEFAULT NULL COMMENT '日志描述',
  `log_create_time` datetime DEFAULT NULL COMMENT '记录时间',
  `log_type` int(11) DEFAULT NULL COMMENT '1 表示普通日志 0表示异常日志',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('23', 'admin', '系统管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', 'Error attempting to get column \'description\' from result set.  Cause: java.sql.SQLException: Invalid value for getInt() - \'超级管理员\'\n; Invalid value for getInt() - \'超级管理员\'; nested exception is java.sql.SQLException: Invalid value for getInt() - \'超级管理员\'', '2020-05-07 13:26:36', '1');
INSERT INTO `sys_log` VALUES ('24', 'admin', '系统管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', 'Error attempting to get column \'description\' from result set.  Cause: java.sql.SQLException: Invalid value for getInt() - \'超级管理员\'\n; Invalid value for getInt() - \'超级管理员\'; nested exception is java.sql.SQLException: Invalid value for getInt() - \'超级管理员\'', '2020-05-07 13:30:18', '1');
INSERT INTO `sys_log` VALUES ('25', 'admin', '系统管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', 'Error attempting to get column \'description\' from result set.  Cause: java.sql.SQLException: Invalid value for getInt() - \'超级管理员\'\n; Invalid value for getInt() - \'超级管理员\'; nested exception is java.sql.SQLException: Invalid value for getInt() - \'超级管理员\'', '2020-05-07 13:32:40', '1');
INSERT INTO `sys_log` VALUES ('26', 'admin', '系统管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', 'Error attempting to get column \'description\' from result set.  Cause: java.sql.SQLException: Invalid value for getInt() - \'超级管理员\'\n; Invalid value for getInt() - \'超级管理员\'; nested exception is java.sql.SQLException: Invalid value for getInt() - \'超级管理员\'', '2020-05-07 13:32:53', '1');
INSERT INTO `sys_log` VALUES ('27', 'admin', '系统管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', '用户注册', '2020-05-07 13:35:34', '1');
INSERT INTO `sys_log` VALUES ('28', 'admin', '系统管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', '用户注册', '2020-05-07 13:40:12', '1');
INSERT INTO `sys_log` VALUES ('29', 'admin', '系统管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', '用户注册', '2020-05-07 13:41:15', '1');
INSERT INTO `sys_log` VALUES ('30', 'admin', '系统管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', '用户注册', '2020-05-07 13:41:47', '1');
INSERT INTO `sys_log` VALUES ('31', 'admin', '系统管理员', '用户登录', '用户登录', '/api/auth/login', '127.0.0.1', '用户登录', '2020-05-07 17:01:37', '1');
INSERT INTO `sys_log` VALUES ('32', 'admin', '系统管理员', '用户登录', '用户登录', '/api/auth/login', '127.0.0.1', '用户登录', '2020-05-07 17:12:04', '1');
INSERT INTO `sys_log` VALUES ('33', 'admin', '系统管理员', '用户登录', '用户登录', '/api/auth/login', '127.0.0.1', '用户登录', '2020-05-08 10:41:51', '1');
INSERT INTO `sys_log` VALUES ('34', 'admin', '系统管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', 'write javaBean error, class com.baomidou.mybatisplus.extension.plugins.pagination.Page', '2020-05-08 11:01:48', '2');
INSERT INTO `sys_log` VALUES ('35', 'admin', '系统管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', 'write javaBean error, class com.baomidou.mybatisplus.extension.plugins.pagination.Page', '2020-05-08 11:08:47', '2');
INSERT INTO `sys_log` VALUES ('36', 'admin', '系统管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 11:12:24', '1');
INSERT INTO `sys_log` VALUES ('37', 'admin', '系统管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 11:16:11', '1');
INSERT INTO `sys_log` VALUES ('38', 'admin', '系统管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 11:16:48', '1');
INSERT INTO `sys_log` VALUES ('39', 'admin', '系统管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 11:26:59', '1');
INSERT INTO `sys_log` VALUES ('40', 'admin', '系统管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 11:30:14', '1');
INSERT INTO `sys_log` VALUES ('41', 'admin', '系统管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 11:34:56', '1');
INSERT INTO `sys_log` VALUES ('42', 'admin', '系统管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 12:51:41', '1');
INSERT INTO `sys_log` VALUES ('43', 'panhuaqing', '超级管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 12:52:58', '1');
INSERT INTO `sys_log` VALUES ('44', 'panhuaqing', '超级管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 12:58:21', '1');
INSERT INTO `sys_log` VALUES ('45', 'panhuaqing', '超级管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 12:58:38', '1');
INSERT INTO `sys_log` VALUES ('46', 'panhuaqing', '超级管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 13:06:56', '1');
INSERT INTO `sys_log` VALUES ('47', 'panhuaqing', '超级管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 13:13:18', '1');
INSERT INTO `sys_log` VALUES ('48', 'panhuaqing', '超级管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 13:21:06', '1');
INSERT INTO `sys_log` VALUES ('49', 'panhuaqing', '超级管理员', '用户列表', 'getUserList', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-08 13:54:40', '1');
INSERT INTO `sys_log` VALUES ('50', null, null, '用户登录', '用户登录', '/api/auth/login', '127.0.0.1', '用户登录', '2020-05-08 14:44:35', '1');
INSERT INTO `sys_log` VALUES ('51', null, null, '用户登录', '用户登录', '/api/auth/login', '127.0.0.1', '用户登录', '2020-05-08 16:34:02', '1');

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `module` varchar(255) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `pid` bigint(19) DEFAULT NULL,
  `seq` tinyint(2) NOT NULL DEFAULT '0',
  `status` tinyint(2) NOT NULL DEFAULT '0',
  `sys_resourcetype` tinyint(2) NOT NULL DEFAULT '0',
  `createdate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=268 DEFAULT CHARSET=utf8 COMMENT='资源';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '系统管理', null, '', '系统管理', 'icon-company', '0', '0', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('11', '资源管理', '/sys_resource/manager', '/sys_resource/manager', '资源管理', 'icon-folder', '1', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('12', '角色管理', '/role/manager', '/role/manager', '角色管理', 'icon-folder', '1', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('13', '用户管理', '/user/manager', '/user/manager', '用户管理', 'icon-folder', '1', '3', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('221', '日志管理', '/sysLog/manager', '/sysLog/manager', '日志管理', 'icon-company', '1', '4', '0', '0', '2015-12-01 11:44:20');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `seq` tinyint(2) NOT NULL DEFAULT '0',
  `description` varchar(255) DEFAULT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系統管理员', '0', '系統管理员', '0');

-- ----------------------------
-- Table structure for `sys_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(19) NOT NULL,
  `resource_id` bigint(19) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1778 DEFAULT CHARSET=utf8 COMMENT='角色资源';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1653', '1', '1');
INSERT INTO `sys_role_resource` VALUES ('1654', '1', '11');
INSERT INTO `sys_role_resource` VALUES ('1655', '1', '12');
INSERT INTO `sys_role_resource` VALUES ('1656', '1', '13');
INSERT INTO `sys_role_resource` VALUES ('1695', '1', '221');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(64) DEFAULT NULL,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `sex` tinyint(2) DEFAULT '0',
  `age` tinyint(2) DEFAULT '0',
  `usertype` tinyint(2) DEFAULT '0',
  `status` tinyint(2) DEFAULT '0',
  `organization_id` int(11) DEFAULT '0',
  `createdate` datetime DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'admin', '098f6bcd4621d373cade4e832627b4f6', '0', '25', '0', '0', '1', '2015-12-06 13:14:05', '');
INSERT INTO `sys_user` VALUES ('39', 'panhuaqing', 'panhuaqing', '$2a$10$s5A.60Vk09jattjKcQPulu8O.JtHb33bLxtyAVt6QbkzjeYQBzy/O', '0', '0', '0', '0', '0', null, null);

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(19) NOT NULL,
  `role_id` bigint(19) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '39', '1');
INSERT INTO `sys_user_role` VALUES ('64', '1', '1');
