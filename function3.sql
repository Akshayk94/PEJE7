DELIMITER $$;

DROP FUNCTION IF EXISTS `peje7`.`displaycustomertype`$$

CREATE DEFINER=`root`@`localhost` FUNCTION `displaycustomertype`(creditlimit double) RETURNS varchar(10) CHARSET utf8
BEGIN
	DECLARE custtype varchar(10);
	IF creditlimit<10000 THEN
		SET custtype='SILVER';
	ELSEIF (creditlimit>=10000 and creditlimit<25000) THEN
		SET custtype='GOLD';
	ELSEIF (creditlimit>=25000) THEN
		SET custtype='PLATINUM';
	END IF;
	return custtype;
END$$

DELIMITER ;$$