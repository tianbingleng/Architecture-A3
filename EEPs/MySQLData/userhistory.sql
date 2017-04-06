-- MySQL dump 10.13  Distrib 5.1.42, for Win32 (ia32)
--
-- Host: localhost    Database: userhistory
-- ------------------------------------------------------
-- Server version	5.1.42-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `loginhistory`
--

DROP TABLE IF EXISTS `loginhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginhistory` (
  `category` varchar(15) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `logintype` varchar(10) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `ipaddress` varchar(20) DEFAULT NULL,
  `time` DATETIME DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginhistory`
--

LOCK TABLES `loginhistory` WRITE;
/*!40000 ALTER TABLE `loginhistory` DISABLE KEYS */;
INSERT INTO `loginhistory` VALUES ('inventory','i1','log_in','success','128.237.221.209','2017-04-04 10:30:00');
INSERT INTO `loginhistory` VALUES ('inventory','i2','log_in','success','128.237.221.222','2017-04-03 10:31:24');
INSERT INTO `loginhistory` VALUES ('inventory','i2','log_in','success','128.237.221.210','2017-04-05 10:32:08');
INSERT INTO `loginhistory` VALUES ('inventory','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:09');
INSERT INTO `loginhistory` VALUES ('inventory','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:10');
INSERT INTO `loginhistory` VALUES ('inventory','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:11');
INSERT INTO `loginhistory` VALUES ('inventory','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:12');
INSERT INTO `loginhistory` VALUES ('inventory','i1','logout','success','128.237.221.209','2017-04-04 12:00:19');
INSERT INTO `loginhistory` VALUES ('inventory','i2','logout','success','128.237.221.222','2017-04-03 12:21:49');
INSERT INTO `loginhistory` VALUES ('inventory','i3','logout','success','128.237.221.210','2017-04-05 12:34:00');
INSERT INTO `loginhistory` VALUES ('order','o1','log_in','success','128.237.221.209','2017-04-04 10:30:00');
INSERT INTO `loginhistory` VALUES ('order','o2','log_in','success','128.237.221.222','2017-04-03 10:31:24');
INSERT INTO `loginhistory` VALUES ('order','o2','log_in','success','128.237.221.210','2017-04-05 10:32:08');
INSERT INTO `loginhistory` VALUES ('order','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:09');
INSERT INTO `loginhistory` VALUES ('order','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:10');
INSERT INTO `loginhistory` VALUES ('order','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:11');
INSERT INTO `loginhistory` VALUES ('order','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:12');
INSERT INTO `loginhistory` VALUES ('order','o1','logout','success','128.237.221.209','2017-04-04 12:00:19');
INSERT INTO `loginhistory` VALUES ('order','o2','logout','success','128.237.221.222','2017-04-03 12:21:49');
INSERT INTO `loginhistory` VALUES ('order','o3','logout','success','128.237.221.210','2017-04-05 12:34:00');
INSERT INTO `loginhistory` VALUES ('shipping','s1','log_in','success','128.237.221.209','2017-04-04 10:30:00');
INSERT INTO `loginhistory` VALUES ('shipping','s2','log_in','success','128.237.221.222','2017-04-03 10:31:24');
INSERT INTO `loginhistory` VALUES ('shipping','s2','log_in','success','128.237.221.210','2017-04-05 10:32:08');
INSERT INTO `loginhistory` VALUES ('shipping','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:09');
INSERT INTO `loginhistory` VALUES ('shipping','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:10');
INSERT INTO `loginhistory` VALUES ('shipping','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:11');
INSERT INTO `loginhistory` VALUES ('shipping','x1','log_in','failure','128.237.221.204','2017-04-01 10:34:12');
INSERT INTO `loginhistory` VALUES ('shipping','s1','logout','success','128.237.221.209','2017-04-04 12:00:19');
INSERT INTO `loginhistory` VALUES ('shipping','s2','logout','success','128.237.221.222','2017-04-03 12:21:49');
INSERT INTO `loginhistory` VALUES ('shipping','s3','logout','success','128.237.221.210','2017-04-05 12:34:00');


/*!40000 ALTER TABLE `loginhistory` ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-02-10 15:33:35
