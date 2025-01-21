-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 21, 2025 at 06:07 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_fts`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_completed_exercises`
--

CREATE TABLE `tb_completed_exercises` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `day` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `exercise` varchar(100) NOT NULL,
  `duration` varchar(50) DEFAULT NULL,
  `sets` int(11) DEFAULT NULL,
  `reps` int(11) DEFAULT NULL,
  `completion_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_incomplete_exercises`
--

CREATE TABLE `tb_incomplete_exercises` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `day` varchar(50) NOT NULL,
  `type` varchar(100) NOT NULL,
  `exercise` varchar(100) NOT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `sets` int(11) DEFAULT NULL,
  `reps` int(11) DEFAULT NULL,
  `completed` tinyint(1) DEFAULT 0,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tb_users`
--

CREATE TABLE `tb_users` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `age` int(11) NOT NULL,
  `sex` enum('Male','Female') NOT NULL,
  `weight` float(5,2) NOT NULL,
  `height` float(5,2) NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `sec_question` varchar(255) NOT NULL,
  `sec_answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `bmi` varchar(255) DEFAULT NULL,
  `classification` varchar(255) DEFAULT NULL,
  `goal` enum('Gain Weight','Lose Weight','Maintain Weight') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tb_users`
--

INSERT INTO `tb_users` (`user_id`, `first_name`, `last_name`, `email`, `username`, `age`, `sex`, `weight`, `height`, `password`, `sec_question`, `sec_answer`, `bmi`, `classification`, `goal`) VALUES
(24, 'test', 'user', 'test@gmail.com', 'testUser', 21, 'Female', 71.00, 177.40, 'testPassword', 't', 't', '22.6 kg/m²', 'Normal Weight', 'Lose Weight'),
(32, 'Miko', 'Miano', 'mik041126@gmail.com', 'yliris', 20, 'Male', 58.27, 177.40, 'ylirispercy26', 'What is my favorite car?', 'Honda NSX', '18.5 kg/m²', 'Normal Weight', 'Maintain Weight'),
(33, 'Ayrton', 'Senna', 'ayrtonsenna@gmail.com', 'senna123', 42, 'Male', 51.00, 180.20, 'senna12345', 'What?', 'Yes', '15.7 kg/m²', 'Underweight', NULL),
(35, 'Mikoo', 'Miano', 'mik@gmail.com', 'mik', 20, 'Male', 56.70, 177.40, '12345678', 'w', 'w', '18.0 kg/m²', 'Underweight', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_completed_exercises`
--
ALTER TABLE `tb_completed_exercises`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tb_incomplete_exercises`
--
ALTER TABLE `tb_incomplete_exercises`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `tb_users`
--
ALTER TABLE `tb_users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `EMAIL` (`email`),
  ADD UNIQUE KEY `USERNAME` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_completed_exercises`
--
ALTER TABLE `tb_completed_exercises`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_incomplete_exercises`
--
ALTER TABLE `tb_incomplete_exercises`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- AUTO_INCREMENT for table `tb_users`
--
ALTER TABLE `tb_users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_completed_exercises`
--
ALTER TABLE `tb_completed_exercises`
  ADD CONSTRAINT `tb_completed_exercises_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `tb_incomplete_exercises`
--
ALTER TABLE `tb_incomplete_exercises`
  ADD CONSTRAINT `tb_incomplete_exercises_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
