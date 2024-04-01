package managecandidates;

import java.util.List;

import datalayer.DataLayer;
import managecompany.CompanyView;
import model.Candidates;
import model.Validation;

public class ManageCandidateModel {
	
	 ManageCandidateView manageCandidateView;
	 Validation val;
	 private Candidates c;
	 
	 ManageCandidateModel(ManageCandidateView manageCandidateView)
	 {
		this.manageCandidateView=manageCandidateView; 
		val=new Validation();
		
	 }
	 								
	 public void setCandidateDetails(int id,String name,String phoneno,String mailid,String address,String status,String intId)
	   {
		     c=new Candidates(id,name,phoneno,mailid,address,status,intId);
		    
		     if(validateCanDetails(id,name,phoneno,mailid))
		     {	 
			 if(addCan(c))
			 {
				 manageCandidateView.alertMse("DUBLICATE FOUND TRY AGAIN");
			     manageCandidateView.addCandidates();
			 }
			 else
			 {   
				 manageCandidateView.alertMse("CANDIDATE ADDED SUCCESSFULLY");
				 manageCandidateView.init();
			
				 }
		     }
		     else
		    	 manageCandidateView.addCandidates();
		
	   }
	 private boolean validateCanDetails(int id,String name,String phoneno,String mailId)
	 {
		 if(!val.validateName(name))
		 {   
			 manageCandidateView.alertMse("INVALID NAME TRY AGAIN");
			 return false;
		 }
		 if(!val.validatePhoneNo(phoneno))
		 {
			 manageCandidateView.alertMse("INVALID PHONENO TRY AGAIN");
			 return false;
		 }
			
		 if(!val.isValidId(id))
		 {
			 manageCandidateView.alertMse("INVALID DETAI TRY AGAIN");
			 return false;
		 }
		 if(!val.isValidMail(mailId))
		 {
			 manageCandidateView.alertMse("INVALID MAIL ID");
			 return false;
		 }
		   return true; 	
		 
		 
	 }
	 private boolean addCan(Candidates c)
	 {
		 return DataLayer.getInstance().addCandidate(c);
	 }
	 public void verifyCandidate(int id)
	 {
		c=DataLayer.getInstance().verifyCandidate(id);
		 
		 if(c!=null)
		 {     
			   manageCandidateView.showTheCandidate(c);
		       manageCandidateView.alertMse("CANDIDATE VERIFICATION COMPLETED");
		       manageCandidateView.init();
		 } 
		 else
		 {
			 manageCandidateView.alertMse("CANDIDATE NOT IN THE LIST");
			 manageCandidateView.init();
		 }
	 }
	   
	public List<Candidates> showCandidateList()
	 {
		return DataLayer.getInstance().showCandidatesList();
	 }
	 
	public void removeCandidate(int id)
	{
		if(removeCand(id))
		{
			manageCandidateView.alertMse("CANDIDATE REMOVED SUCCESSFULLY");
		    manageCandidateView.init();	
		}
		else
		{
			manageCandidateView.alertMse("SOMETHING WRONG");
		    manageCandidateView.init();
		}
	}
	 public boolean removeCand(int id)
	 {
		 return DataLayer.getInstance().removeCandidate(id);
		 
	 }
	
	 public void checkCandidateStatus(int id)
	 {
		 manageCandidateView.alertMse(DataLayer.getInstance().checkCandidateStatus(id));
		 manageCandidateView.init();
	 }
	 
	 public void changeStatus(int id,String status)
	 {
		 if(changeStat(id,status))
		 {
			 manageCandidateView.alertMse("CHANGED CANDIDATE STATUS SUCCESSFULLY");
			 manageCandidateView.init();
		 }
		 else
		 {
			 manageCandidateView.alertMse("SOMETHING WRONG");
			 manageCandidateView.init();
		 }
	 }
	  
	 public boolean changeStat(int id,String status)
	 {
		 return DataLayer.getInstance().changeCandidateStatus(id,status);
	 }
}

