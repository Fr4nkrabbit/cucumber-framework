package cucumberframework.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	// creating a webdriver
	WebDriver driver;
	
	// using a Before hook
	@Before()
	public void setup() 
	{
		System.setProperty("webdriver.gecko.driver", 
		"C:\\softwaredistribution\\workspaces\\cucumber-framework-second-attempt\\cucumber-framework-second-attempt\\src\\test\\java\\cucumberframework\\resources\\geckodriver.exe");
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}
	
	
	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
	    // Go to Stack Overflow website
		driver.get("https://stackoverflow.com/");
	}

	@Given("^User clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		// Find the Log In button and press it.
		// /html/body/header/div/ol/li[6]/a[1] - Static XPATH
		// Dynamic XPath of "//a[contains(text(), 'Log In')]"
		driver.findElement(By.xpath("//a[contains(text(), 'Log In')]")).click();
	}

	@Given("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
	    // Put in the email
		// TODO: change this sleep to a better way to wait for thread to catch up.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("eugenerku@gmail.com");
	}
	
	@Given("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
	    // Put in the password
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Fr4nk_ray94");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
	    // Verifies that we can see the 'Ask Questions' button - which means we've logged on
		// TODO: change this sleep to a better way to wait for thread to catch up.
		Thread.sleep(3000);
		WebElement askQuestionButton = driver.findElement(By.xpath("//a[contains(text(), 'Ask Question')]"));
		Assert.assertEquals(true, askQuestionButton.isDisplayed());
	}
}
