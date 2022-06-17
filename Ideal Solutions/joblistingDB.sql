-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.21-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for joblistings
CREATE DATABASE IF NOT EXISTS `joblistings` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `joblistings`;

-- Dumping structure for table joblistings.applicants
CREATE TABLE IF NOT EXISTS `applicants` (
  `appId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `surname` varchar(50) NOT NULL DEFAULT '0',
  `resume` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table joblistings.applicants: ~4 rows (approximately)
/*!40000 ALTER TABLE `applicants` DISABLE KEYS */;
INSERT INTO `applicants` (`appId`, `name`, `surname`, `resume`) VALUES
	(2, 'Litania', 'Chauke', 'Aspiring Java Developer'),
	(3, 'Chris', 'Cole', 'Senior Jave Developer'),
	(4, 'Christian', 'Sindegaurd', 'Pentester');
/*!40000 ALTER TABLE `applicants` ENABLE KEYS */;

-- Dumping structure for table joblistings.job
CREATE TABLE IF NOT EXISTS `job` (
  `jobId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL DEFAULT '0',
  `salary` double NOT NULL,
  PRIMARY KEY (`jobId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table joblistings.job: ~1 rows (approximately)
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` (`jobId`, `description`, `salary`) VALUES
	(1, 'IT specialist', 2000),
	(2, 'Java Developer', 20000),
	(4, 'Network Designer', 30000);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;

-- Dumping structure for table joblistings.listing
CREATE TABLE IF NOT EXISTS `listing` (
  `listingId` int(11) NOT NULL AUTO_INCREMENT,
  `jobId` int(10) unsigned NOT NULL,
  `appId` int(10) unsigned NOT NULL,
  PRIMARY KEY (`listingId`),
  KEY `FK__job` (`jobId`),
  KEY `FK__applicants` (`appId`),
  CONSTRAINT `FK__applicants` FOREIGN KEY (`appId`) REFERENCES `applicants` (`appId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__job` FOREIGN KEY (`jobId`) REFERENCES `job` (`jobId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table joblistings.listing: ~0 rows (approximately)
/*!40000 ALTER TABLE `listing` DISABLE KEYS */;
INSERT INTO `listing` (`listingId`, `jobId`, `appId`) VALUES
	(2, 1, 4),
	(3, 1, 2);
/*!40000 ALTER TABLE `listing` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
