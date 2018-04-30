package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
    monochrome = false, snippets = SnippetType.CAMELCASE,
    dryRun = false, strict = false,
    features = "src/test/resources/",
    glue = "steps",
    tags = {"@Unitários", "~@Ignore"}
)
public class RunnerUnitariosTest {
}

