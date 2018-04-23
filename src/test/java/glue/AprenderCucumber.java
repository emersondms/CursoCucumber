package glue;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

public class AprenderCucumber {

    @Dado("^que criei o arquivo corretamente$")
    public void que_criei_o_arquivo_corretamente() {
    }

    @Quando("^executá-lo$")
    public void executá_lo() {
    }

    @Então("^a especificação deve finalizar com sucesso$")
    public void a_especificação_deve_finalizar_com_sucesso() {
    }

    private int contador = 0;

    @Dado("^que o valor do contador é (\\d+)$")
    public void queOValorDoContadorÉ(int arg1) {
        contador = arg1;
    }

    @Quando("^incrementar em (\\d+)$")
    public void incrementarEm(int arg1) {
        contador += arg1;
    }

    @Então("^o valor do contador será (\\d+)$")
    public void oValorDoContadorSerá(int arg1) {
        System.out.println(arg1);
        System.out.println(contador);
        Assert.assertEquals(arg1, contador);
    }
}
