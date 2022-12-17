package coding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test3 {

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
		driver.findElement(By.cssSelector("input#edit-name")).sendKeys("User485959545775@gmail.coms");
		driver.findElement(By.cssSelector("#edit-pass")).sendKeys("Psd343434@3874748348");
		driver.findElement(By.cssSelector("#edit-captcha-response")).sendKeys("10");
		String captcha = driver.findElement(By.cssSelector(".field-prefix")).getText();

		String[] str = captcha.split("+");
		for (String s : str) {
			System.out.println(s);
		}

	}

}
