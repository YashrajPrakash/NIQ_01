package testPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test_demo {
	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\prya3001\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com");
	
	driver.manage().window().maximize();
//	System.out.println("Title : " + driver.getTitle());
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
//	Thread.sleep(1000);
	String actualTitle = driver.getTitle();
	String expTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	Assert.assertEquals(actualTitle, expTitle , "Title mismatch !!!");
	
	
	
	System.out.println("1 -- Title Verified.. ✔");
	System.out.println("Current Page Title : "+ actualTitle);
	
	 
//	WebElement loginBar = driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']"));
//	loginBar.sendKeys("79031934ix");

	
	WebElement close_btn =  driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	close_btn.click();
	
	WebElement searchBar = driver.findElement(By.xpath("//input[@class='_3704LK']"));
	searchBar.click();
	searchBar.sendKeys("iphone 13 128 blue");
	
	WebElement search_btn = driver.findElement(By.className("L0Z3Pu"));
	search_btn.click();
//	Thread.sleep(5000);
//	loginBar.click();
	String expct_title = "Iphone 13 128 Blue- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	Thread.sleep(2000);
	String searchedTitle = driver.getTitle();
	Assert.assertEquals(expct_title, searchedTitle , "Title mismatch !!!");
	
	System.out.println("2 -- Current Page Verified.. ✔");
	System.out.println("Current Page Title : "+ searchedTitle);
	
//	WebElement view_prod = driver.findElement(By.xpath	("//div[contains(@class, '_4rR01T') and text()='APPLE iPhone 13 (Blue, 128 GB)']"));
//	WebElement view_prod = driver.findElement(By.xpath("//a/div[contains(text(),'APPLE iPhone 13 (Blue, 128 GB)')]"));
//	WebElement view_prod = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a"));    //Absolute path
	
//	driver.findElement(By.id("_2kHMtA")).findElements(By.xpath("/*")).get(0).click();
	
	List<WebElement> results = driver.findElements(By.xpath("//a[@class=\"_1fQZEK\"]"));
	results.get(0).click();
//	System.out.println(results);
	
//	Thread.sleep(2000);
//	List<WebElement> storage = driver.findElements(By.xpath("//ul/li[@class=\"_3V2wfe\"]"));
//	List<WebElement> storage = driver.findElements(By.cssSelector("a[class^='_1fGeJ5']"));
//	storage.get(1).click();
	String exp_storage = "128 GB";
	try {
		WebElement storage = driver.findElement(By.id("swatch-0-storage"));
		Assert.assertEquals(exp_storage, storage.getText() , "Storage doesn't match!!!");
		System.out.println("3 -- Storage Verified.. ✔");		
	}catch(Exception e) {
		System.out.println("Troble verifying storage!!");
	}
	
//	
//	WebElement btn_add_to_cart = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
////Thread.sleep(5000);
//	System.out.println("Adding to cart....");
//	btn_add_to_cart.click();
//	System.out.println("4 --- Product added to cart. ");
	ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(newTb.get(0));
	WebElement btn_go_to_cart = driver.findElement(By.className("_3SkBxJ"));
	System.out.println(btn_go_to_cart.getText());
	btn_go_to_cart.click();
	
	String order_text = "Place Order";
	WebElement btn_place_order = driver.findElement(By.className("_2KpZ6l _2ObVJD _3AWRsL"));
	String fetchedText = btn_place_order.getText();
	Assert.assertEquals(order_text, fetchedText , "String mismatch !!!");
	
	
	driver.close();
	
	
	
//	WebElement view_prod = driver.findElement(By.xpath("//a[contains(@href, '/apple-iphone-13-blue-128-gb')]"));
//	view_prod.click();
	
	
//	view_prod.click();
	
	
	
//	driver.close();
	
}
}