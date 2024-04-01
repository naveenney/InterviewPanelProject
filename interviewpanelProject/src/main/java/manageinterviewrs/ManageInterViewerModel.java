package manageinterviewrs;

import java.util.List;

import datalayer.DataLayer;
import model.Interviewers;
import model.Validation;

public class ManageInterViewerModel {
	
   ManageInterViewerView manageInterViewerView;
   private Validation val=new Validation();
   Interviewers i;
   
   ManageInterViewerModel(ManageInterViewerView manageinterviewerview)
   {
	   manageInterViewerView=manageinterviewerview;
	  
   }
   
   public void setInterviewerDetails(String id,String name,String phoneno,String mailid,String availability)
   {   
	   	i=new Interviewers(id,name,phoneno,mailid,availability);
		 if(!val.validateName(name))
		 {
			 manageInterViewerView.alertMse("INVALID NAME TRY AGAIN");
			 manageInterViewerView.addInterviewers();;
		 }
		 if(!val.validatePhoneNo(phoneno))
		 {
			 manageInterViewerView.alertMse("INVALID PHONE NUMBER TRY AGAIN");
			 manageInterViewerView.addInterviewers();;
		
		 }
		 
		 if(!val.isValidMail(mailid))
		 {
			 manageInterViewerView.alertMse("INVALID MAIL ID TRY AGAIN");
			 manageInterViewerView.addInterviewers();;
			 
		 }
		 if(addInt(i))
		 {
			 manageInterViewerView.alertMse("DUBLICATE FOUND TRY AGAIN");
			 manageInterViewerView.addInterviewers();
		 }
		 else
		 {  
			 addInt(i);
		    manageInterViewerView.alertMse("INTERVIEWER ADDED SUCCESSFULLY");
		    manageInterViewerView.OnSuccess();
		 }
   }
   
   public void removeInterviewer(String mailid)
   {
	   if(removeInt(mailid))
	   {
	       manageInterViewerView.alertMse("INTERVIEWER REMOVED SUCCESSFULLY");
	       manageInterViewerView.init();   
	   }
	   else
	   {
		   manageInterViewerView.alertMse("SOMETHING WRONG");
		   manageInterViewerView.init();
	   }
	       
   }
   public boolean addInt(Interviewers i)
   {
	   return DataLayer.getInstance().addInterviewer(i);
   }
   public List<Interviewers> showDetails()
   {
	   return DataLayer.getInstance().showInterviewersList();
   }
   
   public boolean removeInt(String mailid)
   {
	   return DataLayer.getInstance().removeInterviewer(mailid);
   }
   
   public void replaceInt(String mailId,String name,String phoneno,String mailid)
   {
	   if(replaceInterViewer(mailId,name,phoneno,mailid))
	   {
		   manageInterViewerView.alertMse("INTERVIEWER REPLACED SUCCESSFULLY");
	       manageInterViewerView.init();
	   }
	   else
	   {
		   manageInterViewerView.alertMse("SOMETHING WRONG");
		   manageInterViewerView.init();
	   }
        
   }
   public boolean replaceInterViewer(String mailId,String name,String phoneno,String mailid)
   {
	   return DataLayer.getInstance().replaceInterviewer(mailId,name,phoneno,mailid);
   }
   
   public String checkInterviewerStaus(String mailId)
   {
	   return DataLayer.getInstance().checkInterviewerStatus(mailId);
   }
   
   public void changeIntStatus(String mailId,String status)
   {
	   if(changeInterviewerStatus(mailId,status))
	   {
		   manageInterViewerView.alertMse("INTERVIEWER STATUS CHANGED SUCCESSFULLY");
		   manageInterViewerView.init();
	   }
	   else
	   {
		   manageInterViewerView.alertMse("SOMETHING WRONG");
		   manageInterViewerView.init();
	   }
   }
   public boolean changeInterviewerStatus(String mailid,String status)
   {
	   return DataLayer.getInstance().changeInterviewerStatus(mailid,status);
   }
}
