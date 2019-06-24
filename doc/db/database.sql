CREATE DATABASE IF NOT EXISTS `api-wiki` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `api-wiki`;
/*
  Database structure for user
*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `type` tinyint(4) DEFAULT '1' COMMENT '用户类型：0-系统管理员，1-普通用户',
  `salt` char(11) NOT NULL COMMENT '随机加盐',
  `uuid` char(36) NOT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_email` (`email`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
/*
  Database structure for project
*/
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '项目编号',
  `name` varchar(255) NOT NULL COMMENT '项目名称',
  `description` varchar(255) DEFAULT '空描述' COMMENT '项目描述',
  `uuid` char(36) NOT NULL COMMENT '生成项目访问地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
/*
  Database structure for user_project
*/
DROP TABLE IF EXISTS `user_project`;
CREATE TABLE `user_project` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) unsigned NOT NULL COMMENT '用户编号',
  `project_id` int(11) unsigned NOT NULL COMMENT '项目编号',
  PRIMARY KEY (`id`),
  KEY `fk_user` (`user_id`),
  KEY `fk_project` (`project_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
/*
  Database structure for article
*/
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `user_id` int(11) unsigned NOT NULL COMMENT '用户编号',
  `project_id` int(11) unsigned NOT NULL COMMENT '项目编号',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` text COMMENT '正文',
  `uuid` char(36) NOT NULL COMMENT '生成文章访问地址',
  PRIMARY KEY (`id`),
  KEY `fk_article_user` (`user_id`),
  KEY `fk_article_project` (`project_id`),
  CONSTRAINT `fk_article_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_article_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
/*
  Database structure for module
*/
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `project_id` int(11) unsigned NOT NULL COMMENT '项目编号',
  `name` varchar(255) NOT NULL COMMENT '模块名称',
  `description` varchar(255) DEFAULT '空描述' COMMENT '模块描述',
  `uuid` char(36) NOT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`),
  KEY `fk_module_project` (`project_id`),
  CONSTRAINT `fk_module_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
/*
  Database structure for interfaces
*/
DROP TABLE IF EXISTS `interfaces`;
CREATE TABLE `interfaces` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '接口编号',
  `module_id` int(11) unsigned NOT NULL COMMENT '模块编号',
  `name` varchar(255) NOT NULL COMMENT '接口名称',
  `description` varchar(255) DEFAULT '空描述' COMMENT '接口描述',
  `url` varchar(255) NOT NULL COMMENT '访问地址',
  `method` tinyint(4) DEFAULT '0' COMMENT '请求类型',
  `uuid` char(36) NOT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`),
  KEY `fk_interfaces_module` (`module_id`),
  CONSTRAINT `fk_interfaces_module` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
/*
  Database structure for parameter
*/
DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '参数编号',
  `interfaces_id` int(11) unsigned NOT NULL COMMENT '接口编号',
  `parent_id` int(11) unsigned COMMENT '父接口编号',
  `name` varchar(255) NOT NULL COMMENT '参数名称',
  `description` varchar(255) DEFAULT '空描述' COMMENT '参数描述',
  `type` tinyint(1) DEFAULT '0' COMMENT '参数类型：0-请求，1-响应',
  `datatype` tinyint(4) DEFAULT '0' COMMENT '数据类型',
  `necessary` tinyint(1) DEFAULT '1' COMMENT '0-可选，1-必选',
  `rule` varchar(255) DEFAULT NULL COMMENT '生成规则',
  PRIMARY KEY (`id`),
  KEY `fk_parameter_interfaces` (`interfaces_id`),
  CONSTRAINT `fk_parameter_interfaces` FOREIGN KEY (`interfaces_id`) REFERENCES `interfaces` (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;