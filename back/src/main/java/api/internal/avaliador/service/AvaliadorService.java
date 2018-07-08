package api.internal.avaliador.service;

import api.internal.avaliador.model.criterio.Criterio;
import api.internal.avaliador.model.criterio.CriterioFactory;
import api.internal.avaliador.model.senha.Senha;
import api.internal.avaliador.model.senha.SenhaCommand;
import api.internal.avaliador.model.senha.SenhaHandler;
import api.internal.avaliador.model.senha.complexidade.ComplexidadeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliadorService {

    public Senha avaliarSenha(SenhaCommand command){
        SenhaHandler handler = new SenhaHandler(command);
        Senha senha = handler.senha;
        List<Criterio> criterios =  CriterioFactory.instanciarCriterios();
        int resultadoDaAvaliacao = 0;
        criterios.forEach(criterio->{
            try{
                criterio.avaliar(senha);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
        String novaComplexidade = ComplexidadeFactory.instance(senha).getDescricao();
        senha.setComplexidade(novaComplexidade);
        return senha;
    }
}
