package login;

import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.naveen.interviewpanel.InterviewPanelMain;

import companysetup.CompanySetupView;

public class LogInView {
	
	LogInModel loginModel;
	
	public LogInView()
	{
		loginModel=new LogInModel(this);
	}
	
	public void in()
	{
		Scanner sc=new Scanner(System.in);
		 System.out.print("\n\tEnter the Username:");
		  String username=sc.nextLine();
		  
		  System.out.print("\n\tEnter the password:");
		  String password=sc.nextLine();
		  
		 	loginModel.validateAdmin(username, password);
		 
		
	}
	public void init() 
	{
	  System.out.println("\n\t**********WELCOME TO  "+InterviewPanelMain.getInstance().getappName()+"*********"+"\n\n\t\t\t****"+InterviewPanelMain.getInstance().getAppVersion()+"****");	
	  Scanner sc=new Scanner(System.in);
	  
	  System.out.print("\n\tEnter the Username:");
	  String username=sc.nextLine();
	  
	  System.out.print("\n\tEnter the password:");
	  String password=sc.nextLine();
	  
	 	loginModel.validateAdmin(username, password);
	  
	  
	}
	
	public void init1()
	{
		new CompanySetupView().companySetup();
	}
	
   
	public void alertMse(String mse)
	{
		System.out.println("\n\t****************"+mse+"*****************");
	}
}
