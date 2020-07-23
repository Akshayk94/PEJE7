package model;

//MODEL LAYER======> SERVICE CLASS======> BUSINESS LOGIC
public class CabService 
{
	public double autoBill(double km, int minutes)
	{
		double basicAmount=km*6;
		
		double watingcharge=minutes*2;
		
		double finalAmount=basicAmount+watingcharge;
		
		return finalAmount;
	}
	
	public double primeBill(double km, int minutes)
	{
		double basicAmount=km*10;
		
		double watingcharge=minutes*2;
		
		double finalAmount=basicAmount+watingcharge;
		
		return finalAmount;
	}
	
	public double miniBill(double km, int minutes)
	{
		double basicAmount=km*8;
		
		double watingcharge=minutes*2;
		
		double finalAmount=basicAmount+watingcharge;
		
		return finalAmount;
	}
}
