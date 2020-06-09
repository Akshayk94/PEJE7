package domain;

public class Bike implements Vehicle //ConnectionImpl
{

	@Override
	public void getVehicleType() 
	{
		System.out.println("VEHICLE TYPE IS BIKE");
	}

	@Override
	public void getVehiclePrice() 
	{
		System.out.println("VEHICLE PRICE IS 100000 Rs");
		
	}

}
