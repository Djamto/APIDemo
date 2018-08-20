package com.demo.api;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by darjandjamtovski on 11/30/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:cucumber.json",
        features = {
                "src/test/resources/features/Competitions.feature",
                "src/test/resources/features/matchers.feature"
        },
        glue = {"com.demo.api.steps", "com.demo.api.base", "com.demo.api.endpoint"},
        tags = {"@Matchers"}
)
public class Runner {
}
