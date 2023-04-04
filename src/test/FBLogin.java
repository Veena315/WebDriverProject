package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("dusa.shivaraj@yahoo.com");
		
		WebElement password = driver.findElement(By.name("pass"));
		password.sendKeys("Shiveen@1705");
		
		WebElement loginBtn = driver.findElement(By.name("login"));
		loginBtn.click();

	}

}
