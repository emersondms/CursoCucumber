package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("^que desejo adicionar uma conta$")
    public void queDesejoAdicionarUmaConta() {
        driver = new FirefoxDriver();
        driver.get("https://srbarriga.herokuapp.com");
        driver.findElement(By.id("email")).sendKeys("emersondms@hotmail.com");
        driver.findElement(By.id("senha")).sendKeys("emersondms");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("^adiciono a conta \"([^\"]*)\"$")
    public void informoAConta(String arg1) {
        driver.findElement(By.id("nome")).sendKeys(arg1);
        driver.findElement(By.tagName("button")).click();
    }

    @Então("^recebo a mensagem \"([^\"]*)\"$")
    public void receboAMensagem(String arg1) {
        Assert.assertEquals(arg1,
            driver.findElement(By.xpath(
                "//div[starts-with(@class, 'alert alert-')]"
            )).getText()
        );
    }

    @Before
    public void inicia() {
        System.out.println("Começando aqui...");
    }

    @After(order = 1, value = {"@Funcionais"})
    public void screenShot(Scenario scenario) throws IOException {
        FileUtils.copyFile(
            ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
            new File("target/screenshots/"+scenario.getId()+".jpg")
        );
    }

    @After(order = 0, value = {"@Funcionais"})
    public void fecharBrowser() {
        driver.quit();
        System.out.println("Terminando...");
    }
}
