package api.internal.avaliador.model.criterio.adicao;

import api.internal.avaliador.model.senha.Senha;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumerosOuSimbolosNoMeio implements CriterioDeAdicao {
    @Override
    public void avaliar(Senha senha) throws Exception {
        List<String> caracteres = Arrays
                .asList(senha.getSenha().split("(?!^)"));
        if(caracteres.size()<3)
            throw new Exception("Menos de 3 caracteres.");
        List<String> caracteresDoMeio = caracteres
                .subList(1, senha.getSenha().length()-1);

        int qntdNumerosOuSimbolosNoMeio = caracteresDoMeio.stream()
                .filter(caracter -> ehNumeroOuSimboloNoMeio(caracter))
                .collect(Collectors.toList())
                .size();

        int resultado = qntdNumerosOuSimbolosNoMeio * 2;
        senha.adicionar(resultado);
    }

    private boolean ehNumeroOuSimboloNoMeio(String caracter) {
        return caracter.matches("[^a-zA-Z]");
    }
}
