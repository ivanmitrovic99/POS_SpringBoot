-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:8111
-- Generation Time: Jul 20, 2022 at 04:41 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos`
--

-- --------------------------------------------------------

--
-- Table structure for table `cashier`
--

CREATE TABLE `cashier` (
  `id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(80) NOT NULL,
  `age` int(3) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(70) NOT NULL,
  `address` varchar(100) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cashier`
--

INSERT INTO `cashier` (`id`, `username`, `password`, `age`, `phone`, `email`, `address`, `role`) VALUES
(1, 'kasir', '$2a$12$kd.FewPKuuOlnap8JicLquFfVStPQgVyv9vS6IpegRi9B3z9D.dzS', 30, '014000333', 'kasir@gmail.com', 'Ulica Ulica 1', 'user'),
(2, 'admin', '$2a$12$yWUnIHyRDQD2mUQ7Sx20/OVKCI0cDs3vMlRDWSFJDLl1ktmygUMr2', 30, '000', 'admin@gmail.com', 'admin admin', 'admin'),
(3, 'ivanmi', '$2a$12$eRSyJn88q3WsV1azvGS4JeUrBh.7b0E9LwDRlb78hMAhTqPn..xu2', 23, '0638018939', 'ivanmitrovicenemy@gmail.com', 'Filipa Visnjica 23', 'admin'),
(7, 'mika', '$2a$12$00wk.CQ.kmj5d/2zH410J.PiglGJFgXgrVHpqnU63JPeRClIHKuWG', 20, '069420', 'ninamirkovic555@gmail.com', 'Ulica 13', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `company` varchar(50) NOT NULL,
  `pib` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `companynum` varchar(20) NOT NULL,
  `email` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `company`, `pib`, `address`, `companynum`, `email`) VALUES
(1, 'Ivan Mitrovic', 'FTN', '23321312', 'Ulica 13', '0123456789', 'ivanmitrovicenemy@gmail.com'),
(14, 'Goran Markovic', 'Lasta', '692312', 'Ulica 69', '069999', 'ivanmitrovicenemy@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `author` varchar(20) NOT NULL,
  `content` varchar(2000) NOT NULL,
  `date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`id`, `author`, `content`, `date`) VALUES
(2, 'admin', 'Pozdrav', '18/07/2022 14:35'),
(3, 'Admin', 'Novi post test', '17/07/2022 14:30');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `uom` varchar(15) NOT NULL,
  `exp_date` varchar(30) NOT NULL,
  `tax_symbol` varchar(5) NOT NULL,
  `tax_rate` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `uom`, `exp_date`, `tax_symbol`, `tax_rate`) VALUES
(1, 'Meso', 550, 'KG', '12/02/2023', 'A', 10),
(2, 'Mleko', 400, 'L', '12/05/2022', 'B', 20),
(3, 'Piletina', 1000, 'KG', '12/02/2023', 'A', 10);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `id` int(11) NOT NULL,
  `cashierid` int(13) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `products` varchar(1000) NOT NULL,
  `quantity` varchar(400) NOT NULL,
  `total` int(12) NOT NULL,
  `customerid` int(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`id`, `cashierid`, `date`, `time`, `products`, `quantity`, `total`, `customerid`) VALUES
(1, 1, '14/07/2022', '14:23', '1 1 1 1 ', '1 2 3 69', 333333, 1),
(13, 2, '17/07/2022', '09:34', '1 ', '10 ', -5500, 14),
(26, 2, '19/07/2022', '12:38', '1 ', '1 ', 550, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cashier`
--
ALTER TABLE `cashier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cashierid` (`cashierid`),
  ADD KEY `customerid` (`customerid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cashier`
--
ALTER TABLE `cashier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`cashierid`) REFERENCES `cashier` (`id`),
  ADD CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
