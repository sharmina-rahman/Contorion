package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginToSite {
    public WebDriver driver;
    public loginToSite(WebDriver driver){
        this.driver=driver;
    }
    public void login() throws Exception {
        takeSnapShot ss= new takeSnapShot(driver);

        String menu1="Contact us";
        String menu2="Sign in";
        String header="ALREADY REGISTERED?";
        String field1="Email address";
        String field2="Password";
        String field3="Forgot your password?";
        String field4="Sign in";
        String username="sharminarahman.dsi@gmail.com";
        String password="Testing123!";
        String pageheader="MY ACCOUNT";

        try{
            Assert.assertEquals(driver.findElement(By.id("contact-link")).getText(), menu1);
        }
        catch (AssertionError e){
            System.out.println("Menu not found");
            ss.snapShot();
        }
        System.out.println("Menu contact found");

        try{
            Assert.assertEquals(driver.findElement(By.className("login")).getText(), menu2);
        }
        catch (AssertionError e){
            System.out.println("Menu not found");
            ss.snapShot();
        }
        System.out.println("Menu login found");

        driver.findElement(By.className("login")).click();
        System.out.println("Landed on Login page");
        ss.snapShot();

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("#login_form > h3")).getText(), header);
        }
        catch (AssertionError e){
            System.out.println("Header not found");
            ss.snapShot();
        }
        System.out.println("Header found");

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("#login_form > div > div:nth-child(1) > label")).getText(), field1);
        }
        catch (AssertionError e){
            System.out.println("Email address field not found");
            ss.snapShot();
        }
        System.out.println("Email address field found");

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("#login_form > div > div:nth-child(2) > label")).getText(), field2);
        }
        catch (AssertionError e){
            System.out.println("Password field not found");
            ss.snapShot();
        }
        System.out.println("Password field found");

        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("#login_form > div > p.lost_password.form-group > a")).getText(), field3);
        }
        catch (AssertionError e){
            System.out.println("Forgot password not found");
            ss.snapShot();
        }
        System.out.println("Forgot password found");

        try {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).getText(), field4);
        }
        catch (AssertionError e){
            System.out.println("Button not found");
            ss.snapShot();
        }
        System.out.println("Button found");

        driver.findElement(By.id("email")).sendKeys(username);
        System.out.println("Email inserted");
        driver.findElement(By.id("passwd")).sendKeys(password);
        System.out.println("Password inserted");
        driver.findElement(By.id("SubmitLogin")).click();
        System.out.println("Clicked on signin");

        Assert.assertEquals(driver.findElement(By.className("page-heading")).getText(), pageheader);
        System.out.println("Succesfully logged in");
        ss.snapShot();
    }
}
