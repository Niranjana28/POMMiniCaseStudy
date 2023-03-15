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
import pages.AddItemToCartPage;
import pages.CartListPage;
import pages.CartPage;
import pages.LoginPage;
import pages.OrderPage;

public class TestCase extends TestBase {
	
	LoginPage loginPage;
	CartPage cartPage;
	AddItemToCartPage addItemToCartPage;
	OrderPage order;
	CartListPage delete;
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
	 //  Assert.assertEquals(login.welcome.getText(), "Welcome");
	   
   }
  
   
   @Test(priority=2, dataProvider="MultipleItems")
   public void addItem(String MultipleItems) throws InterruptedException {
	   addItemToCartPage =new AddItemToCartPage();
	   addItemToCartPage.addItem(MultipleItems);
		   
	}
   @Test(priority=3)
   public void cart() throws InterruptedException{
	   cartPage = new CartPage();
	   cartPage.cart();
	 
}
  @Test(priority=4, dependsOnMethods="cart")
   public void delete() throws InterruptedException {
	   delete =new CartListPage();
	   delete. delete();
	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
	  
  }
  @Test(priority=5)
  public void Placeorder() throws InterruptedException {
	  order = new OrderPage();
	  order.Placeorder();
	  WebElement msg=order.message;
	  Assert.assertTrue(msg.isDisplayed());
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

