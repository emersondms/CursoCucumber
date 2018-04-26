package steps;

import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import converters.DateConverter;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumberSteps {

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

    private Date entrega = new Date();

    @Dado("^que a entrega é dia (.*)$")
    public void queAEntregaÉDia(@Transform(DateConverter.class) Date data) {
        entrega = data;
        System.out.println(entrega);
    }

    @Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
    public void aEntregaAtrasarEmDias(int arg1, String tempo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        if (tempo.equals("dias")) cal.add(Calendar.DAY_OF_MONTH, arg1);
        if (tempo.equals("meses")) cal.add(Calendar.MONTH, arg1);
        entrega = cal.getTime();
    }

    @Então("^a entrega será efetuada em (\\d{2}/\\d{2}/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
        Assert.assertEquals(data, new SimpleDateFormat("dd/MM/yyyy").format(entrega));
    }

    @Dado("^que o ticket( especial)? é (A.\\d{3})$")
    public void queOTicketÉAF(String tipo, String arg1) {
    }

    @Dado("^que o valor da passagem é R\\$ (.*)$")
    public void queOValorDaPassagemÉR$(Double numero) {
        System.out.println(numero);
    }

    @Dado("^que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroÉ(String arg1) {
    }

    @Dado("^que o telefone do passageiro é 9(\\d{3})-(\\d+)$")
    public void queOTelefoneDoPassageiroÉ(int arg1, int arg2) {
    }

    @Quando("^criar os steps$")
    public void criarOsSteps() {
    }

    @Então("^o teste vai funcionar$")
    public void oTesteVaiFuncionar() {
    }
}
