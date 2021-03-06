package com.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RodanFieldsTest {

	WebDriver driver;
	
	@BeforeMethod
	public void testBegin(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	
	@Test(priority=1)
	public void testRodanFieldsMethod(){
						
		driver.get("https://www.rodanandfields.com/ca");
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='hidden-xs']/div[@class='container-fluid black-nav']//a[@id='corp-opp']"))).build().perform();
		driver.findElement(By.linkText("ENROLL NOW")).click();
		
		driver.findElement(By.xpath("//input[@id='sponserparam']")).sendKeys("mary");
		driver.findElement(By.xpath("//*[@id='search-sponsor-button']")).click();
		
		driver.findElement(By.xpath("//*[@id='sponsorPage']//a[@class='next']")).click();
		
		String page=driver.findElement(By.xpath("//*[@id='sponsorPage']//span[text()='2']")).getText();
		System.out.println(page);
		Assert.assertEquals(page, "2");
			    
	}
	
	
	@Test(priority=2)
	public void testSkincareProducts() throws InterruptedException{
						
		driver.get("https://www.rodanandfields.com/ca");
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='hidden-xs']/div[@class='container-fluid black-nav']//a[@id='our-products']"))).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dropdown-menu']/li[7]/div/a")).click();
	
		driver.findElement(By.xpath("//*[@id='quick-refine']//input[@value='- Price -']")).click();
		driver.findElement(By.xpath("//*[@id='quick-refine']/div[2]/div[2]/ul/li[2]/form/div/div[1]/div[2]/div")).click();
//		String costOfFirstProdct=driver.findElement(By.xpath("//*[@id='main-content']//span[text()='CAD$ 71.00']")).getText();
//		System.out.println(costOfFirstProdct);
		//Assert.assertTrue(condition);
		String costText=driver.findElement(By.xpath("//label[text()='CAD$50 TO CAD$199.99']")).getText();
		Assert.assertEquals(costText, "CAD$50 TO CAD$199.99");
		driver.findElement(By.xpath("//*[@id='sortOptions']")).click();
		driver.findElement(By.xpath(".//*[@id='sortOptions']/option[3]")).click();
		
		//Assert.assertTrue(condition);
		
		
		
	}
	
	
	@AfterMethod
	public void testEnd(){
		driver.close();
	}
	
	
}
