package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		List<WebElement> Rows = driver.findElements(By.cssSelector("table#customers>tbody>tr"));
		System.out.println("Total no of rows are "+Rows.size());
		
		List<WebElement> Columns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println("Total no of columns "+Columns.size());
		
		WebElement data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]/td[1]"));
		//In this case if we want to use Css selector "table#customers>tbody>tr:nth-of-type(4)>td:nth-of-type(1)"
		System.out.println("The data is "+data.getText());
		
		for(int i=2;i<=Rows.size();i++) {
			//for(int j=0;j<Columns.size();j++) 
			List<WebElement> ColumnData = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td"));
			System.out.println(ColumnData.get(0).getText()+" "+ColumnData.get(1).getText()+" "+ColumnData.get(2).getText());
			//    //td[text()='Alfreds Futterkiste']/following-sibling::td[2]
		}
	}

}
