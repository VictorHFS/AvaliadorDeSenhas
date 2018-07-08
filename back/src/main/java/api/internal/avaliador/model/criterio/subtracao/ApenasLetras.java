package api.internal.avaliador.model.criterio.subtracao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ApenasLetras implements CriterioDeSubtracao {
    @Override
    public void avaliar(Senha senha) {
        List<String> caracteres = Arrays.asList(senha.getSenha().split("(?!^)"));
        int totalDeCaracteres = caracteres.size();
        int totalDeLetras = caracteres
                .stream()
                .filter(caracter -> caracter.matches("[a-z][A-Z]*"))
                .collect(Collectors.toList())
                .size();
        if(totalDeCaracteres == totalDeLetras){
            int resultado =  - totalDeLetras;
            senha.adicionar(resultado);
        }
    }
}
