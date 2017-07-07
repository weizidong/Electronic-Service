/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : db_electronic

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-03 17:22:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `url` varchar(255) NOT NULL,
  `letter_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for letter
-- ----------------------------
DROP TABLE IF EXISTS `letter`;
CREATE TABLE `letter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `target` varchar(20) DEFAULT NULL,
  `id_card` varchar(18) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `code` varchar(8) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `receive_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `trial_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `type` int(1) DEFAULT '0',
  `userid` varchar(20) DEFAULT NULL,
  `pwd` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
