/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 100421
 Source Host           : localhost:3306
 Source Schema         : tugas_akhir_johan

 Target Server Type    : MySQL
 Target Server Version : 100421
 File Encoding         : 65001

 Date: 22/11/2021 06:54:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alternatif
-- ----------------------------
DROP TABLE IF EXISTS `alternatif`;
CREATE TABLE `alternatif`  (
  `seq` int NOT NULL,
  `alternatif_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of alternatif
-- ----------------------------
INSERT INTO `alternatif` VALUES (3, 'Lazada');
INSERT INTO `alternatif` VALUES (6, 'Blibli');
INSERT INTO `alternatif` VALUES (7, 'Bukalapak');
INSERT INTO `alternatif` VALUES (8, 'Shopee');
INSERT INTO `alternatif` VALUES (9, 'Tokopedia');

-- ----------------------------
-- Table structure for alternatif_subkriteria
-- ----------------------------
DROP TABLE IF EXISTS `alternatif_subkriteria`;
CREATE TABLE `alternatif_subkriteria`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `subkriteria_seq` int NULL DEFAULT NULL,
  `alternatif_seq` int NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fkalternatif`(`alternatif_seq`) USING BTREE,
  INDEX `fk_subkriteria`(`subkriteria_seq`) USING BTREE,
  CONSTRAINT `alternatif_subkriteria_ibfk_1` FOREIGN KEY (`alternatif_seq`) REFERENCES `alternatif` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_subkriteria` FOREIGN KEY (`subkriteria_seq`) REFERENCES `subkriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 133 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of alternatif_subkriteria
-- ----------------------------
INSERT INTO `alternatif_subkriteria` VALUES (53, 1, 3);
INSERT INTO `alternatif_subkriteria` VALUES (54, 2, 3);
INSERT INTO `alternatif_subkriteria` VALUES (55, 3, 3);
INSERT INTO `alternatif_subkriteria` VALUES (56, 4, 3);
INSERT INTO `alternatif_subkriteria` VALUES (57, 5, 3);
INSERT INTO `alternatif_subkriteria` VALUES (58, 6, 3);
INSERT INTO `alternatif_subkriteria` VALUES (59, 7, 3);
INSERT INTO `alternatif_subkriteria` VALUES (60, 8, 3);
INSERT INTO `alternatif_subkriteria` VALUES (61, 9, 3);
INSERT INTO `alternatif_subkriteria` VALUES (62, 10, 3);
INSERT INTO `alternatif_subkriteria` VALUES (83, 1, 6);
INSERT INTO `alternatif_subkriteria` VALUES (84, 2, 6);
INSERT INTO `alternatif_subkriteria` VALUES (85, 3, 6);
INSERT INTO `alternatif_subkriteria` VALUES (86, 4, 6);
INSERT INTO `alternatif_subkriteria` VALUES (87, 5, 6);
INSERT INTO `alternatif_subkriteria` VALUES (88, 6, 6);
INSERT INTO `alternatif_subkriteria` VALUES (89, 7, 6);
INSERT INTO `alternatif_subkriteria` VALUES (90, 8, 6);
INSERT INTO `alternatif_subkriteria` VALUES (91, 9, 6);
INSERT INTO `alternatif_subkriteria` VALUES (92, 10, 6);
INSERT INTO `alternatif_subkriteria` VALUES (93, 1, 7);
INSERT INTO `alternatif_subkriteria` VALUES (94, 2, 7);
INSERT INTO `alternatif_subkriteria` VALUES (95, 3, 7);
INSERT INTO `alternatif_subkriteria` VALUES (96, 4, 7);
INSERT INTO `alternatif_subkriteria` VALUES (97, 5, 7);
INSERT INTO `alternatif_subkriteria` VALUES (98, 6, 7);
INSERT INTO `alternatif_subkriteria` VALUES (99, 7, 7);
INSERT INTO `alternatif_subkriteria` VALUES (100, 8, 7);
INSERT INTO `alternatif_subkriteria` VALUES (101, 9, 7);
INSERT INTO `alternatif_subkriteria` VALUES (102, 10, 7);
INSERT INTO `alternatif_subkriteria` VALUES (113, 1, 8);
INSERT INTO `alternatif_subkriteria` VALUES (114, 2, 8);
INSERT INTO `alternatif_subkriteria` VALUES (115, 3, 8);
INSERT INTO `alternatif_subkriteria` VALUES (116, 4, 8);
INSERT INTO `alternatif_subkriteria` VALUES (117, 5, 8);
INSERT INTO `alternatif_subkriteria` VALUES (118, 6, 8);
INSERT INTO `alternatif_subkriteria` VALUES (119, 7, 8);
INSERT INTO `alternatif_subkriteria` VALUES (120, 8, 8);
INSERT INTO `alternatif_subkriteria` VALUES (121, 9, 8);
INSERT INTO `alternatif_subkriteria` VALUES (122, 10, 8);
INSERT INTO `alternatif_subkriteria` VALUES (123, 1, 9);
INSERT INTO `alternatif_subkriteria` VALUES (124, 2, 9);
INSERT INTO `alternatif_subkriteria` VALUES (125, 3, 9);
INSERT INTO `alternatif_subkriteria` VALUES (126, 4, 9);
INSERT INTO `alternatif_subkriteria` VALUES (127, 5, 9);
INSERT INTO `alternatif_subkriteria` VALUES (128, 6, 9);
INSERT INTO `alternatif_subkriteria` VALUES (129, 7, 9);
INSERT INTO `alternatif_subkriteria` VALUES (130, 8, 9);
INSERT INTO `alternatif_subkriteria` VALUES (131, 9, 9);
INSERT INTO `alternatif_subkriteria` VALUES (132, 10, 9);

-- ----------------------------
-- Table structure for eigen_alternatif
-- ----------------------------
DROP TABLE IF EXISTS `eigen_alternatif`;
CREATE TABLE `eigen_alternatif`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `nilai_eigen_alternatif` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  `alternatif_seq` int NULL DEFAULT NULL,
  `subkriteria_seq` int NULL DEFAULT NULL,
  `kriteria_seq` int NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fk_seq_alternatif`(`alternatif_seq`) USING BTREE,
  INDEX `fk_sub_seq`(`subkriteria_seq`) USING BTREE,
  INDEX `fk_krit_seq`(`kriteria_seq`) USING BTREE,
  CONSTRAINT `fk_krit_seq` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_seq_alternatif` FOREIGN KEY (`alternatif_seq`) REFERENCES `alternatif` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_sub_seq` FOREIGN KEY (`subkriteria_seq`) REFERENCES `subkriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 316 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_alternatif
-- ----------------------------
INSERT INTO `eigen_alternatif` VALUES (266, '0.226', '2021-11-21', 3, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (267, '0.17', '2021-11-21', 6, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (268, '0.25', '2021-11-21', 7, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (269, '0.193', '2021-11-21', 8, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (270, '0.162', '2021-11-21', 9, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (271, '0.198', '2021-11-21', 3, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (272, '0.231', '2021-11-21', 6, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (273, '0.198', '2021-11-21', 7, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (274, '0.176', '2021-11-21', 8, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (275, '0.198', '2021-11-21', 9, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (276, '0.2', '2021-11-21', 3, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (277, '0.2', '2021-11-21', 6, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (278, '0.2', '2021-11-21', 7, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (279, '0.2', '2021-11-21', 8, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (280, '0.2', '2021-11-21', 9, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (281, '0.2', '2021-11-21', 3, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (282, '0.2', '2021-11-21', 6, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (283, '0.2', '2021-11-21', 7, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (284, '0.2', '2021-11-21', 8, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (285, '0.2', '2021-11-21', 9, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (286, '0.2', '2021-11-21', 3, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (287, '0.2', '2021-11-21', 6, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (288, '0.2', '2021-11-21', 7, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (289, '0.2', '2021-11-21', 8, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (290, '0.2', '2021-11-21', 9, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (291, '0.2', '2021-11-21', 3, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (292, '0.2', '2021-11-21', 6, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (293, '0.2', '2021-11-21', 7, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (294, '0.2', '2021-11-21', 8, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (295, '0.2', '2021-11-21', 9, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (296, '0.198', '2021-11-21', 3, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (297, '0.198', '2021-11-21', 6, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (298, '0.176', '2021-11-21', 7, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (299, '0.231', '2021-11-21', 8, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (300, '0.198', '2021-11-21', 9, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (301, '0.2', '2021-11-21', 3, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (302, '0.2', '2021-11-21', 6, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (303, '0.2', '2021-11-21', 7, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (304, '0.2', '2021-11-21', 8, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (305, '0.2', '2021-11-21', 9, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (306, '0.2', '2021-11-21', 3, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (307, '0.2', '2021-11-21', 6, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (308, '0.2', '2021-11-21', 7, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (309, '0.2', '2021-11-21', 8, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (310, '0.2', '2021-11-21', 9, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (311, '0.192', '2021-11-21', 3, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (312, '0.157', '2021-11-21', 6, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (313, '0.267', '2021-11-21', 7, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (314, '0.192', '2021-11-21', 8, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (315, '0.192', '2021-11-21', 9, 10, 4);

-- ----------------------------
-- Table structure for eigen_kriteria
-- ----------------------------
DROP TABLE IF EXISTS `eigen_kriteria`;
CREATE TABLE `eigen_kriteria`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `nilai_eigen_kriteria` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  `kriteria_seq` int NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `kriteria_seq_fk`(`kriteria_seq`) USING BTREE,
  CONSTRAINT `kriteria_seq_fk` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_kriteria
-- ----------------------------
INSERT INTO `eigen_kriteria` VALUES (1, '0.085', '2021-11-21', 1);
INSERT INTO `eigen_kriteria` VALUES (2, '0.201', '2021-11-21', 2);
INSERT INTO `eigen_kriteria` VALUES (3, '0.254', '2021-11-21', 3);
INSERT INTO `eigen_kriteria` VALUES (4, '0.46', '2021-11-21', 4);

-- ----------------------------
-- Table structure for eigen_subkriteria
-- ----------------------------
DROP TABLE IF EXISTS `eigen_subkriteria`;
CREATE TABLE `eigen_subkriteria`  (
  `seq_eigen_subkriteria` int NOT NULL AUTO_INCREMENT,
  `nilai_eigen_subkriteria` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  `subkriteria_seq` int NULL DEFAULT NULL,
  `kriteria_seq` int NULL DEFAULT NULL,
  PRIMARY KEY (`seq_eigen_subkriteria`) USING BTREE,
  INDEX `subkriteria_seq_fk`(`subkriteria_seq`) USING BTREE,
  INDEX `kriteriaseqfk`(`kriteria_seq`) USING BTREE,
  CONSTRAINT `kriteriaseqfk` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `subkriteria_seq_fk` FOREIGN KEY (`subkriteria_seq`) REFERENCES `subkriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_subkriteria
-- ----------------------------
INSERT INTO `eigen_subkriteria` VALUES (118, '0.75', '2021-11-21', 1, 1);
INSERT INTO `eigen_subkriteria` VALUES (119, '0.25', '2021-11-21', 2, 1);
INSERT INTO `eigen_subkriteria` VALUES (120, '0.098', '2021-11-21', 3, 2);
INSERT INTO `eigen_subkriteria` VALUES (121, '0.568', '2021-11-21', 4, 2);
INSERT INTO `eigen_subkriteria` VALUES (122, '0.334', '2021-11-21', 5, 2);
INSERT INTO `eigen_subkriteria` VALUES (123, '0.156', '2021-11-21', 6, 3);
INSERT INTO `eigen_subkriteria` VALUES (124, '0.224', '2021-11-21', 7, 3);
INSERT INTO `eigen_subkriteria` VALUES (125, '0.62', '2021-11-21', 8, 3);
INSERT INTO `eigen_subkriteria` VALUES (126, '0.333', '2021-11-21', 9, 4);
INSERT INTO `eigen_subkriteria` VALUES (127, '0.667', '2021-11-21', 10, 4);

-- ----------------------------
-- Table structure for hasil_rangking
-- ----------------------------
DROP TABLE IF EXISTS `hasil_rangking`;
CREATE TABLE `hasil_rangking`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `alternatif_seq` int NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `rangking` int NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fk_alter`(`alternatif_seq`) USING BTREE,
  CONSTRAINT `hasil_rangking_ibfk_1` FOREIGN KEY (`alternatif_seq`) REFERENCES `alternatif` (`seq`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hasil_rangking
-- ----------------------------
INSERT INTO `hasil_rangking` VALUES (1, 3, '0.199', 2);
INSERT INTO `hasil_rangking` VALUES (2, 6, '0.185', 5);
INSERT INTO `hasil_rangking` VALUES (3, 7, '0.222', 1);
INSERT INTO `hasil_rangking` VALUES (4, 8, '0.198', 3);
INSERT INTO `hasil_rangking` VALUES (5, 9, '0.195', 4);

-- ----------------------------
-- Table structure for kriteria
-- ----------------------------
DROP TABLE IF EXISTS `kriteria`;
CREATE TABLE `kriteria`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `kriteria_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of kriteria
-- ----------------------------
INSERT INTO `kriteria` VALUES (1, 'Promo');
INSERT INTO `kriteria` VALUES (2, 'Metode Pembayaran');
INSERT INTO `kriteria` VALUES (3, 'Metode Pengiriman');
INSERT INTO `kriteria` VALUES (4, 'Layanan CS');

-- ----------------------------
-- Table structure for perbandingan_alternatif
-- ----------------------------
DROP TABLE IF EXISTS `perbandingan_alternatif`;
CREATE TABLE `perbandingan_alternatif`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `alternatif1_seq` int NULL DEFAULT NULL,
  `alternatif2_seq` int NULL DEFAULT NULL,
  `pilihan_alternatif_seq` int NULL DEFAULT NULL,
  `subkriteria_seq` int NULL DEFAULT NULL,
  `kriteria_seq` int NULL DEFAULT NULL,
  `nilai` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_alternatif
-- ----------------------------
INSERT INTO `perbandingan_alternatif` VALUES (27, 3, 6, 3, 1, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (28, 3, 7, 0, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (29, 3, 8, 0, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (30, 3, 9, 0, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (31, 6, 7, 0, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (32, 6, 8, 0, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (33, 6, 9, 0, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (34, 7, 8, 0, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (35, 7, 9, 7, 1, 1, '3');
INSERT INTO `perbandingan_alternatif` VALUES (36, 8, 9, 0, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (37, 3, 6, 0, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (38, 3, 7, 0, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (39, 3, 8, 0, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (40, 3, 9, 0, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (41, 6, 7, 0, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (42, 6, 8, 6, 2, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (43, 6, 9, 0, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (44, 7, 8, 0, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (45, 7, 9, 0, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (46, 8, 9, 0, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (47, 3, 6, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (48, 3, 7, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (49, 3, 8, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (50, 3, 9, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (51, 6, 7, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (52, 6, 8, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (53, 6, 9, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (54, 7, 8, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (55, 7, 9, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (56, 8, 9, 0, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (57, 3, 6, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (58, 3, 7, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (59, 3, 8, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (60, 3, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (61, 6, 7, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (62, 6, 8, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (63, 6, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (64, 7, 8, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (65, 7, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (66, 8, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (67, 3, 6, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (68, 3, 7, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (69, 3, 8, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (70, 3, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (71, 6, 7, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (72, 6, 8, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (73, 6, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (74, 7, 8, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (75, 7, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (76, 8, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (77, 3, 6, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (78, 3, 7, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (79, 3, 8, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (80, 3, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (81, 6, 7, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (82, 6, 8, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (83, 6, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (84, 7, 8, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (85, 7, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (86, 8, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (87, 3, 6, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (88, 3, 7, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (89, 3, 8, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (90, 3, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (91, 6, 7, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (92, 6, 8, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (93, 6, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (94, 7, 8, 8, 7, 3, '2');
INSERT INTO `perbandingan_alternatif` VALUES (95, 7, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (96, 8, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (97, 3, 6, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (98, 3, 7, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (99, 3, 8, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (100, 3, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (101, 6, 7, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (102, 6, 8, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (103, 6, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (104, 7, 8, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (105, 7, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (106, 8, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (107, 3, 6, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (108, 3, 7, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (109, 3, 8, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (110, 3, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (111, 6, 7, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (112, 6, 8, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (113, 6, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (114, 7, 8, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (115, 7, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (116, 8, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (117, 3, 6, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (118, 3, 7, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (119, 3, 8, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (120, 3, 9, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (121, 6, 7, 7, 10, 4, '4');
INSERT INTO `perbandingan_alternatif` VALUES (122, 6, 8, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (123, 6, 9, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (124, 7, 8, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (125, 7, 9, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (126, 8, 9, 0, 10, 4, '1');

-- ----------------------------
-- Table structure for perbandingan_kriteria
-- ----------------------------
DROP TABLE IF EXISTS `perbandingan_kriteria`;
CREATE TABLE `perbandingan_kriteria`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `kriteria1_seq` int NULL DEFAULT NULL,
  `kriteria2_seq` int NULL DEFAULT NULL,
  `pilihan_kriteria_seq` int NULL DEFAULT NULL,
  `nilai` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_kriteria
-- ----------------------------
INSERT INTO `perbandingan_kriteria` VALUES (1, 1, 2, 2, '3');
INSERT INTO `perbandingan_kriteria` VALUES (2, 1, 3, 3, '3');
INSERT INTO `perbandingan_kriteria` VALUES (3, 1, 4, 4, '4');
INSERT INTO `perbandingan_kriteria` VALUES (4, 2, 3, 3, '2');
INSERT INTO `perbandingan_kriteria` VALUES (5, 2, 4, 4, '2');
INSERT INTO `perbandingan_kriteria` VALUES (6, 3, 4, 4, '3');

-- ----------------------------
-- Table structure for perbandingan_subkriteria
-- ----------------------------
DROP TABLE IF EXISTS `perbandingan_subkriteria`;
CREATE TABLE `perbandingan_subkriteria`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `subkriteria1_seq` int NULL DEFAULT NULL,
  `subkriteria2_seq` int NULL DEFAULT NULL,
  `pilihan_subkriteria_seq` int NULL DEFAULT NULL,
  `kriteria_seq` int NULL DEFAULT NULL,
  `nilai` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_subkriteria
-- ----------------------------
INSERT INTO `perbandingan_subkriteria` VALUES (43, 1, 2, 1, 1, '3');
INSERT INTO `perbandingan_subkriteria` VALUES (44, 3, 4, 4, 2, '5');
INSERT INTO `perbandingan_subkriteria` VALUES (45, 3, 5, 5, 2, '4');
INSERT INTO `perbandingan_subkriteria` VALUES (46, 4, 5, 4, 2, '2');
INSERT INTO `perbandingan_subkriteria` VALUES (47, 6, 7, 7, 3, '2');
INSERT INTO `perbandingan_subkriteria` VALUES (48, 6, 8, 8, 3, '3');
INSERT INTO `perbandingan_subkriteria` VALUES (49, 7, 8, 8, 3, '4');
INSERT INTO `perbandingan_subkriteria` VALUES (50, 9, 10, 10, 4, '2');

-- ----------------------------
-- Table structure for random_index
-- ----------------------------
DROP TABLE IF EXISTS `random_index`;
CREATE TABLE `random_index`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `size_matrics` int NOT NULL,
  `random_consistency` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  UNIQUE INDEX `Ukuran_Matriks`(`size_matrics`) USING BTREE,
  UNIQUE INDEX `Ukuran_Matriks_2`(`size_matrics`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of random_index
-- ----------------------------
INSERT INTO `random_index` VALUES (1, 1, '0.00');
INSERT INTO `random_index` VALUES (2, 2, '0.00');
INSERT INTO `random_index` VALUES (4, 3, '0.58');
INSERT INTO `random_index` VALUES (5, 4, '0.90');
INSERT INTO `random_index` VALUES (6, 5, '1.12');
INSERT INTO `random_index` VALUES (7, 6, '1.24');
INSERT INTO `random_index` VALUES (8, 7, '1.32');
INSERT INTO `random_index` VALUES (9, 8, '1.41');
INSERT INTO `random_index` VALUES (10, 9, '1.45');
INSERT INTO `random_index` VALUES (11, 10, '1.49');
INSERT INTO `random_index` VALUES (12, 11, '1.51');
INSERT INTO `random_index` VALUES (13, 12, '1.48');
INSERT INTO `random_index` VALUES (14, 13, '1.56');
INSERT INTO `random_index` VALUES (15, 14, '1.57');
INSERT INTO `random_index` VALUES (16, 15, '1.59');

-- ----------------------------
-- Table structure for subkriteria
-- ----------------------------
DROP TABLE IF EXISTS `subkriteria`;
CREATE TABLE `subkriteria`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `subkriteria_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `kriteria_seq` int NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fk_kriteria_seq`(`kriteria_seq`) USING BTREE,
  CONSTRAINT `fk_kriteria_seq` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subkriteria
-- ----------------------------
INSERT INTO `subkriteria` VALUES (1, 'Diskon', 1);
INSERT INTO `subkriteria` VALUES (2, 'Cashback', 1);
INSERT INTO `subkriteria` VALUES (3, 'Tunai (COD)', 2);
INSERT INTO `subkriteria` VALUES (4, 'Transfer Bank', 2);
INSERT INTO `subkriteria` VALUES (5, 'E-Wallet', 2);
INSERT INTO `subkriteria` VALUES (6, 'Instant (Same day)', 3);
INSERT INTO `subkriteria` VALUES (7, 'Reguler', 3);
INSERT INTO `subkriteria` VALUES (8, 'Ekspress', 3);
INSERT INTO `subkriteria` VALUES (9, 'Live Chat', 4);
INSERT INTO `subkriteria` VALUES (10, 'BOT Chat', 4);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_seq` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `akses` enum('Admin','User') CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'YWRtaW4=', 'Admin');
INSERT INTO `user` VALUES (2, 'johan', 'am9oYW4=', 'User');
INSERT INTO `user` VALUES (3, 'khavid', 'a2hhdmlk', 'User');

SET FOREIGN_KEY_CHECKS = 1;
