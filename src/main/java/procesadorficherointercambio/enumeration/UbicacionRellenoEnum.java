package procesadorficherointercambio.enumeration;

public enum UbicacionRellenoEnum {

    DERECHA("derecha"),
    IZQUIERDA("izquierda");

    private String valor;

    UbicacionRellenoEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static UbicacionRellenoEnum valueOfValor(String valor) {
        for (UbicacionRellenoEnum e : values()) {
            if (e.valor.equals(valor)) {
                return e;
            }
        }
        return null;
    }
}
