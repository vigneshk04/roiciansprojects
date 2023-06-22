package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Basepackage.Baseclass;
import pompackage.PomLogin;
import testdata.Excelsheet;

public class LoginTest extends Baseclass{
	PomLogin Log;
	public LoginTest() {
		
		super();
		}
	@BeforeMethod
	public void initsetup() {
		initiation();
	
		 Log=new PomLogin();
	}
	@Test(priority=1)
	public void Title () throws InterruptedException {
		
		String actual=Log.verify();
		Assert.assertEquals(actual,"OrangeHRM");
		System.out.println(actual);
		Thread.sleep(3000);
		screenshots("login");
		
	}
	@DataProvider
	public Object[][] Details(){
		Object result[][]=Excelsheet.readdata("Sheet1");
		return result;
		
		
	}
	@Test(priority=2, dataProvider="Details")
	public void Login(String name,String password) throws InterruptedException {
		
		Log.typeusername(name);
		Log.typepassword(password);
		Thread.sleep(3000);
		screenshots("login");
		//Log.clickbtn();
		
		}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
