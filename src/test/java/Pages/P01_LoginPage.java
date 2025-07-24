package Pages;

import Base.TestBase;
import Utils.ConfigReaderWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class P01_LoginPage extends TestBase {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String username = ConfigReaderWriter.getPropKey("login.username");
    private final String password = ConfigReaderWriter.getPropKey("login.password");

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "inputPassword")
    private WebElement passwordInput;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public P01_LoginPage(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        if (username == null || password == null) {
            throw new IllegalStateException("Username or password not found in config");
        }
        // Debug element initialization
        System.out.println("emailInput initialized: " + (emailInput != null));
    }

    public void loginSteps() {
        for (int i = 0; i < 3; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(username);
                wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
                wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
                System.out.println("Login steps completed");
                return;
            } catch (Exception e) {
                System.out.println("Retry " + (i + 1) + ": Failed to perform login actions - " + e.getMessage());
            }
        }
        throw new RuntimeException("Failed to perform login actions after retries");
    }

    public void loginValidation() {
        String expectedUrl = "https://swinji.azurewebsites.net/Org#!/Reporting/";
        wait.until(ExpectedConditions.urlContains("Reporting"));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl), "Login redirect URL mismatch");
    }
}