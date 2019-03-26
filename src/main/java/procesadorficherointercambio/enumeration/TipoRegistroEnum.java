package procesadorficherointercambio.enumeration;

public enum TipoRegistroEnum {
    CABECERA,
    OPERACION,
    TOTALES;

    private TipoRegistroEnum siguiente;

    static {
        CABECERA.siguiente = OPERACION;
        OPERACION.siguiente = TOTALES;
        TOTALES.siguiente = null;
    }

    public TipoRegistroEnum getSiguiente() {
        return siguiente;
    }
}
