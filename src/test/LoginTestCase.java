package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) throws InterruptedException {

		
		// step-1 : Launch chrome browser and open simplilearn website
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		// step-2: Maximize the browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
		
		// step-3: click  on the Login link on top right corner

		System.out.println("The title of the page is "+driver.getTitle());
		
		WebElement Loginlink = driver.findElement(By.linkText("Log in"));
		String location = Loginlink.getAttribute("href");
		System.out.println("The link will take you to "+location);
		Loginlink.click();
		Thread.sleep(3000);
		
		//step-4: Enter the user name

		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("veenajannu315@gmail.com");
		
		// step-5: Enter the password
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Shiven@1705");
		
		//step-6: Click on Remember me check box
		
		WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
		//step-7 : Click  on Login

		WebElement Submit = driver.findElement(By.name("btn_login"));
		Submit.click();
		
		//step-8: Validate the login was unsuccessful and error message is expected
		
		WebElement error = driver.findElement(By.className("error_msg"));
		String errorMsg = error.getText();
		String expectederror = "The email or password you have entered is invalid.";
		
		if(error.isDisplayed() && errorMsg.equals(expectederror)) {
			System.out.println("TC passed");
		}
		else {
			System.out.println("TC failed");
		}
		
		List<WebElement> AllLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total no od links are: "+AllLinks.size());
		
		for(WebElement links:AllLinks) {
			
			System.out.println(links.getAttribute("href"));
			
		}
		
		//step-9: Close the browser
		
		driver.close();
	}

}
