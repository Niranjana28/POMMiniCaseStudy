package testScripts;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import base.TestBase;
import pages.HomePage;
import pages.CartPage;
import pages.LoginPage;
import pages.PurchasePage;

public class TestCase extends TestBase {
	
	LoginPage loginPage;
	CartPage cartPage;
	HomePage homePage;
	PurchasePage purchasePage;
	WebDriverWait wait;
	
    @BeforeTest
    public void setup() {
	   initialize();
    }
   
    @Test(priority=1)
    public void login() throws InterruptedException {
	   wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	   loginPage= new LoginPage();
	   loginPage.login();
	 // Assert.assertEquals(login.welcome.getText(), "Welcome");
	   
   }
  
   
   @Test(priority=2, dataProvider="MultipleItems")
   public void addItem(String MultipleItems) throws InterruptedException {
	   homePage =new HomePage();
	   homePage.addItem(MultipleItems);
   }
   
   @Test(priority=3)
   public void cart() throws InterruptedException{
	   homePage = new HomePage();
	   homePage.cart();
}
  @Test(priority=4, dependsOnMethods="cart")
   public void delete() throws InterruptedException {
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
	   CartPage delete = new CartPage();
	   delete. delete();
	 
	  
  }
  @Test(priority=5)
  public void Placeorder() throws InterruptedException {
	  PurchasePage order = new PurchasePage();
	  Thread.sleep(3000);
	  order.Placeorder();
	  wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	 //Assert.assertTrue(msg.isDisplayed())}
	 }
 

  @DataProvider(name="MultipleItems")
   public Object[][] getData() throws CsvValidationException, IOException {
	   String path=System.getProperty("user.dir")+"//src//test//resources//itemDetails//MultipleItems.csv";
	   String[] cols;
	   CSVReader reader=new CSVReader(new FileReader(path));
	   ArrayList<Object> dataList=new ArrayList<Object>(); 
	   while((cols=reader.readNext())!=null) {
	
		   Object[] record= {cols[0]};
		   dataList.add(record);
		   
	   }
	   return dataList.toArray(new Object[dataList.size()][]);
   }
   
}

