/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : recuriment_website

 Target Server Type    : MySQL
 Target Server Version : 80016
d File Encoding         : 65001

 Date: 06/11/2021 19:32:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carousel_info
-- ----------------------------
DROP TABLE IF EXISTS `carousel_info`;
CREATE TABLE `carousel_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '图片',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `active` tinyint(1) NULL DEFAULT NULL,
  `is_delete` int(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of carousel_info
-- ----------------------------
INSERT INTO `carousel_info` VALUES (1, '2021校园招聘', '提升求职能力，了解校招流程，校园求职快人一步。\r\n              高质量实习名企推荐，帮助大家在招聘季全面启动之前提升简历背景，名企实习经验，提高校招竞争力！', 'http://101.35.116.44:8888/group1/M00/00/00/CgAECWGGTPOABhjhAAC06c4-zFY232.jpg', 0, 1, 0);
INSERT INTO `carousel_info` VALUES (2, '第八届京津冀招才引智大会', '“京津冀招才引智大会”是助力人才强冀工程深入实施，服务和促进京津冀人才协同发展的重要引才平台，是2020年省委人才工作要点，省政府年度工作任务确定的重点人才工作项目。', 'http://101.35.116.44:8888/group1/M00/00/00/CgAECWGGTQOAOXIxAAGic5Ic6uA879.jpg', 1, 0, 0);
INSERT INTO `carousel_info` VALUES (3, '2020届高校毕业生全国网络联合招聘', '线视频面试，避免疫情感染，随时随地在线沟通，语音视频面试更安全<br>\r\n              随时随地可面试，在哪都能聊工作。远程面试防止疫情感染', 'http://101.35.116.44:8888/group1/M00/00/00/CgAECWGGTQ2AUXjZAAbsycL3_Nk289.jpg', 2, 0, 0);
INSERT INTO `carousel_info` VALUES (5, '1', '3', 'http://101.35.116.44:8888/group1/M00/00/00/CgAECWGGVkeAdMjWAAGic5Ic6uA954.jpg', 4, NULL, 0);

-- ----------------------------
-- Table structure for company_info
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '登录用户id',
  `c_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '公司名称',
  `c_logo` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '公司logo',
  `c_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '公司描述',
  `c_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '公司地址',
  `c_city` int(11) NULL DEFAULT NULL COMMENT '所属城市',
  `c_established` date NULL DEFAULT NULL COMMENT '成立时间',
  `c_currentstate` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '当前状态',
  `c_contact` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `c_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '公司类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '企业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company_info
-- ----------------------------
INSERT INTO `company_info` VALUES (1, 1, '公司1', '	http://mallfile.oss-cn-shanghai.aliyuncs.com/fault/kf/2021-10-25/AAAAA.jpg', '啊啊啊啊啊啊啊啊', '啊啊啊啊啊啊啊啊', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `company_info` VALUES (2, 4, 'aaaaaaa', 'http://101.35.116.44:8888/group1/M00/00/00/CgAECWGF7nGAKinNAAD441VQe-g817.jpg', 'aaaaa', 'aaaa', 1, '2021-02-01', '已上市', 'aaaaaaaa', 'aaaaa');

-- ----------------------------
-- Table structure for job_info
-- ----------------------------
DROP TABLE IF EXISTS `job_info`;
CREATE TABLE `job_info`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NULL DEFAULT NULL COMMENT '公司id',
  `j_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '职位名称',
  `j_experience` smallint(1) NULL DEFAULT NULL COMMENT '工作经验',
  `j_education` smallint(1) NULL DEFAULT NULL COMMENT '学历',
  `j_salary_min` int(11) NULL DEFAULT NULL COMMENT '薪资范围(低)',
  `j_salary_max` int(11) NULL DEFAULT NULL COMMENT '薪资范围(高)',
  `j_number` int(11) NULL DEFAULT NULL COMMENT '招聘多少人',
  `j_type` int(1) NULL DEFAULT NULL COMMENT '岗位类型',
  `j_resume` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '职位介绍',
  `j_require` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '职位要求',
  `j_treatment` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '职位待遇',
  `j_stime` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `j_etime` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '职业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job_info
-- ----------------------------
INSERT INTO `job_info` VALUES (1, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-02-01 00:00:00', '2021-10-01 00:00:00');
INSERT INTO `job_info` VALUES (2, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');
INSERT INTO `job_info` VALUES (3, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');
INSERT INTO `job_info` VALUES (4, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');
INSERT INTO `job_info` VALUES (5, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');
INSERT INTO `job_info` VALUES (6, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');
INSERT INTO `job_info` VALUES (7, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');
INSERT INTO `job_info` VALUES (8, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');
INSERT INTO `job_info` VALUES (9, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');
INSERT INTO `job_info` VALUES (10, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');
INSERT INTO `job_info` VALUES (11, 2, 'bbbbb', 1, 1, 5000, 5000, 100, 1, '职位介绍', '岗位要求', '岗位待遇', '2021-11-01 10:40:48', '2021-12-31 10:41:01');

-- ----------------------------
-- Table structure for resume_info
-- ----------------------------
DROP TABLE IF EXISTS `resume_info`;
CREATE TABLE `resume_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) NULL DEFAULT NULL COMMENT '公司id',
  `j_id` int(11) NULL DEFAULT NULL COMMENT '职位id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `curriculum_vitae` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '简历',
  `resume_time` datetime(0) NULL DEFAULT NULL COMMENT '投递时间',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resume_info
-- ----------------------------
INSERT INTO `resume_info` VALUES (3, 2, 1, 1, 'http://101.35.116.44:8888/group1/M00/00/00/CgAECWGDmzeAabfVAAxwj2hAxj407.docx', '2021-11-05 08:46:36', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `role_id` int(255) NULL DEFAULT NULL COMMENT '角色(1-管理员，2-用户，3-企业)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '1@qq.com', '111', 'aa', 2);
INSERT INTO `user` VALUES (3, '117354827@qq.com', '111', '111', 2);
INSERT INTO `user` VALUES (4, '1173548276@qq,com', 'a3216119', NULL, 3);
INSERT INTO `user` VALUES (5, 'admin', 'admin', '管理员', 1);
INSERT INTO `user` VALUES (7, '1173548271@qq.com', '1111', 'aaaaa', 2);
INSERT INTO `user` VALUES (8, 'ccc', 'ccc', 'cccc', 2);
INSERT INTO `user` VALUES (9, '333', '444', '444', 2);

-- ----------------------------
-- Table structure for user_complain
-- ----------------------------
DROP TABLE IF EXISTS `user_complain`;
CREATE TABLE `user_complain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `c_id` int(11) NULL DEFAULT NULL COMMENT '企业id',
  `complain` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '投诉内容',
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '投诉' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_file
-- ----------------------------
DROP TABLE IF EXISTS `user_file`;
CREATE TABLE `user_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '类型',
  `file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '存储地址',
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '联系方式',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `graduate_date` date NULL DEFAULT NULL COMMENT '毕业时间',
  `graduate_school` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `education` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '学历',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '自我介绍',
  `curriculum_vitae` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '简历',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (5, 'aaaa', '1996-11-02', 'bbbb', '男', '2021-11-10', 'aaaaaa', '小学', 'aaaaa', 'http://101.35.116.44:8888/group1/M00/00/00/CgAECWGDmzeAabfVAAxwj2hAxj407.docx', 1);

SET FOREIGN_KEY_CHECKS = 1;
