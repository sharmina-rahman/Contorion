package testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class takeSnapShot {
    public WebDriver driver;
    public takeSnapShot(WebDriver driver){
        this.driver=driver;
    }

    public void snapShot() throws Exception{
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File DestFile=new File("./screenshots/"+sdf.format(d)+".png");
        FileHandler.copy(SrcFile,  DestFile);
    }
}
