package factory;

import domain.Iphone;
import domain.Mobile;
import domain.Samsung;

public class MobileFactory //factory class
{
	public Mobile getMobile(int mobiletype)//factory method
	{
		Mobile m1=null;
		switch(mobiletype)
		{
			case 1: m1=new Samsung();
					break;
			
			case 2: m1=new Iphone();
					break;
		}
		
		return m1;
	}
}	
