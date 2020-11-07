package com.jbk.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsefulLinksObjectRepository {
	
	@FindBy(xpath="//section[@class='content-header']/h1")
	public WebElement text_usefulLinks;
	
	@FindBy(xpath="//div[@class='box-header']/h3")
	public WebElement text_internetRequired;
	
	@FindBy(xpath="//footer/strong[1]")
	public WebElement text_copyright;
	
	@FindBy(xpath="//footer[@class='main-footer']/div")
	public WebElement text_designedForSelenium;
	
	@FindBy(xpath="//td//a")
	public List<WebElement> listLinks ;
	
	@FindBy(xpath="//tbody/tr/th")
	public List<WebElement> actualHeaders ;
	
	@FindBy(xpath="//tbody/tr/td")
	public List<WebElement> rowsData ;

}
