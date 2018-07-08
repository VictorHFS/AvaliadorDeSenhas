package api.internal.avaliador.model.criterio.adicao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Simbolos implements CriterioDeAdicao {
    @Override
    public void avaliar(Senha senha) {
        List<String> caracteres = Arrays.asList(senha.getSenha().split("(?!^)"));
        int qntdDeSimbolos = caracteres
                .stream()
                .filter(caracter -> ehSimbolo(caracter))
                .collect(Collectors.toList())
                .size();

        int resultado = qntdDeSimbolos * 6;
        senha.adicionar(resultado);
    }

    private boolean ehSimbolo(String caracter) {
        return caracter.matches("[^a-zA-Z0-9]");
    }
}
