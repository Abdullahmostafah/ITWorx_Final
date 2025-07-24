package StepDefinitions;

import Base.TestBase;
import Pages.P01_LoginPage;
import Utils.ConfigReaderWriter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class D01_LoginStepDefinitions extends TestBase {
    private final P01_LoginPage login;

    public D01_LoginStepDefinitions() {
        super();
        this.login = new P01_LoginPage(TestBase.getDriver());
    }

    @Given("the user navigates to the Winjigo login page")
    public void the_user_navigates_to_the_winjigo_login_page() {
        TestBase.getDriver().navigate().to(ConfigReaderWriter.getPropKey("url"));
        new WebDriverWait(TestBase.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.id("Email")));
        System.out.println("Navigated to URL: " + TestBase.getDriver().getCurrentUrl());
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        login.loginSteps();
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        // Included in loginSteps
    }

    @Then("the user is logged in and redirected to the home page")
    public void the_user_is_logged_in_and_redirected_to_the_home_page() {
        login.loginValidation();
    }
}