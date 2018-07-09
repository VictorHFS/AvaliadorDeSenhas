package api.internal.avaliador.model.senha;

public class SenhaHandler {

    public final Senha senha;
    public SenhaHandler(SenhaCommand command){
        String cSenha = command.senha;
        String cNota = command.nota;
        String cCompl = command.complexidade;
        Integer nota = castInt(cNota == null? "0": cNota);
        this.senha = new Senha(cSenha == null ? "": cSenha);
        this.senha.adicionar(nota);
        this.senha.setComplexidade(cCompl == null? "": cCompl);
    }

    private Integer castInt(String nota) {
        return Integer.valueOf(nota);
    }
}
