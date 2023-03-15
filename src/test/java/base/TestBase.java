package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop=null;
    public static WebDriver driver=null;
    public TestBase() {
    	String path=System.getProperty("user.dir")+"//src//test//resources//ConfigFiles//config.properties";
    	prop=new Properties();
    	FileInputStream fin;
    	try {
    		fin=new FileInputStream(path);
    		prop.load(fin);
    	}
    	catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    public static void initialize() {
    	String strBrowser=prop.getProperty("browser");    	
    	if(strBrowser.equalsIgnoreCase(strBrowser)) {
    		WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();    		
    	}
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    	driver.get(prop.getProperty("url"));
}
}