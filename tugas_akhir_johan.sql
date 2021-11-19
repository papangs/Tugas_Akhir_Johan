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

 Date: 19/11/2021 08:34:26
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
) ENGINE = InnoDB AUTO_INCREMENT = 196 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_alternatif
-- ----------------------------
INSERT INTO `eigen_alternatif` VALUES (41, '0.2', '2021-11-06', 3, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (42, '0.2', '2021-11-06', 6, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (43, '0.2', '2021-11-06', 7, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (44, '0.2', '2021-11-06', 8, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (45, '0.2', '2021-11-06', 9, 3, 2);
INSERT INTO `eigen_alternatif` VALUES (81, '0.215', '2021-11-06', 3, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (82, '0.172', '2021-11-06', 6, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (83, '0.199', '2021-11-06', 7, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (84, '0.243', '2021-11-06', 8, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (85, '0.172', '2021-11-06', 9, 1, 1);
INSERT INTO `eigen_alternatif` VALUES (91, '0.278', '2021-11-06', 3, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (92, '0.169', '2021-11-06', 6, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (93, '0.195', '2021-11-06', 7, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (94, '0.22', '2021-11-06', 8, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (95, '0.138', '2021-11-06', 9, 2, 1);
INSERT INTO `eigen_alternatif` VALUES (136, '0.173', '2021-11-07', 3, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (137, '0.196', '2021-11-07', 6, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (138, '0.173', '2021-11-07', 7, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (139, '0.229', '2021-11-07', 8, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (140, '0.229', '2021-11-07', 9, 8, 3);
INSERT INTO `eigen_alternatif` VALUES (151, '0.188', '2021-11-07', 3, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (152, '0.165', '2021-11-07', 6, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (153, '0.277', '2021-11-07', 7, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (154, '0.221', '2021-11-07', 8, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (155, '0.15', '2021-11-07', 9, 6, 3);
INSERT INTO `eigen_alternatif` VALUES (171, '0.245', '2021-11-07', 3, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (172, '0.139', '2021-11-07', 6, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (173, '0.17', '2021-11-07', 7, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (174, '0.253', '2021-11-07', 8, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (175, '0.195', '2021-11-07', 9, 7, 3);
INSERT INTO `eigen_alternatif` VALUES (176, '0.172', '2021-11-07', 3, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (177, '0.206', '2021-11-07', 6, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (178, '0.205', '2021-11-07', 7, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (179, '0.191', '2021-11-07', 8, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (180, '0.227', '2021-11-07', 9, 9, 4);
INSERT INTO `eigen_alternatif` VALUES (181, '0.171', '2021-11-07', 3, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (182, '0.231', '2021-11-07', 6, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (183, '0.235', '2021-11-07', 7, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (184, '0.171', '2021-11-07', 8, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (185, '0.191', '2021-11-07', 9, 4, 2);
INSERT INTO `eigen_alternatif` VALUES (186, '0.148', '2021-11-07', 3, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (187, '0.17', '2021-11-07', 6, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (188, '0.188', '2021-11-07', 7, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (189, '0.195', '2021-11-07', 8, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (190, '0.3', '2021-11-07', 9, 5, 2);
INSERT INTO `eigen_alternatif` VALUES (191, '0.172', '2021-11-07', 3, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (192, '0.17', '2021-11-07', 6, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (193, '0.17', '2021-11-07', 7, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (194, '0.228', '2021-11-07', 8, 10, 4);
INSERT INTO `eigen_alternatif` VALUES (195, '0.261', '2021-11-07', 9, 10, 4);

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
INSERT INTO `eigen_kriteria` VALUES (1, '0.112', '2021-11-19', 1);
INSERT INTO `eigen_kriteria` VALUES (2, '0.112', '2021-11-19', 2);
INSERT INTO `eigen_kriteria` VALUES (3, '0.425', '2021-11-19', 3);
INSERT INTO `eigen_kriteria` VALUES (4, '0.351', '2021-11-19', 4);

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
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_subkriteria
-- ----------------------------
INSERT INTO `eigen_subkriteria` VALUES (52, '0.5', '2021-11-18', 1, 1);
INSERT INTO `eigen_subkriteria` VALUES (53, '0.5', '2021-11-18', 2, 1);
INSERT INTO `eigen_subkriteria` VALUES (60, '0.5', '2021-11-18', 9, 4);
INSERT INTO `eigen_subkriteria` VALUES (61, '0.5', '2021-11-18', 10, 4);
INSERT INTO `eigen_subkriteria` VALUES (83, '0.158', '2021-11-18', 3, 2);
INSERT INTO `eigen_subkriteria` VALUES (84, '0.655', '2021-11-18', 4, 2);
INSERT INTO `eigen_subkriteria` VALUES (85, '0.187', '2021-11-18', 5, 2);
INSERT INTO `eigen_subkriteria` VALUES (89, '0.333', '2021-11-18', 6, 3);
INSERT INTO `eigen_subkriteria` VALUES (90, '0.333', '2021-11-18', 7, 3);
INSERT INTO `eigen_subkriteria` VALUES (91, '0.333', '2021-11-18', 8, 3);

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
INSERT INTO `hasil_rangking` VALUES (1, 3, '0.199', 3);
INSERT INTO `hasil_rangking` VALUES (2, 6, '0.181', 5);
INSERT INTO `hasil_rangking` VALUES (3, 7, '0.196', 4);
INSERT INTO `hasil_rangking` VALUES (4, 8, '0.219', 1);
INSERT INTO `hasil_rangking` VALUES (5, 9, '0.208', 2);

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
) ENGINE = InnoDB AUTO_INCREMENT = 710 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_alternatif
-- ----------------------------
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
INSERT INTO `perbandingan_alternatif` VALUES (411, 3, 6, 3, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (412, 3, 7, 3, 1, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (413, 3, 8, 3, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (414, 3, 9, 9, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (415, 6, 7, 7, 1, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (416, 6, 8, 6, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (417, 6, 9, 6, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (418, 7, 8, 8, 1, 1, '3');
INSERT INTO `perbandingan_alternatif` VALUES (419, 7, 9, 7, 1, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (420, 8, 9, 8, 1, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (432, 3, 6, 3, 2, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (433, 3, 7, 7, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (434, 3, 8, 8, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (435, 3, 9, 3, 2, 1, '3');
INSERT INTO `perbandingan_alternatif` VALUES (436, 6, 7, 6, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (437, 6, 8, 6, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (438, 6, 9, 6, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (439, 7, 8, 7, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (440, 7, 9, 7, 2, 1, '1');
INSERT INTO `perbandingan_alternatif` VALUES (441, 8, 9, 8, 2, 1, '2');
INSERT INTO `perbandingan_alternatif` VALUES (561, 3, 6, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (562, 3, 7, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (563, 3, 8, 8, 8, 3, '2');
INSERT INTO `perbandingan_alternatif` VALUES (564, 3, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (565, 6, 7, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (566, 6, 8, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (567, 6, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (568, 7, 8, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (569, 7, 9, 9, 8, 3, '2');
INSERT INTO `perbandingan_alternatif` VALUES (570, 8, 9, 0, 8, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (594, 3, 6, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (595, 3, 7, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (596, 3, 8, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (597, 3, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (598, 6, 7, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (599, 6, 8, 8, 6, 3, '2');
INSERT INTO `perbandingan_alternatif` VALUES (600, 6, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (601, 7, 8, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (602, 7, 9, 7, 6, 3, '5');
INSERT INTO `perbandingan_alternatif` VALUES (603, 8, 9, 0, 6, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (658, 3, 6, 3, 7, 3, '3');
INSERT INTO `perbandingan_alternatif` VALUES (659, 3, 7, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (660, 3, 8, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (661, 3, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (662, 6, 7, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (663, 6, 8, 8, 7, 3, '2');
INSERT INTO `perbandingan_alternatif` VALUES (664, 6, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (665, 7, 8, 8, 7, 3, '2');
INSERT INTO `perbandingan_alternatif` VALUES (666, 7, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (667, 8, 9, 0, 7, 3, '1');
INSERT INTO `perbandingan_alternatif` VALUES (670, 3, 6, 6, 9, 4, '2');
INSERT INTO `perbandingan_alternatif` VALUES (671, 3, 7, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (672, 3, 8, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (673, 3, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (674, 6, 7, 7, 9, 4, '2');
INSERT INTO `perbandingan_alternatif` VALUES (675, 6, 8, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (676, 6, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (677, 7, 8, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (678, 7, 9, 9, 9, 4, '2');
INSERT INTO `perbandingan_alternatif` VALUES (679, 8, 9, 0, 9, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (680, 3, 6, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (681, 3, 7, 7, 4, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (682, 3, 8, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (683, 3, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (684, 6, 7, 6, 4, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (685, 6, 8, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (686, 6, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (687, 7, 8, 7, 4, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (688, 7, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (689, 8, 9, 0, 4, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (690, 3, 6, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (691, 3, 7, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (692, 3, 8, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (693, 3, 9, 9, 5, 2, '4');
INSERT INTO `perbandingan_alternatif` VALUES (694, 6, 7, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (695, 6, 8, 8, 5, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (696, 6, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (697, 7, 8, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (698, 7, 9, 0, 5, 2, '1');
INSERT INTO `perbandingan_alternatif` VALUES (699, 8, 9, 9, 5, 2, '2');
INSERT INTO `perbandingan_alternatif` VALUES (700, 3, 6, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (701, 3, 7, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (702, 3, 8, 8, 10, 4, '2');
INSERT INTO `perbandingan_alternatif` VALUES (703, 3, 9, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (704, 6, 7, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (705, 6, 8, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (706, 6, 9, 9, 10, 4, '2');
INSERT INTO `perbandingan_alternatif` VALUES (707, 7, 8, 0, 10, 4, '1');
INSERT INTO `perbandingan_alternatif` VALUES (708, 7, 9, 9, 10, 4, '2');
INSERT INTO `perbandingan_alternatif` VALUES (709, 8, 9, 0, 10, 4, '1');

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
INSERT INTO `perbandingan_kriteria` VALUES (1, 2, 1, 1, '2');
INSERT INTO `perbandingan_kriteria` VALUES (2, 2, 3, 3, '4');
INSERT INTO `perbandingan_kriteria` VALUES (3, 4, 3, 4, '2');
INSERT INTO `perbandingan_kriteria` VALUES (4, 3, 1, 3, '2');
INSERT INTO `perbandingan_kriteria` VALUES (5, 4, 1, 1, '3');
INSERT INTO `perbandingan_kriteria` VALUES (6, 2, 4, 4, '3');

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
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_subkriteria
-- ----------------------------
INSERT INTO `perbandingan_subkriteria` VALUES (10, 2, 1, 2, 1, '4');
INSERT INTO `perbandingan_subkriteria` VALUES (17, 10, 9, 10, 4, '3');
INSERT INTO `perbandingan_subkriteria` VALUES (39, 3, 4, 4, 2, '5');
INSERT INTO `perbandingan_subkriteria` VALUES (40, 5, 3, 3, 2, '6');
INSERT INTO `perbandingan_subkriteria` VALUES (41, 4, 5, 4, 2, '3');
INSERT INTO `perbandingan_subkriteria` VALUES (45, 7, 6, 7, 3, '8');
INSERT INTO `perbandingan_subkriteria` VALUES (46, 8, 6, 8, 3, '2');
INSERT INTO `perbandingan_subkriteria` VALUES (47, 8, 7, 7, 3, '3');

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
