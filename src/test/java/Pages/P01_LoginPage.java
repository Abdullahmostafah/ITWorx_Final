package Pages;

import StepDefinitions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Boolean.TRUE;

public class P01_LoginPage {

    public void LoginSteps(String userName , String passWord){
        username().sendKeys(userName); //"testregister@aaa.com"
        password().sendKeys(passWord); //"Wakram_123";
    }

    public WebElement username() {
        return Hooks.driver.findElement(By.id("Email"));
    }

   public WebElement password() {
        return Hooks.driver.findElement(By.id("inputPassword"));
    }

   public WebElement loginButton() {
        return Hooks.driver.findElement(By.id("btnLogin"));
    }

    public void loginValidation() throws InterruptedException {
        String expectedResult = "https://swinji.azurewebsites.net/Org#!/Reporting/";
        String actualResult = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualResult.contains(expectedResult) , TRUE);
        Thread.sleep(2000);
    }
}
