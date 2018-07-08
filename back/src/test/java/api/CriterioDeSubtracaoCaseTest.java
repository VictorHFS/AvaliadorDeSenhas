package api;


import api.internal.avaliador.model.criterio.subtracao.*;
import api.internal.avaliador.model.senha.Senha;
import api.model.senha.SenhaBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
public class CriterioDeSubtracaoCaseTest {

    @Test
    public void testarCriterioApenasLetras(){
        SenhaBuilder builder = new SenhaBuilder();
        builder.withSenha("abcdefg");
        Senha senha =builder.build();
        new ApenasLetras().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == -7);
    }

    @Test
    public void testarCriterioApenasNumeros(){
        SenhaBuilder builder = new SenhaBuilder();
        builder.withSenha("123456789");
        Senha senha =builder.build();
        new ApenasNumeros().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == -9);
    }

    @Test
    public void testarCriterioCaracteresRepetidos(){
        SenhaBuilder builder = new SenhaBuilder();
        builder.withSenha("aabcCcdDeffFg");
        Senha senha =builder.build();
        new CaracteresRepetidos().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == -3);
    }

    @Test
    public void testarCriterioLetrasSequenciais(){
        SenhaBuilder builder = new SenhaBuilder();
        builder.withSenha("abcdefg");
        Senha senha =builder.build();
        new LetrasSequenciais().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == -15);
    }

    @Test
    public void testarCriterioMaiusculosConsecutivos(){
        SenhaBuilder builder = new SenhaBuilder();
        builder.withSenha("abBCcdDEefg");
        Senha senha =builder.build();
        new MaiusculosConsecutivos().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == -4);
    }

    @Test
    public void testarCriterioMinucsculosConsecutivos(){
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha = builder.build();
        new MinusculosConsecutivos().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == -4);
    }

    @Test
    public void testarCriterioNumerosConsecutivos(){
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha =builder.build();
        new NumerosConsecutivos().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == -14);
    }

    @Test
    public void testarCriterioNumerosSequenciais(){
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha = builder.build();
        new NumerosSequenciais().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == -15);
    }

    @Test
    public void testarCriterioSimbolosSequenciais(){
        SenhaBuilder builder = new SenhaBuilder();
        builder.withSenha("¨!@#$%");
        Senha senha =builder.build();
        new SimbolosSequenciais().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == -9);
    }
}
