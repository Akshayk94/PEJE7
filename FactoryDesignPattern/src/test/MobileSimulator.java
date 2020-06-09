package test;

import java.util.Scanner;

import domain.Mobile;
import factory.MobileFactory;

public class MobileSimulator
{
	public static void main(String[] args)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("SELECT MOBILE");
		System.out.println("1: SAMSUNG");
		System.out.println("2: IPHONE");
		
		int choice=sc1.nextInt();
		
		//create an object of factory class
		MobileFactory m1=new MobileFactory();
		Mobile v1=m1.getMobile(choice);
		
		//accept the values from end user
		
		System.out.println("ENTER MOBILE PRICE");
		double price=sc1.nextDouble();
		
		System.out.println("ENTER MOBILE QTY");
		int qty=sc1.nextInt();
		
		//call the methods of business logic classes
		v1.getOsType();
		v1.getBillAmount(qty, price);
	}
}
