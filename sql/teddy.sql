-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.23-log - MySQL Community Server (GPL)
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

-- 正在导出表  teddy.t_base 的数据：~0 rows (大约)
DELETE FROM `t_base`;
/*!40000 ALTER TABLE `t_base` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_base` ENABLE KEYS */;


-- 导出  表 teddy.t_channel 结构
CREATE TABLE IF NOT EXISTS `t_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '版块名称',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='版块';

-- 正在导出表  teddy.t_channel 的数据：~0 rows (大约)
DELETE FROM `t_channel`;
/*!40000 ALTER TABLE `t_channel` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_channel` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='推送';

-- 正在导出表  teddy.t_post 的数据：~4 rows (大约)
DELETE FROM `t_post`;
/*!40000 ALTER TABLE `t_post` DISABLE KEYS */;
INSERT INTO `t_post` (`id`, `author_id`, `channel_id`, `title`, `summary`, `tags`, `views`, `featured`, `weight`, `created`, `enable`) VALUES
	(1, 2, 0, 'man age like wine', 'man age like wine!', 'age', 0, 0, 0, '2018-10-15 16:11:16', 1),
	(2, 1, 0, '雪！雪！雪！', '落大雪', 'snow', 0, 0, 0, '2018-12-11 14:47:08', 1),
	(3, 1, 0, '心狗', 'single to me', 'single', 0, 0, 0, '2018-12-11 14:47:57', 1),
	(4, 1, 0, '水', '江河湖海浪淘沙波涛汹涌，汀浦滨滩潮漫浒洲渚沉浮。', '水', 0, 0, 0, '2018-12-11 14:49:17', 1);
/*!40000 ALTER TABLE `t_post` ENABLE KEYS */;


-- 导出  表 teddy.t_post_content 结构
CREATE TABLE IF NOT EXISTS `t_post_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `post_id` bigint(20) NOT NULL COMMENT 'post id',
  `content` text NOT NULL,
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='推送内容';

-- 正在导出表  teddy.t_post_content 的数据：~1 rows (大约)
DELETE FROM `t_post_content`;
/*!40000 ALTER TABLE `t_post_content` DISABLE KEYS */;
INSERT INTO `t_post_content` (`id`, `post_id`, `content`, `created`, `enable`) VALUES
	(1, 3, 'single to me is about looking after yourself - physically, financially, mentally ...all of it and making your life better in every way you can think to, as well as finding more things you like and exploring them. Gym, setting financial goals and working towards them, hobbies that you can get stuck into (for example, I’m an amateur astronomer, gamer, book lover, math geek) that kinda thing. Not knowing what else there is in life without having someone is just sad.', '2018-12-11 14:47:57', 1);
/*!40000 ALTER TABLE `t_post_content` ENABLE KEYS */;


-- 导出  表 teddy.t_post_favor 结构
CREATE TABLE IF NOT EXISTS `t_post_favor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `post_id` bigint(20) NOT NULL COMMENT 'post id',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='点赞 收藏 喜欢';

-- 正在导出表  teddy.t_post_favor 的数据：~0 rows (大约)
DELETE FROM `t_post_favor`;
/*!40000 ALTER TABLE `t_post_favor` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_post_favor` ENABLE KEYS */;


-- 导出  表 teddy.t_role 结构
CREATE TABLE IF NOT EXISTS `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role` varchar(50) NOT NULL COMMENT '角色',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='角色管理';

-- 正在导出表  teddy.t_role 的数据：~2 rows (大约)
DELETE FROM `t_role`;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`id`, `role`, `created`, `enable`) VALUES
	(1, '管理员', '2018-09-14 09:35:47', 1),
	(2, '普通用户', '2018-09-14 09:40:18', 1);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;


-- 导出  表 teddy.t_role_url 结构
CREATE TABLE IF NOT EXISTS `t_role_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `url_id` bigint(20) NOT NULL COMMENT '资源id',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='角色-资源';

-- 正在导出表  teddy.t_role_url 的数据：~5 rows (大约)
DELETE FROM `t_role_url`;
/*!40000 ALTER TABLE `t_role_url` DISABLE KEYS */;
INSERT INTO `t_role_url` (`id`, `role_id`, `url_id`, `created`, `enable`) VALUES
	(1, 1, 1, '2018-09-14 09:40:52', 1),
	(2, 1, 2, '2018-09-14 09:40:53', 1),
	(3, 2, 1, '2018-09-14 09:40:54', 0),
	(4, 2, 2, '2018-09-19 16:30:17', 1),
	(5, 1, 3, '2018-12-20 18:31:54', 1);
/*!40000 ALTER TABLE `t_role_url` ENABLE KEYS */;


-- 导出  表 teddy.t_url 结构
CREATE TABLE IF NOT EXISTS `t_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `url` varchar(50) NOT NULL COMMENT 'API-URL',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='资源管理';

-- 正在导出表  teddy.t_url 的数据：~3 rows (大约)
DELETE FROM `t_url`;
/*!40000 ALTER TABLE `t_url` DISABLE KEYS */;
INSERT INTO `t_url` (`id`, `url`, `created`, `enable`) VALUES
	(1, '/user/**', '2018-09-14 09:39:11', 1),
	(2, '/**', '2018-09-14 09:39:44', 1),
	(3, '/manager/**', '2018-12-20 18:30:32', 1);
/*!40000 ALTER TABLE `t_url` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户管理';

-- 正在导出表  teddy.t_user 的数据：~2 rows (大约)
DELETE FROM `t_user`;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `password`, `username`, `phone`, `email`, `mood`, `sex`, `birthday`, `created`, `enable`) VALUES
	(1, '22935a8ea24e04937cfbd7c00fe6cccc864cc54e9b0c2cba10dd43a7aa7aabec', 'okkpp', NULL, NULL, 'man age like wine', 0, '2018-09-11 13:18:08', '2018-09-11 13:18:09', 1),
	(2, 'be923516c501cbb09114b0e18d13efbc084b426aa7e116fd2bd322f4230f73e2', 'okkpp@qq.com', NULL, NULL, 'wind 321', 1, NULL, '2018-09-12 11:36:22', 1);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;


-- 导出  表 teddy.t_user_role 结构
CREATE TABLE IF NOT EXISTS `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='用户-角色';

-- 正在导出表  teddy.t_user_role 的数据：~2 rows (大约)
DELETE FROM `t_user_role`;
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` (`id`, `user_id`, `role_id`, `created`, `enable`) VALUES
	(1, 1, 1, '2018-09-14 15:00:39', 1),
	(2, 2, 2, '2018-09-14 15:02:39', 1);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;


-- 导出  表 teddy.t_wallet 结构
CREATE TABLE IF NOT EXISTS `t_wallet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `balance` decimal(10,2) DEFAULT '0.00' COMMENT '余额',
  `created` datetime DEFAULT NULL COMMENT '创建日期',
  `enable` int(11) DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  teddy.t_wallet 的数据：~0 rows (大约)
DELETE FROM `t_wallet`;
/*!40000 ALTER TABLE `t_wallet` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_wallet` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
