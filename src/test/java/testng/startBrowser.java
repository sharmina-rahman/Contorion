package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class startBrowser {
    WebDriver driver=null;

    @Parameters({"browserName"})
    @BeforeTest
    public void setBrowser(String browserName) {
        if(browserName.equalsIgnoreCase("chrome")){
            System.out.println("Browser name is: "+browserName);
            System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            System.out.println("Browser name is: "+browserName);
            System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    @Test
    public void mainTest() throws Exception{
        navigateSite n= new navigateSite(driver);
        n.navSite();
        loginToSite l=new loginToSite(driver);
        l.login();
        searchItem s=new searchItem(driver);
        s.search();
    }
    @AfterTest
    public void shutdown(){
        driver.close();
    }
}
