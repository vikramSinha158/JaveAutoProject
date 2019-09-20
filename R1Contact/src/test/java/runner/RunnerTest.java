package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/R1Contact/HomeAndReminder.feature" }, 
//tags = { "@419105"}, 
glue = "r1.steps.definitions",
/*dryRun = true,*/
monochrome=true)

public class RunnerTest {

	
	
}