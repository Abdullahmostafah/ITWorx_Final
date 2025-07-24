package StepDefinitions;

import Base.TestBase;
import Pages.P02_CreateCourse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D02_CreateCourseDefinitions extends TestBase {
    private final P02_CreateCourse create;

    public D02_CreateCourseDefinitions() {
        super();
        this.create = new P02_CreateCourse(TestBase.getDriver());
    }

    @And("user click on create course button")
    public void user_click_on_create_course_button() {
        create.createCourseIcon().click();
    }

    @When("user fill mandatory course fields and click on save")
    public void user_fill_mandatory_course_fields_and_click_on_save() {
        create.creationSteps();
    }

    @Then("the user is redirected to the courses list page")
    public void theUserIsRedirectedToTheCoursesListPage() {

        String expectedUrlFragment = "/courses";
        String currentUrl = getDriver().getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains(expectedUrlFragment),
                "Expected to be redirected to courses page, but got URL: " + currentUrl);
        softAssert.assertAll();
    }

}