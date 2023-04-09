package StepDefinitions;

import Pages.P02_CreateCourse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class D02_CreateCourseDefinitions {

    P02_CreateCourse create = new P02_CreateCourse();

    @Given("user click on course page icon")
    public void user_click_on_course_page_icon(){
        create.coursePageIcon();
    }

    @And("user click on create course button")
    public void user_click_on_create_course_button(){
        create.createCourseIcon().click();
    }

    @When("user fill mandatory course fields and click on save")
    public void user_fill_mandatory_course_fields_and_click_on_save(){
        create.creationSteps();
    }

}
