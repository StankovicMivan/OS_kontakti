-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: skolajezika
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `kurs`
--

DROP TABLE IF EXISTS `kurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(20) NOT NULL,
  `tip` varchar(20) NOT NULL,
  `cena` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kurs`
--

LOCK TABLES `kurs` WRITE;
/*!40000 ALTER TABLE `kurs` DISABLE KEYS */;
INSERT INTO `kurs` VALUES (1,'Engleski','osnovni',15000.00),(2,'Engleski','srednji',25000.00),(3,'Engleski','visi',38000.00),(4,'paprikas','osnovni',13000.00),(5,'Persun','ultra',666.00);
/*!40000 ALTER TABLE `kurs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nastavnik`
--

DROP TABLE IF EXISTS `nastavnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nastavnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nastavnik`
--

LOCK TABLES `nastavnik` WRITE;
/*!40000 ALTER TABLE `nastavnik` DISABLE KEYS */;
INSERT INTO `nastavnik` VALUES (1,'Ivan','Stankovic'),(2,'Vladimir','Jankovic'),(3,'Marijana','Pejanovic'),(4,'Vanja','Denda'),(5,'Milutin','Milankovic'),(9,'Helena','Hip'),(10,'Helena','Hip');
/*!40000 ALTER TABLE `nastavnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pohadja`
--

DROP TABLE IF EXISTS `pohadja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pohadja` (
  `ucenik_id` int(11) NOT NULL,
  `kurs_id` int(11) NOT NULL,
  PRIMARY KEY (`ucenik_id`,`kurs_id`),
  KEY `kurs_id` (`kurs_id`),
  CONSTRAINT `pohadja_ibfk_1` FOREIGN KEY (`ucenik_id`) REFERENCES `ucenik` (`id`),
  CONSTRAINT `pohadja_ibfk_2` FOREIGN KEY (`kurs_id`) REFERENCES `kurs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pohadja`
--

LOCK TABLES `pohadja` WRITE;
/*!40000 ALTER TABLE `pohadja` DISABLE KEYS */;
INSERT INTO `pohadja` VALUES (1,1),(13,1),(1,2),(3,2),(13,2),(1,3),(2,3),(1,5),(2,5),(3,5),(4,5),(5,5),(13,5);
/*!40000 ALTER TABLE `pohadja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predaje`
--

DROP TABLE IF EXISTS `predaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `predaje` (
  `nastavnik_id` int(11) NOT NULL,
  `kurs_id` int(11) NOT NULL,
  PRIMARY KEY (`nastavnik_id`,`kurs_id`),
  KEY `kurs_id` (`kurs_id`),
  CONSTRAINT `predaje_ibfk_1` FOREIGN KEY (`nastavnik_id`) REFERENCES `nastavnik` (`id`),
  CONSTRAINT `predaje_ibfk_2` FOREIGN KEY (`kurs_id`) REFERENCES `kurs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predaje`
--

LOCK TABLES `predaje` WRITE;
/*!40000 ALTER TABLE `predaje` DISABLE KEYS */;
INSERT INTO `predaje` VALUES (1,1),(3,1),(10,1),(1,2),(2,2),(10,2),(1,3),(4,3),(10,3),(1,5);
/*!40000 ALTER TABLE `predaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skola`
--

DROP TABLE IF EXISTS `skola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skola` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(20) NOT NULL,
  `adresa` varchar(20) NOT NULL,
  `telefon` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `web` varchar(20) NOT NULL,
  `pib` int(9) NOT NULL,
  `maticniBr` int(9) NOT NULL,
  `ziroRacun` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skola`
--

LOCK TABLES `skola` WRITE;
/*!40000 ALTER TABLE `skola` DISABLE KEYS */;
INSERT INTO `skola` VALUES (1,'Engleski Jezici','Tamo daleko','0652645463','blabla@gmail.com','www.skolajezika.com',123123123,321321321,'0000000666');
/*!40000 ALTER TABLE `skola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ucenik`
--

DROP TABLE IF EXISTS `ucenik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ucenik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ucenik`
--

LOCK TABLES `ucenik` WRITE;
/*!40000 ALTER TABLE `ucenik` DISABLE KEYS */;
INSERT INTO `ucenik` VALUES (1,'Pera','Peric'),(2,'Mika','Mikic'),(3,'Nikola','Nikolic'),(4,'Fika','Fikic'),(5,'Zoraz','Zoric'),(13,'gh','gh');
/*!40000 ALTER TABLE `ucenik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uplate`
--

DROP TABLE IF EXISTS `uplate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uplate` (
  `ucenik_id` int(11) NOT NULL,
  `kurs_id` int(11) NOT NULL,
  KEY `uplate_ibfk_1_idx` (`ucenik_id`),
  KEY `uplate_ibfk_2_idx` (`kurs_id`),
  CONSTRAINT `uplate_ibfk_1` FOREIGN KEY (`ucenik_id`) REFERENCES `pohadja` (`ucenik_id`),
  CONSTRAINT `uplate_ibfk_2` FOREIGN KEY (`kurs_id`) REFERENCES `pohadja` (`kurs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uplate`
--

LOCK TABLES `uplate` WRITE;
/*!40000 ALTER TABLE `uplate` DISABLE KEYS */;
INSERT INTO `uplate` VALUES (1,1),(1,2),(2,2),(3,3),(4,3),(1,3),(1,5);
/*!40000 ALTER TABLE `uplate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-09 17:21:11
