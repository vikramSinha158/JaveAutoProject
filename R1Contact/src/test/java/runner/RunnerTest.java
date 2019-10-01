package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Contact/SmokeCases.feature" },
//tags= {"@428416"},
glue = "r1.steps.definitions",
dryRun = false,
monochrome = true

		)

public class RunnerTest {

}