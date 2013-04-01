
DROP DATABASE IF EXISTS foc;
CREATE DATABASE IF NOT EXISTS foc;
USE foc;


DROP TABLE IF EXISTS `foc_head`;
CREATE TABLE `foc_head` (
  `head_id` int(11) NOT NULL auto_increment,
  `last_name` varchar(35) NOT NULL default '',
  `first_name` varchar(3) NOT NULL default '',
  `username` varchar(20) NOT NULL default '',
  `password` varchar(30) NOT NULL default '***',
  PRIMARY KEY  (`head_id`)
) ;

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `member_id` int(11) NOT NULL auto_increment,
  `last_name` varchar(35) NOT NULL default '',
  `first_name` varchar(3) NOT NULL default '',
  `department` varchar(50) NOT NULL default '',
  `eligib` char(1) default '1',
  PRIMARY KEY  (`member_id`)
) ;

DROP TABLE IF EXISTS `committee`;
CREATE TABLE `committee` (
  `com_id` int(11) NOT NULL auto_increment,
  `name` varchar(35) NOT NULL default '',
  `size` varchar(3) NOT NULL default '',
  `members` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`com_id`)
) ;