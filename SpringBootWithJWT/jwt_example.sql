CREATE DATABASE  IF NOT EXISTS `db_name`;
USE `db_name`;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_status` int(2) NOT NULL,
  `update_on` datetime NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `role` VALUES (1,1,'2016-01-01 00:00:00','ROLE_USER'),(2,1,'2016-01-01 00:00:00','ROLE_ADMIN');


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `phone_number` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `registered_on` datetime NOT NULL,
  `enabled` bit(1) NOT NULL,
  `record_status` int(2) NOT NULL,
  `update_on` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES (1,'admin','admin','admin@admin.com','admin','1234567890','$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi','2016-01-01 00:00:00',true,1,'2016-01-01 00:00:00');

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_status` int(2) DEFAULT NULL,
  `update_on` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_role_id` (`role_id`),
  KEY `fk_user_role_user_id` (`user_id`),
  CONSTRAINT `fk_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO `user_role` VALUES (1,NULL,NULL,1,1);
