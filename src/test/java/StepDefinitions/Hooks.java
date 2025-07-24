package StepDefinitions;

import Base.TestBase;
import Utils.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import java.io.File;
import java.nio.file.Paths;

public class Hooks extends TestBase {
    @BeforeAll
    public void initDriver() {
        setUp();
    }

    @AfterAll
    public void closeDriver(io.cucumber.java.Scenario scenario) {
        if (driver != null) {
            if (scenario.isFailed()) {
                String screenshotPath = ScreenshotUtils.takeScreenshot(driver, scenario.getName());
                if (screenshotPath != null && !screenshotPath.isEmpty()) {
                    try {
                        String relativePath = Paths.get("..", "screenshots", new File(screenshotPath).getName()).toString();
                        scenario.attach(
                                java.nio.file.Files.readAllBytes(new File(screenshotPath).toPath()),
                                "image/png",
                                "Failure Screenshot"
                        );
                        System.out.println("Screenshot attached to report: " + relativePath);
                    } catch (Exception e) {
                        System.err.println("Failed to attach screenshot to scenario '" + scenario.getName() + "': " + e.getMessage());
                    }
                } else {
                    System.err.println("Screenshot path is empty for scenario '" + scenario.getName() + "'");
                }
            }
            tearDown();
        }
    }
}