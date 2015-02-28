SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `StudentID` int(10) unsigned NOT NULL,
  `LastName` char(30) NOT NULL,
  `FirstName` char(30) NOT NULL,
  `Initial` char(1) NOT NULL,
  `City` char(30) NOT NULL,
  `State` char(30) NOT NULL,
  `Phone` char(7) NOT NULL,
  `Gender` char(1) NOT NULL,
  `Year` tinyint(1) unsigned NOT NULL,
  `Major` char(4) NOT NULL,
  `Credits` int(10) unsigned NOT NULL,
  `CGPA` decimal(10,2) NOT NULL,
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `student` (`StudentID`, `LastName`, `FirstName`, `Initial`, `City`, `State`, `Phone`, `Gender`, `Year`, `Major`, `Credits`, `CGPA`) VALUES
(10103, 'Johnson', 'James', 'L', 'Waupun', 'Wisconsin', '7345229', 'M', 1, 'ENGR', 15, '3.15'),
(10104, 'Andrews', 'Peter', 'J', 'Grand-Rapids', 'Michigan', '9493301', 'M', 2, 'CPSC', 42, '2.78'),
(10110, 'Peters', 'Andrew', 'J', 'Lynden', 'Washington', '3239550', 'M', 5, 'ART', 63, '2.05'),
(10113, 'VandenVander', 'Vanessa', 'V', 'Fremont', 'Michigan', '5509237', 'F', 4, 'HIST', 110, '3.74'),
(10126, 'Aristotle', 'Alice', 'A', 'Chino', 'California', '3330861', 'F', 3, 'PHIL', 78, '3.10'),
(10144, 'Lucky', 'Lucy', 'L', 'Grandville', 'Michigan', '7745424', 'F', 5, 'HIST', 66, '2.29'),
(10179, 'Euler', 'Lennie', 'L', 'Three_Rivers', 'Michigan', '6290017', 'M', 1, 'MATH', 15, '3.83'),
(10191, 'Nakamura', 'Toky', 'O', 'Chicago', 'Illinois', '4249665', 'F', 1, 'SOCI', 12, '1.95'),
(10226, 'Freud', 'Fred', 'E', 'Lynden', 'Washington', '8340115', 'M', 1, 'PSYC', 15, '1.85'),
(10272, 'Speareshake', 'William', 'W', 'Grand-Rapids', 'Michigan', '2410744', 'M', 5, 'ENGL', 102, '2.95'),
(10274, 'Tchaikovsky', 'Wolfgang', 'A', 'Byron-Center', 'Michigan', '8845115', 'M', 3, 'MUSC', 79, '2.75'),
(10284, 'Orange', 'Dutch', 'V', 'Graafschaap', 'Michigan', '3141660', 'M', 2, 'ENGR', 42, '2.98'),
(10297, 'Caesar', 'Julie', 'S', 'Denver', 'Colorado', '4470338', 'F', 4, 'HIST', 117, '3.25'),
(10298, 'Psycho', 'Prunella', 'E', 'De_Motte', 'Indiana', '5384609', 'F', 4, 'PSYC', 120, '2.99'),
(10301, 'Bull', 'Sitting', 'U', 'Gallup', 'New_Mexico', '6632997', 'M', 1, 'EDUC', 14, '2.95'),
(10302, 'Custer', 'General', 'G', 'Badlands', 'South_Dakota', '5552995', 'M', 3, 'HIST', 40, '1.95'),
(10303, 'Fahrenheit', 'Felicia', 'O', 'Sheboygan', 'Wisconsin', '5154997', 'F', 2, 'CHEM', 40, '3.85'),
(10304, 'Deutsch', 'Sprechen', 'Z', 'Sparta', 'Michigan', '8861201', 'F', 5, 'GERM', 14, '3.05'),
(10307, 'Mendelssohn', 'Mozart', 'W', 'Peoria', 'Illinois', '2410747', 'M', 3, 'MUSC', 76, '2.87'),
(10310, 'Augusta', 'Ada', 'B', 'Lakewood', 'California', '7172339', 'F', 2, 'CPSC', 46, '3.83'),
(10319, 'Gauss', 'Carl', 'F', 'Yorktown', 'Pennsylvania', '3385494', 'M', 2, 'MATH', 41, '4.00'),
(10323, 'Kronecker', 'Leo', 'P', 'Traverse_City', 'Michigan', '6763991', 'M', 3, 'MATH', 77, '2.75'),
(10330, 'Issacson', 'Jacob', 'A', 'Silver_Springs', 'Maryland', '4847932', 'M', 5, 'RELI', 25, '2.99'),
(10331, 'Issacson', 'Esau', 'B', 'Silver_Springs', 'Maryland', '4847932', 'M', 5, 'RELI', 25, '2.98'),
(10339, 'Dewey', 'Johanna', 'A', 'Salt_Lake_City', 'Utah', '6841129', 'F', 2, 'EDUC', 41, '3.83'),
(10348, 'Virus', 'Vera', 'W', 'Saginaw', 'Michigan', '6634401', 'F', 4, 'CPSC', 115, '3.25'),
(10355, 'Zylstra', 'Zelda', 'A', 'Downs', 'Kansas', '7514008', 'F', 1, 'ENGL', 16, '1.95'),
(10377, 'Porgy', 'Bess', 'N', 'Columbus', 'Ohio', '4841771', 'F', 2, 'MUSI', 44, '2.78'),
(10389, 'Newmann', 'Alfred', 'E', 'Cheyenne', 'Wyoming', '7712399', 'M', 4, 'EDUC', 115, '0.99'),
(10395, 'Medes', 'Archie', 'L', 'Whitinsville', 'Maryland', '9294401', 'M', 3, 'ENGR', 80, '3.10'),
(10406, 'Macdonald', 'Ronald', 'B', 'Seattle', 'Washington', '5582911', 'M', 1, 'CPSC', 15, '2.99'),
(10415, 'Aardvark', 'Anthony', 'A', 'Grandville', 'Michigan', '5325912', 'M', 2, 'ENGR', 43, '2.79'),
(10422, 'Gestalt', 'Gloria', 'G', 'Wheaton', 'Illinois', '6631212', 'F', 2, 'PSYC', 42, '2.48'),
(10431, 'GotoDijkstra', 'Edgar', 'G', 'Cawker_City', 'Kansas', '6349971', 'M', 1, 'CPSC', 15, '4.00'),
(10448, 'Rembrandt', 'Roberta', 'E', 'Sioux_Center', 'Iowa', '2408113', 'F', 1, 'ART', 77, '2.20'),
(10458, 'Shoemaker', 'Imelda', 'M', 'Honolulu', 'Hawaii', '9193001', 'F', 1, 'POLS', 15, '3.15'),
(10467, 'Marx', 'Karl', 'Z', 'Hawthorne', 'New_Jersey', '5513915', 'M', 3, 'ECON', 78, '2.75'),
(10470, 'Scrooge', 'Ebenezer', 'T', 'Troy', 'Michigan', '8134001', 'M', 4, 'SOCI', 118, '3.25'),
(10482, 'Nightingale', 'Florence', 'K', 'Rochester', 'New_York', '7175118', 'F', 1, 'NURS', 15, '3.15'),
(10490, 'Gazelle', 'Gwendolyn', 'D', 'Chino', 'California', '3132446', 'F', 2, 'PE', 43, '2.78'),
(10501, 'Pasteur', 'Louise', 'A', 'Window_Rock', 'Arizona', '4245170', 'F', 1, 'BIOL', 16, '3.10'),
(10511, 'Lewis', 'Clark', 'N', 'New_Era', 'Michigan', '6461125', 'M', 4, 'GEOG', 114, '3.37'),
(10515, 'Mouse', 'Michael', 'E', 'Boise', 'Idaho', '5132771', 'M', 5, 'EDUC', 87, '1.99'),
(10519, 'Elba', 'Able', 'M', 'Bozeman', 'Montana', '8183226', 'M', 3, 'SPEE', 77, '3.40'),
(10523, 'Pavlov', 'Bowser', 'T', 'Farmington', 'Michigan', '9421753', 'F', 1, 'PSYC', 13, '1.77'),
(10530, 'Chicita', 'Juanita', 'A', 'Oklahoma_City', 'Oklahoma', '3714377', 'F', 5, 'BIOL', 95, '2.66'),
(10538, 'Busch', 'Arch', 'E', 'St_Louis', 'Missouri', '8354112', 'M', 3, 'ENGR', 74, '2.75'),
(10547, 'Fault', 'Paige', 'D', 'Petoskey', 'Michigan', '4543116', 'F', 5, 'CPSC', 55, '2.95'),
(10553, 'Santamaria', 'Nina', 'P', 'Plymouth', 'Massachusetts', '2351181', 'F', 1, 'HIST', 15, '1.77'),
(10560, 'Shyster', 'Samuel', 'D', 'Everglades', 'Florida', '4421885', 'M', 1, 'SOCI', 13, '1.95'),
(10582, 'Yewliss', 'Cal', 'C', 'Rudyard', 'Michigan', '3451220', 'M', 3, 'MATH', 76, '2.99'),
(10590, 'Atanasoff', 'Eniac', 'C', 'Springfield', 'Illinois', '6142449', 'F', 1, 'CPSC', 14, '1.88'),
(10597, 'Rockne', 'Newton', 'K', 'New_York', 'New_York', '4631744', 'M', 4, 'PE', 116, '1.98'),
(10610, 'Roosevelt', 'Rose', 'Y', 'Spring_Lake', 'Michigan', '9491221', 'F', 5, 'POLS', 135, '2.95'),
(10623, 'Xerxes', 'Art', 'I', 'Cincinnati', 'Ohio', '3701228', 'M', 4, 'GREE', 119, '3.25'),
(10629, 'Leibniz', 'Gottfried', 'W', 'Boulder', 'Colorado', '5140228', 'M', 1, 'MATH', 13, '1.95'),
(10633, 'Vespucci', 'Vera', 'D', 'Ripon', 'California', '4341883', 'F', 5, 'GEOG', 89, '2.29'),
(10648, 'Principal', 'Pamela', 'P', 'Albany', 'New_York', '7145513', 'F', 1, 'EDUC', 14, '1.75'),
(10652, 'Cicero', 'Marsha', 'M', 'Rapid_City', 'South_Dakota', '3335910', 'F', 3, 'LATI', 77, '2.87'),
(10657, 'Weerd', 'Dewey', 'L', 'Detroit', 'Michigan', '4841962', 'M', 4, 'PHIL', 115, '2.99'),
(10663, 'Hochschule', 'Hortense', 'C', 'Lincoln', 'Nebraska', '7120111', 'F', 5, 'EDUC', 100, '2.70'),
(10668, 'Einstein', 'Alfred', 'M', 'Newark', 'New_Jersey', '3710225', 'M', 2, 'ENGR', 41, '2.78'),
(10675, 'Fibonacci', 'Leonard', 'O', 'Nashville', 'Tennessee', '4921107', 'M', 4, 'MATH', 115, '3.25'),
(10682, 'Angelo', 'Mike', 'L', 'Austin', 'Texas', '5132201', 'M', 4, 'ART', 117, '3.74'),
(10688, 'Pascal', 'Blaze', 'R', 'Brooklyn', 'New_York', '7412993', 'M', 1, 'CPSC', 15, '1.98');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
