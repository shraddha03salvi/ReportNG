package com.Testing_Pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Reportngtest2 {

	WebDriver driver;

	@BeforeTest
	public void setup() throws Exception
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://only-testing-blog.blogspot.in/2014/04/calc.html");
	}

	@Test(priority = 1)
	public void mul_Test() {
		driver.findElement(By.xpath("//input[@id='Resultbox']")).clear();
		driver.findElement(By.xpath("//input[@id='5']")).click();
		driver.findElement(By.xpath("//input[@id='multiply']")).click();
		driver.findElement(By.xpath("//input[@id='4']")).click();
		driver.findElement(By.xpath("//input[@id='equals']")).click();
		String Result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
		int ResultInt = Integer.parseInt(Result);
		Assert.assertEquals(20, ResultInt);
	}

	@Test(priority = 2)
	public void div_Test() 
	{
		driver.findElement(By.xpath("//input[@id='Resultbox']")).clear();
		driver.findElement(By.xpath("//input[@id='9']")).click();
		driver.findElement(By.xpath("//input[@id='divide']")).click();
		driver.findElement(By.xpath("//input[@id='3']")).click();
		driver.findElement(By.xpath("//input[@id='equals']")).click();
		String Result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
		int ResultInt = Integer.parseInt(Result);
		Assert.assertEquals(3, ResultInt);
	}

	@AfterTest
	public void Close() throws Exception
	{
		driver.quit();
	}

}
