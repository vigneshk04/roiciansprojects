package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basepackage.Baseclass;

public class PomLogin extends Baseclass {
	
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")
	WebElement Username;
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(3) > div > div:nth-child(2) > input")
	WebElement PassWord;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement Loginbtn;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p")
	WebElement ForgetPassword;
	
	public PomLogin() {
		
		PageFactory.initElements(driver, this);
	}
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	public void typepassword(String pass) {
		PassWord.sendKeys(pass);
	}
	public void clickbtn() {
		Loginbtn.click();
	}
	public String verify() {
		return driver.getTitle();
	}

}
