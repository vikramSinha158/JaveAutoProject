package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = { "src/test/resources/features/R1Contact/HomeAndReminder.feature" },

glue = "r1.steps.definitions",

monochrome = true,
tags= {"@408189 or  @410384 or @410383 or @410385"},
dryRun= false
		)

public class RunnerTest {

};