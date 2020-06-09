package test;

import java.util.Scanner;

import domain.Vehicle;
import factory.VehicleFactory;

public class VehicleSimulator 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		System.out.println("SELECT VEHICLE TYPE");
		System.out.println("CAR");
		System.out.println("BIKE");
		
		String choice=sc1.next();
		
		VehicleFactory f1=new VehicleFactory();
		
		Vehicle v=f1.getVehicle(choice);
		v.getVehicleType();
		v.getVehiclePrice();
	}
}
