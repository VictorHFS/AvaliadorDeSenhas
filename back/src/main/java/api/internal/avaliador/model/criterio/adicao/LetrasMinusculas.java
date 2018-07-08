package api.internal.avaliador.model.criterio.adicao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LetrasMinusculas implements CriterioDeAdicao{
    @Override
    public void avaliar(Senha senha) {

        int letrasMinusculas = Arrays.asList(senha.getSenha().split("(?!^)"))
                .stream().filter(letra-> ehMinuscula(letra))
                .collect(Collectors.toList())
                .size();

        int quantidadeDeCaracteres = senha.getSenha().length();
        int resultado = 0;
        if(letrasMinusculas>0)
            resultado = (quantidadeDeCaracteres-letrasMinusculas) * 2;
        senha.adicionar(resultado);
    }

    private boolean ehMinuscula(String letra) {
        boolean ehMaiuscula = letra.matches("[a-z]");
        return ehMaiuscula;
    }
}
