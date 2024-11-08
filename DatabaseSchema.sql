-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: javaproject
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `staff_id` int DEFAULT NULL,
  PRIMARY KEY (`Username`),
  KEY `constraint_name` (`staff_id`),
  CONSTRAINT `constraint_name` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`Staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('managerUser','managerPass',NULL),('waiterUser','waiterPass',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `ItemID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Description` text,
  `Price` float NOT NULL,
  `Availability` tinyint(1) NOT NULL,
  `Size` char(1) DEFAULT NULL,
  `IsAlcoholic` tinyint(1) DEFAULT '0',
  `IsSpicy` tinyint(1) DEFAULT '0',
  `ItemType` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ItemID`),
  CONSTRAINT `item_chk_1` CHECK ((`ItemType` in (_utf8mb4'Food',_utf8mb4'Drink')))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Coca','Refreshing beverage',1.99,1,'S',0,0,'Drink'),(2,'Burger','Burger with meat',9.99,1,'M',0,1,'Food'),(3,'Mild Pizza','Cheese pizza with mild sauce',10.99,1,'L',0,0,'Food'),(4,'Beer','Alcoholic drink',3.99,1,'M',1,0,'Drink');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `CustomerName` varchar(100) NOT NULL,
  `PhoneNumber` varchar(15) DEFAULT NULL,
  `OrderDate` date NOT NULL,
  `OrderStatus` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (206,'John Doe','1234567890','2024-10-30',0),(207,'Jane Smith','9876543210','2024-10-31',1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS `orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderitems` (
  `OrderID` int NOT NULL,
  `ItemID` int NOT NULL,
  `Quantity` int NOT NULL,
  PRIMARY KEY (`OrderID`,`ItemID`),
  KEY `ItemID` (`ItemID`),
  CONSTRAINT `orderitems_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `order` (`OrderID`),
  CONSTRAINT `orderitems_ibfk_2` FOREIGN KEY (`ItemID`) REFERENCES `item` (`ItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems`
--

LOCK TABLES `orderitems` WRITE;
/*!40000 ALTER TABLE `orderitems` DISABLE KEYS */;
INSERT INTO `orderitems` VALUES (206,1,2),(206,2,1),(207,3,2),(207,4,1);
/*!40000 ALTER TABLE `orderitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `Staff_id` int NOT NULL AUTO_INCREMENT,
  `Account_Username` varchar(50) DEFAULT NULL,
  `Name` varchar(100) NOT NULL,
  `DoB` date DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Role` varchar(50) DEFAULT NULL,
  `Manager_id` int DEFAULT NULL,
  PRIMARY KEY (`Staff_id`),
  KEY `Account_Username` (`Account_Username`),
  KEY `Manager_id` (`Manager_id`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`Account_Username`) REFERENCES `account` (`Username`),
  CONSTRAINT `staff_ibfk_2` FOREIGN KEY (`Manager_id`) REFERENCES `staff` (`Staff_id`),
  CONSTRAINT `staff_chk_1` CHECK ((`Role` in (_utf8mb4'Manager',_utf8mb4'Waiter')))
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'waiterUser','Alice Johnson','1995-03-15','123-456-7890','alice@example.com','Waiter',NULL),(2,'managerUser','Bob Brown','1980-07-20','098-765-4321','bob@example.com','Manager',NULL);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waiterorders`
--

DROP TABLE IF EXISTS `waiterorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waiterorders` (
  `WaiterID` int NOT NULL,
  `OrderID` int NOT NULL,
  PRIMARY KEY (`WaiterID`,`OrderID`),
  KEY `OrderID` (`OrderID`),
  CONSTRAINT `waiterorders_ibfk_1` FOREIGN KEY (`WaiterID`) REFERENCES `staff` (`Staff_id`),
  CONSTRAINT `waiterorders_ibfk_2` FOREIGN KEY (`OrderID`) REFERENCES `order` (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waiterorders`
--

LOCK TABLES `waiterorders` WRITE;
/*!40000 ALTER TABLE `waiterorders` DISABLE KEYS */;
/*!40000 ALTER TABLE `waiterorders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-06 17:12:06
