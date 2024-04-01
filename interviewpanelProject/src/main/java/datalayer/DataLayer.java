package datalayer;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.AdminCredentials;
import model.Candidates;
import model.Company;
import model.Interviewers;

public class DataLayer {

	private AdminCredentials adc;
	private String companyFile = "company.json";
	private String candidateFile = "candidate.json";
	private String interviewersFile = "interviewers.json";

	private List<Candidates> candidateList = new ArrayList<>();

	private List<Interviewers> interviewersList=new ArrayList<>();;

	// private Company company;

	private static DataLayer d;

	private DataLayer() {
		adc = new AdminCredentials();

	}

	public static DataLayer getInstance() {
		if (d == null)
			d = new DataLayer();
		return d;
	}

	public boolean validateAdmin(String username, String password) {
		if (validateAdminUserName(username) && validateAdminPassWord(password)) {
			return true;
		}
		return false;
	}

	private boolean validateAdminUserName(String username) {
		return username.equals(adc.getUserName());
	}

	private boolean validateAdminPassWord(String password) {
		return password.equals(adc.getPassWord());
	}

	public Candidates verifyCandidate(int id) {
		ObjectMapper obj=new ObjectMapper();
		File file=new File(candidateFile);
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  
		if(file.exists())
		{
			
	        if(file.length()>0)
	        {
	        	try {
					candidateList=obj.readValue(file,new TypeReference<List<Candidates>> () {});
				} catch (Exception e) {
				
					e.printStackTrace();
				}
	        	for(Candidates c:candidateList)
	        	{
	        		if(id==c.getCandidateId())
	        		{
	        			return c;
	        		}
	        	}
	        }
		}
		return null;
	
	}

	public void insertCompany(Company c) {
		ObjectMapper companyMap = new ObjectMapper();
		try {
			File fileCompany = new File(companyFile);
			if (!fileCompany.exists()) {
				fileCompany = new File(companyFile);
			}

			companyMap.enable(SerializationFeature.INDENT_OUTPUT);
			companyMap.writeValue(fileCompany, c);
		} catch (Exception e) {
		
		}

	}

	public Company getCompany() {
		ObjectMapper companyMap = new ObjectMapper();

		try {
			return companyMap.readValue(new File(companyFile), Company.class);
		} catch (Exception e) {
			return null;
		}

	}

	public boolean addCandidate(Candidates c) {
		ObjectMapper obj = new ObjectMapper();
		File file = new File(candidateFile);
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			if (!file.exists())
				file.createNewFile();
			if (file.length() > 0) {
				candidateList = obj.readValue(file, new TypeReference<List<Candidates>>() {
				});
				for (Candidates c1 : candidateList) {
					if (c.getCandidateMailId().equals(c1.getCandidateMailId())) {
						return true;
					}
				}

				candidateList.add(c);
				obj.enable(SerializationFeature.INDENT_OUTPUT);
				obj.writeValue(file, candidateList);
				return false;
			} else {
				candidateList.add(c);
				obj.enable(SerializationFeature.INDENT_OUTPUT);
				obj.writeValue(file, candidateList);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean addInterviewer(Interviewers i) {
		ObjectMapper obj = new ObjectMapper();

		File file = new File(interviewersFile);
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			if (file.length() > 0) {
				interviewersList = obj.readValue(new File(interviewersFile), new TypeReference<List<Interviewers>>() {
				});

				for (Interviewers in : interviewersList) {
					if (i.getMailId().equals(in.getMailId())) {
						return true;
					}

				}
				interviewersList.add(i);
				obj.enable(SerializationFeature.INDENT_OUTPUT);
				obj.writeValue(file, interviewersList);
				return false;
			} else {
				interviewersList.add(i);
				obj.enable(SerializationFeature.INDENT_OUTPUT);
				obj.writeValue(file, interviewersList);
				return false;
			}

		} catch (Exception e) {
			return false;
		}

	}

	public boolean removeCandidate(int id) {

		ObjectMapper obj=new ObjectMapper();
		
		File file=new File("candidate.json");
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		
		if(file.exists())
		{
			if(file.length()>0)
			{
				try {
					candidateList=obj.readValue(file,new TypeReference<List<Candidates>> () {});
					
					for(Candidates c:candidateList)
					{
						if(id==c.getCandidateId())
							candidateList.remove(c);
						obj.writeValue(file,interviewersList);
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
			
		   }
		return false;

	}

	public boolean removeInterviewer(String mailId) {
		ObjectMapper obj = new ObjectMapper();
		File file = new File(interviewersFile);
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		if (file.exists()) {
			if (file.length() > 0) {
				try {
				   interviewersList=obj.readValue(file,new TypeReference<List<Interviewers>> () {});
					for (Interviewers i : interviewersList) {
						if (mailId.equals(i.getMailId())) {
							interviewersList.remove(i);
								obj.writeValue(file,interviewersList);
							
								
								return true;
							}
							
						}
					}
				
				 catch (Exception e) {
					e.printStackTrace();
				}
				}
		}
				return false;

			}

	public boolean replaceInterviewer(String mailid, String newInterviewerName, String phoneno, String mailId) {
		
		ObjectMapper obj=new ObjectMapper();
		File file=new File(interviewersFile);
		 obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		 
		if(file.exists())
		{  
			if(file.length()>0)
			{
		       try {
				interviewersList=obj.readValue(file,new TypeReference<List<Interviewers>> () {});
				for (Interviewers i : interviewersList) {
					if (i.getMailId().equals(mailid)) {
						i.setInterviewerName(newInterviewerName);
						i.setInterviewerPhoneNo(phoneno);
						i.setMailId(mailId);
						obj.writeValue(file,interviewersList);
						return true;
					}
				}
		       
		       } catch (Exception e) {
				e.printStackTrace();
			}
		}
			}
		return false;
		}

	public List<Interviewers> showInterviewersList() {
		
	      ObjectMapper obj=new ObjectMapper();
	  	 
	      File file1=new File(interviewersFile);
	      obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	      if(file1.exists())
	      {
	    	  if(file1.length()>0)
	    	  {
	    		  try {
					return interviewersList=obj.readValue(file1,new TypeReference<List<Interviewers>> () {});
				} catch (Exception e) {
					e.printStackTrace();
				}
	    		  
	    	  }
	    	  
	      }
	      return null;
	}

	public List<Candidates> showCandidatesList() {
		ObjectMapper obj = new ObjectMapper();

		File file1 = new File("candidate.json");
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		  
		if (file1.exists()) {
			if (file1.length() > 0) {
				try {
					return candidateList=obj.readValue(file1, new TypeReference<List<Candidates>>() {});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} 
			return null;
		

	}

	public String checkCandidateStatus(int id) {
		ObjectMapper obj = new ObjectMapper();

		File file = new File(candidateFile);
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


		if (file.exists()) {
			if (file.length() > 0) {
				try {
					candidateList = obj.readValue(file, new TypeReference<List<Candidates>>() {
					});

					for (Candidates c : candidateList) {
						if (c.getCandidateId() == id)
							return c.getStatus();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
		return null;
	}

	public String checkInterviewerStatus(String id) {
		ObjectMapper obj = new ObjectMapper();

		File file = new File("interviewers.json");
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


		if (file.exists()) {
			if (file.length() > 0) {
				try {
					interviewersList = obj.readValue(file, new TypeReference<List<Interviewers>>() {
					});
					for (Interviewers i : interviewersList) {
						if(id.equals(i.getInterviewerId()))
							return i.getAvailability();

						}
					}
				 catch (Exception e) {
					e.printStackTrace();
				}

			} 	}
		
			return "NULL";

	}

	public boolean changeInterviewerStatus(String id, String status) {
		ObjectMapper obj = new ObjectMapper();

		File file1 = new File(interviewersFile);
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		if (file1.exists()) {
			try {
				interviewersList = obj.readValue(file1, new TypeReference<List<Interviewers>>() {
				});
				for (Interviewers i : interviewersList) {
					if (id.equals(i.getInterviewerId())) {
								i.setInterviewerAvailability(status);
								obj.writeValue(file1, interviewersList);
								return true;
						
							}

						}
			} catch (Exception e) {
				e.printStackTrace();
			}

			}
		return false;
		}
	

	public boolean checkCandidateId(int id)
	{
		for(Candidates c:candidateList)
		{
			if(c.getCandidateId()==id)
				return false;
		}
		return true;
	}

	public boolean changeCandidateStatus(int id,String status)
	{
		ObjectMapper obj=new ObjectMapper();
		
		File file=new File(candidateFile);
		obj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		
		if(file.exists())
		{
			if(file.length()>0)
			{
				try {
					candidateList=obj.readValue(file,new TypeReference<List<Candidates>> () {});
					for(Candidates c:candidateList)
					{
						if(id==c.getCandidateId())
						{
							c.setCandidateStatus(status);
							obj.writeValue(file,candidateList);
						    return true;
						}
					}
				
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	    }
		return false;
	}
	
	
	
	
	
}

	
