import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/rmoharana/git/Cucumber-JVM-Masterthought/Features/PartnerBankTest.feature"},
        plugin = {"json:/Users/rmoharana/git/Cucumber-JVM-Masterthought/target/cucumber-parallel/2.json"},
        monochrome = true,
        tags = {"@InterestOffers,@PartnerBank"},
        glue = {"com.raisin.stepdefinitions"})
public class Parallel02IT {
}
