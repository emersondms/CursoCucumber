package services;

import entidades.Filme;
import entidades.NotaAluguel;
import utils.DateUtils;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, String tipoAluguel) {
        if (filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAluguel());
        nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));
        nota.setPontuacao(1);

        if ("extendido".equals(tipoAluguel)) {
            nota.setPreco(filme.getAluguel() * 2);
            nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
            nota.setPontuacao(2);
        }

        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}