--
-- Database: `rental_vehicle_system`
--

-- --------------------------------------------------------

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`vPlateNo`, `vMake`, `vModel`, `vRatePerDay`, `vTransmission`, `cAirCondition`, `cNoOfDoors`, `cNoOfSeats`) VALUES
('car11', 'Honda', 'Civic', '500.00', 'auto', b'1', 4, 4),
('car12', 'Honda', 'Accord', '550.00', 'auto', b'0', 4, 3),
('car13', 'Nissan', 'March', '1000.00', 'semi-auto', b'0', 4, 5),
('car14', 'Suzuki', 'Swift', '450.00', 'manual', b'1', 4, 4),
('car15', 'Toyota', 'Prius', '700.00', 'semi-auto', b'1', 4, 5),
('car16', 'Honda', 'Grace', '600.00', 'auto', b'1', 4, 4),
('car17', 'Honda', 'Vezel', '400.00', 'auto', b'0', 4, 4),
('car18', 'Nissan', 'Leaf', '600.00', 'manual', b'0', 4, 4),
('car19', 'Suzuki', 'Alto', '500.00', 'semi-auto', b'1', 4, 3);

-- --------------------------------------------------------

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cusID`, `cusContactNo`, `cusLicenseNo`, `cusName`) VALUES
('cus11', '1234567891', 'abc123456', 'Shiromi'),
('cus12', '1234561236', 'def123456', 'Anita'),
('cus13', '9876543211', 'asd123456', 'Anne'),
('cus14', '4561231231', 'qwe123456', 'John'),
('cus15', '1239876547', 'dfg123456', 'Steve');

-- --------------------------------------------------------

--
-- Dumping data for table `motorbike`
--

INSERT INTO `motorbike` (`vPlateNo`, `vMake`, `vModel`, `vRatePerDay`, `vTransmission`, `mPetrolCapacity`, `mType`, `mModelYear`) VALUES
('bike11', 'Yamaha', 'Sports', '800.00', 'Manual', 6, 'Sports', 2010),
('bike12', 'Bajaj', 'Pulsar', '350.00', 'Manual', 9, 'Motorbike', 2015),
('bike13', 'Honda', 'Activa', '300.00', 'Auto', 7.5, 'Scooters', 2009),
('bike14', 'Honda', 'Aviator', '400.00', 'Manual', 8, 'Scooters', 2018),
('bike15', 'Bajaj', 'Discover', '500.00', 'Auto', 10, 'Motorbike', 2012),
('bike16', 'Honda', 'Touring', '700.00', 'Manual', 6, 'Cruiser', 2020);

-- --------------------------------------------------------

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`sID`, `cusID`, `sDropOffDate`, `sPickUpDate`, `vPlateNo`) VALUES
(20, 'cus11', '2019-12-10', '2019-12-12', 'car12'),
(21, 'cus13', '2019-12-09', '2019-12-10', 'bike15'),
(22, 'cus16', '2019-12-18', '2019-12-20', 'car15'),
(23, 'cus12', '2019-12-12', '2019-12-14', 'bike11'),
(24, 'cus14', '2019-12-17', '2019-12-20', 'car14');
