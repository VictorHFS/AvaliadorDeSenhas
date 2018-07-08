package api.model.senha;

import api.internal.avaliador.model.senha.Senha;

public class SenhaBuilder {

    private Integer resultadoDaAvaliacao;
    private String senha;

    public SenhaBuilder(){
        this.senha = "abcD@eF+G1234%56789";
        this.resultadoDaAvaliacao = 0;
    }

    public Senha build(){
        Senha senhaContruida =  new Senha(this.senha);
        senhaContruida.adicionar(resultadoDaAvaliacao);
        return senhaContruida;
    }

    public SenhaBuilder adicionarValorHaAvaliacao(Integer valor){
        this.resultadoDaAvaliacao += valor;
        return this;
    }

    public SenhaBuilder withSenha(String senha){
        this.senha = senha;
        return this;
    }

}
