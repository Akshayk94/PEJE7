package domain;

public class Car implements Vehicle 
{

	@Override
	public void getVehicleType() 
	{
		System.out.println("VEHICLE TYPE IS CAR");
	}

	@Override
	public void getVehiclePrice()
	{

		System.out.println("VEHICLE PRICE IS 1000000 Rs");
	}

}
