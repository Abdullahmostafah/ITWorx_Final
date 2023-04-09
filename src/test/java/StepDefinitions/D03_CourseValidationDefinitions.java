package StepDefinitions;

import Pages.P03_CourseValidation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class D03_CourseValidationDefinitions {

P03_CourseValidation validate = new P03_CourseValidation();

    @When("search by course name")
    public void search_by_course_name(){
        validate.searchCourse();
    }

    @Then("course title is displayed on course page")
        public void course_title_is_displayed_on_course_page(){
          boolean actualResult = Hooks.driver.findElement(By.xpath("//*[contains(text(),'ScrumMaster')]")).isDisplayed();
          Assert.assertTrue(actualResult);
    }

}
