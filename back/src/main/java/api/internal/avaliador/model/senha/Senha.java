package api.internal.avaliador.model.senha;


public class Senha {

    private final String senha;
    private Integer nota;
    private String complexidade;

    public Senha(String valor){
        this.senha = valor;
        this.nota = 0;
    }

    public String getSenha() {
        return senha;
    }

    public Integer getNota() {
        return nota;
    }

    public void adicionar(Integer valor) {
        this.nota += valor;
    }

    public String getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(String complexidade) {
        this.complexidade = complexidade;
    }
}
