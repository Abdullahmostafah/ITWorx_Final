package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/main/resources/Features",
                glue ="StepDefinitions",
                tags = "@smoke",
                plugin = { "pretty",
                        "html:target/Report.html",
                        "json:target/Report2.json",
                        "junit:target/Report3.xml",
                        "rerun:target/rerun.txt"}
        )

public class Runners {
}
