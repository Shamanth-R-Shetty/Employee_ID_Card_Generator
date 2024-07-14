-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2024 at 11:35 AM
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
-- Database: `beststore`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `joined_at` datetime(6) DEFAULT NULL,
  `about` text DEFAULT NULL,
  `image_file_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `employees` (`id`, `city`, `designation`, `joined_at`, `about`, `image_file_name`, `name`, `salary`) VALUES
(13, 'Marineford', 'Administrator', '2024-04-07 21:40:56.000000', 'The Red Dog.', '1712506256636_images-26.jpeg', 'Akainu', 15000),
(14, 'Ohara', 'Developer', '2024-04-07 21:42:19.000000', 'Blue peasant', '1712506640652_1cfee5dd7ec40c0e06fcd0b8fcf8611a.jpg', 'Aokiji', 15000),
(15, 'Egghead', 'Tester', '2024-04-07 21:48:24.000000', 'Yellow Monkey.', '1712506704224_82d59715cbe844078f4138640272e09c.jpg', 'Kizaru', 15000),
(16, 'Doressarosa', 'Analyst', '2024-04-07 21:49:45.000000', 'Purple Tiger.', '1712506785366_images.jpg', 'Fujitora', 15000),
(17, 'Wano', 'other', '2024-04-07 21:50:18.000000', 'Green Bull.', '1712506818195_a760e627d7b0fb6b749e0bae3832654c.jpg', 'Aramaki', 15000),
(18, 'Heien', 'other', '2024-04-09 06:16:38.000000', 'White yaksha', '1712623598325_wallpaperflare.com_wallpaper (6).jpg', 'Gintoki', 100000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
