-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.8-rc-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  7.0.0.4363
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 teddy 的数据库结构
CREATE DATABASE IF NOT EXISTS `teddy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `teddy`;


-- 导出  表 teddy.t_base 结构
CREATE TABLE IF NOT EXISTS `t_base` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='表单模板';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_channel 结构
CREATE TABLE IF NOT EXISTS `t_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '版块名称',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='版块';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_post 结构
CREATE TABLE IF NOT EXISTS `t_post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `author_id` bigint(20) NOT NULL COMMENT '用户id',
  `channel_id` bigint(20) NOT NULL COMMENT '版块id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `summary` varchar(255) NOT NULL COMMENT '摘要',
  `tags` varchar(255) DEFAULT NULL COMMENT '标签',
  `views` int(11) NOT NULL DEFAULT '0' COMMENT '阅读数',
  `featured` int(11) NOT NULL DEFAULT '0' COMMENT '推荐状态',
  `weight` int(11) NOT NULL DEFAULT '0' COMMENT '置顶状态',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='推送';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_post_content 结构
CREATE TABLE IF NOT EXISTS `t_post_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `post_id` bigint(20) NOT NULL COMMENT 'post id',
  `content` text NOT NULL,
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='推送内容';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_post_favor 结构
CREATE TABLE IF NOT EXISTS `t_post_favor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `post_id` bigint(20) NOT NULL COMMENT 'post id',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='点赞 收藏 喜欢';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_role 结构
CREATE TABLE IF NOT EXISTS `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role` varchar(50) NOT NULL COMMENT '角色',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='角色管理';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_role_url 结构
CREATE TABLE IF NOT EXISTS `t_role_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `url_id` bigint(20) NOT NULL COMMENT '资源id',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='角色-资源';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_url 结构
CREATE TABLE IF NOT EXISTS `t_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(50) NOT NULL COMMENT 'API-URL',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='资源管理';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `mood` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户管理';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_user_role 结构
CREATE TABLE IF NOT EXISTS `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='用户-角色';

-- 数据导出被取消选择。


-- 导出  表 teddy.t_wallet 结构
CREATE TABLE IF NOT EXISTS `t_wallet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `balance` decimal(10,2) DEFAULT '0.00' COMMENT '余额',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
