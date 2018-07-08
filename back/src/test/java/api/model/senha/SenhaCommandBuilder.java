package api.model.senha;

import api.internal.avaliador.model.senha.Senha;
import api.internal.avaliador.model.senha.SenhaCommand;

public class SenhaCommandBuilder {

    private String nota;
    private String senha;
    private String complexidade;

    public SenhaCommandBuilder(){
        this.senha = "abcD@eF+G1234%56789";
        this.nota = "0";
        this.complexidade="";
    }

    public SenhaCommand build(){
        SenhaCommand command = new SenhaCommand(senha, nota, complexidade);
        return command;
    }

    public SenhaCommandBuilder withNota(String nota){
        this.nota = nota;
        return this;
    }

    public SenhaCommandBuilder withSenha(String senha){
        this.senha = senha;
        return this;
    }

}
