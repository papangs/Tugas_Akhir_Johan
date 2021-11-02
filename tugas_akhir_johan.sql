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

 Date: 02/11/2021 07:53:23
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
  `subkriteria_seq` int NULL DEFAULT NULL,
  INDEX `fk_sub_seq`(`subkriteria_seq`) USING BTREE,
  CONSTRAINT `fk_sub_seq` FOREIGN KEY (`subkriteria_seq`) REFERENCES `subkriteria` (`seq`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of alternatif
-- ----------------------------
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 1);
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 2);
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 3);
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 4);
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 5);
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 6);
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 7);
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 8);
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 9);
INSERT INTO `alternatif` VALUES (1, 'Tokopedia', 10);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 1);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 2);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 3);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 4);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 5);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 6);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 7);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 8);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 9);
INSERT INTO `alternatif` VALUES (2, 'Bukalapak', 10);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 1);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 2);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 3);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 4);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 5);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 6);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 7);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 8);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 9);
INSERT INTO `alternatif` VALUES (4, 'Lazada', 10);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 1);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 2);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 3);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 4);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 5);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 6);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 7);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 8);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 9);
INSERT INTO `alternatif` VALUES (5, 'Blibli', 10);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 1);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 2);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 3);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 4);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 5);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 6);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 7);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 8);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 9);
INSERT INTO `alternatif` VALUES (6, 'Shopees', 10);

-- ----------------------------
-- Table structure for eigen_alternatif
-- ----------------------------
DROP TABLE IF EXISTS `eigen_alternatif`;
CREATE TABLE `eigen_alternatif`  (
  `seq` int NOT NULL AUTO_INCREMENT,
  `nilai_eigen_alternatif` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` date NULL DEFAULT NULL,
  `alternatif_seq` int NULL DEFAULT NULL,
  PRIMARY KEY (`seq`) USING BTREE
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
