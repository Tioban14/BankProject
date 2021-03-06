-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mybank
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata` (
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `cardtype` varchar(100) DEFAULT NULL,
  `cardnumber` varchar(255) DEFAULT NULL,
  `subscriptionstatus` varchar(255) DEFAULT NULL,
  `subscriptiondate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata`
--

LOCK TABLES `userdata` WRITE;
/*!40000 ALTER TABLE `userdata` DISABLE KEYS */;
INSERT INTO `userdata` VALUES ('ALBERTO','LPZ','1985-09-12','DEBIT','1111555522223333','ACTIVE','2022-02-03'),('Andrea','AAM','1998-05-14','CREDIT','1111222233334444','ACTIVE','2022-02-02'),('Carlos','Carl','1998-05-15','CREDIT','3333333333333333','ACTIVE','2022-02-02'),('Esteban','ELR','1998-05-16','DEBIT','1234567812345678','ACTIVE','2022-02-02'),('Fernando','FER','1998-05-17','CREDIT','1234567890123456','ACTIVE','2022-02-02'),('GERONIMO','MTZ','1990-04-05','DEBIT','7777999944442222','ACTIVE','2022-02-03'),('Hermione','Her','1994-08-23','DEBIT','0000000000000000','ACTIVE','2022-02-03'),('Jose','J','1998-05-18','CREDIT','1111444477770000','ACTIVE','2022-02-02'),('Juan','JJ','1995-12-22','DEBIT','1111111111111111','ACTIVE','2022-02-02'),('PABLO','PABL','1990-11-02','CREDIT','5555555555555555','ACTIVE','2022-02-03'),('Pancho','pa','1998-05-19','CREDIT','3213213213213212','ACTIVE','2022-02-02'),('Pedrito Sola','PeSo','1998-05-20','CREDIT','9999999999999999','ACTIVE','2022-02-02'),('ROBERTO','ROB','1990-12-12','DEBIT','1111222233334444','ACTIVE','2022-02-03'),('Sancho','sa','1888-03-03','DEBIT','8888888888888888','ACTIVE','2022-02-03'),('Simon','smn','1998-05-01','DEBIT','5555555111111111','ACTIVE','2022-02-03');
/*!40000 ALTER TABLE `userdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-03 18:16:20
