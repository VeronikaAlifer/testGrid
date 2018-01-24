package grid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class GridTest {

    static WebDriver driver;
    static String nodeUrl;

    public static void main(String[] args) throws MalformedURLException {
        nodeUrl = "http://10.6.103.39:5555/wd/hub";
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(nodeUrl),cap);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.get("http://www.seleniumhq.org/download/");
        driver.findElement(By.xpath("//input[@id='q']")).click();

    }
//    private static final String SET_PROPERTIY_VALUE = "C:\\SeleniumDriver\\GoogleChromeDriver\\chromedriver_win32\\chromedriver.exe";
//    private static final String SET_PROPERTIY_KEY = "webdriver.chrome.driver";
//    @Test
//    public void test1() throws MalformedURLException {
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setPlatform(Platform.WIN10);
//
//        URL url = new URL("http://localhost:4444/wd/console");
//        System.setProperty(SET_PROPERTIY_KEY, SET_PROPERTIY_VALUE);
//        WebDriver driver = new RemoteWebDriver(url, cap);
//        driver.get("http://www.seleniumhq.org");
//        System.out.println("Title is " + driver.getTitle() );
//    }

}