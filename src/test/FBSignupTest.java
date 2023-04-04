package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignupTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//click on create new account
		
		WebElement signup = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signup.click();
		
		
		WebElement fname = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement sname = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		
		fname.sendKeys("naveena");
		sname.sendKeys("jannu");
		mobile.sendKeys("9876543210");
		password.sendKeys("veen@123");
		
		WebElement selectedDay = driver.findElement(By.xpath("//select[@title='Day']/option[@selected='1']"));
		System.out.println("The default selected Day is: "+selectedDay.getText()); 
		
		WebElement selectedMonth = driver.findElement(By.xpath("//select[@title='Month']/option[@selected='1']"));
		System.out.println("The default selected Month is: "+selectedMonth.getText());
		
		WebElement selectedYear = driver.findElement(By.xpath("//select[@title='Year']/option[@selected='1']"));
		System.out.println("The default selected Year is: "+selectedYear.getText());
		
		WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select ddDay = new Select(day);
		ddDay.selectByVisibleText("5");
		
		List<WebElement> list = driver.findElements(By.xpath("//select[@title='Month']/option"));
		for(WebElement month: list) {
			System.out.println("The list of months: "+month.getText());
		}
		WebElement month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select ddMonth = new Select(month);
		ddMonth.selectByValue("6");
		
		WebElement year = driver.findElement(By.xpath("//select[@title='Year']"));
		Select ddYear = new Select(year);
		ddYear.selectByVisibleText("1995");
		
		String Gender = "Female";
		
		/*String genderXpath = "//label[text()='placeholder']";
		String newXpath = genderXpath.replace("placeholder", Gender);*/
		
		String newXpath = "//label[text()='" + Gender + "']";
		
		WebElement genderElem = driver.findElement(By.xpath(newXpath));
		genderElem.click();

		
	}

}
