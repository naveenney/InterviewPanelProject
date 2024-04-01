package manageinterviewrs;

import java.util.List;
import java.util.Scanner;

import managecompany.CompanyView;
import model.Interviewers;

public class ManageInterViewerView {
	
	ManageInterViewerModel manageInterviewerModel;
	Scanner sc=new Scanner(System.in);
	
	public ManageInterViewerView()
	{
		manageInterviewerModel=new ManageInterViewerModel(this);
	}
	
	public void init()
	{
		boolean flag=true;
		System.out.println("################INTERVIEWER HOME PAGE######################################################################################################################################################################################################################################################################");
		while(flag)
		{
			
			System.out.print("\n\tpress => 1 ADD INTERVIEWER:\n\n\t"+"\n\tPress => 2 REMOVE INTERVIEWER:\n\n\t"+"\n\tPress 3 => REPLACE INTERVIEWER\n\n\t"+"\n\tpress 4=> CHECK INTERVIEWER STATUS\n\n\t"+"\n\tPress 5 => CHANGE INTERVIEWER STATUS\n\n\t"+"\n\tPress => 6 SHOW THE INTERVIEWERLIST\n\n\t"+"\n\tPress => 7.EXIT\n\n\t");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				addInterviewers();
			    break;
			case 2:
				System.out.println("\n\tEnter the interviewer Mail id:");
				String mailId=sc.next();
				manageInterviewerModel.removeInterviewer(mailId);
				break;
				
			case 3:
				System.out.print("\n\tEnter the interviewer Mailid:");
				String mailId1=sc.next();
				System.out.print("\n\tEnter the new Interviewer Name:");
				String name=sc.next();
				System.out.print("\n\tEnter the phoneno:");
				String phoneno=sc.next();
				System.out.print("\n\tEnter the mail Id:");
				String mailid=sc.next();
				
				manageInterviewerModel.replaceInt(mailId1,name,phoneno,mailid);
				break;
				
			case 4:
				System.out.print("\n\tEnter the Interviewer Id To Check status:");
				String mailid2=sc.next();
				System.out.println("INTERVIEWER STATUS:"+manageInterviewerModel.checkInterviewerStaus(mailid2));
				break;
			
			
			case 5:
				System.out.print("\n\tEnter the Interviewer id to change status");
				String mailid3=sc.next();
				
				System.out.print("\n\tEnter the Interviewer Status:");
				String status=sc.next();
				status=status.toUpperCase();
				manageInterviewerModel.changeIntStatus(mailid3, status);
				break;
				
			case 6:
				showDet();
				break;
			
		    case 7:
				flag=false;
				new CompanyView().init();
				break;
			
			}
			
		}
		
	}
	
	public void addInterviewers()
	{

		System.out.print("\n\tINTERVIEWER ID:");
		String id=sc.next();
	    
		System.out.print("\n\tINTERVIEWER NAME:");
		String name=sc.next();
		
		System.out.print("\n\tINTERVIEWER PHONE NUMBER:");
		String phoneno=sc.next();
		
		System.out.print("\n\tINTERVIEWER MAIL ID:");
		String mailId=sc.next();
		
		System.out.print("\n\tINTERVIEWER AVAILABILITY:");
		String availability=sc.next();		
		availability=availability.toUpperCase();
		manageInterviewerModel.setInterviewerDetails(id,name, phoneno, mailId, availability);
		
		
	}
	
	public void showDet()
	{
		List <Interviewers> i=manageInterviewerModel.showDetails();

		if(i!=null)
			{
			    System.out.println("*******************INTERVIEWER DETAILS*********************************************************************************************************************************************************");
			  	
			    
			    for(Interviewers in:i)
				{
					System.out.println("\n\tINTERVIEWER ID      :  "  +in.getInterviewerId()+"\n\tINTERVIEWER NAME    :  "+in.getInterviewerName()+"\n\tINTERVIEWER PHONENO :  "+in.getPhoneNo()+"\n\tINTERVIEWER MAIL ID :  "+in.getMailId()+"\n\tINTERVIEWER STATUS  :  "+in.getAvailability());
					System.out.println("_________________________________________________________________________________________________________________________________________________________________________________________");
				}
			}
		else
		{
			System.out.println("empty first add candidates...");
		}
	}
	
	public void OnSuccess()
	{
		init();
	}
	
	public void alertMse(String mse)
	{
		System.out.println("\n\t*****************"+mse+"*************************");
	}

}
