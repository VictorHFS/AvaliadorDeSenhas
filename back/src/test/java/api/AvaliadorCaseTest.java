package api;

import api.internal.avaliador.model.senha.Senha;
import api.internal.avaliador.model.senha.SenhaCommand;
import api.internal.avaliador.service.AvaliadorService;
import api.model.senha.SenhaBuilder;
import api.model.senha.SenhaCommandBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
public class AvaliadorCaseTest {

    @Autowired
    private AvaliadorService service;

    @Test
    public void avaliarSenha() throws Exception{
        SenhaCommandBuilder builder = new SenhaCommandBuilder();
        SenhaCommand command = builder.build();
        assertTrue(command != null);
        Senha senha = service.avaliarSenha(command);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 185);
    }

}
