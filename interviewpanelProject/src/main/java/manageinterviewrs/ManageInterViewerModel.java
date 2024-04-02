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
   
   public void replaceInt(String id,String name,String phoneno,String mailid)
   {
	   if(replaceInterViewer(id,name,phoneno,mailid))
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
   public boolean replaceInterViewer(String id,String name,String phoneno,String mailid)
   {
	   return DataLayer.getInstance().replaceInterviewer(id,name,phoneno,mailid);
   }
   
   public String checkInterviewerStaus(String id)
   {
	   return DataLayer.getInstance().checkInterviewerStatus(id);
   }
   
   public void changeIntStatus(String id,String status)
   {
	   if(changeInterviewerStatus(id,status))
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
