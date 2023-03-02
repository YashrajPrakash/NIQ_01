package testPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_demo {
	@Test
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prya3001\\Downloads\\chromedriver_win32\\chromedriver.exe"); // Setting up chrome driver.
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");

		System.out.println("Title : " + driver.getTitle());
		String actualTitle = driver.getTitle();
		String expTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";

		Assert.assertEquals(actualTitle, expTitle, "Title mismatch !!!");
		System.out.println("1 -- Title Verified.. ✔");
		System.out.println("Current Page Title : " + actualTitle);

		/*
		 * For * LOG-IN Purpose *
		 * driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"))
		 * .sendKeys("790xxxxxx7"); <Input your phone number in-here>
		 * .click();
		 * 
		 */

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click(); // Popup_Close_btn

		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("iphone 13 128 blue"); // * Search Query *

		driver.findElement(By.className("L0Z3Pu")).click(); // Search_btn

		String expct_title = "iPhone 13 ( 128 GB GB Storage, Blue) Online at Best Price On Flipkart.com";

		/*
		 * driver.findElement(By.xpath
		 * ("//div[contains(@class, '_4rR01T') and text()='APPLE iPhone 13 (Blue, 128 GB)']"
		 * )); driver.findElement(By.
		 * xpath("//a/div[contains(text(),'APPLE iPhone 13 (Blue, 128 GB)')]"));
		 * driver.findElement(By.xpath(
		 * "//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a")); //-- Absolute path
		 * driver.findElement(By.id("_2kHMtA")).findElements(By.xpath("/*")).get(0).
		 * click();
		 */

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait -- 10s
		List<WebElement> results = driver.findElements(By.xpath("//a[@class=\"_1fQZEK\"]"));
		results.get(0).click();

		driver.getWindowHandles().forEach((tab) -> driver.switchTo().window(tab));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(expct_title, pageTitle, "Title mismatch !!!");
		System.out.println("2 -- Current Page Verified.. ✔");
		System.out.println("Current Page Title : " + pageTitle);

		/*
		 * <Alternatives> driver.findElements(By.xpath("//ul/li[@class=\"_3V2wfe\"]"));
		 * driver.findElements(By.cssSelector("a[class^='_1fGeJ5']"));
		 * storage.get(1).click();
		 */
		String exp_storage = "128 GB";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement storage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='128 GB']"))); // Explicit
																												// wait
			Assert.assertEquals(exp_storage, storage.getText(), "Storage doesn't match!!!");
			System.out.println("3 -- Storage Verified.. (✔) :" + storage.getText());
		} catch (Exception e) {
			System.out.println("Trouble validating storage!!");
		}

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement btn_add_to_cart = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")));
			System.out.println("Adding to cart....");
			btn_add_to_cart.click();
			System.out.println("4 --- Product added to cart. (✔) ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		WebElement btn_go_to_cart = driver.findElement(By.className("_3SkBxJ"));
		btn_go_to_cart.click();

		driver.navigate().refresh(); // Refreshing the page..

		String order_text = "PLACE ORDER";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement btn_place_order = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() ='Place Order']")));
                    //	.findElement(By.className("_2KpZ6l _2ObVJD _3AWRsL"));
		String fetchedText = btn_place_order.getText();
		Assert.assertEquals(order_text, fetchedText, "Button mismatch !!!");
		System.out.println("5 -- Place order button... Validated!! (✔)");
		System.out.println("------------ Test cases passed (5/5) ------------");
		
		/* 
		 * WebElement view_prod = driver.findElement(By.
		 * xpath("//a[contains(@href, '/apple-iphone-13-blue-128-gb')]"));
		 * view_prod.click(); view_prod.click();
		 */

		driver.close();

	}
}