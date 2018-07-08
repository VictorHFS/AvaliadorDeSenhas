package api.internal.avaliador.model.criterio.subtracao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApenasNumeros implements CriterioDeSubtracao {
    @Override
    public void avaliar(Senha senha) {
        List<String> caracteres = Arrays.asList(senha.getSenha().split("(?!^)"));
        int totalDeCaracteres = caracteres.size();
        int totalDeNumeros = caracteres
                .stream()
                .filter(caracter -> caracter.matches("[0-9]"))
                .collect(Collectors.toList())
                .size();
        if(totalDeCaracteres == totalDeNumeros){
            int resultado =  - totalDeNumeros;
            senha.adicionar(resultado);
        }
    }
}
