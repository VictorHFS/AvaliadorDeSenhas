package api.internal.avaliador.model.criterio.adicao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RequisitosMinimos implements CriterioDeAdicao {

    /*
    Minimum 8 characters in length
    Contains 3/4 of the following items:
    - Uppercase Letters
    - Lowercase Letters
    - Numbers
    - Symbols
     */
    @Override
    public void avaliar(Senha senha) {
        String dados = senha.getSenha();
        int qntdDeCriterio = 0;
        boolean minimoDeCaracteres = dados.length() > 8;
        if(minimoDeCaracteres){
            qntdDeCriterio = quantidadeDeCriterios(dados);
            qntdDeCriterio += qntdDeCriterio > 0 ? 1 : 0;
            int resultado = qntdDeCriterio * 2;
            senha.adicionar(resultado);
        }

    }

    private int quantidadeDeCriterios(String dados) {
        int qntdDeCriteiros = 0;
        List<String> caracteres = Arrays.asList(dados.split("(?!^)"));
        if(possuiMaiusculos(caracteres))
            qntdDeCriteiros++;
        if(possuiMinusculos(caracteres))
            qntdDeCriteiros++;
        if(possuiNumeros(caracteres))
            qntdDeCriteiros++;
        if(verificaSeExistemSimbolos(dados))
            qntdDeCriteiros++;
        if(qntdDeCriteiros >= 3)
            return qntdDeCriteiros;
        else
            return 0;
    }

    private boolean possuiNumeros(List<String> caracteres) {
        for(String caracter: caracteres)
            if(caracter.matches("[0-9]"))
                return true;
        return false;
    }

    private boolean possuiMinusculos(List<String> caracteres) {
        for(String caracter: caracteres)
            if(caracter.matches("[a-z]"))
                return true;
        return false;
    }

    private boolean possuiMaiusculos(List<String> caracteres) {
        for(String caracter: caracteres)
            if(caracter.matches("[A-Z]"))
                return true;
        return false;
    }

    private boolean verificaSeExistemSimbolos(String dados) {
        List<String> caracteres = Arrays
                .asList(dados.split("(?!^)"));
        int qntdeDeSimbolos = caracteres
                .stream()
                .filter(caracter -> ehSimbolo(caracter))
                .collect(Collectors.toList())
                .size();

        return qntdeDeSimbolos > 0;
    }

    private boolean ehSimbolo(String caracter) {
        return caracter.matches("[^a-zA-Z0-9]");
    }
}
