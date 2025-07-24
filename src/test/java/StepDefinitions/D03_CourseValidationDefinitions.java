package StepDefinitions;

import Base.TestBase;
import Pages.P03_CourseValidation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D03_CourseValidationDefinitions extends TestBase {
    private final P03_CourseValidation validate;

    public D03_CourseValidationDefinitions() {
        super();
        this.validate = new P03_CourseValidation(TestBase.getDriver());
    }

    @When("search by course name")
    public void search_by_course_name() {
        validate.searchCourse();
    }

    @Then("course title is displayed on course page")
    public void course_title_is_displayed_on_course_page() {
        validate.verifyCourseDisplayed();
    }
}