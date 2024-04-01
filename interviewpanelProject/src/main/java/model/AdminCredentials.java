package model;

public class AdminCredentials {
	
	String userName;
	String passWord;
	
	public AdminCredentials()
	{
		userName="Zsgs";
		passWord="admin";
	}
	
	public void setUserName(String username)
	{
		userName=username;
	}

	public void setPassWord(String password)
	{
		passWord=password;
		
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassWord()
	{
		return passWord;
	}
	
	
}
