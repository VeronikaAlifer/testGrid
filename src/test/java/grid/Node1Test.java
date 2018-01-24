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

public class Node1Test {
    WebDriver driver;
    String hubUrl;


    @Test
    public void h(){
        try {
            hubUrl = "http://localhost:4444/wd/hub";
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL(hubUrl), cap);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
            driver.get("http://www.quizful.net");
            driver.findElement(By.xpath("//a[@title='собеседование Java']")).click();
            System.out.println(driver.getTitle());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }driver.quit();
    }
}
