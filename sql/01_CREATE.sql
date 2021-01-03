
DROP DATABASE IF EXISTS project_hub_db;
CREATE DATABASE project_hub_db;

DROP TABLE IF EXISTS project_hub_db.`Boards`;
CREATE TABLE project_hub_db.`Boards` (
    `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `Name` varchar(100) NOT NULL,
    PRIMARY KEY (`Id`)
);

DROP TABLE IF EXISTS project_hub_db.`Cards`;
CREATE TABLE project_hub_db.`Cards` (
    `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `BoardId` int(10) unsigned NOT NULL,
    `Title` varchar(100) NOT NULL,
    `Description` varchar(100) DEFAULT NULL,
    `DueDate` DATETIME DEFAULT NULL,
    `CreatedDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`Id`)
);

DROP TABLE IF EXISTS project_hub_db.`Lists`;
CREATE TABLE project_hub_db.`Lists` (
    `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `SortOrder` int(10) unsigned NOT NULL,
    PRIMARY KEY (`Id`)
);

DROP TABLE IF EXISTS project_hub_db.`Menus`;
CREATE TABLE project_hub_db.`Menus` (
    `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `BackgroundColor` varchar(64) DEFAULT NULL,
    PRIMARY KEY (`Id`)
);

DROP TABLE IF EXISTS project_hub_db.`Users`;
CREATE TABLE project_hub_db.`Users` (
    `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `FirstName` varchar(64) NOT NULL,
    `LastName` varchar(64) NOT NULL,
    `Username` varchar(32) NOT NULL,
    PRIMARY KEY (`Id`)
);

DROP TABLE IF EXISTS project_hub_db.`UserBoards`;
CREATE TABLE project_hub_db.`UserBoards` (
    `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `UserId` int(10) unsigned NOT NULL,
    `BoardId` int(10) unsigned NOT NULL,
    PRIMARY KEY (`Id`)
);
