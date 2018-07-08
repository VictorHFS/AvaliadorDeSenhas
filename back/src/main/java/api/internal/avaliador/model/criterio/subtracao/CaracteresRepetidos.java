package api.internal.avaliador.model.criterio.subtracao;

import api.internal.avaliador.model.senha.Senha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CaracteresRepetidos implements CriterioDeSubtracao {
    @Override
    public void avaliar(Senha senha) {
        List<String> usados = new ArrayList<>();
        List<String> caracteres = Arrays.asList(senha.getSenha().split("(?!^)"));
        int resultado = 0;
        for(String  caracter: caracteres){
            int ocorrencias = ocorrenciasDe(caracter, caracteres);
            if(ocorrencias > 1 ){
                if(!usados.contains(caracter)){
                    usados.add(caracter);
                    resultado -= ocorrencias;
                }
            }
        }
        senha.adicionar(resultado/2);
    }

    private int ocorrenciasDe(String original, List<String> caracteres) {
        return caracteres
                    .stream()
                    .filter(caracter -> caracter.equals(original))
                    .collect(Collectors.toList())
                    .size();
    }
}
