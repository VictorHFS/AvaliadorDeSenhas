package api.internal.avaliador.model.senha.complexidade;

public enum Complexidade {
    MuitoCurta("Muito curto"),MuitoFraca("Muito fraca"),Fraca("Fraca"),Boa("Boa"),Forte("Forte"),MuitoForte("Muito forte");

    private final String descricao;

    Complexidade(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

}
