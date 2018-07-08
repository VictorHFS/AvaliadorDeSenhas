package api.internal.avaliador.model.criterio.adicao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;

public class NumeroDeCaracteres implements CriterioDeAdicao {
    @Override
    public void avaliar(Senha senha) {

        int qntdDeCaracteres = senha.getSenha().length();
        int resultado = qntdDeCaracteres * 4;

        senha.adicionar(resultado);
    }
}
