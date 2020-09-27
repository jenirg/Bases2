-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: conexion2
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` varchar(10) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Nit` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Saldo` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('CLI-1','Mariano','1234k','Colonia SJ',0),('CLI-10','Mariana','45345K','Colonia Vista Hermosa',0),('CLI-2','Mariano','1234k','Colonia SJ',0),('CLI-3','Carlos','1234L','SJ',0),('CLI-4','Ana','67879k','Vista Hermosa',0),('CLI-5','Lucia','9874l','Vista Bella',0),('CLI-6','Carlos','7411k','Xela',0),('CLI-7','Jenifer','0099a','Coatepeque',0),('CLI-8','Maria','8909K','Colonia Molina',0),('CLI-9','Mariana','45345K','Colonia Vista Hermosa',0);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `CambiarID` BEFORE INSERT ON `cliente` FOR EACH ROW BEGIN  
declare the_id varchar(10);
declare id_aux int;
declare ID Integer default 0;
 SELECT count(id) into ID FROM cliente;
if ID=0 THEN
set ID=ID;
SELECT concat('CLI-',ID) into the_id;
SET NEW.Saldo=0;
SET NEW.id=the_id;
ELSE
set ID=ID+1;
SELECT concat('CLI-',ID) into the_id;
SET NEW.Saldo=0;
SET NEW.id=the_id;
END IF;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `detallefactura`
--

DROP TABLE IF EXISTS `detallefactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallefactura` (
  `id` int NOT NULL,
  `Cantidad` float DEFAULT NULL,
  `Subtotal` float DEFAULT NULL,
  `Factura_id` int NOT NULL,
  `Producto_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_DetalleFactura_Factura1_idx` (`Factura_id`),
  KEY `fk_DetalleFactura_Producto1_idx` (`Producto_id`),
  CONSTRAINT `fk_DetalleFactura_Factura1` FOREIGN KEY (`Factura_id`) REFERENCES `factura` (`id`),
  CONSTRAINT `fk_DetalleFactura_Producto1` FOREIGN KEY (`Producto_id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallefactura`
--

LOCK TABLES `detallefactura` WRITE;
/*!40000 ALTER TABLE `detallefactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallefactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallepago`
--

DROP TABLE IF EXISTS `detallepago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallepago` (
  `id` int NOT NULL,
  `Monto` float DEFAULT NULL,
  `Factura_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_DetallePago_Factura1_idx` (`Factura_id`),
  CONSTRAINT `fk_DetallePago_Factura1` FOREIGN KEY (`Factura_id`) REFERENCES `factura` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallepago`
--

LOCK TABLES `detallepago` WRITE;
/*!40000 ALTER TABLE `detallepago` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallepago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `id` int NOT NULL,
  `Fecha` date DEFAULT NULL,
  `Total` float DEFAULT NULL,
  `Credito` tinyint DEFAULT NULL,
  `Impresa` tinyint DEFAULT NULL,
  `Saldo` float DEFAULT NULL,
  `anulada` float DEFAULT NULL,
  `Cliente_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Factura_Cliente1_idx` (`Cliente_id`),
  CONSTRAINT `fk_Factura_Cliente1` FOREIGN KEY (`Cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagoscreditos`
--

DROP TABLE IF EXISTS `pagoscreditos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagoscreditos` (
  `id` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `total` float DEFAULT NULL,
  `Cliente_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_PagosCreditos_Cliente1_idx` (`Cliente_id`),
  CONSTRAINT `fk_PagosCreditos_Cliente1` FOREIGN KEY (`Cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagoscreditos`
--

LOCK TABLES `pagoscreditos` WRITE;
/*!40000 ALTER TABLE `pagoscreditos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagoscreditos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Existencias` int DEFAULT NULL,
  `Precio` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Mariana',88,46),(2,'Camarones',50,2),(3,'Manzana',5,5),(4,'Melon',3,15),(5,'Manzana',5,5),(6,'Camarones',50,2),(7,'Camarones',50,2),(8,'Manzanas',50,4);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-25  0:57:31
