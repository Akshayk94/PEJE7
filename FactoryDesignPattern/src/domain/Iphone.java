package domain;

public class Iphone implements Mobile 
{

	@Override
	public void getOsType() 
	{
		System.out.println("OS TYPE IS IoS");
	}

	@Override
	public void getBillAmount(int qty, double price) 
	{
		double totalamount=qty*price;
		
		System.out.println("TOTAL AMOUNT IS "+totalamount);
	}

}
