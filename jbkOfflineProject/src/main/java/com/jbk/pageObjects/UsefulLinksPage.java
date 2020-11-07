package com.jbk.pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.jbk.objectRepository.UsefulLinksObjectRepository;
import com.jbk.utility.Expected_ExcelData;




public class UsefulLinksPage extends UsefulLinksObjectRepository {
	WebDriver driver;
	
	
	
	

	public UsefulLinksPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	public boolean isUsefulLinkTextValid(ExtentTest test)
	{   
		
		
		//test.info("isUsefulLinkTextValid test case started");
		test.log(Status.INFO,"isUsefulLinkTextValid test case started");
		
		if(text_usefulLinks.getText().equals("Useful Links")){
			test.pass("isUsefulLinkTextValid test case passed");
			
			test.log(Status.PASS, "isUsefulLinkTextValid test case passed");
			return true;
		}
		else{
			test.fail("isUsefulLinkTextValid test case failed");
			return false;
		}
		
	}
	
	public boolean isInternetRequiredTextValid(ExtentTest test)
	{
		test.info("isInternetRequiredTextValid test case started");
		if(text_internetRequired.getText().equals("* Internet Required")){
			test.pass("isInternetRequiredTextValid test case passed");
			return true;
		}
		else{
			test.fail("isInternetRequiredTextValid test case failed");
			return false;
		}
	}
	
	public boolean isCopyRightTextValid(ExtentTest test)
	{
		test.info("isCopyRightTextValid test case started");
		if(text_copyright.getText().equals("Copyright © 2005-2019 JavaByKiran.")){
			test.pass("isCopyRightTextValid test case passed");
			return true;
		}
		else{
			test.fail("isCopyRightTextValid test case failed");
			return false;
		}
	}
	
	public boolean isDesignForTextValid(ExtentTest test)
	{   
		test.info("isDesignForTextValid test case started");
		if(text_designedForSelenium.getText().equals("Design for Selenium Automation Test V 2.3.0"))
		{
			test.pass("isDesignForTextValid test case passed");
			return true;}
		
		else{
			test.fail("isDesignForTextValid test case failed");
			return false;
		}
	}
	
	public boolean ispageTitleValid(ExtentTest test) {
		test.info("ispageTitleValid test case started");
		String title=driver.getTitle();
		if(title.equals("JavaByKiran | Useful Links")){
			test.pass("ispageTitleValid test case passed");
			return true;
			
		}
		else{
			
			test.fail("ispageTitleValid test case failed");
			return false;
		}
	}
	
public boolean isThereanyBrokenLink(ExtentTest test) {
	test.info("isThereanyBrokenLink test case started");
	 String currentUrl;
	 URL url ;
	 HttpURLConnection conn;
	 boolean flag=false;
	 for(WebElement we:listLinks)
 {
	  currentUrl=we.getAttribute("href");
	  try
	  {
	  url =new URL(currentUrl);
	  conn = (HttpURLConnection) url.openConnection();
	  conn.connect();
	  int respCode=conn.getResponseCode();
	  if(respCode>400){
		  flag=true;
		  break;
	                } 
	  
	  }
	  catch(Exception e)
	     {
		  System.out.println("Http netwrk errror");
		  break;
	      }
 }
	 
	 return flag;
		
	}
	
public boolean isTotalNumberOfLinksValid(ExtentTest test) {
	test.info("isTotalNumberOfLinksValid test case started");
		int totalLinks=listLinks.size();
		if(totalLinks==6){
			test.pass("isTotalNumberOfLinksValid test case passed");
			return true;
		}
		else{
			test.fail("isTotalNumberOfLinksValidd test case failed");
			return false;
		}
	}
	
	public boolean isTitleofLinksValid(ExtentTest test) {
		test.info("isTitleofLinksValid test case started");
		boolean flag=false;
		List<String> exp=null;
		
		try {
			exp = Expected_ExcelData.ExpectedData("titles");
		} 
		catch (Exception e)
		{
			System.out.println("Your Excel not found when accessing for Titles");
		}
		for (int i = 0; i < listLinks.size(); i++) {
			listLinks.get(i).click();
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			String parent = itr.next();
			String child = itr.next();
			driver.switchTo().window(child);
			if(driver.getTitle().equals(exp.get(i+1)))
			{
				test.pass("isTitleofLinksValid test case passed");
				flag=true;
				
			}
			else
			{
				test.fail("isTitleofLinksValid test case failed");
				flag=false;
				break;
			}
			driver.close();
			driver.switchTo().window(parent);
			}
		
		
	
		return flag;
	}
	
	public boolean isheadersValid(ExtentTest test) {
		test.info("isheadersValid test case started");
		boolean flag=false;
		List<String> exp=null;
		try {
			exp = Expected_ExcelData.ExpectedData("headers");
		} 
		catch (Exception e)
		{
			System.out.println("Your Excel not found when accessing for Headers");
		}
		for(int i=0;i<actualHeaders.size();i++){
				if(actualHeaders.get(i).getText().equals(exp.get(i))){
					test.pass("isheadersValid test case passed");
					flag=true;
					
					}
				else{
					test.fail("isheadersValid test case failed");
					flag=false;
					break;
					}
			}
	
		return flag;
		}
	
	public boolean isRowDataValid(ExtentTest test) {
		test.info("isRowDataValid test case started");
		boolean flag=false;
		List<String> exp=null;
		try {
			exp = Expected_ExcelData.ExpectedData("data");
		} 
		catch (Exception e)
		{
			System.out.println("Your Excel not found when accessing for Rows Data");
		}
		for(int i=0;i<rowsData.size();i++){
				if(rowsData.get(i).getText().equals(exp.get(i)))
					
				{
					test.pass("isRowDataValid test case passed");
					
					flag=true;
					}
				else{
					test.fail("isRowDataValid test case failed");
					flag=false;
					break;
					}
			}
	

		
		
		return flag;
		}
	
	
	
}
