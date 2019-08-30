/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : jblog

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 30/08/2019 13:15:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `descrip` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `time` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `t_message_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES (78, '第一篇博客', '<p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p>第一篇博客第一篇博客第一篇博客</p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p>', '第一篇博客第一篇博客第一篇博客第一篇博客', 1, '2019-08-21');
INSERT INTO `t_message` VALUES (79, '第二篇博客', '<p></p><p></p><p>第二篇博客第二篇博客第二篇博客</p><p></p><p><br></p>', '第二篇博客第二篇博客第二篇博客第二篇博客', 1, '2019-08-21');
INSERT INTO `t_message` VALUES (85, '第三篇博客', '<p></p><p></p><p></p><p><br></p><p></p><p><br></p><p></p><p>第三篇博客第三篇博客第三篇博客第三篇博客第三篇博客第三篇博客</p>', '第三篇博客第三篇博客第三篇博客第三篇博客第三篇博客第三篇博客', 1, '2019-08-22');
INSERT INTO `t_message` VALUES (86, '第四篇博客', '<p></p><p></p><p></p><p></p><p></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p><p></p><p><br></p>', '第四篇博客第四篇博客第四篇博客第四篇博客第四篇博客', 1, '2019-08-22');
INSERT INTO `t_message` VALUES (89, '第六篇博客', '<p></p><p>第六篇博客第六篇博客第六篇博客第六篇博客第六篇博客第六篇博客</p>', '第六篇博客第六篇博客第六篇博客第六篇博客第六篇博客', 1, '2019-08-22');
INSERT INTO `t_message` VALUES (90, '戴爸爸第一篇博客', '<p></p><p>戴爸爸第一篇博客戴爸爸第一篇博客戴爸爸第一篇博客戴爸爸第一篇博客戴爸爸第一篇博客</p>', '戴爸爸第一篇博客戴爸爸第一篇博客戴爸爸第一篇博客戴爸爸第一篇', 3, '2019-08-22');
INSERT INTO `t_message` VALUES (91, '戴爸爸第二篇博客', '<p></p><p>戴爸爸第二篇博客戴爸爸第二篇博客戴爸爸第二篇博客戴爸爸第二篇博客</p>', '戴爸爸第二篇博客戴爸爸第二篇博客戴爸爸第二篇博客戴爸爸第二篇', 3, '2019-08-22');
INSERT INTO `t_message` VALUES (92, '戴爸爸第二篇博客', '<p></p><p><br></p>', '戴爸爸第二篇博客戴爸爸第二篇博客戴爸爸第二篇博客戴爸爸第二篇', 3, '2019-08-22');
INSERT INTO `t_message` VALUES (93, '戴大大第一篇博客', '<p></p><p><br></p>', '戴大大第一篇博客戴大大第一篇博客戴大大第一篇博客戴大大第一篇', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (94, '戴大大第二篇博客', '<p></p><p><br></p>', '戴大大第二篇博客戴大大第二篇博客戴大大第二篇博客戴大大第二篇', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (95, '戴大大的第三篇博客', '<p></p><p></p><p><br></p><p></p><p><br></p>', '戴大大的第三篇博客戴大大的第三篇博客戴大大的第三篇博客戴大大', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (96, '戴大大第四篇博客', '<p></p><p><br></p>', '戴大大第四篇博客戴大大第四篇博客戴大大第四篇博客戴大大第四篇', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (97, '戴大大第五篇博客', '<p></p><p><br></p>', '戴大大第五篇博客戴大大第五篇博客戴大大第五篇博客戴大大第五篇', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (98, '戴大大第六篇博客', '<p></p><blockquote>戴大大第<span style=\"font-weight: bold;\">六篇博客戴大大第六篇博客戴大大第六篇博客戴大大第六篇博客</span></blockquote>', '戴大大第六篇博客戴大大第六篇博客戴大大第六篇博客戴大大第六篇', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (99, '戴大大第七篇博客', '<p></p><p><br></p>', '', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (100, '戴大大第八篇博客', '<p></p><p><br></p>', '', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (101, '戴大大第九篇博客', '<p></p><p><br></p>', '', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (102, '戴大大第十篇博客', '<p></p><p><br></p>', '', 4, '2019-08-22');
INSERT INTO `t_message` VALUES (103, '戴大大第十一篇博客', NULL, NULL, 4, '2019-08-01');
INSERT INTO `t_message` VALUES (105, '戴大大第十三篇博客', '<p></p><p><br></p>', '', 4, '2019-08-05');
INSERT INTO `t_message` VALUES (108, '戴大大第十六篇博客', '<p></p><p></p><p></p><p><br></p><p></p><p>戴大大第十六篇博客戴大大第十六篇博客戴大大第十六篇博客</p><p></p><p><br></p>', '戴大大第十六篇博客戴大大第十六篇博客戴大大第十六篇博客', 4, '2019-08-06');
INSERT INTO `t_message` VALUES (110, '第二十篇博客', '<p></p><p></p><p><br></p><p></p><p><br></p>', '第二十篇博客第二十篇博客第二十篇博客第二十篇博客', 1, '2019-08-23');
INSERT INTO `t_message` VALUES (111, '第二十一篇博客', '<p></p><p><br></p>', '第二十一篇博客第二十一篇博客第二十一篇博客第二十一篇博客', 1, '2019-08-23');

-- ----------------------------
-- Table structure for t_middle
-- ----------------------------
DROP TABLE IF EXISTS `t_middle`;
CREATE TABLE `t_middle`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `t_middle_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `t_message` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `t_middle_ibfk_3` FOREIGN KEY (`cid`) REFERENCES `t_totalclass` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_middle
-- ----------------------------
INSERT INTO `t_middle` VALUES (24, 78, 41);
INSERT INTO `t_middle` VALUES (25, 78, 42);
INSERT INTO `t_middle` VALUES (26, 79, 41);
INSERT INTO `t_middle` VALUES (27, 79, 43);
INSERT INTO `t_middle` VALUES (30, 78, 45);
INSERT INTO `t_middle` VALUES (44, 85, 41);
INSERT INTO `t_middle` VALUES (45, 85, 53);
INSERT INTO `t_middle` VALUES (46, 85, 54);
INSERT INTO `t_middle` VALUES (47, 85, 55);
INSERT INTO `t_middle` VALUES (48, 86, 41);
INSERT INTO `t_middle` VALUES (49, 86, 56);
INSERT INTO `t_middle` VALUES (57, 89, 41);
INSERT INTO `t_middle` VALUES (58, 89, 56);
INSERT INTO `t_middle` VALUES (59, 89, 64);
INSERT INTO `t_middle` VALUES (60, 89, 65);
INSERT INTO `t_middle` VALUES (61, 90, 41);
INSERT INTO `t_middle` VALUES (62, 90, 66);
INSERT INTO `t_middle` VALUES (63, 91, 67);
INSERT INTO `t_middle` VALUES (64, 91, 56);
INSERT INTO `t_middle` VALUES (68, 93, 70);
INSERT INTO `t_middle` VALUES (69, 93, 71);
INSERT INTO `t_middle` VALUES (77, 98, 71);
INSERT INTO `t_middle` VALUES (78, 98, 75);
INSERT INTO `t_middle` VALUES (79, 98, 76);
INSERT INTO `t_middle` VALUES (80, 98, 77);
INSERT INTO `t_middle` VALUES (81, 108, 71);
INSERT INTO `t_middle` VALUES (82, 108, 78);
INSERT INTO `t_middle` VALUES (94, 105, 70);
INSERT INTO `t_middle` VALUES (95, 105, 70);
INSERT INTO `t_middle` VALUES (98, 85, 41);
INSERT INTO `t_middle` VALUES (99, 110, 41);
INSERT INTO `t_middle` VALUES (101, 111, 41);
INSERT INTO `t_middle` VALUES (102, 111, 65);

-- ----------------------------
-- Table structure for t_totalclass
-- ----------------------------
DROP TABLE IF EXISTS `t_totalclass`;
CREATE TABLE `t_totalclass`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clazz` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_totalclass
-- ----------------------------
INSERT INTO `t_totalclass` VALUES (41, 'java', 1);
INSERT INTO `t_totalclass` VALUES (42, '计算机', 1);
INSERT INTO `t_totalclass` VALUES (43, 'web开发', 1);
INSERT INTO `t_totalclass` VALUES (45, '河北大学', 1);
INSERT INTO `t_totalclass` VALUES (52, '保定', 1);
INSERT INTO `t_totalclass` VALUES (53, '计算机体系结构', 1);
INSERT INTO `t_totalclass` VALUES (54, '数据结构', 1);
INSERT INTO `t_totalclass` VALUES (55, '算法', 1);
INSERT INTO `t_totalclass` VALUES (56, '计算机网络', 1);
INSERT INTO `t_totalclass` VALUES (60, '操作系统', 1);
INSERT INTO `t_totalclass` VALUES (61, 'python', 1);
INSERT INTO `t_totalclass` VALUES (64, '模式识别', 1);
INSERT INTO `t_totalclass` VALUES (65, '前端开发', 1);
INSERT INTO `t_totalclass` VALUES (66, '戴爸爸', 3);
INSERT INTO `t_totalclass` VALUES (67, 'web前端开发', 3);
INSERT INTO `t_totalclass` VALUES (68, 'java', 3);
INSERT INTO `t_totalclass` VALUES (69, '计算机网络', 3);
INSERT INTO `t_totalclass` VALUES (70, 'java', 4);
INSERT INTO `t_totalclass` VALUES (71, '哈哈哈', 4);
INSERT INTO `t_totalclass` VALUES (72, '哼哼哼', 4);
INSERT INTO `t_totalclass` VALUES (73, '呵呵呵', 4);
INSERT INTO `t_totalclass` VALUES (75, 'linux', 4);
INSERT INTO `t_totalclass` VALUES (76, '前端', 4);
INSERT INTO `t_totalclass` VALUES (77, '河北大学', 4);
INSERT INTO `t_totalclass` VALUES (78, '计算机网络', 4);
INSERT INTO `t_totalclass` VALUES (96, '嘿嘿嘿', 4);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `signature` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `github` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logoSrc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '111111', '17778884349', '2502266520@qq.com', '舒服是给死人留着的。', '戴书博', 'https://github.com/Zesystem', 'http://localhost:8080/imgs/1_middle.png');
INSERT INTO `t_user` VALUES (3, 'Zesystem', 'daishubo', '17778889991', 'asdasdas@qq.com', '决战java', '戴爸爸', NULL, 'http://localhost:8080/imgs/3_logo_admin.png');
INSERT INTO `t_user` VALUES (4, 'daishubo', 'daishubo', '17778884349', '2502266520@qq.com', '生死看淡不服就干', '戴大大', 'https://github.com/Zesystem', 'http://localhost:8080/imgs/4_logo_zesystem.png');

SET FOREIGN_KEY_CHECKS = 1;
