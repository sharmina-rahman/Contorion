package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class searchItem {
    public WebDriver driver;
    public searchItem(WebDriver driver){
        this.driver=driver;
    }
    public void search() throws Exception{
        takeSnapShot ss=new takeSnapShot(driver);

        driver.findElement(By.name("submit_search")).isDisplayed();
        driver.findElement(By.id("search_query_top")).isDisplayed();
        System.out.println("Search bar found");

        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Searched for dress");

        Assert.assertEquals(driver.findElement(By.className("lighter")).getText(), "\"DRESS\"");
        ss.snapShot();
        System.out.println("Found results");
    }
}
