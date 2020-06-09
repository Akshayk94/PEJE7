package domain;

public class Samsung implements Mobile 
{

	@Override
	public void getOsType() 
	{
		System.out.println("OS TYPE IS ANDROID");
	}

	@Override
	public void getBillAmount(int qty, double price) 
	{
		double totalamount=qty*price;
		
		System.out.println("TOTAL AMOUNT IS "+totalamount);
	}

}
