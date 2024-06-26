package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleSearchPageFactory;

public class GoogleSearch {
	WebDriver driver;	
	  
	  GoogleSearchPageFactory browser;
	/*
	 * private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
	 * 
	 * @Before public void setup() { driver = new ChromeDriver();
	 * webDriver.set(driver); }
	 */

	  @Given("I am on the Google search page") 
	  public void  i_am_on_the_google_search_page() {
		  driver=TestBase.getDriver();
		   browser= new GoogleSearchPageFactory(driver);
		   browser.NavigateGoogleSearchPage();
	//  driver.get("https://www.google.com"); 
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, "Google");
	  
	  }
	  
	  @When("I search for {string}") 
	  public void i_search_for(String Keyword) {
		  
		  browser.typeSearchKeyword(Keyword);}
	//  driver.findElement(By.name("q")).sendKeys(Keyword);
	//  driver.findElement(By.name("q")).sendKeys(Keys.ENTER); }
	  
	  @Then("I should see search results for {string}") 
	  public void  i_should_see_search_results_for(String Title) { String
	  actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle, Title); }
	  
	 
	 
}
