package managecandidates;

import java.util.List;
import java.util.Scanner;

import managecompany.CompanyView;
import model.Candidates;

public class ManageCandidateView {
	 
	ManageCandidateModel manageCandidateModel;
	Scanner sc=new Scanner(System.in);
	
	public ManageCandidateView()
	{
	    manageCandidateModel=new ManageCandidateModel(this);
	}
	
	public void init()
	{
		boolean flag=true;
		System.out.println("\n\n############CANDIDATE HOME PAGE##################################################################################################################################################################################################################################################################################################################\n\n");
		while(flag)
		{
			   System.out.print("\n\tPress 1 => ADD CANDIDATE\n\n\t"+"\n\tPress 2 => REMOVE CANDIDATE\n\n\t"+"\n\tPress 3 => CHECK CANDIDATE STATUS\n\n\t"+"\n\tPress 4 => CHANGE CANDIDATE STATUS\n\n\t"+"\n\tPress 5 => SHOW CANDIDATE LIST\n\n\t"+"\n\tPress => 6.CANDIDATE INFO\n\n\t"+"\n\tPress => 7.EXIT\n\n\t");
	           int choice=sc.nextInt();
	    		 
		     switch(choice)
		     {
		     case 1:
		    	  addCandidates();
		    	  break;
		     case 2:
		    	 System.out.print("\n\tEnter the Candidate id:");
		    	 int id=sc.nextInt();
		    	  manageCandidateModel.removeCandidate(id);
		    	  break; 
		     case 3:
		    	  System.out.print("\n\tEnter candidate id to check Status:");
		    	  int id1=sc.nextInt();
		    	  manageCandidateModel.checkCandidateStatus(id1);
		          break;
		     case 4:
		    	  System.out.print("\n\tEnter the Candidate id to change the status:");
		    	  int id2=sc.nextInt();
		    	  sc.nextLine();
		    	  System.out.print("\n\tEnter the status:");
		    	  String status1=sc.nextLine();
		    	  manageCandidateModel.changeStatus(id2,status1);
		    	  break;
		     case 5:
		    	  showCanList();
		    	  break;
		    	  
		     case 6:
		    	  System.out.print("\n\tEnter the CandidateId:");
		    	  int id4=sc.nextInt();
		    	  
		    	  manageCandidateModel.verifyCandidate(id4);
		    	  break;
		     case 7:
		    	  flag=false;
		    	  new CompanyView().init();
		    	  break;
		    	  
		     }	 
	}
		    	 
		    		 
	}
	public void addCandidates()
	{
	 	
	 	System.out.print("\n\tEnter the candidate Id:");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.print("\n\tEnter the Candidate Name:");
		String name=sc.nextLine();
		System.out.print("\n\tEnter the Candidate Phone number(TEN NUMBERS):");
		String phoneno=sc.nextLine();
		
		System.out.print("\n\tEnter the Mail Id:");
		String mailId=sc.nextLine();
		
		System.out.print("\n\tEnter the address:");
		String address=sc.nextLine();
		
		System.out.print("\n\tEnter the Status:");
		String status=sc.nextLine();
		status=status.toUpperCase();
		System.out.print("\n\tEnter the interviewer id:");
		String intId=sc.nextLine();
		manageCandidateModel.setCandidateDetails(id,name,phoneno,mailId,address,status,intId);
	 }
	
	public void OnSuccess()
	{
		new CompanyView().init();
	}
	
	public void showTheCandidate(Candidates c)
	{
		System.out.println("******************CANDIDATE INFO********************************************************************************************************************************************************************************************************************************************");

		System.out.println("\n\tCANDIDATE ID      :   "+c.getCandidateId()+"\n\tCANDIDATE NAME    :  "+c.getCandidateName()+"\n\tCANDIDATE PHONE NO:  "+c.getPhoneNo()+"\n\tCANDIDATE MAIL ID :  "+c.getCandidateMailId()+"\n\tCANDIDATE STATUS  :  "+c.getStatus()+"\n\tCANDIDATE ADDRESS :  "+c.getCandidateAddress()+"\n\tINTERVIEWER ID    :    "+c.getIntId());
	    
	    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
	}
	public void showCanList()
	{
		List<Candidates> l=manageCandidateModel.showCandidateList();
		if(l!=null)
		{
		System.out.println("******************CANDIDATE DETAILS********************************************************************************************************************************************************************************************************************************************");
		for(Candidates c:l)
		{
			System.out.println("\n\tCANDIDATE ID      :   "+c.getCandidateId()+"\n\tCANDIDATE NAME    :  "+c.getCandidateName()+"\n\tCANDIDATE PHONE NO:  "+c.getPhoneNo()+"\n\tCANDIDATE MAIL ID :  "+c.getCandidateMailId()+"\n\tCANDIDATE STATUS  :  "+c.getStatus()+"\n\tCANDIDATE ADDRESS :  "+c.getCandidateAddress()+"\n\tINTERVIEWER ID    :    "+c.getIntId());
		    System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		}
		}
		else
			System.out.println("CandidateList Is Empty");
	}
	public void alertMse(String mse)
	{
	  	
		System.out.println("***************************"+mse+"*******************************************************************************************************************************************************************************************************************************************************");
	}

}
