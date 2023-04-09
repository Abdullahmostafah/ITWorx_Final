package StepDefinitions;

import Pages.P01_LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import static java.lang.Boolean.TRUE;

public class D01_LoginStepDefinitions {
P01_LoginPage login = new P01_LoginPage();

    @Given("user navigates to login page")
    public void user_navigates_to_login_page(){
        Hooks.driver.navigate().to("https://swinji.azurewebsites.net");
    }

    @When("user enter valid name and password")
    public void user_enter_valid_name_and_password(){
        login.LoginSteps("testregister@aaa.com","Wakram_123");
    }

    @And ("user click on login button")
    public void user_click_on_login_button() throws InterruptedException {
        login.loginButton().click();
        Thread.sleep(2000);
    }

    @Then("user could login successfully and go to home page")
    public void user_could_login_successfully_and_go_to_home_page() throws InterruptedException {
    login.loginValidation();
    }

}
