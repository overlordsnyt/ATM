# Host: localhost  (Version: 5.6.24-log)
# Date: 2015-08-03 11:46:18
# Generator: MySQL-Front 5.3  (Build 4.211)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "account"
#

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_Id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(6) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `current_balance` decimal(11,2) DEFAULT NULL,
  `fixed_balance` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`account_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "account"
#

INSERT INTO `account` VALUES (1,'666001','123',49.05,588.00),(2,'666002','123',118.79,2000.00);

#
# Structure for table "detail"
#

DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `trade_Id` int(11) NOT NULL AUTO_INCREMENT,
  `money` decimal(11,2) NOT NULL DEFAULT '0.00',
  `account_ID_out` int(11) DEFAULT NULL,
  `account_ID_in` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `operateType` smallint(1) DEFAULT NULL,
  PRIMARY KEY (`trade_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "detail"
#

INSERT INTO `detail` VALUES (1,100.00,40,50,'1994-09-01 16:50:00',0),(2,12.00,1,2,NULL,NULL),(3,1012.00,2,1,NULL,NULL),(4,5.00,1,2,'2015-06-30 14:31:20',0);

#
# Structure for table "person_info"
#

DROP TABLE IF EXISTS `person_info`;
CREATE TABLE `person_info` (
  `account_ID` int(11) NOT NULL DEFAULT '0',
  `name` varchar(30) NOT NULL DEFAULT '',
  `identify` varchar(19) NOT NULL DEFAULT '',
  `contact` varchar(11) DEFAULT NULL,
  `sex` smallint(1) NOT NULL DEFAULT '0',
  `note` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`account_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "person_info"
#

INSERT INTO `person_info` VALUES (1,'郑理传','123456789012345678','11156987458',1,NULL),(2,'上帝','000011112222333344','13544446666',0,NULL);
