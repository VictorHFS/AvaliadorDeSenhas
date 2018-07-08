package api.internal.avaliador.model.criterio;

import api.internal.avaliador.model.criterio.adicao.CriteriosDeAdicaoFactory;
import api.internal.avaliador.model.criterio.subtracao.CriteriosDeSubtracaoFactory;

import java.util.List;

public class CriterioFactory {

    public static List<Criterio> instanciarCriterios(){
        List<Criterio> criterios = (List<Criterio>)(List<?>)CriteriosDeAdicaoFactory.instanciar();
        criterios.addAll(
                (List<Criterio>)(List<?>) CriteriosDeSubtracaoFactory.instanciar()
        );
        return criterios;
    }
}
