package coding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

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
		System.out.println(driver.findElement(By.cssSelector("div.content-headerlogo")).isDisplayed());

		WebElement element = driver.findElement(By.cssSelector("div.content-btn-desplegable-menu"));

		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		

	}

}
