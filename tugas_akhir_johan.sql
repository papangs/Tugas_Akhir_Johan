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

 Date: 03/11/2021 07:26:37
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
  PRIMARY KEY (`seq`) USING BTREE,
  INDEX `fk_seq_alternatif`(`alternatif_seq`) USING BTREE,
  CONSTRAINT `fk_seq_alternatif` FOREIGN KEY (`alternatif_seq`) REFERENCES `alternatif` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_alternatif
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_kriteria
-- ----------------------------

-- ----------------------------
-- Table structure for eigen_subkriteria
-- ----------------------------
DROP TABLE IF EXISTS `eigen_subkriteria`;
CREATE TABLE `eigen_subkriteria`  (
  `seq_eigen_subkriteria` int NOT NULL AUTO_INCREMENT,
  `nilai_eigen_subkriteria` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  `subkriteria_seq` int NULL DEFAULT NULL,
  PRIMARY KEY (`seq_eigen_subkriteria`) USING BTREE,
  INDEX `subkriteria_seq_fk`(`subkriteria_seq`) USING BTREE,
  CONSTRAINT `subkriteria_seq_fk` FOREIGN KEY (`subkriteria_seq`) REFERENCES `subkriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of eigen_subkriteria
-- ----------------------------

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
  `nilai` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_alternatif
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_kriteria
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of perbandingan_subkriteria
-- ----------------------------

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
