package test;

//Q.5 product operations with business logic class

import java.util.Scanner;

import domain.ProductDAO;

public class MainApplication 
{
	public static void main(String[] args) 
	{
		Scanner sc1=new Scanner(System.in);
		
		ProductDAO p=new ProductDAO();

		System.out.println("SELECT MODE OF OPERATION");
		System.out.println("1: ADD NEW PRODUCT");
		System.out.println("2: DELETE PRODUCT");
		
		int choice=sc1.nextInt();
		
		switch(choice)
		{
			case 1: System.out.println("ENTER PRODUCT NAME");
			 		String name=sc1.next();
			 		
			 		System.out.println("ENTER PRODUCT PRICE");
			 		double price=sc1.nextDouble();
			 		
			 		p.addProduct(name, price);
			 		
			 		break;
			
			case 2: System.out.println("ENTER PRODUCT ID");
					int id=sc1.nextInt();
					
					p.removeProduct(id);
					
					break;
			
		}
	}
}
