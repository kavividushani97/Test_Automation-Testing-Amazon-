package assesment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {


	
		static WebDriver driver;
		String url = "https://www.amazon.com";

		public void connection() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().deleteAllCookies();
		}

		public void search(String search_item) {
		WebElement search = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		search.sendKeys(search_item);

		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		}

		public void countElement() {
		WebElement items = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]"));
		String res = items.getAttribute("textContent");
		System.out.println(res);
		}

		public void nthProduct(int proId) {

		String base = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div";
		String id = base.concat("[".concat(Integer.toString(proId)).concat("]"));

		WebElement product = driver.findElement(By.xpath(id));
		System.out.println("*******************************");
		System.out.println(product.getText());
		System.out.println("*******************************");
		}


		public void allProduct() {

		String base = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]";
		//String id = base.concat("[".concat(Integer.toString(proId)).concat("]"));

		List allProducts = driver.findElements(By.xpath(base));

		for(WebElement product : allProducts) {
		System.out.println("*******************************");
		System.out.println(product.getText());
		System.out.println("*******************************");
		}
		}

		public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[63]"));
		js.executeScript("arguments[0].scrollIntoView(true);",element);

		}

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		AmazonTest t1 = new AmazonTest();
		t1.connection();
		t1.search("shirts for men");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		t1.nthProduct(4);
		t1.allProduct();
		t1.scroll();
		t1.countElement();



		}

		}






