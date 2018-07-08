package api.internal.avaliador.model.criterio.subtracao;

import java.util.ArrayList;
import java.util.List;

public class CriteriosDeSubtracaoFactory {

    public static List<CriterioDeSubtracao> instanciar(){
        ArrayList<CriterioDeSubtracao> criterioDeSubtracaos = new ArrayList<>();
        criterioDeSubtracaos.add(new ApenasNumeros());
        criterioDeSubtracaos.add(new ApenasLetras());
        criterioDeSubtracaos.add(new CaracteresRepetidos());
        criterioDeSubtracaos.add(new LetrasSequenciais());
        criterioDeSubtracaos.add(new MaiusculosConsecutivos());
        criterioDeSubtracaos.add(new MinusculosConsecutivos());
        criterioDeSubtracaos.add(new NumerosConsecutivos());
        criterioDeSubtracaos.add(new NumerosSequenciais());
        criterioDeSubtracaos.add(new SimbolosSequenciais());
        return criterioDeSubtracaos;
    }
}
