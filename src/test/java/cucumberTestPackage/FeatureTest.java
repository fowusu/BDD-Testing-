package cucumberTestPackage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeatureTest {
	
	    WebDriver driver; 
	    String url = "http://www.practiceselenium.com/welcome.html";
	    
	    @Before
	    public void init() {
	    	System.setProperty("webdriver.chrome.driver", "C:\\external apps/chromedriver.exe");
	    	driver = new ChromeDriver(); 
	    	driver.manage().window().maximize();
	    	
	    }

		@Given("^the correct web address$")
		public void the_correct_web_address()  {
			driver.get(url);
		    assertEquals("http://www.practiceselenium.com/welcome.html",url);
		    
		}

		@When("^I navigate to the 'Menu' page$")
		public void i_navigate_to_the_Menu_page()  {
			WebElement we = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
			we.click();
		}

		@Then("^I can browse a list of the available products\\.$")
		public void i_can_browse_a_list_of_the_available_products()  {
			WebElement we = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong"));
			assertEquals("Green Tea",we.getText());
			we = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231072\"]/div/p/span/span/strong"));
			assertEquals("Red Tea",we.getText());
			we = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453231735\"]/div/p/span/span/strong"));
			assertEquals("Oolong Tea",we.getText());
	
		}

		@When("^I click the checkout button$")
		public void i_click_the_checkout_button()  {
			WebElement we = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
			we.click();
		    
		}

		@Then("^I am taken to the checkout page$")
		public void i_am_taken_to_the_checkout_page() {
		    // Write code here that turns the phrase above into concrete actions
			WebElement we = driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000451990420\"]/div/pre/strong/span"));
			assertEquals("Enter your billing information",we.getText());
		}
		
		@After
		public void finalise() {
			driver.quit();
		}

}
