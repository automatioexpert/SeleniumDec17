package coding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch1 {

	@Test
	public void launch() throws InterruptedException {
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
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'European')]")).getText());
		System.out.println(driver.findElement(By.cssSelector("div.content-main-txt-header>h2")).getText());
		driver.findElement(By.cssSelector("input#edit-keys")).sendKeys("absdsdsd");
		driver.findElement(By.cssSelector("input[value='Search']")).click();
		Thread.sleep(5600);
		driver.quit();
		
	}
}
