package Pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.By;

public class P03_CourseValidation {

    public void searchCourse(){
        Hooks.driver.findElement(By.id("txtCourseSearch")).sendKeys("ScrumMaster");
        Hooks.driver.findElement(By.id("txtCourseSearch")).submit();
    }

}
