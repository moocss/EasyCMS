/*
Navicat MySQL Data Transfer

Source Server         : cms
Source Server Version : 50203
Source Host           : localhost:3306
Source Database       : easycmsdb

Target Server Type    : MYSQL
Target Server Version : 50203
File Encoding         : 65001

Date: 2013-06-14 13:55:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '测试123', '123');
INSERT INTO `account` VALUES ('2', '测试456', '123');
INSERT INTO `account` VALUES ('3', '测试789', '123');
INSERT INTO `account` VALUES ('4', '测试122200', '123');
INSERT INTO `account` VALUES ('5', '测试189555', '123');
INSERT INTO `account` VALUES ('6', 'fuxin', '123456');
INSERT INTO `account` VALUES ('8', '总经理', '123456');
INSERT INTO `account` VALUES ('9', 'SDAFSDAF', '123456');
INSERT INTO `account` VALUES ('10', 'SADWERWER23423423434', '123456');
INSERT INTO `account` VALUES ('11', 'SADWE4323434', '234234');
INSERT INTO `account` VALUES ('12', 'DFDFDFS', '234234');
INSERT INTO `account` VALUES ('13', '121321123123', '123123123');
INSERT INTO `account` VALUES ('14', 'E234', '123123123');
INSERT INTO `account` VALUES ('15', '测试a', '123456');
INSERT INTO `account` VALUES ('16', '测试b', '123456');
INSERT INTO `account` VALUES ('17', '测试c', '123456');
INSERT INTO `account` VALUES ('18', '测试d', '123456');
INSERT INTO `account` VALUES ('19', '测试e', '123456');
INSERT INTO `account` VALUES ('20', '测试f', '123456');
INSERT INTO `account` VALUES ('21', '测试g', '123456');
INSERT INTO `account` VALUES ('22', '测试aa', '123456');
INSERT INTO `account` VALUES ('23', '测试bb', '123456');

-- ----------------------------
-- Table structure for `ec_group`
-- ----------------------------
DROP TABLE IF EXISTS `ec_group`;
CREATE TABLE `ec_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `priority` int(11) NOT NULL DEFAULT '10',
  `allowPerDay` int(11) NOT NULL DEFAULT '4096',
  `allowMaxFile` int(11) NOT NULL DEFAULT '1024',
  `allowSuffix` varchar(255) DEFAULT 'jpg,jpeg,gif,png,bmp',
  `needCaptcha` tinyint(1) NOT NULL DEFAULT '1',
  `needCheck` tinyint(1) NOT NULL DEFAULT '1',
  `regDef` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_group
-- ----------------------------
INSERT INTO `ec_group` VALUES ('1', '付鑫', '2', '4096', '1024', 'jpg,jpeg,gif,png,bmp', '1', '0', '1');
INSERT INTO `ec_group` VALUES ('2', 'liming', '1', '2000', '1024', 'jpg,jpeg,gif,png,bmp', '1', '0', '1');

-- ----------------------------
-- Table structure for `ec_user`
-- ----------------------------
DROP TABLE IF EXISTS `ec_user`;
CREATE TABLE `ec_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `registerIP` varchar(50) DEFAULT '127.0.0.1',
  `lastLoginTime` datetime DEFAULT NULL,
  `lastLoginIp` varchar(50) DEFAULT '127.0.0.1',
  `loginCount` int(11) NOT NULL DEFAULT '0',
  `rank` int(11) NOT NULL DEFAULT '0',
  `uploadSize` int(11) NOT NULL DEFAULT '0',
  `uploadDate` datetime DEFAULT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `viewonlyAdmin` tinyint(1) NOT NULL DEFAULT '0',
  `selfAdmin` tinyint(1) NOT NULL DEFAULT '0',
  `disabled` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ec_user
-- ----------------------------
INSERT INTO `ec_user` VALUES ('1', '2', '付鑫', '123456', 'moocss@gmail.com', '2013-05-31 11:44:01', '127.0.0.1', '2013-05-17 11:43:04', '127.0.0.1', '0', '0', '0', '2013-05-15 11:43:20', '0', '0', '0', '0');
