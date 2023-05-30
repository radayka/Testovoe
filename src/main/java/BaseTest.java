import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver;
    String URL_APP = "file:///C:/Users/Max/Downloads/qa-test.html";

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(URL_APP);
    }

    @After
    public void clean() {
        webDriver.quit();
    }

}

