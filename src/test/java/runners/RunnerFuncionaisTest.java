package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
    monochrome = false, snippets = SnippetType.CAMELCASE,
    dryRun = false, strict = false,
    features = "src/test/resources/",
    glue = "steps",
    tags = {"@Funcionais", "~@Ignore"}
)
public class RunnerFuncionaisTest {

    @BeforeClass
    public static void reset() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://srbarriga.herokuapp.com");
        driver.findElement(By.id("email")).sendKeys("emersondms@hotmail.com");
        driver.findElement(By.id("senha")).sendKeys("emersondms");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}

