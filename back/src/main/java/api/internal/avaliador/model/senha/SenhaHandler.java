package api.internal.avaliador.model.senha;

public class SenhaHandler {

    public final Senha senha;
    public SenhaHandler(SenhaCommand command){
        this.senha = new Senha(command.senha);
        Integer nota = castInt(command.nota);
        this.senha.adicionar(nota);
        this.senha.setComplexidade(command.complexidade);
    }

    private Integer castInt(String nota) {
        return Integer.valueOf(nota);
    }
}
