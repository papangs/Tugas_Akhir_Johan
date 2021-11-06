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

 Date: 06/11/2021 10:11:37
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
  CONSTRAINT `fk_seq_alternatif` FOREIGN KEY (`alternatif_seq`) REFERENCES `alternatif` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_krit_seq` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_sub_seq` FOREIGN KEY (`subkriteria_seq`) REFERENCES `subkriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_alternatif
-- ----------------------------
INSERT INTO `eigen_alternatif` VALUES (31, '0.215', '2021-11-06', 3, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (32, '0.172', '2021-11-06', 6, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (33, '0.199', '2021-11-06', 7, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (34, '0.243', '2021-11-06', 8, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (35, '0.172', '2021-11-06', 9, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (36, '0.278', '2021-11-06', 3, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (37, '0.169', '2021-11-06', 6, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (38, '0.195', '2021-11-06', 7, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (39, '0.22', '2021-11-06', 8, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (40, '0.138', '2021-11-06', 9, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (41, '0.2', '2021-11-06', 3, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (42, '0.2', '2021-11-06', 6, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (43, '0.2', '2021-11-06', 7, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (44, '0.2', '2021-11-06', 8, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (45, '0.2', '2021-11-06', 9, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (46, '0.2', '2021-11-06', 3, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (47, '0.2', '2021-11-06', 6, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (48, '0.2', '2021-11-06', 7, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (49, '0.2', '2021-11-06', 8, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (50, '0.2', '2021-11-06', 9, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (51, '0.2', '2021-11-06', 3, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (52, '0.2', '2021-11-06', 6, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (53, '0.2', '2021-11-06', 7, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (54, '0.2', '2021-11-06', 8, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (55, '0.2', '2021-11-06', 9, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (56, '0.2', '2021-11-06', 3, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (57, '0.2', '2021-11-06', 6, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (58, '0.2', '2021-11-06', 7, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (59, '0.2', '2021-11-06', 8, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (60, '0.2', '2021-11-06', 9, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (61, '0.2', '2021-11-06', 3, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (62, '0.2', '2021-11-06', 6, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (63, '0.2', '2021-11-06', 7, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (64, '0.2', '2021-11-06', 8, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (65, '0.2', '2021-11-06', 9, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (66, '0.2', '2021-11-06', 3, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (67, '0.2', '2021-11-06', 6, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (68, '0.2', '2021-11-06', 7, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (69, '0.2', '2021-11-06', 8, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (70, '0.2', '2021-11-06', 9, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (71, '0.2', '2021-11-06', 3, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (72, '0.2', '2021-11-06', 6, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (73, '0.2', '2021-11-06', 7, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (74, '0.2', '2021-11-06', 8, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (75, '0.2', '2021-11-06', 9, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (76, '0.2', '2021-11-06', 3, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (77, '0.2', '2021-11-06', 6, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (78, '0.2', '2021-11-06', 7, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (79, '0.2', '2021-11-06', 8, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (80, '0.2', '2021-11-06', 9, 10, 4);

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
INSERT INTO `eigen_kriteria` VALUES (1, '0.289', '2021-11-06', 1);
INSERT INTO `eigen_kriteria` VALUES (2, '0.289', '2021-11-06', 2);
INSERT INTO `eigen_kriteria` VALUES (3, '0.176', '2021-11-06', 3);
INSERT INTO `eigen_kriteria` VALUES (4, '0.247', '2021-11-06', 4);

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
  CONSTRAINT `subkriteria_seq_fk` FOREIGN KEY (`subkriteria_seq`) REFERENCES `subkriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `kriteriaseqfk` FOREIGN KEY (`kriteria_seq`) REFERENCES `kriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_subkriteria
-- ----------------------------
INSERT INTO `eigen_subkriteria` VALUES (7, '0.125', '2021-11-06', 1, 1);
INSERT INTO `eigen_subkriteria` VALUES (8, '0.875', '2021-11-06', 2, 1);
INSERT INTO `eigen_subkriteria` VALUES (17, '0.3', '2021-11-06', 6, 3);
INSERT INTO `eigen_subkriteria` VALUES (18, '0.1', '2021-11-06', 7, 3);
INSERT INTO `eigen_subkriteria` VALUES (19, '0.6', '2021-11-06', 8, 3);
INSERT INTO `eigen_subkriteria` VALUES (20, '0.333', '2021-11-06', 9, 4);
INSERT INTO `eigen_subkriteria` VALUES (21, '0.667', '2021-11-06', 10, 4);
INSERT INTO `eigen_subkriteria` VALUES (37, '0.139', '2021-11-06', 3, 2);
INSERT INTO `eigen_subkriteria` VALUES (38, '0.368', '2021-11-06', 4, 2);
INSERT INTO `eigen_subkriteria` VALUES (39, '0.493', '2021-11-06', 5, 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 411 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_alternatif
-- ----------------------------
INSERT INTO `perbandingan_alternatif` VALUES (311, 3, 6, 3, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (312, 3, 7, 3, 1, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (313, 3, 8, 3, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (314, 3, 9, 9, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (315, 6, 7, 7, 1, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (316, 6, 8, 6, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (317, 6, 9, 6, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (318, 7, 8, 8, 1, 1, '3');
INSERT INTO `perbandingan_alternatif` VALUES (319, 7, 9, 7, 1, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (320, 8, 9, 8, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (321, 3, 6, 3, 2, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (322, 3, 7, 7, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (323, 3, 8, 8, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (324, 3, 9, 3, 2, 1, '3');
INSERT INTO `perbandingan_alternatif` VALUES (325, 6, 7, 6, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (326, 6, 8, 6, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (327, 6, 9, 6, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (328, 7, 8, 7, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (329, 7, 9, 7, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (330, 8, 9, 8, 2, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (331, 3, 6, 6, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (332, 3, 7, 7, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (333, 3, 8, 8, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (334, 3, 9, 3, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (335, 6, 7, 7, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (336, 6, 8, 8, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (337, 6, 9, 9, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (338, 7, 8, 8, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (339, 7, 9, 9, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (340, 8, 9, 8, 3, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (341, 3, 6, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (342, 3, 7, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (343, 3, 8, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (344, 3, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (345, 6, 7, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (346, 6, 8, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (347, 6, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (348, 7, 8, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (349, 7, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (350, 8, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (351, 3, 6, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (352, 3, 7, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (353, 3, 8, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (354, 3, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (355, 6, 7, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (356, 6, 8, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (357, 6, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (358, 7, 8, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (359, 7, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (360, 8, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (361, 3, 6, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (362, 3, 7, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (363, 3, 8, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (364, 3, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (365, 6, 7, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (366, 6, 8, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (367, 6, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (368, 7, 8, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (369, 7, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (370, 8, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (371, 3, 6, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (372, 3, 7, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (373, 3, 8, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (374, 3, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (375, 6, 7, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (376, 6, 8, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (377, 6, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (378, 7, 8, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (379, 7, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (380, 8, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (381, 3, 6, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (382, 3, 7, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (383, 3, 8, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (384, 3, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (385, 6, 7, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (386, 6, 8, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (387, 6, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (388, 7, 8, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (389, 7, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (390, 8, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (391, 3, 6, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (392, 3, 7, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (393, 3, 8, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (394, 3, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (395, 6, 7, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (396, 6, 8, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (397, 6, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (398, 7, 8, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (399, 7, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (400, 8, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (401, 3, 6, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (402, 3, 7, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (403, 3, 8, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (404, 3, 9, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (405, 6, 7, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (406, 6, 8, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (407, 6, 9, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (408, 7, 8, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (409, 7, 9, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (410, 8, 9, 0, 10, 4, '1');

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
INSERT INTO `perbandingan_kriteria` VALUES (1, 1, 2, 2, '1');
INSERT INTO `perbandingan_kriteria` VALUES (2, 1, 3, 1, '2');
INSERT INTO `perbandingan_kriteria` VALUES (3, 1, 4, 1, '1');
INSERT INTO `perbandingan_kriteria` VALUES (4, 2, 3, 2, '2');
INSERT INTO `perbandingan_kriteria` VALUES (5, 2, 4, 4, '1');
INSERT INTO `perbandingan_kriteria` VALUES (6, 3, 4, 3, '1');

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
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_subkriteria
-- ----------------------------
INSERT INTO `perbandingan_subkriteria` VALUES (74, 1, 2, 2, 1, '7');
INSERT INTO `perbandingan_subkriteria` VALUES (94, 6, 7, 6, 3, '3');
INSERT INTO `perbandingan_subkriteria` VALUES (95, 6, 8, 8, 3, '2');
INSERT INTO `perbandingan_subkriteria` VALUES (96, 7, 8, 8, 3, '6');
INSERT INTO `perbandingan_subkriteria` VALUES (97, 9, 10, 10, 4, '2');
INSERT INTO `perbandingan_subkriteria` VALUES (113, 3, 4, 4, 2, '2');
INSERT INTO `perbandingan_subkriteria` VALUES (114, 3, 5, 5, 2, '5');
INSERT INTO `perbandingan_subkriteria` VALUES (115, 4, 5, 4, 2, '1');

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

SET FOREIGN_KEY_CHECKS = 1;
