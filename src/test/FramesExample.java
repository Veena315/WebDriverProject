package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		driver.switchTo().frame("frame1");
		WebElement Header = driver.findElement(By.id("sampleHeading"));
		System.out.println("The Header content is : "+Header.getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		WebElement Header1 = driver.findElement(By.id("sampleHeading"));
		System.out.println("The second Header content is : "+Header1.getText());
	}

}
