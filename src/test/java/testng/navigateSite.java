package testng;

import org.openqa.selenium.WebDriver;

public class navigateSite {
    public WebDriver driver;
    public navigateSite(WebDriver driver){
        this.driver=driver;
    }
    public void navSite(){
        String url= "http://automationpractice.com/index.php";
        driver.manage().window().maximize(); //maximize the browser
        driver.navigate().to(url); //launching the site
        String title= driver.getTitle();
        System.out.println("The title is: "+title);
    }
}
