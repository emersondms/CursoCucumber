package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = "pretty", monochrome = true,
    snippets = SnippetType.CAMELCASE,
    dryRun = false, strict = false,
    features = "src/test/resources/aprender_cucumber.feature",
    glue = "steps",
    tags = {"@Tipo1, @Tipo2", "~@Ignore"}
)
public class Runner {
}
