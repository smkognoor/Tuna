package com.system;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.system.ExcelSheetConfigue;

public class Provide{

	WebDriver driver=null;
	
	@Test(dataProvider="wordpress")
	
	public void shashi12(String username, String password) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\new jars\\chromedriver.exe");
	
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		driver.findElement(By.id("user_login")).sendKeys(username);
		
		driver.findElement(By.id("user_pass")).sendKeys(password);
		
		driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
		
		Thread.sleep(3000);
		
		
	}
	
	
	
	@DataProvider(name="wordpress")
	public Object[][] dataAcces(){
		
		ExcelSheetConfigue ec=new ExcelSheetConfigue("C:\\Users\\shashikumar\\Desktop\\shashi\\EXCELLSHEET\\Shashi\\hello.xlsx");
		
		int rows=ec.getRowCount(0);
		
		
		Object[][] data1=new Object[rows][3];
		 int c=2;
		
		for(int i=0;i<rows;i++){
			
			data1[i][0]=ec.getData(0, i, 0);
			
			
			data1[i][0]=ec.getData(0, i, 1);
			
			
		}
		
		return data1;
		
		
	}

}
