package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = { "src/test/resources/features/R1Contact/ApiConfiguration.feature" },

glue = "r1.steps.definitions",

monochrome = true,
//tags= {"@Test"},
dryRun= false
		)

public class RunnerTest {

};