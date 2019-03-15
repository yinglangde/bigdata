DROP DATABASE IF EXISTS `bigdata`;
CREATE DATABASE `bigdata`;
USE `bigdata`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id，自增',
  `USERNAME` varchar(50) NOT null ,
  `PASSWORD` varchar(50) NOT null ,
  `disabled` tinyint(1) NOT NULL default 0 COMMENT '0:生效启用，1:失效禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

INSERT INTO `user`(USERNAME,PASSWORD) VALUES ('admin', 'admin');
INSERT INTO `user`(USERNAME,PASSWORD) VALUES ('zhangbin', '123456');
