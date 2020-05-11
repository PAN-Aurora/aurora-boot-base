/*
Navicat MySQL Data Transfer

Source Server         : 本地地址
Source Server Version : 50129
Source Host           : localhost:3306
Source Database       : aurora

Target Server Type    : MYSQL
Target Server Version : 50129
File Encoding         : 65001

Date: 2020-05-11 17:23:47
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
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('82', 'panhuaqing', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '127.0.0.1', '用户登录', '2020-05-11 13:14:34', '1');
INSERT INTO `sys_log` VALUES ('83', 'panhuaqing', '系統管理员', '测试模块', '模糊查询', '/test/dorest', '127.0.0.1', 'Cannot get Jedis connection; nested exception is redis.clients.jedis.exceptions.JedisConnectionException: Failed connecting to host 127.0.0.1:6379', '2020-05-11 13:14:43', '2');
INSERT INTO `sys_log` VALUES ('84', 'panhuaqing', '系統管理员', '用户管理模块', '获取用户列表', '/api/user/getUserList', '127.0.0.1', '获取用户分页列表数据', '2020-05-11 13:27:36', '1');
INSERT INTO `sys_log` VALUES ('85', 'panhuaqing', '系統管理员', '测试模块', '模糊查询', '/test/dorest', '127.0.0.1', 'Cannot get Jedis connection; nested exception is redis.clients.jedis.exceptions.JedisConnectionException: Failed connecting to host 127.0.0.1:6379', '2020-05-11 13:27:59', '2');
INSERT INTO `sys_log` VALUES ('86', 'panhuaqing', '系統管理员', '测试模块', '模糊查询', '/test/dorest', '127.0.0.1', '测试模糊查询', '2020-05-11 13:28:26', '1');
INSERT INTO `sys_log` VALUES ('87', 'panhuaqing', '系統管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', '\r\n### Error updating database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'Date())\' at line 1\r\n### The error may exist in file [D:\\aurora-base\\aurora-service\\target\\classes\\mapper\\auth\\AuthMapper.xml]\r\n### The error may involve com.aurora.service.mapper.auth.AuthMapper.insertUser-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into sys_user (username, password,createdate) VALUES (?, ?,new Date());\r\n### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near \'Date())\' at line 1\n; bad SQL grammar []; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorE', '2020-05-11 13:47:13', '2');
INSERT INTO `sys_log` VALUES ('88', 'panhuaqing', '系統管理员', '用户权限模块', '用户注册', '/api/v1/sign', '127.0.0.1', '用户注册', '2020-05-11 13:53:21', '1');
INSERT INTO `sys_log` VALUES ('89', null, null, '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', 'Bad credentials', '2020-05-11 14:35:04', '2');
INSERT INTO `sys_log` VALUES ('90', null, null, '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', 'Bad credentials', '2020-05-11 14:37:17', '2');
INSERT INTO `sys_log` VALUES ('91', null, null, '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', 'Bad credentials', '2020-05-11 14:37:40', '2');
INSERT INTO `sys_log` VALUES ('92', 'panhuaqing', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '127.0.0.1', '用户登录', '2020-05-11 14:39:04', '1');
INSERT INTO `sys_log` VALUES ('93', null, null, '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', 'Bad credentials', '2020-05-11 14:39:26', '2');
INSERT INTO `sys_log` VALUES ('94', null, null, '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', 'Bad credentials', '2020-05-11 14:40:12', '2');
INSERT INTO `sys_log` VALUES ('95', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 14:40:37', '1');
INSERT INTO `sys_log` VALUES ('96', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 14:42:43', '1');
INSERT INTO `sys_log` VALUES ('97', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 14:44:48', '1');
INSERT INTO `sys_log` VALUES ('98', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 14:48:52', '1');
INSERT INTO `sys_log` VALUES ('99', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 14:50:52', '1');
INSERT INTO `sys_log` VALUES ('100', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 14:52:38', '1');
INSERT INTO `sys_log` VALUES ('101', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 14:53:37', '1');
INSERT INTO `sys_log` VALUES ('102', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 14:54:10', '1');
INSERT INTO `sys_log` VALUES ('103', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 14:55:24', '1');
INSERT INTO `sys_log` VALUES ('104', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 15:00:37', '1');
INSERT INTO `sys_log` VALUES ('105', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 15:02:50', '1');
INSERT INTO `sys_log` VALUES ('106', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 15:03:58', '1');
INSERT INTO `sys_log` VALUES ('107', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 15:17:36', '1');
INSERT INTO `sys_log` VALUES ('108', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 15:20:12', '1');
INSERT INTO `sys_log` VALUES ('109', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 15:20:21', '1');
INSERT INTO `sys_log` VALUES ('110', 'admin', '系統管理员', '用户权限模块', '用户登录', '/api/auth/login', '192.168.109.100', '用户登录', '2020-05-11 15:48:34', '1');

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '资源主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '资源名称',
  `module` varchar(255) DEFAULT NULL COMMENT '模块key',
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
INSERT INTO `sys_resource` VALUES ('11', '资源管理', 'resource', '/sys_resource/manager', '资源管理', 'icon-folder', '1', '1', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('12', '角色管理', 'roleManage', '/role/manager', '角色管理', 'icon-folder', '1', '2', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('13', '用户管理', 'userManage', '/user/manager', '用户管理', 'icon-folder', '1', '3', '0', '0', '2014-02-19 01:00:00');
INSERT INTO `sys_resource` VALUES ('221', '日志管理', 'logManage', '/sysLog/manager', '日志管理', 'icon-company', '1', '4', '0', '0', '2015-12-01 11:44:20');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '系統管理员', '0', '系統管理员', '0');

-- ----------------------------
-- Table structure for `sys_role_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '角色资源表主键',
  `role_id` bigint(19) NOT NULL DEFAULT '0' COMMENT '角色主键',
  `resource_id` bigint(19) NOT NULL DEFAULT '0' COMMENT '资源主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1696 DEFAULT CHARSET=utf8 COMMENT='角色资源表';

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
