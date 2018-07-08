package api.internal.avaliador.model.criterio.subtracao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.List;

public class MinusculosConsecutivos implements CriterioDeSubtracao {
    @Override
    public void avaliar(Senha senha) {
        List<String> caracteres = Arrays.asList(senha.getSenha().split("(?!^)"));
        for(int i = 0; i < caracteres.size(); i ++){
            if(i+1 < caracteres.size()){
                String caracter = caracteres.get(i);
                String caracterSeguinte = caracteres.get(i+1);
                if(ehMinusculo(caracter) && ehMinusculo(caracterSeguinte)){
                    int resultado = -2;
                    senha.adicionar(resultado);
                }
            }
        }
    }

    private boolean ehMinusculo(String caracter) {
        return caracter.matches("[a-z]");
    }
}
