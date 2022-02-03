package pagegoogleobjectmodel.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "remoteChrome": {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("browserName", "chrome");
                    capabilities.setCapability("browserVersion", "96.0");
                    try {
                        driver = new RemoteWebDriver(
                                URI.create("http://localhost:4444/wd/hub").toURL(),
                                capabilities
                        );
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
            }
        }
        return driver;
    }

    public static void closeDriver() {
        Optional.ofNullable(driver).ifPresent(webDriver -> {
            webDriver.quit();
            driver = null;
        });
    }
}
