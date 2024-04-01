package managecompany;

import java.util.Scanner;

import login.LogInView;
import managecandidates.ManageCandidateView;
import manageinterviewrs.ManageInterViewerView;

public class CompanyView {

	   CompanyModel companyModel;
	   
	   public CompanyView()
	   {
		   companyModel=new CompanyModel(this);
	   }
	   
	   public void init()
	   {
		   Scanner sc=new Scanner(System.in);
		   
		   boolean flag=true;
		   System.out.println("\n************************HOME PAGE*****************************************************************************************");
		   while(flag)
		   {
			   
			   System.out.print("\n\t1.MANAGE CANDIDATES\n\n\t"+"\n\t2.MANAGEINTERVIEWER\n\n\t"+"\n\t3.LOGOUT\n\n\t");
			   int choice=sc.nextInt();
			   
			   switch(choice)
			   {
			      case 1:
			    	  new ManageCandidateView().init();
			    	  break;
			      case 2:
			    	   new ManageInterViewerView().init();
			    	   break;
			      case 3:
			    	   flag=false;
			    	   new LogInView().init();
			    	   break;
			    	  			   
			   }
		   }
			   
		   
		   
	   }
}
