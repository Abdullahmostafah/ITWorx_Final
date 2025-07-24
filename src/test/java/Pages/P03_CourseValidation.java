package Pages;

import Base.TestBase;
import Utils.ConfigReaderWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class P03_CourseValidation extends TestBase {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String courseName = ConfigReaderWriter.getPropKey("course.name");

    @FindBy(id = "btnMyCoursesList")
    private WebElement myCoursesListBtn;

    @FindBy(id = "txtCourseSearch")
    private WebElement courseSearchBox;

    @FindBy(css = "div.course-list-item span.course-title")
    private List<WebElement> courseResults;

    public P03_CourseValidation(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        if (courseName == null) {
            throw new IllegalStateException("Course name not found in config");
        }
    }

    public void coursePageIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(myCoursesListBtn)).click();
    }

    public void searchCourse() {
        wait.until(ExpectedConditions.visibilityOf(courseSearchBox)).sendKeys(courseName);
        courseSearchBox.submit();
    }

    public void verifyCourseDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(courseResults));
        boolean courseFound = courseResults.stream()
                .anyMatch(element -> element.getText().trim().equals(courseName));
        Assert.assertTrue(courseFound, "Course title '" + courseName + "' not displayed in course list");
    }
}