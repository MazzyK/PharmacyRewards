-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 20, 2022 at 08:02 PM
-- Server version: 8.0.27
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmareward`
--
CREATE DATABASE IF NOT EXISTS `pharmareward` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `pharmareward`;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `CustomerID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(20) DEFAULT NULL,
  `FirstName` varchar(20) DEFAULT NULL,
  `Surname` varchar(20) DEFAULT NULL,
  `Email` varchar(50) NOT NULL,
  `Mobile` varchar(10) NOT NULL,
  `Points` int NOT NULL DEFAULT '0',
  `Credit` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `Title`, `FirstName`, `Surname`, `Email`, `Mobile`, `Points`, `Credit`) VALUES
(178, 'Captain', 'James', 'Kirk', 'kirk@ufp.org', '2112111111', 0, 0),
(180, 'Captain', 'Jean-Luc', 'Picard', 'earlgrey@hot.com', '2222222222', 0, 0),
(181, 'Commander', 'S\'chn T\'gai', 'Spock', 'logical@ufp.org', '2332333333', 0, 0),
(182, 'Mr', 'Harry', 'Mudd', 'jammydodger@tribblemaster.com', '2442444444', 0, 0),
(183, 'Dr', 'Leonard', 'McCoy', 'imadoctor@bones.com', '2552555555', 0, 0),
(184, 'Commander', 'Deanna', 'Troi', 'iknow@betazoid.org', '2662666666', 45, 0),
(185, 'Captain', 'Christopher', 'Pike', 'quiff@ufp.org', '2882888888', 0, 0),
(186, 'Ms', 'Lwaxana', 'Troi', 'galacticcougar@betazoid.com', '2772777777', 0, 0),
(187, 'Commander', 'Will', 'Riker', 'love2loveu@ufp.org', '2992999999', 20, 0);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `instanceID` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `SKU` varchar(20) NOT NULL,
  PRIMARY KEY (`instanceID`),
  KEY `SKU` (`SKU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `SKU` varchar(20) NOT NULL,
  `Pname` varchar(100) NOT NULL,
  `Price` float NOT NULL,
  `Company` varchar(100) NOT NULL,
  PRIMARY KEY (`SKU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`SKU`, `Pname`, `Price`, `Company`) VALUES
('1160', 'EAU THERMAL 150ml', 7.8, 'VICHY'),
('1161', 'PURETE THERMAL CLEANING GEL 200ml', 12.5, 'VICHY'),
('1162', 'PURETE THERMAL CLEANING GEL 400ml', 19, 'VICHY'),
('1163', 'PURETE THERMAL 3 IN 1 200ml', 13.4, 'VICHY'),
('1164', 'PURETE THERMAL 3 IN 1 300ml', 16.7, 'VICHY'),
('1165', 'AQUALIA THERMAL MINI POUCH - PROMO KIT ', 14, 'VICHY'),
('1166', 'AQUALIA LEGERE/RICHE TUBE 40ml', 15.4, 'VICHY'),
('1167', 'AQUALIA THERMALEYE WATERBALM 15ml', 20, 'VICHY'),
('1168', 'AQUALIA THERMAL SERUM 30ml', 22.1, 'VICHY'),
('1169', 'NORMADERM BB 40ml', 19.1, 'VICHY'),
('1170', 'NORMADERM NIGHT DETOX 40ml', 18.2, 'VICHY'),
('1171', 'NORMADERM GEL NETTOYANT 200ml', 11.8, 'VICHY'),
('1172', 'NORMADERM HYALUSPOT 15ml', 12.1, 'VICHY'),
('1177', 'LIFTACTIV SUPREME SERUM 10 ANIMATION ', 42.3, 'VICHY'),
('1178', 'LIFTACTIV SUPREME DAY CREAM PROMO ', 32.5, 'VICHY'),
('1179', 'LIFTACTIV ADVANCED FILLER FACIAL CREME 30ml', 37.2, 'VICHY'),
('1180', 'LIFTACTIV SERUM 10 EYES&LASHES 15ml', 24.6, 'VICHY'),
('1181', 'NEOVADIOLNUIT NIGHT CREME 50ml', 36.2, 'VICHY'),
('1182', 'NEOVADIOL PNM FOR DRY SKIN 50ml', 34.4, 'VICHY'),
('1183', 'NEOVADIOL SERUM 30ml', 38.2, 'VICHY'),
('1184', 'NUTRILOGIE I -CREME FOR DRY SKIN 50ml', 20.6, 'VICHY'),
('1185', 'NUTRILOGIE 2 - CREME FOR VERY DRY SKIN 50ml', 20.6, 'VICHY'),
('1186', 'IDEAL BODY SORBET 200ml', 16.5, 'VICHY'),
('1187', 'IDEAL BODY SERUM/EMULSION 200ml', 14.8, 'VICHY'),
('1188', 'IDEAL BODY BAUME 200ml', 22.6, 'VICHY'),
('1189', 'IDEAL BODY DRY OIL 100ml', 26.9, 'VICHY'),
('1190', 'VICHY HOMME HYDRA MAG C + 50ml', 19.5, 'VICHY'),
('20840P', 'DERM\'INTIM pH 5,5 200ml', 9.6, 'A-DERMA'),
('20843P', 'DERM\'INTIM pH 8 200ml', 10.3, 'A-DERMA'),
('20847P', 'PROMO DERM\'INTIM pH 8 200ml -20%', 8.24, 'A-DERMA'),
('20848P', 'PROMO DERM\'INTIM pH 5,5 200ml -20%', 7.68, 'A-DERMA'),
('21116P', 'SENSINOL SHAMPOO 200ml', 11.9, 'DUCRAY'),
('21117P', 'ELUTION SHAMPOO 200 ml', 7.3, 'DUCRAY'),
('21125P', 'SQUANORM SHAMPOO DRY DANDCRUFF 200ml', 12.7, 'DUCRAY'),
('21135P', 'SQUANORM SHAMPOO GREASY DANDCRUFF 200ml', 12.7, 'DUCRAY'),
('21145P', 'KELUAL DS SHAMPOO 100 ml', 13.2, 'DUCRAY'),
('21155P', 'KERPTYOL P.S.O SHAMPOO 200ml', 14.2, 'DUCRAY'),
('21163P', 'SQUANORM ZINC LOTION 200ml', 14.4, 'DUCRAY'),
('21170P', 'SABAL SHAMPOO 200ml', 12.7, 'DUCRAY'),
('21180P', 'ARGEAL SHAMPOO 150ml', 11.3, 'DUCRAY'),
('21290P', 'ITAX ANTI-POUX 75ml', 17.2, 'DUCRAY'),
('21327P', 'PROMO ICTYANE LAIT CORPOREL 500ml -20%', 16.48, 'A-DERMA'),
('21511P', 'ANACAPS tri-ACTIV 30 caps', 29.2, 'DUCRAY'),
('21701P', 'ICTYANE GEL MOUSSANT SURGRAS 200ml', 8.5, 'A-DERMA'),
('21705P', 'ICTYANE GEL MOUSSANT SURGRAS NEW 400ml', 15.2, 'A-DERMA'),
('21706P', 'PROMO ICTYANE GEL MOUSSANT SURGRAS NEW 400ml', 9.9, 'A-DERMA'),
('21710P', 'ICTYANE LAIT CORPOREL 500ml', 20.6, 'A-DERMA'),
('21810P', 'SENSINOL LAIT APAISANT 400ml', 20.9, 'DUCRAY'),
('21820P', 'SENSINOL HUILE LAVANTE 200ml', 12.7, 'DUCRAY'),
('21850P', 'ANAPHASE SHAMPOO 200ml', 12.3, 'DUCRAY'),
('21875P', 'CREASTIM LOTION 2*30ml ', 44.4, 'DUCRAY'),
('21880P', 'NEOPTIDE LOTION WOMEN  3*30ml', 49.9, 'DUCRAY'),
('21905P', 'NEOPTIDE LOTION MEN 100ml', 49.9, 'DUCRAY'),
('21910P', 'EXTRA - DOUX SHAMPOO 200ml', 15.5, 'DUCRAY'),
('22530P', 'PAIN DERMATOLOGIQUE 100g', 5.7, 'A-DERMA'),
('22712P', 'EXOMEGA HUILE NETTOYANT 200 ml', 11.6, 'A-DERMA'),
('22716P', 'PROMO EXOMEGA HUILE NETTOYANT 500 ml', 18, 'A-DERMA'),
('22735P', 'EXOMEGALAIT EMOLLIENT 400 ml', 18.6, 'A-DERMA'),
('22745P', 'EXOMEGA BAUME DEFI 200 ml', 20.2, 'A-DERMA'),
('22750P', 'EXOMEGA SHAMPOO MOUSSE 125 ml', 14.7, 'A-DERMA'),
('22761P', 'EXOMEGA GEL MOUSSANT 500 ml', 18, 'A-DERMA'),
('22790P', 'EXOMEGA GEL 2 IN 1 HAIR & BODY 200  mL', 11, 'A-DERMA'),
('22820P', 'CYTELIUM LOTION 100ml', 8.9, 'A-DERMA'),
('22851P', 'DERMALIBOUR+ STICK 8g', 10.2, 'A-DERMA'),
('80000P', 'DEXERYL CREAM DM 250 g', 5.2, 'PFD'),
('80003P', 'PROMO DEXERYL CREAM DM 500g', 10, 'PFD'),
('80010P', 'ONYSTER PATE UREE DM 10g', 42.5, 'PFD'),
('80015P', 'ONYPSO VERNIS DM 3ml', 18.8, 'PFD');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE IF NOT EXISTS `purchase` (
  `OrderID` int NOT NULL AUTO_INCREMENT,
  `CustomerID` int NOT NULL,
  `instanceID` int NOT NULL,
  PRIMARY KEY (`OrderID`),
  KEY `CustomerID` (`CustomerID`),
  KEY `instanceID` (`instanceID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`SKU`) REFERENCES `product` (`SKU`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`instanceID`) REFERENCES `item` (`instanceID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
