package api.internal.avaliador.model.criterio.adicao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Numeros implements CriterioDeAdicao {
    @Override
    public void avaliar(Senha senha) {
        int qntdNumeros = Arrays.asList(senha.getSenha().split("(?!^)"))
                .stream()
                .filter(caracter -> ehNumero(caracter))
                .collect(Collectors.toList())
                .size();

        int resultado = qntdNumeros * 4;
        senha.adicionar(resultado);
    }

    private boolean ehNumero(String caracter) {
        return caracter.matches("[0-9]*");
    }
}
