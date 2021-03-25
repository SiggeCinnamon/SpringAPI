DROP DATABASE IF EXISTS `person_database`;

CREATE SCHEMA `person_database` DEFAULT CHARACTER SET utf8 COLLATE utf8_swedish_ci ;

USE `person_database`;

DROP TABLE IF EXISTS `persons`;

CREATE TABLE `persons` (
  `person_id` int(9) unsigned NOT NULL AUTO_INCREMENT,
  `person_name` varchar(100) NOT NULL,
  `person_age` int(9) unsigned NOT NULL,
  `person_country` varchar(100) NOT NULL,
  `person_favourite_colour` varchar(255) NOT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;


