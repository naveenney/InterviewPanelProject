package model;

public class Interviewers {

    private String id;
    
	private String name;
	
	private String phoneNo;
	
	private String mailId;
	
	private String availability;
	
    public Interviewers() {
		
	}
	
	
	public Interviewers(String id,String name, String phoneNo, String mailId, String availability) {
        this.id=id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.mailId = mailId;
		this.availability = availability;
	}

    public void setInterviewerId(String id)
    {
    	this.id=id;
    }
	public void setInterviewerName(String name)
	{
		this.name=name;
	}
	
	public void setInterviewerPhoneNo(String phoneno)
	{
		phoneNo=phoneno;
	}
	
	public void setMailId(String mailId)
	{
		this.mailId=mailId;
	}
	public void setInterviewerAvailability(String availability)
	{
		this.availability=availability;
	}
	public String getInterviewerId()
	{
		return id;
	}
	public String getInterviewerName()
	{
		return name;
	}
	public String getPhoneNo()
	{
		return phoneNo;
	}
	
	public String getMailId()
	{
		return mailId;
	}
	
	public String getAvailability()
	{
		return availability;
	}

}



