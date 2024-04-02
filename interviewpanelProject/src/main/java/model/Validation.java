package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import datalayer.DataLayer;

public class Validation {
	
	 public boolean isValidId(int id)
	 {
		return DataLayer.getInstance().checkCandidateId(id);
	 }
   
		public boolean validateName(String name) {
			Pattern p = Pattern.compile("^[A-Za-z]{3,20}$");
			Matcher m = p.matcher(name);

			return m.matches();

		}

		public boolean validatePhoneNo(String phoneno) {
			String regex = "^\\(?(\\d{3})\\)?[-]?(\\d{3})[-]?(\\d{4})$";

			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(phoneno);
			return m.matches() && phoneno.length() == 10;
		}


	   public boolean isValidMail(String email) 
	    { 
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$"; 
	                              
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (email == null) 
	            return false; 
	        return pat.matcher(email).matches(); 
}
	       

}
