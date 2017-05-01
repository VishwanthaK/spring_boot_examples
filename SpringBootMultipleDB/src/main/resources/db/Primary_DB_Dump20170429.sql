CREATE DATABASE  IF NOT EXISTS `db_primary`;
USE `db_primary`;
DROP TABLE IF EXISTS `primary_table1`;
CREATE TABLE `primary_table1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_status` int(2) NOT NULL,
  `update_on` datetime NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;