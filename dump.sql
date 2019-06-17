-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: crm
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL,
  `brand` varchar(40) DEFAULT NULL,
  `model` varchar(40) DEFAULT NULL,
  `prod_year` int(4) DEFAULT NULL,
  `reg_nr` varchar(20) DEFAULT NULL,
  `review_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `car_ibfk_1` (`customer_id`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,3,'sf','sfs',1994,'BM 6739','2020-06-23'),(2,3,'rt','uo',1996,'DF 8642','2020-02-24'),(3,4,'jk','model 5',1998,'KL 4725','2021-05-20'),(4,5,'zc','sf',2014,'TU 5728','2020-10-24'),(6,5,'rdg','t',1945,'56 tutu','2019-06-11');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(60) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (3,'Kl 2','Kl 2 surname','1960-02-09'),(4,'Kl 3','Kl 3 surname','1940-04-30'),(5,'Klient 4','Klient 4 surname','1976-08-02'),(6,'Kl 5','Kl 5 nazwisko','1956-08-26'),(7,'x','c','1934-02-14'),(8,'w','e','1924-12-14');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(60) DEFAULT NULL,
  `phone_nr` varchar(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `man_hour` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'prac1','nazw prac1','62-826-478','notatka nr 1',46.38),(2,'Prac2','Nazw prac2','78-8395-56','Notatka nr 2',32.26),(3,'Prac3','N prac3','34-5678','jbs jkao',25.12),(4,'pracow 4','N prac 4','78 876-345','Tekst prac 4',65.10),(5,'Prac 5','N prac 5','5634-6806','hjie kgsh',40.21);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status`
--

DROP TABLE IF EXISTS `order_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_status` (
  `status_code` varchar(20) NOT NULL,
  `status_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`status_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status`
--

LOCK TABLES `order_status` WRITE;
/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;
INSERT INTO `order_status` VALUES ('CANC','Rezygnacja'),('DONE','Gotowy do odbioru'),('PRAC','Zatwierdzone koszty naprawy'),('RECE','Przyjęty'),('REPR','W naprawie');
/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `receive_date` date DEFAULT NULL,
  `planned_start_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `problem_desc` varchar(1000) DEFAULT NULL,
  `repair_desc` varchar(1000) DEFAULT NULL,
  `status_code` varchar(20) DEFAULT NULL,
  `repair_price` decimal(10,2) DEFAULT NULL,
  `parts_price` decimal(10,2) DEFAULT NULL,
  `man_hour` decimal(10,2) DEFAULT NULL,
  `work_hours` double DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `status_code` (`status_code`),
  KEY `car_id` (`car_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`status_code`) REFERENCES `order_status` (`status_code`) ON DELETE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`) ON DELETE CASCADE,
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,2,'2019-05-22','2019-05-24','2019-05-24','opis awarii','opis naprawy','DONE',464.00,34.00,36.00,6.82,'2019-05-26'),(2,4,4,'2019-05-20','2019-05-20','2019-05-16','Aw  1','Napr 1','REPR',794.84,37.23,140.00,38,'2019-05-18'),(3,1,4,'2019-04-16','2019-04-20','2019-04-25','Aw 2','Napr 2','REPR',247.84,47.21,68.36,64.16000366210938,'2019-04-30'),(5,3,4,'2019-05-22','2019-05-15','2019-05-24','yti','cbn','RECE',256.23,56.78,24.13,5.68,'2019-05-28'),(6,3,5,'2019-04-30','2019-05-16','2019-05-22','rr','tt','PRAC',346.44,24.00,56.00,6,'2019-05-27'),(7,3,1,'2019-05-08','2019-05-15','2019-05-22','e','r','RECE',56.12,45.23,12.24,45.35,'2019-06-04'),(8,3,1,'2019-05-08','2019-05-15','2019-05-22','e','r','RECE',56.12,45.23,12.24,45.35,'2019-06-16');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-02 16:42:31
