package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = { "src/test/resources/features/R1Contact/HomeAndReminder.feature" },

glue = "r1.steps.definitions",

monochrome = true,
tags= {"@410385 or @410384 or @410383"},
dryRun= false
		)

public class RunnerTest {

};