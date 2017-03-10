/*
Navicat MySQL Data Transfer

Source Server         : ch_meddkim
Source Server Version : 50633
Source Host           : 42.96.144.163:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-03-10 21:03:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sessions
-- ----------------------------
DROP TABLE IF EXISTS `sessions`;
CREATE TABLE `sessions` (
  `id` varchar(200) NOT NULL DEFAULT '',
  `session` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sessions
-- ----------------------------

-- ----------------------------
-- Table structure for sys_app
-- ----------------------------
DROP TABLE IF EXISTS `sys_app`;
CREATE TABLE `sys_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `app_key` varchar(100) DEFAULT NULL,
  `app_secret` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_app_app_key` (`app_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_app
-- ----------------------------
INSERT INTO `sys_app` VALUES ('1', '中心服务器', '645ba616-370a-43a8-a8e0-993e7a590cf0', 'bb74abb6-bae0-47dd-a7b1-9571ea3a0f33', '1');
INSERT INTO `sys_app` VALUES ('2', 'APP-1', '645ba612-370a-43a8-a8e0-993e7a590cf0', 'bb74abb2-bae0-47dd-a7b1-9571ea3a0f33', '1');
INSERT INTO `sys_app` VALUES ('3', 'APP-2', '645ba613-370a-43a8-a8e0-993e7a590cf0', 'bb74abb3-bae0-47dd-a7b1-9571ea3a0f33', '1');

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_organization_parent_id` (`parent_id`) USING BTREE,
  KEY `idx_sys_organization_parent_ids` (`parent_ids`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
INSERT INTO `sys_organization` VALUES ('1', '总公司', '0', '0/', '1');
INSERT INTO `sys_organization` VALUES ('2', '分公司1', '1', '0/1/', '1');
INSERT INTO `sys_organization` VALUES ('3', '分公司2', '1', '0/1/', '1');
INSERT INTO `sys_organization` VALUES ('4', '分公司11', '2', '0/1/2/', '1');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_resource_parent_id` (`parent_id`) USING BTREE,
  KEY `idx_sys_resource_parent_ids` (`parent_ids`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '资源', 'menu', '', '0', '0/', '', '1');
INSERT INTO `sys_resource` VALUES ('11', '组织机构管理', 'menu', '/organization', '1', '0/1/', 'organization:*', '1');
INSERT INTO `sys_resource` VALUES ('12', '组织机构新增', 'button', '', '11', '0/1/11/', 'organization:create', '1');
INSERT INTO `sys_resource` VALUES ('13', '组织机构修改', 'button', '', '11', '0/1/11/', 'organization:update', '1');
INSERT INTO `sys_resource` VALUES ('14', '组织机构删除', 'button', '', '11', '0/1/11/', 'organization:delete', '1');
INSERT INTO `sys_resource` VALUES ('15', '组织机构查看', 'button', '', '11', '0/1/11/', 'organization:view', '1');
INSERT INTO `sys_resource` VALUES ('16', '应用管理', 'menu', '/app', '1', '0/1/', 'app:*', '1');
INSERT INTO `sys_resource` VALUES ('17', '应用新增', 'button', '', '16', '0/1/16/', 'app:create', '1');
INSERT INTO `sys_resource` VALUES ('18', '应用修改', 'button', '', '16', '0/1/16/', 'app:update', '1');
INSERT INTO `sys_resource` VALUES ('19', '应用删除', 'button', '', '16', '0/1/16/', 'app:delete', '1');
INSERT INTO `sys_resource` VALUES ('20', '应用查看', 'button', '', '16', '0/1/16/', 'app:view', '1');
INSERT INTO `sys_resource` VALUES ('21', '用户管理', 'menu', '/user', '1', '0/1/', 'user:*', '1');
INSERT INTO `sys_resource` VALUES ('22', '用户新增', 'button', '', '21', '0/1/21/', 'user:create', '1');
INSERT INTO `sys_resource` VALUES ('23', '用户修改', 'button', '', '21', '0/1/21/', 'user:update', '1');
INSERT INTO `sys_resource` VALUES ('24', '用户删除', 'button', '', '21', '0/1/21/', 'user:delete', '1');
INSERT INTO `sys_resource` VALUES ('25', '用户查看', 'button', '', '21', '0/1/21/', 'user:view', '1');
INSERT INTO `sys_resource` VALUES ('31', '资源管理', 'menu', '/resource', '1', '0/1/', 'resource:*', '1');
INSERT INTO `sys_resource` VALUES ('32', '资源新增', 'button', '', '31', '0/1/31/', 'resource:create', '1');
INSERT INTO `sys_resource` VALUES ('33', '资源修改', 'button', '', '31', '0/1/31/', 'resource:update', '1');
INSERT INTO `sys_resource` VALUES ('34', '资源删除', 'button', '', '31', '0/1/31/', 'resource:delete', '1');
INSERT INTO `sys_resource` VALUES ('35', '资源查看', 'button', '', '31', '0/1/31/', 'resource:view', '1');
INSERT INTO `sys_resource` VALUES ('41', '角色管理', 'menu', '/role', '1', '0/1/', 'role:*', '1');
INSERT INTO `sys_resource` VALUES ('42', '角色新增', 'button', '', '41', '0/1/41/', 'role:create', '1');
INSERT INTO `sys_resource` VALUES ('43', '角色修改', 'button', '', '41', '0/1/41/', 'role:update', '1');
INSERT INTO `sys_resource` VALUES ('44', '角色删除', 'button', '', '41', '0/1/41/', 'role:delete', '1');
INSERT INTO `sys_resource` VALUES ('45', '角色查看', 'button', '', '41', '0/1/41/', 'role:view', '1');
INSERT INTO `sys_resource` VALUES ('51', '授权管理', 'menu', '/authorization', '1', '0/1/', 'authorization:*', '1');
INSERT INTO `sys_resource` VALUES ('52', '授权新增', 'button', '', '51', '0/1/51/', 'authorization:create', '1');
INSERT INTO `sys_resource` VALUES ('53', '授权修改', 'button', '', '51', '0/1/51/', 'authorization:update', '1');
INSERT INTO `sys_resource` VALUES ('54', '授权删除', 'button', '', '51', '0/1/51/', 'authorization:delete', '1');
INSERT INTO `sys_resource` VALUES ('55', '授权查看', 'button', '', '51', '0/1/51/', 'authorization:view', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `resource_ids` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_sys_role_resource_ids` (`resource_ids`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', '11,16,21,31,41,51', '1');
INSERT INTO `sys_role` VALUES ('2', 'role1', 'APP1管理员', '11,16,21,31,41,51', '1');
INSERT INTO `sys_role` VALUES ('3', 'role2', 'APP2管理员', '11,16,21,31,41,51', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `organization_id` bigint(20) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`) USING BTREE,
  KEY `idx_sys_user_organization_id` (`organization_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0');

-- ----------------------------
-- Table structure for sys_user_app_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_app_roles`;
CREATE TABLE `sys_user_app_roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `app_id` bigint(20) DEFAULT NULL,
  `role_ids` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_app_roles_user_id_app_id` (`user_id`,`app_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_app_roles
-- ----------------------------
INSERT INTO `sys_user_app_roles` VALUES ('1', '1', '1', '1');
INSERT INTO `sys_user_app_roles` VALUES ('2', '1', '2', '1,2');
INSERT INTO `sys_user_app_roles` VALUES ('3', '1', '3', '1,3');
