package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InserirContasSteps {

    private WebDriver driver;

    @Dado("^que estou acessando a aplicação$")
    public void queEstouAcessandoAAplicação() {
        driver = new FirefoxDriver();
        driver.get("https://srbarriga.herokuapp.com");
    }

    @Quando("^informo o usuário \"([^\"]*)\"$")
    public void informoOUsuário(String arg1) {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }

    @Quando("^a senha \"([^\"]*)\"$")
    public void aSenha(String arg1) {
        driver.findElement(By.id("senha")).sendKeys(arg1);
    }

    @Quando("^seleciono entrar$")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("^visualizo a página inicial$")
    public void visualizoAPáginaInicial() {
        Assert.assertEquals(
            "Bem vindo, Emerson!",
            driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText()
        );
    }

    @Quando("^seleciono Contas$")
    public void selecionoContas() {
        driver.findElement(By.linkText("Contas")).click();
    }

    @Quando("^seleciono Adicionar$")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("^informo a conta \"([^\"]*)\"$")
    public void informoAConta(String arg1) {
        driver.findElement(By.id("nome")).sendKeys(arg1);
    }

    @Quando("^seleciono Salvar$")
    public void selecionoSalvar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("^a conta é inserida com sucesso$")
    public void aContaÉInseridaComSucesso() {
        Assert.assertEquals(
            "Conta adicionada com sucesso!",
            driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText()
        );
    }

    @Então("^sou notificado que o nome da conta é obrigatório$")
    public void souNotificadoQueONomeDaContaÉObrigatório() {
        Assert.assertEquals(
            "Informe o nome da conta",
            driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
        );
    }

    @Então("^sou notificado que já existe uma conta com esse nome$")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
        Assert.assertEquals(
            "Já existe uma conta com esse nome!",
            driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
        );
    }

    @Before
    public void inicia() {
        System.out.println("Começando aqui...");
    }

    @After
    public void fecharBrowser() {
        driver.quit();
        System.out.println("Terminando...");
    }
}
