package api.internal.avaliador.model.criterio.subtracao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.List;

public class NumerosSequenciais implements CriterioDeSubtracao {
    @Override
    public void avaliar(Senha senha) {
        List<String> caracteres = Arrays.asList(senha.getSenha().split("(?!^)"));
        for(int i = 0; i < caracteres.size(); i ++){
            if(i+2 < caracteres.size()){
                String caracter = caracteres.get(i);
                String caracterSeguinte = caracteres.get(i+1);
                String caracterCosequente = caracteres.get(i+2);
                if(ehNumero(caracter)
                        && ehNumero(caracterSeguinte)
                        && ehNumero(caracterCosequente)){
                    int resultado = -3;
                    senha.adicionar(resultado);
                }
            }
        }
    }

    private boolean ehNumero(String caracter) {
        return caracter.matches("[0-9]");
    }
}
