package grid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Node2Test {
    WebDriver driver;
    String hubUrl;


    @Test
    public void p() {
        try {
            //    hubUrl = " http://10.6.103.39:5555//4/wd/hub";
            hubUrl = "http://localhost:4444/wd/hub";
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.WIN10);
            driver = new RemoteWebDriver(new URL(hubUrl), cap);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.get("http://www.seleniumhq.org/download/");
            driver.findElement(By.xpath("//input[@id='q']")).click();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
