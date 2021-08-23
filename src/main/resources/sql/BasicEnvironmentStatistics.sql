CREATE DATABASE  IF NOT EXISTS `basicenvironmentstatistics`;
USE `basicenvironmentstatistics` ;
START TRANSACTION;
DROP TABLE IF EXISTS `Schemas`;
CREATE TABLE `Schemas` (
    `Id` char(32) COLLATE ascii_general_ci NOT NULL,
    `Name` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
    `Description` longtext CHARACTER SET utf8mb4 NOT NULL,
    CONSTRAINT `PK_Schema` PRIMARY KEY (`Id`)
) CHARACTER SET utf8mb4;
DROP TABLE IF EXISTS `SchemaFields`;
CREATE TABLE `SchemaFields` (
    `Index` int NOT NULL,
    `SchemaId` char(32) COLLATE ascii_general_ci NOT NULL,
    `Type` varchar(8) COLLATE ascii_general_ci NOT NULL,
    `Name` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
    `Description` longtext CHARACTER SET utf8mb4 NOT NULL,
    `Value` longtext CHARACTER SET utf8mb4 NOT NULL,
    CONSTRAINT `PK_SchemaFields` PRIMARY KEY (`SchemaId`, `Index`),
    CONSTRAINT `FK_SchemaFields_Schemas_SchemaId` 
    FOREIGN KEY (`SchemaId`) REFERENCES `Schemas` (`Id`) ON DELETE CASCADE
) CHARACTER SET utf8mb4;
DROP TABLE IF EXISTS `Data`;
CREATE TABLE `Data` (
    `Id` char(32) COLLATE ascii_general_ci NOT NULL,
    `SchemaId` char(32) COLLATE ascii_general_ci NOT NULL,
    `UpdateTime` datetime NOT NULL,
    `Value` longtext CHARACTER SET utf8mb4 NOT NULL,
    CONSTRAINT `PK_Data` PRIMARY KEY (`Id`),
    CONSTRAINT `FK_Data_Schemas_SchemaId` 
    FOREIGN KEY (`SchemaId`) REFERENCES `Schemas` (`Id`) ON DELETE CASCADE
) CHARACTER SET utf8mb4;
COMMIT;