DELIMITER $$;

DROP PROCEDURE IF EXISTS `peje7`.`deleteproduct`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteproduct`(id int)
BEGIN
	delete from product_data where product_id=id;
END$$

DELIMITER ;$$