package Basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Timeutils;

public class Baseclass {
	public static Properties prop= new Properties();
	public static WebDriver driver;
	
	public Baseclass() {
	
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\vigne\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\config.properties");
		prop.load(file);
		
	}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException a) {
			a.printStackTrace();
		}
		}
public static void initiation() {
	String browsername= prop.getProperty("browser");
	if (browsername.equalsIgnoreCase("chrome")) {
		System.setProperty("WebDriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();}
	else if (browsername.equals("FireFox")) {
		System.setProperty("Webdriver.gecko.driver","geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeutils.timepage));
	driver.get(prop.getProperty("url"));
	}
public static void screenshots(String Filename) {
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	try {
		FileUtils.copyFileToDirectory(file,new File("C:\\Users\\vigne\\eclipse-workspace\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots"+ Filename+".jpj"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
		
		}
