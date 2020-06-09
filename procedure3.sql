DELIMITER $$;

DROP PROCEDURE IF EXISTS `peje7`.`insertdata`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertdata`(IN price double,IN pname varchar(10), IN pprice double, IN tempid int)
BEGIN
	insert into product_data values(0,pname,pprice);
	delete from login_data where id=tempid;
	update product_data set product_price=price where product_id=6;
	select * from flight_data;
END$$

DELIMITER ;$$