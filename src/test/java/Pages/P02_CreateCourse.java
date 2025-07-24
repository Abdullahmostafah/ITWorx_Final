package Pages;

import Base.TestBase;
import Utils.ConfigReaderWriter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P02_CreateCourse extends TestBase {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String courseName = ConfigReaderWriter.getPropKey("course.name");
    private final String courseGrade = ConfigReaderWriter.getPropKey("course.grade");
    private final String courseSubject = ConfigReaderWriter.getPropKey("course.subject");
    private final String courseTeacher = ConfigReaderWriter.getPropKey("course.teacher");

    @FindBy(id = "btnMyCoursesList")
    private WebElement myCoursesListBtn;

    @FindBy(id = "btnListAddCourse")
    private WebElement addCourseBtn;

    @FindBy(name = "courseName")
    private WebElement courseNameInput;

    @FindBy(name = "courseGrade")
    private WebElement courseGradeDropdown;

    @FindBy(css = "span.select2-selection__rendered")
    private WebElement subjectDropdownClick;

    @FindBy(css = "ul.select2-results__options li")
    private List<WebElement> subjectOptions;

    @FindBy(css = "label.teacher-option")
    private List<WebElement> teacherOptions;

    @FindBy(id = "btnSaveAsDraftCourse")
    private WebElement saveDraftBtn;

    public P02_CreateCourse(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
        if (courseName == null || courseGrade == null || courseSubject == null || courseTeacher == null) {
            throw new IllegalStateException("Course details not found in config");
        }
    }

    public void coursePageIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(myCoursesListBtn)).click();
    }

    public WebElement createCourseIcon() {
        return wait.until(ExpectedConditions.elementToBeClickable(addCourseBtn));
    }

    public void creationSteps() {
        wait.until(ExpectedConditions.visibilityOf(courseNameInput)).sendKeys(courseName);
        wait.until(ExpectedConditions.visibilityOf(courseGradeDropdown));
        new Select(courseGradeDropdown).selectByValue("number:" + courseGrade);
        wait.until(ExpectedConditions.elementToBeClickable(subjectDropdownClick)).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(subjectOptions));
        subjectOptions.stream()
                .filter(option -> option.getText().trim().equals(courseSubject))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Subject '" + courseSubject + "' not found"))
                .click();
        wait.until(ExpectedConditions.visibilityOfAllElements(teacherOptions));
        teacherOptions.stream()
                .filter(option -> option.getText().trim().equals(courseTeacher))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Teacher '" + courseTeacher + "' not found"))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(saveDraftBtn)).click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            // Silent handling
        }

        wait.until(ExpectedConditions.elementToBeClickable(myCoursesListBtn)).click();
    }
}