package api.internal.avaliador.model.criterio.subtracao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.List;

public class LetrasSequenciais implements CriterioDeSubtracao {


    @Override
    public void avaliar(Senha senha) {
        List<String> caracteres = Arrays.asList(senha.getSenha().split("(?!^)"));
        for(int i = 0; i < caracteres.size(); i ++){
            if(i+2 < caracteres.size()){
                String caracter = caracteres.get(i);
                String caracterSeguinte = caracteres.get(i+1);
                String caracterCosequente = caracteres.get(i+2);
                if(ehLetra(caracter)
                        && ehLetra(caracterSeguinte)
                        && ehLetra(caracterCosequente)){
                    int resultado = -3;
                    senha.adicionar(resultado);
                }
            }
        }
    }

    private boolean ehLetra(String caracter) {
        return caracter.matches("[A-Za-z]");
    }
}
