package api.internal.avaliador.model.criterio;

import api.internal.avaliador.model.senha.Senha;

public interface Criterio {
    void avaliar(Senha senha) throws Exception;
}
