package StepDefinitions;

import Base.TestBase;
import Pages.P02_CreateCourse;
import io.cucumber.java.en.Given;

public class CommonStepDefinitions extends TestBase {
    private final P02_CreateCourse createCourse;

    public CommonStepDefinitions() {
        super();
        this.createCourse = new P02_CreateCourse(TestBase.getDriver());
    }

    @Given("the user is on the courses page")
    public void navigateToCoursesPage() {
        createCourse.coursePageIcon();
    }
}