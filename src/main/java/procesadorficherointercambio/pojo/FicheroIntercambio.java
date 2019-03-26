package procesadorficherointercambio.pojo;

import java.util.ArrayList;
import java.util.HashMap;

public class FicheroIntercambio {
    private ArrayList<HashMap<String, String>> listaCabecera = new ArrayList<HashMap<String, String>>();
    private ArrayList<HashMap<String, String>> listaOperacion = new ArrayList<HashMap<String, String>>();
    private ArrayList<HashMap<String, String>> listaTotales = new ArrayList<HashMap<String, String>>();

    //region Getters cuando hay un solo elemento

    /**
     * Devuelve la cabecera cuando sólo hay 1 ó 0.
     *
     * @return La cabecera del fichero.
     */
    public HashMap<String, String> getCabecera() {
        if (this.listaCabecera.size() > 1)
            throw new UnsupportedOperationException("El número de cabeceras (" + this.listaCabecera.size() + ") debe ser 1 para poder utilizar este método.");
        if(this.listaCabecera.size() == 0)
            return null;
        return this.listaCabecera.get(0);
    }

    /**
     * Devuelve la operación cuando sólo hay 1 ó 0.
     *
     * @return La operación del fichero.
     */
    public HashMap<String, String> getOperacion() {
        if (this.listaOperacion.size() > 1)
            throw new UnsupportedOperationException("El número de operaciones (" + this.listaOperacion.size() + ") debe ser 1 para poder utilizar este método.");
        if(this.listaOperacion.size() == 0)
            return null;
        return this.listaOperacion.get(0);
    }

    /**
     * Devuelve la totales cuando sólo hay 1 ó 0.
     *
     * @return La totales del fichero.
     */
    public HashMap<String, String> getTotales() {
        if (this.listaTotales.size() > 1)
            throw new UnsupportedOperationException("El número de totales (" + this.listaTotales.size() + ") debe ser 1 para poder utilizar este método.");
        if(this.listaTotales.size() == 0)
            return null;
        return this.listaTotales.get(0);
    }

    //endregion

    //region Getters genéricos

    public ArrayList<HashMap<String, String>> getListaCabecera() {
        return listaCabecera;
    }

    public ArrayList<HashMap<String, String>> getListaOperacion() {
        return listaOperacion;
    }

    public ArrayList<HashMap<String, String>> getListaTotales() {
        return listaTotales;
    }


    //endregion

}
