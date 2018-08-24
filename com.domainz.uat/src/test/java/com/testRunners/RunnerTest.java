package com.testRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		strict = false,
		features = {"src/test/java/com/face/features"},
		glue = {"core.Hooks", "com.face.stepDefinitions"},
		tags = {"@FunctionalAutomation1"},
		
			//	dryRun = true,
		monochrome = true,
		
		format = {
				"pretty",
				"html:src/test/java/testresult/cucumber-report",
				"junit:src/test/java/testresult/cucumber-report/cucumber.xml",
				"json:src/test/java/testresult/cucumber-report/cucumber.json",
				"html:target/cucumber-html-report"
		}
		
		)
/**
 * @ScriptName    : TestRunner
 * @Description   : This class contains   
 * @Author: Digvijay Dusane(Aress) @Creation Date : 28 Nov 2017   @Modified Date:                      
 */
public class RunnerTest
{
	
}
