package procesadorficherointercambio.enumeration;

public enum TipoDatoEnum {

    ALFANUMERICO("alfanum\u00e9rico"),
    NUMERICO("num\u00e9rico"),
    REGEXP("regexp"),
    TEXTO("texto"),
    DECIMAL("decimal");

    private String valor;

    TipoDatoEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static TipoDatoEnum valueOfValor(String valor) {
        for (TipoDatoEnum e : values()) {
            if (e.valor.equals(valor)) {
                return e;
            }
        }
        return null;
    }
}
