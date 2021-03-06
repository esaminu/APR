SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


DROP TABLE IF EXISTS `studentupdate`;
CREATE TABLE IF NOT EXISTS `studentupdate` (
  `StudentID` int(10) unsigned NOT NULL,
  `Course_1` char(7) NOT NULL,
  `Grade_1` char(2) NOT NULL,
  `CourseCredit_1` tinyint(3) unsigned NOT NULL,
  `Course_2` char(7) NOT NULL,
  `Grade_2` char(2) NOT NULL,
  `CourseCredit_2` tinyint(3) unsigned NOT NULL,
  `Course_3` char(7) NOT NULL,
  `Grade_3` char(2) NOT NULL,
  `CourseCredit_3` tinyint(3) unsigned NOT NULL,
  `Course_4` char(7) NOT NULL,
  `Grade_4` char(2) NOT NULL,
  `CourseCredit_4` tinyint(3) unsigned NOT NULL,
  `Course_5` char(7) NOT NULL,
  `Grade_5` char(2) NOT NULL,
  `CourseCredit_5` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `studentupdate` (`StudentID`, `Course_1`, `Grade_1`, `CourseCredit_1`, `Course_2`, `Grade_2`, `CourseCredit_2`, `Course_3`, `Grade_3`, `CourseCredit_3`, `Course_4`, `Grade_4`, `CourseCredit_4`, `Course_5`, `Grade_5`, `CourseCredit_5`) VALUES
(10103, 'ENGL176', 'C', 4, 'EDUC268', 'B', 4, 'EDUC330', 'B+', 3, 'PE281', 'C', 3, 'ENGR317', 'D', 4),
(10104, 'CPSC271', 'D+', 4, 'ESCI208', 'D-', 3, 'PHIL340', 'B+', 2, 'CPSC146', 'D+', 4, 'ENGL432', 'D+', 4),
(10110, 'ART520', 'D', 3, 'ESCI259', 'F', 1, 'ENGL151', 'D+', 4, 'MUSC257', 'B', 4, 'PSYC486', 'C', 4),
(10113, 'HIST498', 'F', 3, 'PE317', 'C+', 4, 'MUSC139', 'B-', 3, 'PHIL165', 'D', 3, 'GEOG222', 'C', 3),
(10126, 'PHIL367', 'C-', 4, 'EDUC420', 'C-', 3, 'EDUC473', 'C', 3, 'EDUC224', 'D-', 3, 'GERM257', 'F', 4),
(10144, 'HIST559', 'C+', 3, 'MATH357', 'D', 3, 'CPSC323', 'C-', 2, 'PE246', 'D-', 4, 'MUSC379', 'D+', 4),
(10179, 'MATH169', 'C-', 4, 'CHEM163', 'C+', 4, 'MUSC436', 'A-', 3, 'MATH366', 'D-', 2, 'BIOL213', 'A-', 4),
(10191, 'SOCI177', 'F', 4, 'POLS106', 'A', 4, 'EDUC495', 'A-', 3, 'ENGR418', 'B+', 2, 'ENGR355', 'A', 4),
(10226, 'PSYC116', 'B', 3, 'GERM323', 'B-', 4, 'ART350', 'A', 4, 'HIST269', 'B+', 4, 'EDUC214', 'C+', 3),
(10272, 'ENGL558', 'A-', 4, 'EDUC169', 'D+', 3, 'PSYC483', 'B+', 4, 'ENGR335', 'B+', 2, 'BIOL228', 'B', 4),
(10274, 'MUSC351', 'B', 4, 'PSYC209', 'C-', 4, 'ENGR400', 'F', 1, 'ESCI392', 'A', 4, 'SOCI394', 'B-', 3),
(10284, 'ENGR292', 'D', 4, 'PSYC172', 'C', 4, 'EDUC140', 'B', 4, 'MATH274', 'F', 4, 'MUSC101', 'D+', 4),
(10297, 'HIST464', 'F', 1, 'HIST205', 'F', 1, 'ENGR444', 'F', 1, 'MATH269', 'F', 1, 'EDUC163', 'F', 1),
(10298, 'PSYC452', 'B', 3, 'MATH170', 'C+', 4, 'EDUC344', 'C-', 2, 'GREE138', 'C-', 2, 'SPEE303', 'A-', 3),
(10301, 'EDUC197', 'A', 4, 'PE372', 'B', 3, 'ENGR218', 'D', 4, 'MATH309', 'C', 4, 'ESCI405', 'C-', 4),
(10302, 'CHEM283', 'F', 1, 'PE440', 'A', 2, 'MATH399', 'A-', 3, 'HIST455', 'C-', 4, 'MATH387', 'C-', 3),
(10303, 'HIST111', 'D-', 3, 'ART151', 'C+', 3, 'ENGL100', 'C-', 3, 'PSYC151', 'D+', 3, 'PE104', 'A-', 1),
(10304, 'GERM526', 'C-', 2, 'CHEM243', 'C', 4, 'POLS331', 'B-', 4, 'EDUC398', 'A', 3, 'ENGR479', 'D+', 4),
(10307, 'MUSC323', 'B+', 3, 'MATH485', 'C', 4, 'HIST232', 'B+', 4, 'EDUC180', 'A', 3, 'ENGL130', 'B+', 4),
(10310, 'CPSC264', 'B', 2, 'POLS227', 'D+', 3, 'ENGR467', 'D-', 3, 'MATH494', 'D-', 4, 'ART420', 'C+', 4),
(10319, 'MATH276', 'B', 2, 'ESCI434', 'A', 3, 'HIST197', 'B-', 4, 'GERM489', 'B-', 2, 'ART137', 'C-', 3),
(10323, 'MATH377', 'D-', 4, 'EDUC210', 'D', 4, 'MATH385', 'D-', 4, 'ENGR433', 'C', 2, 'HIST338', 'A-', 4),
(10330, 'HIST546', 'C+', 3, 'ESCI440', 'B+', 3, 'GREE472', 'C+', 3, 'BIOL186', 'B', 4, 'GEOG434', 'C+', 2),
(10331, 'HIST546', 'C', 3, 'ESCI440', 'B+', 3, 'GREE472', 'C', 3, 'BIOL186', 'B+', 4, 'GEOG434', 'C+', 2),
(10339, 'EDUC283', 'B', 3, 'CPSC150', 'B', 3, 'ENGR120', 'D', 4, 'CPSC122', 'F', 4, 'ART216', 'B', 4),
(10348, 'CPSC411', 'C-', 3, 'HIST480', 'C+', 4, 'PSYC459', 'B', 4, 'BIOL299', 'B+', 4, 'ECON276', 'B+', 3),
(10355, 'ENGL130', 'C-', 3, 'CPSC282', 'C+', 4, 'CPSC181', 'A-', 4, 'CPSC146', 'C-', 4, 'SOCI113', 'F', 1),
(10377, 'SOCI213', 'D+', 3, 'PSYC158', 'D', 4, 'MUSC188', 'C', 3, 'PSYC281', 'D-', 4, 'ENGR339', 'B+', 4),
(10389, 'EDUC414', 'D+', 4, 'PSYC115', 'C-', 2, 'PSYC152', 'D-', 4, 'ART366', 'D-', 3, 'ENGR366', 'F', 4),
(10395, 'ENGR396', 'B', 4, 'HIST102', 'F', 3, 'ENGL111', 'A', 4, 'PSYC210', 'D-', 2, 'GREE128', 'A', 4),
(10406, 'CPSC160', 'C+', 4, 'CPSC233', 'C', 1, 'LATI494', 'C+', 3, 'ENGL115', 'C-', 3, 'MATH181', 'A', 3),
(10415, 'ENGR287', 'C', 4, 'EDUC166', 'B-', 4, 'EDUC106', 'A-', 3, 'PE190', 'F', 3, 'MATH171', 'B-', 3),
(10422, 'PSYC275', 'A-', 4, 'MATH497', 'A', 4, 'EDUC340', 'F', 1, 'GERM403', 'C-', 4, 'MATH245', 'D+', 4),
(10431, 'CPSC187', 'D-', 4, 'CPSC426', 'F', 4, 'ENGR476', 'B-', 4, 'BIOL148', 'B+', 3, 'CPSC220', 'F', 3),
(10448, 'ART171', 'D+', 3, 'CPSC239', 'C-', 3, 'SOCI499', 'B-', 4, 'HIST113', 'D+', 3, 'PSYC116', 'C', 4),
(10458, 'POLS171', 'F', 1, 'CPSC187', 'C+', 4, 'CHEM150', 'B', 2, 'PHIL438', 'D-', 4, 'PHIL254', 'D', 4),
(10467, 'ECON335', 'D-', 3, 'ESCI471', 'B+', 4, 'MATH457', 'C+', 3, 'MATH207', 'C', 2, 'BIOL429', 'D', 4),
(10470, 'MUSC415', 'C+', 3, 'POLS177', 'C', 3, 'CPSC480', 'A', 4, 'PSYC437', 'B', 3, 'SOCI276', 'D', 4),
(10482, 'ENGL158', 'D-', 4, 'EDUC475', 'B', 3, 'HIST172', 'B-', 2, 'PE316', 'F', 4, 'ENGR294', 'A-', 3),
(10490, 'PE239', 'F', 4, 'ENGL348', 'F', 3, 'LATI246', 'F', 4, 'CPSC350', 'F', 4, 'MATH114', 'F', 1),
(10501, 'BIOL125', 'F', 4, 'CPSC412', 'F', 3, 'ESCI279', 'F', 4, 'ENGR153', 'F', 2, 'ART293', 'F', 1),
(10511, 'ESCI416', 'B', 3, 'MATH316', 'D-', 4, 'MATH287', 'C', 2, 'MATH499', 'A-', 4, 'ESCI288', 'D', 3),
(10515, 'EDUC563', 'D+', 3, 'PHIL373', 'D-', 3, 'ART318', 'B', 4, 'HIST451', 'F', 1, 'ART476', 'C+', 3),
(10519, 'SPEE386', 'B+', 4, 'HIST479', 'C', 4, 'PSYC249', 'B-', 2, 'GREE204', 'B-', 4, 'PE421', 'A', 1),
(10523, 'BIOL183', 'D-', 2, 'HIST296', 'D+', 4, 'HIST380', 'B+', 4, 'ENGR216', 'C', 4, 'MATH412', 'B-', 2),
(10530, 'ENGL559', 'F', 1, 'EDUC457', 'D+', 4, 'CPSC306', 'A', 3, 'ENGR171', 'B+', 1, 'CPSC380', 'A', 4),
(10538, 'ENGR328', 'A-', 4, 'ENGR336', 'C', 3, 'EDUC418', 'D+', 3, 'PHIL437', 'B+', 4, 'CPSC475', 'D', 4),
(10547, 'CPSC537', 'A-', 4, 'ART386', 'D', 4, 'HIST292', 'D-', 4, 'ENGR467', 'A-', 4, 'PE464', 'B+', 4),
(10553, 'HIST170', 'A-', 4, 'SOCI496', 'D-', 3, 'PHIL136', 'B+', 4, 'CPSC371', 'D-', 4, 'CPSC160', 'A-', 1),
(10560, 'SOCI153', 'D+', 3, 'MATH438', 'D+', 4, 'CPSC378', 'C', 4, 'BIOL266', 'F', 3, 'EDUC278', 'D+', 3),
(10582, 'MATH388', 'A-', 3, 'PE311', 'B', 3, 'ECON143', 'D', 4, 'MATH304', 'C+', 3, 'PE428', 'C+', 4),
(10590, 'CPSC134', 'B-', 3, 'ESCI114', 'B+', 3, 'CPSC492', 'C', 4, 'ENGL121', 'C', 4, 'ENGR403', 'A-', 4),
(10597, 'PE423', 'A-', 3, 'BIOL189', 'D+', 3, 'PHIL122', 'D-', 4, 'ENGL194', 'C-', 4, 'SOCI113', 'D+', 3),
(10610, 'ESCI594', 'C-', 3, 'PHIL344', 'F', 4, 'CPSC189', 'B+', 2, 'ENGR411', 'D-', 3, 'MATH241', 'A', 4),
(10623, 'GREE412', 'B-', 4, 'ENGL415', 'D-', 3, 'ENGL234', 'D-', 4, 'MATH275', 'F', 1, 'SOCI124', 'B+', 3),
(10629, 'MATH137', 'D', 2, 'MATH481', 'F', 3, 'ESCI445', 'F', 1, 'MATH339', 'D', 4, 'ART219', 'B+', 4),
(10633, 'GEOG573', 'B', 4, 'ENGL149', 'C+', 4, 'EDUC113', 'B+', 4, 'ENGR458', 'C-', 2, 'HIST446', 'D+', 4),
(10648, 'EDUC132', 'D+', 4, 'MUSC103', 'D-', 4, 'ENGL263', 'C', 4, 'ENGL134', 'B+', 4, 'ESCI392', 'A', 3),
(10652, 'LATI363', 'F', 3, 'BIOL425', 'F', 1, 'CPSC267', 'C', 4, 'EDUC127', 'C+', 3, 'MATH338', 'B', 4),
(10657, 'PHIL429', 'F', 1, 'ART412', 'D-', 4, 'MUSC473', 'B-', 4, 'SOCI447', 'C-', 4, 'MATH237', 'D+', 2),
(10663, 'EDUC580', 'B-', 4, 'ENGR351', 'B+', 4, 'SOCI283', 'D', 4, 'ART340', 'C', 4, 'PSYC133', 'D+', 3),
(10668, 'ENGR274', 'B+', 4, 'SOCI438', 'C', 1, 'PE327', 'C', 4, 'BIOL158', 'A', 4, 'EDUC457', 'A-', 4),
(10675, 'MATH457', 'A', 4, 'ENGR114', 'C', 4, 'CPSC218', 'C', 3, 'ESCI433', 'C-', 3, 'PSYC243', 'C+', 1),
(10682, 'ART483', 'D+', 3, 'GERM432', 'C', 3, 'ENGL103', 'B+', 4, 'MUSC169', 'C-', 3, 'SOCI381', 'C-', 2),
(10688, 'CPSC182', 'F', 1, 'HIST371', 'C+', 4, 'PSYC408', 'F', 1, 'MUSC214', 'B+', 4, 'MATH151', 'C', 3);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
