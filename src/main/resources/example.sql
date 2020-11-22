/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2020-11-22 20:19:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `abnormal_resignation`
-- ----------------------------
DROP TABLE IF EXISTS `abnormal_resignation`;
CREATE TABLE `abnormal_resignation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `emp_id` varchar(32) NOT NULL COMMENT '员工工号',
  `resign_data` date NOT NULL COMMENT '离职日期',
  `reason` varchar(100) DEFAULT NULL COMMENT '离职异常原因',
  `create_by` varchar(32) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `one` (`create_by`),
  KEY `two` (`update_by`),
  KEY `three` (`emp_id`) USING BTREE,
  CONSTRAINT `one` FOREIGN KEY (`create_by`) REFERENCES `employee_information` (`emp_id`),
  CONSTRAINT `two` FOREIGN KEY (`update_by`) REFERENCES `employee_information` (`emp_id`),
  CONSTRAINT `three` FOREIGN KEY (`emp_id`) REFERENCES `employee_information` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abnormal_resignation
-- ----------------------------
INSERT INTO `abnormal_resignation` VALUES ('2', '10000002', '2020-11-22', '离职', '10000000', '2020-11-22 15:52:27', null, null);
INSERT INTO `abnormal_resignation` VALUES ('3', '10000003', '2020-11-22', '离职', '10000000', '2020-11-22 17:57:30', '10000001', '2020-11-22 17:57:30');
INSERT INTO `abnormal_resignation` VALUES ('4', '10000002', '2020-11-22', '离职', '10000000', '2020-11-22 15:54:25', null, null);
INSERT INTO `abnormal_resignation` VALUES ('5', '10000002', '2020-11-22', '离职', '10000000', '2020-11-22 15:55:40', null, null);
INSERT INTO `abnormal_resignation` VALUES ('6', '10000002', '2020-11-22', '离职', '10000000', '2020-11-22 16:34:44', null, null);

-- ----------------------------
-- Table structure for `employee_information`
-- ----------------------------
DROP TABLE IF EXISTS `employee_information`;
CREATE TABLE `employee_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `emp_id` varchar(32) NOT NULL COMMENT '员工工号',
  `emp_name` varchar(32) NOT NULL COMMENT '员工姓名',
  `status` int(10) NOT NULL COMMENT '在职状态 1 在职  0离职',
  PRIMARY KEY (`id`),
  KEY `emp_id` (`emp_id`),
  KEY `emp_id_2` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_information
-- ----------------------------
INSERT INTO `employee_information` VALUES ('1', '10000000', '张三', '0');
INSERT INTO `employee_information` VALUES ('2', '10000001', '李四', '0');
INSERT INTO `employee_information` VALUES ('3', '10000002', '王五', '1');
INSERT INTO `employee_information` VALUES ('4', '10000003', '赵六', '1');
