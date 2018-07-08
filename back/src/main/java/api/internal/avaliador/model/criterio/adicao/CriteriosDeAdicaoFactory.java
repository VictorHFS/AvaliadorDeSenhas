package api.internal.avaliador.model.criterio.adicao;

import java.util.ArrayList;
import java.util.List;

public class CriteriosDeAdicaoFactory {

    public static List<CriterioDeAdicao> instanciar(){
        ArrayList<CriterioDeAdicao> criteriosDeAdicao = new ArrayList<>();
        criteriosDeAdicao.add(new LetrasMaiusculas());
        criteriosDeAdicao.add(new LetrasMinusculas());
        criteriosDeAdicao.add(new NumeroDeCaracteres());
        criteriosDeAdicao.add(new Numeros());
        criteriosDeAdicao.add(new NumerosOuSimbolosNoMeio());
        criteriosDeAdicao.add(new RequisitosMinimos());
        criteriosDeAdicao.add(new Simbolos());
        return criteriosDeAdicao;
    }
}
