DELIMITER $$;

DROP PROCEDURE IF EXISTS `peje7`.`showtext`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showtext`(INOUT studentname varchar(50))
BEGIN
	SET studentname=concat(studentname, ' is very good java developer', ' in jspiders');
END$$

DELIMITER ;$$