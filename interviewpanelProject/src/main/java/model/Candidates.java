package model;

public class Candidates {
	
	int id;
	
	String name;
	
	String phoneNo;
	
	String mailId;
	
	String address;
	
    String status;
	
	String interViewerId;
	
	public Candidates()
	{
		
	}
	
	public Candidates(int id, String name, String phoneNo, String mailId, String address, String status,String interViewerId) {
		
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.mailId = mailId;
		this.address = address;
		this.status = status;
		this.interViewerId = interViewerId;
	}

	
	public void setCandidateId(int id)
	{
		this.id=id;
	}	
	public void setCandidateName(String name)
	{
		this.name=name;
	}
	
	public void setPhoneNo(String phoneno)
	{
		this.phoneNo=phoneno;
	}
	
	public void setCandidateMailId(String mailId)
	{
		this.mailId=mailId;
	}
	
	public void setCandidateAddress(String address)
	{
		this.address=address;
	}

	public void setCandidateStatus(String status)
	{
		this.status=status;
	}
	
	public void setIntId(String interViewerId)
	{
		this.interViewerId=interViewerId;
	}
	public int getCandidateId()
	{
	   return id;	
	}
	public String getCandidateName()
	{
		return name;
	}
	
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getCandidateMailId()
	{
		return mailId;
	}
	
	public String getCandidateAddress()
	{
		return address;
	}
    
	public String getStatus()
	{
	   return status;	
	}
	
	public String getIntId()
	{
		return interViewerId;
		
	}

	}


