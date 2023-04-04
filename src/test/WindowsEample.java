package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsEample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement newTab = driver.findElement(By.id("tabButton"));
		String ParentWin = driver.getWindowHandle();
		System.out.println("The Parent window ID is "+ParentWin);
		newTab.click();
		
		Set<String> AllWin = driver.getWindowHandles();
		String ChildWin = "";
		
		for(String Win : AllWin) {
			
			
			if(!Win.equals(ParentWin)) {
				
				ChildWin = Win;
			}
			System.out.println("The window ID is "+Win);
		}
		
		System.out.println("Child win is " + ChildWin);
		
		driver.switchTo().window(ChildWin);
		
		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in child win is " + childHeader.getText());
		
		driver.close();
		
		driver.switchTo().window(ParentWin);
		
		WebElement ParentTab = driver.findElement(By.id("windowButton"));
		
		String newChildWin = driver.getWindowHandle();
		System.out.println("The new child window ID is "+newChildWin);
		ParentTab.click();
		
		AllWin = driver.getWindowHandles();
		for(String Win : AllWin) {
			System.out.println("The window ID is "+Win);
			
			if(!Win.equals(ParentWin)) {
				
				newChildWin = Win;
			}
		}
		System.out.println("Child win is " + newChildWin);
		
		driver.switchTo().window(newChildWin);
		
		WebElement newchildHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in child win is " + newchildHeader.getText());
		
		driver.close();

		}
		
		
	}


