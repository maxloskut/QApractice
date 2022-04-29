CREATE SCHEMA 'loskutov3at-21' ;

CREATE TABLE 'loskutov3at-21'.'adrress' (
  'adrress' INT NOT NULL,
  'country' VARCHAR(45) NULL,
  'city' VARCHAR(45) NULL,
  PRIMARY KEY ('adrress'));

CREATE TABLE 'loskutov3at-21'.'student' (
  'idStudent' INT NOT NULL,
  'name' VARCHAR(45) NULL,
  'bd' DATE NULL,
  'course' INT NULL,
  PRIMARY KEY ('idStudent'));

CREATE TABLE `loskutov3at-21`.`address_student` (
  `id_address_student` INT NOT NULL,
  `id_address` VARCHAR(45) NULL,
  `id_student` VARCHAR(45) NULL,
  PRIMARY KEY (`id_address_student`));
