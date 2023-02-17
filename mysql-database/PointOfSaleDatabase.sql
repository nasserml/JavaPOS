-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.23 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for pointofsale
CREATE DATABASE IF NOT EXISTS `pointofsale` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pointofsale`;

-- Dumping structure for table pointofsale.card
CREATE TABLE IF NOT EXISTS `card` (
  `cardnumber` varchar(20) NOT NULL,
  `customerid` varchar(20) NOT NULL,
  `amount` varchar(20) NOT NULL,
  `pin` int NOT NULL DEFAULT '0',
  `registerdate` varchar(15) NOT NULL DEFAULT '0',
  `lastdateused` varchar(15) NOT NULL DEFAULT '0',
  `expireddate` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`cardnumber`),
  KEY `FK__customer` (`customerid`),
  CONSTRAINT `FK__customer` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table pointofsale.cashier
CREATE TABLE IF NOT EXISTS `cashier` (
  `id` int NOT NULL,
  `name` varchar(30) NOT NULL DEFAULT '',
  `age` int NOT NULL DEFAULT '0',
  `gender` varchar(10) NOT NULL DEFAULT '0',
  `address` varchar(40) NOT NULL DEFAULT '0',
  `phone` varchar(20) NOT NULL DEFAULT '0',
  `email` varchar(30) NOT NULL DEFAULT '0',
  `password` varchar(20) NOT NULL DEFAULT '0',
  `datecreated` varchar(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table pointofsale.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `age` varchar(10) NOT NULL,
  `gender` varchar(11) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table pointofsale.product category
CREATE TABLE IF NOT EXISTS `product category` (
  `id` int NOT NULL,
  `name` varchar(30) NOT NULL DEFAULT '',
  `datecreated` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table pointofsale.product items
CREATE TABLE IF NOT EXISTS `product items` (
  `barcode` varchar(30) NOT NULL,
  `name` varchar(100) NOT NULL,
  `categoryid` int NOT NULL DEFAULT '0',
  `price` varchar(30) NOT NULL DEFAULT '0',
  `stockamount` varchar(30) NOT NULL DEFAULT '0',
  `suppliedid` int NOT NULL DEFAULT '0',
  `dateadded` varchar(20) NOT NULL DEFAULT '0',
  `expireddate` varchar(20) NOT NULL DEFAULT '0',
  `count` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`barcode`),
  KEY `FK_product items_product category2` (`categoryid`),
  KEY `FK_product items_supplier` (`suppliedid`),
  CONSTRAINT `FK_product items_product category2` FOREIGN KEY (`categoryid`) REFERENCES `product category` (`id`),
  CONSTRAINT `FK_product items_supplier` FOREIGN KEY (`suppliedid`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table pointofsale.promotion
CREATE TABLE IF NOT EXISTS `promotion` (
  `id` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `product barcode` varchar(30) NOT NULL,
  `percentage` varchar(10) NOT NULL,
  `description` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__product items` (`product barcode`),
  CONSTRAINT `FK__product items` FOREIGN KEY (`product barcode`) REFERENCES `product items` (`barcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table pointofsale.purchase
CREATE TABLE IF NOT EXISTS `purchase` (
  `id` int NOT NULL,
  `cashierid` int NOT NULL,
  `date` varchar(20) NOT NULL DEFAULT '',
  `time` varchar(20) NOT NULL DEFAULT '',
  `product barcode` varchar(700) NOT NULL DEFAULT '',
  `quantity` varchar(300) NOT NULL DEFAULT '',
  `totalamount` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  KEY `FK__cashier1` (`cashierid`),
  CONSTRAINT `FK__cashier1` FOREIGN KEY (`cashierid`) REFERENCES `cashier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table pointofsale.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int NOT NULL,
  `name` varchar(30) NOT NULL DEFAULT '',
  `lastdatesupplied` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

-- Dumping structure for table pointofsale.transaction
CREATE TABLE IF NOT EXISTS `transaction` (
  `id` varchar(40) NOT NULL,
  `cashierid` int NOT NULL DEFAULT '0',
  `cardid` varchar(30) NOT NULL DEFAULT '0',
  `purchaseid` int NOT NULL DEFAULT '0',
  `amount` varchar(40) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK__cashier` (`cashierid`),
  KEY `FK__card` (`cardid`),
  KEY `FK_transaction_purchase` (`purchaseid`),
  CONSTRAINT `FK__card` FOREIGN KEY (`cardid`) REFERENCES `card` (`cardnumber`),
  CONSTRAINT `FK__cashier` FOREIGN KEY (`cashierid`) REFERENCES `cashier` (`id`),
  CONSTRAINT `FK_transaction_purchase` FOREIGN KEY (`purchaseid`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
