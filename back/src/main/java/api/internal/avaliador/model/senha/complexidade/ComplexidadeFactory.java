package api.internal.avaliador.model.senha.complexidade;

import api.internal.avaliador.model.senha.Senha;

public class ComplexidadeFactory {
    public static Complexidade instance(Senha senha){
        Complexidade resultado = Complexidade.MuitoCurta;
        Integer nota = senha.getNota();
        if(nota >= 80){
            resultado = Complexidade.MuitoForte;
        }else if(nota >= 60){
            resultado = Complexidade.Forte;
        }else if(nota >= 40){
            resultado = Complexidade.Boa;
        }else if(nota >= 20){
            resultado = Complexidade.Fraca;
        }else if(nota > 0){
            resultado = Complexidade.MuitoFraca;
        }
        return resultado;
    }
}
