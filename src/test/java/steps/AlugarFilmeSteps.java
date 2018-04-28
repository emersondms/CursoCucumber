package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import entidades.Filme;
import entidades.NotaAluguel;
import org.junit.Assert;
import services.AluguelService;
import utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private String tipoAluguel;

    @Dado("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(int arg1) {
        filme = new Filme();
        filme.setEstoque(arg1);
    }

    @Dado("^que o preço de aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDeAluguelSejaR$(int arg1) {
        filme.setAluguel(arg1);
    }

    @Quando("^alugar$")
    public void alugar() {
        try {
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Então("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(int arg1) {
        Assert.assertEquals(arg1, nota.getPreco());
    }

    @Então("^o estoque do filme será (\\d+) unidade$")
    public void oEstoqueDoFilmeSeráUnidade(int arg1) {
        Assert.assertEquals(arg1, filme.getEstoque());
    }

    @Então("^não será possível por falta de estoque$")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Dado("^que o tipo do aluguel seja (.*)")
    public void queOTipoDoAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo;
    }

    @Então("^a data de entrega será em (\\d+) dias?$")
    public void aDataDeEntregaSeráEmDias(int arg1) {
        Date dataEsperada = DateUtils.obterDataDiferencaDias(arg1);
        Date dataReal = nota.getDataEntrega();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Então("^a pontuação recebida será de (\\d+) pontos?$")
    public void aPontuaçãoRecebidaSeráDePontos(int arg1) {
        Assert.assertEquals(arg1, nota.getPontuacao());
    }
}