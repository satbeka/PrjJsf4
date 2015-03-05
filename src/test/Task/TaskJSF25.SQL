CREATE DATABASE `sakila` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `phonebook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fio` varchar(100) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

SELECT * FROM sakila.locations;DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `del_phonebook`(in in_id int )
BEGIN
    delete from phonebook
    where id=in_id;
    SELECT * FROM phonebook;

  END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_phonebook_all`()
BEGIN
     SELECT *
     FROM phonebook ;

END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_phonebook_phone`(in in_phone varchar (20))
BEGIN
    SELECT *
    FROM phonebook
    where phone=in_phone;

  END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ins_phonebook`(infio varchar (50),inbirthdate date ,inaddress varchar (50),inphone varchar (50))
BEGIN
    insert into phonebook(fio, birth_date, address, phone)
    values (infio,inbirthdate,inaddress,inphone);
    commit;
    SELECT * FROM phonebook;

  END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `upd_phonebook`(in in_id int ,in in_fio varchar (50),
                                      in in_birthDate date ,in in_address varchar (50),in in_phone varchar (50))
BEGIN
    update phonebook
    set fio=in_fio ,birth_date=in_birthdate,address=in_address,phone=in_phone
    where id=in_id;
    SELECT * FROM phonebook;

  END$$
DELIMITER ;


