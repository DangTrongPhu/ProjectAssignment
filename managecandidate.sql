-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2018 at 02:20 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `managecandidate`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidate`
--

CREATE TABLE IF NOT EXISTS `candidate` (
`id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `fullname` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `gpa` double NOT NULL,
  `graduationyear` int(11) NOT NULL,
  `position` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `university` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `interviewdate` date NOT NULL,
  `iqtest` int(11) NOT NULL,
  `technicaltest` int(11) NOT NULL,
  `toeic` int(11) NOT NULL,
  `interviewresult` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `interviewcomments` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dayofbirth` date NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `address` text COLLATE utf8_unicode_ci NOT NULL,
  `degree` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `notes` text COLLATE utf8_unicode_ci
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `candidate`
--

INSERT INTO `candidate` (`id`, `id_user`, `fullname`, `gpa`, `graduationyear`, `position`, `university`, `interviewdate`, `iqtest`, `technicaltest`, `toeic`, `interviewresult`, `interviewcomments`, `dayofbirth`, `email`, `phone`, `address`, `degree`, `notes`) VALUES
(1, 2, 'Trong Phu Dang', 8, 2014, 'Programmer', 'Can Tho University', '2008-06-21', 90, 90, 550, 'Passed', '', '2008-06-21', 'phub1400984@student.ctu.edu.vn', '012779333925', 'Thới Hòa Trà Ôn', 'College', 'tinh anh traoem'),
(2, 1, 'Van A Tran', 7, 2019, 'Network Administrator', 'University of Science Ho Chi Minh City', '2018-06-21', 100, 80, 500, 'Passed', '', '2008-06-21', 'tinhanhtraoem999@gmail.com', '0941616441', 'Trà Ôn', 'College', 'Không có'),
(3, 2, 'Thi B Tran', 5.5, 2017, 'tester', 'Vietnam National University, Ho Chi Minh City', '2018-06-15', 35, 45, 990, 'Passed', '', '1999-07-01', 'ttb999@gmail.com', '01210997455', 'Tien Giang', 'Bachalor', 'No'),
(4, 2, '12', 8.5, 2019, 'Programmer', 'Vietnam National University, Hồ Chí Minh City', '1996-05-02', 12, 12, 12, 'Failed', '12', '1996-05-02', 'phub140098421@student.ctu.edu.vn', '012779333932', '12', '12', '12'),
(18, 1, '2', 2, 2014, '2', 'Can Tho University', '2008-06-21', 2, 2, 2, 'Failed', '2', '2008-06-21', 'tinhanhtraoem11@gmail.com', '01277933392', '2', '2', '2'),
(19, 1, '2', 2, 2019, '2', 'University of Science Ho Chi Minh City', '2008-06-21', 2, 2, 2, 'Passed', '2', '2008-06-21', 'tinhanhtraoem1111@gmail.com', '01277933392', '2', '2', '2'),
(26, 1, 'Dang Van A', 8, 2015, 'tester', 'Can Tho University', '2018-06-17', 90, 90, 850, 'Failed', 't', '1970-01-01', 'tinhanhtrao1111em@gmail.com', '01277933392', 'r', 'College', 'r'),
(28, 3, 'Nguyen Van A', 8.5, 2014, 'tester', 'Can Tho University', '1996-06-08', 80, 90, 560, 'Passed', '12', '1996-06-08', 'nhatkhanh@gmail.com', '01277933393', 'vĩnh long', 'College', '11'),
(29, 3, 'Ho Van A', 8.5, 2014, 'tester', 'Can Tho University', '1996-06-08', 80, 90, 560, 'Passed', NULL, '1996-06-08', 'nhatkhanh1@gmail.com', '01277933393', 'vĩnh long', 'College', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
`id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'interviewer'),
(3, 'PM');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id` int(11) NOT NULL,
  `id_roles` int(11) NOT NULL,
  `name` varchar(125) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `id_roles`, `name`, `email`, `pass`) VALUES
(1, 1, 'Nhat Khanh Nguyen', 'nhatkhanh@gmail.com', '107621'),
(2, 3, 'Cao Ba Dinh', 'caodinh@gmail.com', '1076'),
(3, 2, 'Bao Le', 'baole@gmail.com', '107621');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `candidate`
--
ALTER TABLE `candidate`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `candidate`
--
ALTER TABLE `candidate`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
