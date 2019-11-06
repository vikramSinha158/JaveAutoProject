package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = { "src/test/resources/features/R1Contact/HomeAndReminder.feature" },

glue = "r1.steps.definitions",

monochrome = true,
tags= {"@440387"},
dryRun= false
		)

public class RunnerTest {

};