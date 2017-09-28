/*
Navicat MySQL Data Transfer

Source Server         : fimaly
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : basic-frame

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-09-28 17:29:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `ID` varchar(32) NOT NULL COMMENT '唯一标识',
  `USER_NAME` varchar(32) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(32) DEFAULT NULL COMMENT '密码',
  `NAME` varchar(32) DEFAULT NULL COMMENT '姓名',
  `SEX` char(1) DEFAULT NULL COMMENT '性别(0:女 1:男)',
  `ADDRESS` varchar(32) DEFAULT NULL COMMENT '地址',
  `DIRTHDAY` datetime DEFAULT NULL COMMENT '生日',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `MAIL` varchar(32) NOT NULL COMMENT '邮箱',
  `WECHAT` varchar(32) DEFAULT NULL COMMENT '微信号',
  `SKETCH` varchar(255) DEFAULT NULL COMMENT '描述',
  `ENCRYPT_SALT` varchar(32) DEFAULT NULL COMMENT '加盐值',
  `STATUS` char(1) DEFAULT NULL COMMENT '状态 （1：正常 2：禁用）',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `OPERATE_TIME` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES ('716f9c88f32746d0bedb78b10c1e5b84', '论倾添', '47c6fcc30fbf9966e053260f67d479f4', '黎力豪', '1', null, '2017-09-28 00:00:00', '15381072474', '18166043874@163.com', '123456', '\r\n\r\n', 'f15d1ff69c2269efb693497815be2b51', '1', '2017-09-28 15:20:08', '2017-09-28 15:20:08');
INSERT INTO `blog_user` VALUES ('f2689c0155524067a04b094bb4be6fe1', '张三', '47a42ee6006fdf69e53de74cfe29072d', '黎力豪', '1', '江西,九江,武宁', '2017-09-28 00:00:00', '15381072474', '18166043874@163.com', '740641026', '', 'e10adc3949ba59abbe56e057f20f883e', '1', '2017-09-28 16:42:31', '2017-09-28 16:42:31');
