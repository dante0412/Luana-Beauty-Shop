CREATE DATABASE  IF NOT EXISTS `bd_luana_beauty_shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_luana_beauty_shop`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_luana_beauty_shop
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `tb_categorias`
--

DROP TABLE IF EXISTS `tb_categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categorias` (
  `id_cat` int NOT NULL AUTO_INCREMENT,
  `desc_cat` varchar(255) DEFAULT NULL,
  `id_est` int DEFAULT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categorias`
--

LOCK TABLES `tb_categorias` WRITE;
/*!40000 ALTER TABLE `tb_categorias` DISABLE KEYS */;
INSERT INTO `tb_categorias` VALUES (1,'Perfumes',1),(2,'Cremas',1),(3,'Shampoo',1),(4,'Acondicionador',1),(5,'Niños',1),(6,'Desodorantes',1),(7,'Tratamientos',1),(8,'Accesorios',1),(9,'Colonias',1),(10,'Fuego',2);
/*!40000 ALTER TABLE `tb_categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estado`
--

DROP TABLE IF EXISTS `tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estado` (
  `id_est` int NOT NULL,
  `desc_est` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_est`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado`
--

LOCK TABLES `tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_estado` DISABLE KEYS */;
INSERT INTO `tb_estado` VALUES (1,'activo'),(2,'inactivo');
/*!40000 ALTER TABLE `tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_productos`
--

DROP TABLE IF EXISTS `tb_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_productos` (
  `id_prod` int NOT NULL AUTO_INCREMENT,
  `desc_prod` varchar(255) DEFAULT NULL,
  `stock_prod` int DEFAULT NULL,
  `preciocosto_prod` double NOT NULL,
  `precioventa_prod` double NOT NULL,
  `id_cat` int DEFAULT NULL,
  `id_prov` int DEFAULT NULL,
  `id_est` int DEFAULT NULL,
  PRIMARY KEY (`id_prod`),
  KEY `PKEstado_idx` (`id_est`),
  KEY `PKProveedor_idx` (`id_prov`),
  KEY `PKCategoria_idx` (`id_cat`),
  CONSTRAINT `PKCategoria` FOREIGN KEY (`id_cat`) REFERENCES `tb_categorias` (`id_cat`),
  CONSTRAINT `PKEstadoPro` FOREIGN KEY (`id_est`) REFERENCES `tb_estado` (`id_est`),
  CONSTRAINT `PKProveedor` FOREIGN KEY (`id_prov`) REFERENCES `tb_proveedor` (`id_prov`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_productos`
--

LOCK TABLES `tb_productos` WRITE;
/*!40000 ALTER TABLE `tb_productos` DISABLE KEYS */;
INSERT INTO `tb_productos` VALUES (1,'Kromo Fire 90ml',5,47,50,2,1,1),(2,'Fiesta 50ml',4,51.53,55,1,1,1),(3,'XISS 110ml',6,35.58,38,6,1,1),(16,'Shampoo Murumuru Homem 300ml',5,16.55,18,3,3,1),(17,'Vanilla for Men 75ml',4,27.89,30,9,2,1),(18,'Bio Resist 100gr',4,18.5,20,7,6,1),(19,'Skin First matificante 100gr',3,15.16,17,7,5,1),(20,'Espuma copaiba Homem 200ml',5,22.1,25,2,3,1),(21,'Temptation Black 100ml',4,56.55,60,1,1,1),(22,'UNO 90ml',6,53.2,55,1,2,1),(23,'Musk 100ml',7,45.25,48,1,1,1);
/*!40000 ALTER TABLE `tb_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proveedor` (
  `id_prov` int NOT NULL AUTO_INCREMENT,
  `desc_prov` varchar(255) DEFAULT NULL,
  `correo_prov` varchar(255) DEFAULT NULL,
  `telefono_prov` varchar(255) DEFAULT NULL,
  `id_est` int DEFAULT NULL,
  PRIMARY KEY (`id_prov`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` VALUES (1,'Yanbal','yambal@gmail.com','963852741',1),(2,'Esika','esika@gmail.com','963258714',1),(3,'Natura','natura@gmail.com','951753258',1),(4,'Avon','avon@gmail.com','987521025',1),(5,'Cyzone','cyzone@gmail.com','932012458',1),(6,'Lbel','lbel@gmail.com','903217852',1),(7,'Oryflame','oryflame@gmail.com','951420150',2),(13,'Dupree','dupre@gmail.com','951420150',2);
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipousuario`
--

DROP TABLE IF EXISTS `tb_tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipousuario` (
  `id_tipousu` int NOT NULL,
  `desc_tipousu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tipousu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipousuario`
--

LOCK TABLES `tb_tipousuario` WRITE;
/*!40000 ALTER TABLE `tb_tipousuario` DISABLE KEYS */;
INSERT INTO `tb_tipousuario` VALUES (1,'admin'),(2,'Jefe'),(3,'empleado');
/*!40000 ALTER TABLE `tb_tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id_usu` int NOT NULL AUTO_INCREMENT,
  `nom_usu` varchar(255) DEFAULT NULL,
  `ape_usu` varchar(255) DEFAULT NULL,
  `email_usu` varchar(255) DEFAULT NULL,
  `telefono_usu` varchar(255) DEFAULT NULL,
  `pass_usu` varchar(255) DEFAULT NULL,
  `id_tipousu` int DEFAULT NULL,
  `id_est` int DEFAULT NULL,
  PRIMARY KEY (`id_usu`),
  KEY `pkTipo_idx` (`id_tipousu`),
  KEY `pkEstado_idx` (`id_est`),
  CONSTRAINT `pkEstado` FOREIGN KEY (`id_est`) REFERENCES `tb_estado` (`id_est`),
  CONSTRAINT `pkTipo` FOREIGN KEY (`id_tipousu`) REFERENCES `tb_tipousuario` (`id_tipousu`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'Luis','Calderon Tocto','luisgonzalo152@gmail.com','959370449','admin123',1,1),(2,'Eliana','Vasquez Yarasca','evy_s@gmail.com','985214521','12345',3,1),(3,'Dante','Calderon Vasquez','dante@gmail.com','952014254','98765',3,1),(4,'Felix','Torres Terreros','fel@gmail.com','954120125','123456',3,1);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_luana_beauty_shop'
--

--
-- Dumping routines for database 'bd_luana_beauty_shop'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-21 12:54:13
