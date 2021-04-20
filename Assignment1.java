package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\veena\\chromedriver_win32\\chromedriver.exe");
		String baseURL = "https://www.cleartrip.com/";
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);

		Select adultInfo = new Select(driver.findElement(By.id("Adults")));
		adultInfo.selectByValue("2");
		Select childInfo = new Select(driver.findElement(By.cssSelector("[name='childs']")));
		childInfo.selectByIndex(1);
		Select infantInfo = new Select(driver.findElement(By.id("Infants")));
		infantInfo.selectByVisibleText("1");

		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		driver.findElement(By.id("MoreOptionsLink")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']")).sendKeys("Indigo");
		driver.findElement(By.id("SearchBtn")).click();

		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
	}

}
