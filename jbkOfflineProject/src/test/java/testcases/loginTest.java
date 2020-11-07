package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jbk.basepackage.BaseClass;
import com.jbk.pageObjects.UsefulLinksPage;
import com.jbk.utility.ExtentReporterNG;


public class loginTest extends BaseClass  {
	//ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getObject("LoginPage");
	ExtentTest test2;
	

	@BeforeTest
	public void initialise() throws Exception{
		
		driver = initialization();
		driver.get(prop.getProperty("url"));
	}
	@BeforeClass
	public void createnode(){
		test2=extent.createTest("useful links page");
		test2.createNode("Test cases for useful links page");
	}
	
	@Test(priority = 0)
	public void pageTitle() {
		//ExtentTest test= extent.createTest("pageTitle");
		ExtentTest test=test2.createNode("pageTitle");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertTrue(object.ispageTitleValid(test));
		extent.flush();
		
	}
	@Test(priority = 1)
	public void text_usefulLinks() {
		//ExtentTest test= extent.createTest("text_usefulLinks");
		ExtentTest test=test2.createNode("text_usefulLinks");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertTrue(object.isUsefulLinkTextValid(test));
		extent.flush();
	    }
         	
	@Test(priority = 2)
	public void text_internetRequired() {
		//ExtentTest test= extent.createTest("text_internetRequired");
		ExtentTest test=test2.createNode("text_internetRequired");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertTrue(object.isInternetRequiredTextValid(test));
		extent.flush();
	    }
	
	@Test(priority = 3)
	public void text_copyright() {
		//ExtentTest test= extent.createTest("text_copyright");
		ExtentTest test=test2.createNode("text_copyright");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertTrue(object.isCopyRightTextValid(test));
		extent.flush();
	    }
	
	@Test(priority = 4)
	public void text_designedForSelenium() {
		//ExtentTest test= extent.createTest("pageTitle");
		ExtentTest test=test2.createNode("pageTitle");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertTrue(object.isDesignForTextValid(test));
		extent.flush();
	    }
	
	@Test(priority = 5)
	public void LinksTitle() {
		//ExtentTest test= extent.createTest("LinksTitle");
		ExtentTest test=test2.createNode("LinksTitle");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertTrue(object.isTitleofLinksValid(test));
		extent.flush();
	    }
	
	@Test(priority = 6)
	public void totalLinks() {
		//ExtentTest test= extent.createTest("totalLinks");
		ExtentTest test=test2.createNode("totalLinks");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertTrue(object.isTotalNumberOfLinksValid(test));
		extent.flush();
	    }
	@Test(priority = 7)
	public void brokenLinks() {
		//ExtentTest test= extent.createTest("brokenLinks");
		ExtentTest test=test2.createNode("brokenLinks");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertFalse(object.isThereanyBrokenLink(test));
		extent.flush();
	    }

	@Test(priority = 8)
	public void headers() {
		//ExtentTest test= extent.createTest("headers");
		ExtentTest test=test2.createNode("headers");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertTrue(object.isheadersValid(test));
		extent.flush();
		 }
	
	@Test(priority = 9)
	public void rowsData() {
		//ExtentTest test= extent.createTest("rowsData");
		ExtentTest test=test2.createNode("rowsData");
		UsefulLinksPage object=new UsefulLinksPage(driver);
		Assert.assertTrue(object.isRowDataValid(test));
		extent.flush();
		 }
	
	
	
	@AfterTest
	public void terardown() {
		driver.close();
		
	}
	
}
