package api;

import api.internal.avaliador.model.criterio.adicao.*;
import api.internal.avaliador.model.senha.Senha;
import api.model.senha.SenhaBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
public class CriterioDeAdicaoCaseTest {

    @Test
    public void testarCriterioLetrasMaiusculas() throws Exception{
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha = builder.build();
        new LetrasMaiusculas().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 32);
    }

    @Test
    public void testarCriterioLetrasMinusculas() throws Exception{
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha = builder.build();
        new LetrasMinusculas().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 30);
    }

    @Test
    public void testarCriterioNumeroDeCaracteres(){
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha = builder.build();
        new NumeroDeCaracteres().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 76);
    }

    @Test
    public void testarCriterioNumeros(){
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha = builder.build();
        new Numeros().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 36);
    }

    @Test
    public void testarCriterioNumerosOuSimbolosNoMeio() throws Exception{
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha = builder.build();
        new NumerosOuSimbolosNoMeio().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 22);
    }

    @Test
    public void testarRequisitosMinimosSemSimbolos(){
        SenhaBuilder builder = new SenhaBuilder();
        builder.withSenha("abcDEFg123456789");
        Senha senha = builder.build();
        new RequisitosMinimos().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 8);
    }

    @Test
    public void testarRequisitosMinimosComSimbolos(){
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha = builder.build();
        new RequisitosMinimos().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 10);
    }

    @Test
    public void testarSimbolos(){
        SenhaBuilder builder = new SenhaBuilder();
        Senha senha = builder.build();
        new Simbolos().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 18);
    }

    @Test
    public void testarTodosOsCriteiriosDeAdicao() throws Exception{
        SenhaBuilder builder = new SenhaBuilder();
        //builder.withSenha("abcDEFg_+123456@789");
        Senha senha = builder.build();
        new LetrasMaiusculas().avaliar(senha);
        new LetrasMinusculas().avaliar(senha);
        new NumeroDeCaracteres().avaliar(senha);
        new Numeros().avaliar(senha);
        new NumerosOuSimbolosNoMeio().avaliar(senha);
        new RequisitosMinimos().avaliar(senha);
        new Simbolos().avaliar(senha);
        assertTrue(senha.getSenha() != null);
        assertTrue(senha.getNota() == 224);
    }

}
