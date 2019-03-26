package procesadorficherointercambio.pojo.xsd;

import java.util.List;

public interface Registro {

    List<Campo> getCampo();

    boolean isRepetible();
}
