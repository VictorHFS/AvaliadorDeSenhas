package api.internal.avaliador.model.senha;

public class SenhaCommand {

    public final String senha;
    public final String nota;
    public final String complexidade;
    public SenhaCommand(String senha, String nota, String complexidade){
        this.senha = senha;
        this.nota = nota;
        this.complexidade = complexidade;
    }
}
