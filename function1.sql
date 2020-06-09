DELIMITER $$;

DROP FUNCTION IF EXISTS `peje7`.`multiplynumbers`$$

CREATE DEFINER=`root`@`localhost` FUNCTION `multiplynumbers`(no1 double, no2 double) RETURNS double
BEGIN
		return no1*no2;
END$$

DELIMITER ;$$