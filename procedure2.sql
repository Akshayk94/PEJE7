DELIMITER $$;

DROP PROCEDURE IF EXISTS `peje7`.`displaycount`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `displaycount`(IN stream varchar(10), OUT the_count int)
BEGIN
	select count(*) into the_count from student_data where student_stream=stream;
END$$

DELIMITER ;$$