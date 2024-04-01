package companysetup;

import java.util.Scanner;

import managecompany.CompanyView;

public class CompanySetupView {
	
	CompanySetupModel companySetupModel;
	
	public CompanySetupView()
	{
		companySetupModel=new CompanySetupModel(this);
	}
   
	public void init()
	{
		companySetupModel.init();
	}
	public void companySetup()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.print("\n\tEnter the Company Name:");
		String companyName=sc.nextLine();
		
		System.out.print("\n\tEnter the Company Email id:");
		String mailId=sc.nextLine();
		
		System.out.print("\n\tEnter the Company PhoneNo:");
		String phoneno=sc.nextLine();
		
		System.out.print("\n\tEnter the address:");
		String address=sc.nextLine();
		
		
		companySetupModel.setCompanyDetails(companyName, mailId, phoneno, address);
		
		
	}
	
	public void OnSucccess()
	{
		new CompanyView().init();
	}
	
	public void alertMse(String mse)
	{
		System.out.println("\n\t***************"+mse+"******************");
	}
	
}
