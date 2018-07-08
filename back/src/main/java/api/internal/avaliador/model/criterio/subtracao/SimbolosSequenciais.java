package api.internal.avaliador.model.criterio.subtracao;

import api.internal.avaliador.model.criterio.subtracao.CriterioDeSubtracao;
import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.List;

public class SimbolosSequenciais implements CriterioDeSubtracao {
    @Override
    public void avaliar(Senha senha) {
        List<String> caracteres = Arrays.asList(senha.getSenha().split("(?!^)"));
        for(int i = 0; i < caracteres.size(); i ++){
            if(i+3 < caracteres.size()){
                String caracter = caracteres.get(i);
                String caracterSeguinte = caracteres.get(i+1);
                String caracterCosequente = caracteres.get(i+2);
                String caracterPoscosequente = caracteres.get(i+3);
                if(ehSimbolo(caracter)
                        && ehSimbolo(caracterSeguinte)
                        && ehSimbolo(caracterCosequente)
                        && ehSimbolo(caracterPoscosequente)){
                    int resultado = -3;
                    senha.adicionar(resultado);
                }
            }
        }
    }

    private boolean ehSimbolo(String caracter) {
        return !caracter.matches("[A-Za-z0-9]*");
    }
}
