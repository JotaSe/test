-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.22-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for lemontechdbtest
DROP DATABASE IF EXISTS `lemontechdbtest`;
CREATE DATABASE IF NOT EXISTS `lemontechdbtest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `lemontechdbtest`;


-- Dumping structure for table lemontechdbtest.course
DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`teacher_id`),
  KEY `fk_course_teacher_idx` (`teacher_id`),
  CONSTRAINT `fk_course_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table lemontechdbtest.course: ~5 rows (approximately)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`, `name`, `teacher_id`) VALUES
	(1, 'Castellano', 1),
	(2, 'Matematicas', 2),
	(3, 'Historia', 1),
	(4, 'Programacion', 1),
	(5, 'Deports', 3);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


-- Dumping structure for table lemontechdbtest.course_has_student
DROP TABLE IF EXISTS `course_has_student`;
CREATE TABLE IF NOT EXISTS `course_has_student` (
  `course_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`,`student_id`),
  KEY `fk_course_has_student_student1_idx` (`student_id`),
  KEY `fk_course_has_student_course1_idx` (`course_id`),
  CONSTRAINT `fk_course_has_student_course1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_has_student_student1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table lemontechdbtest.course_has_student: ~8 rows (approximately)
/*!40000 ALTER TABLE `course_has_student` DISABLE KEYS */;
INSERT INTO `course_has_student` (`course_id`, `student_id`) VALUES
	(1, 1),
	(2, 1),
	(4, 1),
	(2, 2),
	(4, 2),
	(3, 3),
	(4, 3),
	(3, 4);
/*!40000 ALTER TABLE `course_has_student` ENABLE KEYS */;


-- Dumping structure for table lemontechdbtest.student
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table lemontechdbtest.student: ~4 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `name`) VALUES
	(1, 'El chavo'),
	(2, 'kiko'),
	(3, 'La chilindrina'),
	(4, 'Paty');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


-- Dumping structure for table lemontechdbtest.teacher
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table lemontechdbtest.teacher: ~3 rows (approximately)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`id`, `name`) VALUES
	(1, 'Jirafales'),
	(2, 'Don Bariga'),
	(3, 'Don Ramon');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;


-- Dumping structure for table lemontechdbtest.test
DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`course_id`),
  KEY `fk_test_course1_idx` (`course_id`),
  CONSTRAINT `fk_test_course1` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table lemontechdbtest.test: ~7 rows (approximately)
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` (`id`, `name`, `course_id`) VALUES
	(1, 'Calculo I', 2),
	(2, 'Ecuaciones', 2),
	(3, 'Patrones de diseno', 4),
	(4, 'Sinonimos', 1),
	(5, 'Boxeo', 5),
	(6, 'Algoritmos', 4),
	(7, 'WWII', 3);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;


-- Dumping structure for table lemontechdbtest.test_has_student
DROP TABLE IF EXISTS `test_has_student`;
CREATE TABLE IF NOT EXISTS `test_has_student` (
  `test_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `score` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`test_id`,`student_id`),
  KEY `fk_test_has_student_student1_idx` (`student_id`),
  KEY `fk_test_has_student_test1_idx` (`test_id`),
  CONSTRAINT `fk_test_has_student_student1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_test_has_student_test1` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table lemontechdbtest.test_has_student: ~7 rows (approximately)
/*!40000 ALTER TABLE `test_has_student` DISABLE KEYS */;
INSERT INTO `test_has_student` (`test_id`, `student_id`, `score`) VALUES
	(1, 1, 3),
	(1, 2, 9),
	(2, 2, 5),
	(3, 1, 5),
	(5, 1, 10),
	(6, 1, 4),
	(7, 4, 4);
/*!40000 ALTER TABLE `test_has_student` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
