package com.naveen.interviewpanel;

import login.LogInView;

public class InterviewPanelMain {
	
	String appName="INTERVIEW PANEL APPLICATION";
	String appVersion="1.0.1";
	
	private static InterviewPanelMain interviewpanel; 
	
	public static InterviewPanelMain getInstance()
	{
		if(interviewpanel==null)
		{
			interviewpanel=new InterviewPanelMain();
		}
		return interviewpanel;
	}
	
	public String getappName()
	{
		return appName;
	}
	
	public String getAppVersion()
	{
		return appVersion;
	}
	
	public static void main(String[] args)
	{
		new LogInView().init();
		
	}
	

}