package coding;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test4 {

	@Test
	public void test2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://artes.esa.int/projects/payload-interface-unit-pliu");
		WebElement accept = driver.findElement(By.xpath("//button[contains(text(),'Accept')]"));
		try {
			if (accept.isDisplayed()) {
				accept.click();
			}
		} catch (Exception e) {
			System.out.println("Could not accept the button");
		}

		driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
		driver.findElement(By.cssSelector("a[href*='register']")).click();
		driver.findElement(By.cssSelector("select#edit-field-esa-role")).click();
		List<WebElement> options = driver.findElements(By.cssSelector("select#edit-field-esa-role>option"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("ESA nonMS")) {
				option.click();
			}
		}
		driver.findElement(By.cssSelector("div#edit-mail--description")).click();
		driver.findElement(By.cssSelector("input[name='mail']")).sendKeys("user49343443@gmail.coms");
		driver.findElement(By.cssSelector("input#edit-field-company-institution-0-value")).sendKeys("ABSD");
		driver.findElement(By.cssSelector("input#edit-field-esa-star-entity-code-0-value")).sendKeys("Usd834347437");
		driver.findElement(By.cssSelector("textarea#edit-field-user-address-0-value")).sendKeys("ABC Plot no 2323 ring outer 34834304 c block sdsd 384hdfhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		//ABC Plot no 2323 ring outer 34834304 c block sdsd 384hdfhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
		System.out.println(driver.findElement(By.cssSelector("textarea#edit-field-user-address-0-value")).getAttribute("value"));
		driver.findElement(By.cssSelector("input#edit-field-user-postal-code-0-value")).sendKeys("3892493447");
		driver.findElement(By.cssSelector("input#edit-field-user-city-0-value")).sendKeys("Tokyo");
		System.out.println("Test case passed");
		driver.quit();
	}

}
