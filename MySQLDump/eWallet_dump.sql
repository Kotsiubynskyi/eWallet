CREATE DATABASE  IF NOT EXISTS `bionic_university` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bionic_university`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: bionic_university
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` bigint(20) NOT NULL,
  `wallet_id` bigint(20) NOT NULL,
  `account_type_id` varchar(10) NOT NULL DEFAULT 'silver',
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  UNIQUE KEY `wallet_id_UNIQUE` (`wallet_id`),
  KEY `fk_account_wallet1_idx` (`wallet_id`),
  KEY `fk_account_account_type1_idx` (`account_type_id`),
  CONSTRAINT `fk_account_account_type1` FOREIGN KEY (`account_type_id`) REFERENCES `account_type` (`account_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_user_information` FOREIGN KEY (`account_id`) REFERENCES `user_information` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_account_wallet1` FOREIGN KEY (`wallet_id`) REFERENCES `wallet` (`wallet_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (113170581245263823,2480557991234081121,'silver','root','root'),(3840965532565889670,6106651521412685222,'silver','login','password');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_type`
--

DROP TABLE IF EXISTS `account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_type` (
  `account_type_id` varchar(10) NOT NULL,
  `acc_type_desc` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`account_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_type`
--

LOCK TABLES `account_type` WRITE;
/*!40000 ALTER TABLE `account_type` DISABLE KEYS */;
INSERT INTO `account_type` VALUES ('bronze','normal'),('gold','great'),('silver','almost great');
/*!40000 ALTER TABLE `account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exchange_rates`
--

DROP TABLE IF EXISTS `exchange_rates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exchange_rates` (
  `currency` varchar(3) NOT NULL,
  `ASK` double NOT NULL,
  `BID` double NOT NULL,
  PRIMARY KEY (`currency`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exchange_rates`
--

LOCK TABLES `exchange_rates` WRITE;
/*!40000 ALTER TABLE `exchange_rates` DISABLE KEYS */;
/*!40000 ALTER TABLE `exchange_rates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_history`
--

DROP TABLE IF EXISTS `transaction_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_history` (
  `account_id` bigint(20) NOT NULL,
  `transaction_id` bigint(20) NOT NULL,
  `oher_account_id` bigint(20) NOT NULL,
  `trans_amount` double NOT NULL,
  `trans_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `transaction_type_id` varchar(45) NOT NULL,
  `currency` varchar(3) NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `fk_transaction_history_exchange_rates1_idx` (`currency`),
  KEY `fk_transaction_history_transaction_type1_idx` (`transaction_type_id`),
  KEY `fk_transaction_history_account1_idx` (`account_id`),
  CONSTRAINT `fk_transaction_history_account1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_history_exchange_rates1` FOREIGN KEY (`currency`) REFERENCES `exchange_rates` (`currency`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_history_transaction_type1` FOREIGN KEY (`transaction_type_id`) REFERENCES `transaction_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_history`
--

LOCK TABLES `transaction_history` WRITE;
/*!40000 ALTER TABLE `transaction_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_type`
--

DROP TABLE IF EXISTS `transaction_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaction_type` (
  `id` varchar(60) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_type`
--

LOCK TABLES `transaction_type` WRITE;
/*!40000 ALTER TABLE `transaction_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaction_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_information`
--

DROP TABLE IF EXISTS `user_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_information` (
  `account_id` bigint(20) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `id_UNIQUE` (`account_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_information`
--

LOCK TABLES `user_information` WRITE;
/*!40000 ALTER TABLE `user_information` DISABLE KEYS */;
INSERT INTO `user_information` VALUES (113170581245263823,'Євгеній','Коцюбинський','turboopera@mail.ru'),(3840965532565889670,'Євгеній','Коцюбинський','turboopera@gmail.com');
/*!40000 ALTER TABLE `user_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wallet` (
  `wallet_id` bigint(20) NOT NULL,
  `balance` double NOT NULL,
  `currency` varchar(3) NOT NULL DEFAULT 'USD',
  PRIMARY KEY (`wallet_id`),
  UNIQUE KEY `id_UNIQUE` (`wallet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (2480557991234081121,0,'EUR'),(6106651521412685222,0,'EUR');
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-27 14:44:25
