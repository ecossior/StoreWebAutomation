package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static util.StoreData.SData;

import java.io.IOException;

public class StoreDriver {
    private static WebDriver webDriver = null;
    private static String browser;
    public static WebDriver getInstance() {
        if (webDriver==null) {
            try {
                browser = SData("browser");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (browser.equals("firefox")) {
                webDriver = getFirefoxDriver();
            } else if (browser.equals("chrome")) {
                webDriver = getChromeDriver();
            }
        }
        return webDriver;
    }
    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
