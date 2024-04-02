package login;



import datalayer.DataLayer;
import managecompany.CompanyView;

public class LogInModel {
	
	LogInView logInView;
	
	LogInModel(LogInView loginview)
	{
		logInView=loginview;
	}
	
	public void validateAdmin(String username,String password)
	{
		if(DataLayer.getInstance().validateAdmin(username, password))
		{
			logInView.alertMse("LOGIN SUCCESSFULLY");
			if(DataLayer.getInstance().getCompany()==null)
			   logInView.init1();
			else
				new CompanyView().init();
		    
		}
		else
		{
			logInView.alertMse("LOGIN FAILED DUE TO INVALID DETAILS TRY AGAIN");
		    logInView.in();
		}   
	}
	

}
