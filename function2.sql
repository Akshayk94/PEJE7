DELIMITER $$;

DROP FUNCTION IF EXISTS `peje7`.`areacircle`$$

CREATE FUNCTION `peje7`.`areacircle` (radius double)
	RETURNS double
BEGIN
	DECLARE result double;

	SET result=3.14*radius*radius;

	return result;
END$$

DELIMITER ;$$

select areacircle(2)