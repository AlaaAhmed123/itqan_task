import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class task {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser()
	{
		  driver=new ChromeDriver();
		  driver.get("http://magento-demo.lexiconn.com/");
		  Reporter.log("Brower is opened now");
		  driver.manage().window().maximize();
		  Reporter.log("Brower is maximized");
	}
	@Test
	public void register() throws InterruptedException
	{

		  WebElement Account=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/a[3]"));
		  WebElement MyAccount=driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[1]"));
		  Actions s=new Actions(driver);
		  s.click(Account);
		  Reporter.log("Click logo Account");
		  Thread.sleep(1000);
		  s.click(MyAccount);
		  Reporter.log("Click My Account");
		  s.build().perform();
	      driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div[1]/div[2]/a")).click();
	      Reporter.log("Click create Account Button");
	   	  driver.findElement(By.id("firstname")).sendKeys("itqan");
	      Reporter.log("Data is entered for firstname");
	      driver.findElement(By.id("lastname")).sendKeys("task");
	      Reporter.log("Data is entered for lastname");	    
	      driver.findElement(By.id("email_address")).sendKeys("itqantask@gmail.com");
	      Reporter.log("Data is entered for email_address");	  
	   	  driver.findElement(By.id("password")).sendKeys("1122334455");
	      Reporter.log("Data is entered for password");	  
	      driver.findElement(By.id("confirmation")).sendKeys("1122334455"); 	
	      Reporter.log("Data is entered for password confirmation");	  
	      driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[1]/ul/li[4]/label")).click();
	      Reporter.log("Click Radio Button");
	      driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button")).click();
	      Reporter.log("Click Register Button");
	      if(driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div/div/ul/li/ul/li/span")).isDisplayed()==true)
	      {
	    	  String ActualTitle=driver.findElement(By.xpath("//*[@id=\\\"top\\\"]/body/div/div[2]/div[2]/div/div/div/ul/li/ul/li/span")).getText();
	    	  Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address,", ActualTitle);
	    	  Reporter.log("There is already an account with this email address. If you are sure that it is your email address");
		      
	      }
	      else
	      {
	      String ActualTitle=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div/div/ul/li/ul/li")).getText();
	      Assert.assertEquals("Thank you for registering with Madison Island.", ActualTitle);
	      Reporter.log("Message for registering");
	      }
	}
	@AfterTest
	public void CloseBrowser(){
	driver.close();
	}

}
