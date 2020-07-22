package model;
//MODEL LAYER=====> SERVICE CLASS====> BUSINESS LOGIC


public class LoginService
{
	public boolean validation(String user, String password)
	{
		if(user.equals("corona") && password.equals("china"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
