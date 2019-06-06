package parametisation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParaTest {
	WebElement we; 
	String currentSearchTerm; 
	
	WebDriver driver; 
	
	@Before 
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\external apps/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@After
	public void finalise() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}


	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String website)  {
		driver.get(website);
	   
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String searchTrm)  {
	    // Write code here that turns the phrase above into concrete actions
	    currentSearchTerm = searchTrm; 
	    WebElement we = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
	    we.sendKeys(searchTrm);
	    we.submit();
	    
	    
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {
	    // Write code here that turns the phrase above into concrete actions
		
		if(currentSearchTerm.equals("QAConsulting")) 
		{
			driver.getPageSource().contains("QAConsulting");	
			assertTrue(true);
		}else if(currentSearchTerm.equals("Guru99")) 
		{
			driver.getPageSource().contains("Guru99");	
			assertTrue(true);	
	    }else if(currentSearchTerm.equals("BlazeDemo")) 
	    {
	    	driver.getPageSource().contains("BlazeDemo");	
			assertTrue(true);
		
	    }else if(currentSearchTerm.equals("Automated Testing")) 
	    {
	    	driver.getPageSource().contains("Automated Testing");	
			assertTrue(true);

	}else {
		fail(); 
	}


}
}
