package companysetup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;

import datalayer.DataLayer;
import managecompany.CompanyView;
import model.Company;
import model.Validation;

public class CompanySetupModel {

	CompanySetupView companySetupView;
	private Company c=new Company();;
	CompanySetupModel(CompanySetupView companysetupview)
	{
		companySetupView=companysetupview;
	
	}
	
	public void init()
	{
			if(DataLayer.getInstance().getCompany()==null)
				companySetupView.companySetup();
			else
				new CompanyView().init();
		} 
	
	
	public void setCompanyDetails(String name,String mailId,String phoneno,String address)
	{
		if(!validateCompanyName(name))
		{
			companySetupView.alertMse("INVALID COMPANYNAME TRY AGAIN!!");
			companySetupView.companySetup();
		}
		
		if(!new Validation().isValidMail(mailId))
		{
			companySetupView.alertMse("INVALID MAIL ID TRY AGAIN!!");
		    companySetupView.companySetup();	
		}
		if(!new Validation().validatePhoneNo(phoneno))
		{
		    companySetupView.alertMse("INVALID PHONENO TRY AGAIN!!");
		    companySetupView.companySetup();
		}
		c.setName(name);
		c.setMailId(mailId);
		c.setPhoneno(phoneno);
		c.setAddress(address);
	    DataLayer.getInstance().insertCompany(c);
		companySetupView.alertMse("*************COMPANY SETUP COMPLETED*******************"); 
		companySetupView.OnSucccess();
		 
		
	}
	
	private boolean validateCompanyName(String name)
	{
		Pattern p=Pattern.compile("^[A-Za-z]{0,20}");
		Matcher m=p.matcher(name);
		return m.matches();
	}	
	
	
	
	
}
