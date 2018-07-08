package api.internal.avaliador.model.criterio.adicao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LetrasMaiusculas implements CriterioDeAdicao {
    @Override
    public void avaliar(Senha senha) {
        int letrasMaiusculas = Arrays.asList(senha.getSenha().split("(?!^)"))
                .stream()
                .filter(letra-> ehMaiuscula(letra))
                .collect(Collectors.toList())
                .size();

        int quantidadeDeCaracteres = senha.getSenha().length();
        int resultado = 0;
        if(letrasMaiusculas>0)
             resultado = (quantidadeDeCaracteres-letrasMaiusculas) * 2;
        senha.adicionar(resultado);
    }

    private boolean ehMaiuscula(String letra) {
        boolean ehMaiuscula = letra.matches("[A-Z]");
        return ehMaiuscula;
    }
}
