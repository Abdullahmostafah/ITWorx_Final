package Pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P02_CreateCourse {

    public void coursePageIcon() {
        Hooks.driver.findElement(By.id("btnMyCoursesList")).click();
    }

    public WebElement createCourseIcon() {
        return Hooks.driver.findElement(By.id("btnListAddCourse"));
    }

    public void creationSteps(){
       Hooks.driver.findElement(By.name("courseName")).sendKeys("ScrumMaster");
       WebElement Grade = Hooks.driver.findElement(By.name("courseGrade"));
       Select grade = new Select(Grade);
       grade.selectByValue("number:3");
       Hooks.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/fieldset[1]/div[4]/div[2]/div[4]/div[3]/div[1]/div[1]/div[1]/span[1]/span[1]")).click();
       Hooks.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/fieldset[1]/div[4]/div[2]/div[4]/div[3]/div[1]/div[1]/ul[1]/li[1]/div[3]/span[1]")).click();
       Hooks.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/fieldset[1]/div[4]/div[2]/div[5]/div[2]/div[1]/label[1]/em[1]")).click();
       Hooks.driver.findElement(By.id("btnSaveAsDraftCourse")).click();
       Hooks.driver.findElement(By.id("btnMyCoursesList")).click();
       Hooks.driver.switchTo().alert().accept();
    }

}
