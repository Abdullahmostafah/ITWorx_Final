package Base;

import Utils.ConfigReaderWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    protected static WebDriver driver;
    protected static SoftAssert softAssert;
    protected static String browser = ConfigReaderWriter.getPropKey("browser");
    protected static String url = ConfigReaderWriter.getPropKey("url");

    public static void initializeDriver() {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--disable-save-password-bubble");
                    chromeOptions.addArguments("--disable-password-generation");
                    chromeOptions.addArguments("--password-store=basic");
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--incognito");
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    chromeOptions.addArguments("user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chrome-temp-profile");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-private");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public void setUp() {
        softAssert = new SoftAssert();
        initializeDriver();
        driver.get(url);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(webDriver -> "complete".equals(((org.openqa.selenium.JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")));
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        softAssert.assertAll();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }
}