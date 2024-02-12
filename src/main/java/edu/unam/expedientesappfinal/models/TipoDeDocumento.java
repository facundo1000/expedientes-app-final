package edu.unam.expedientesappfinal.models;

public enum TipoDeDocumento {
    DNI("DNI"),
    LC("LC"),
    LE("LE"),
    PASAPORTE("PASAPORTE");

    private final String nombre;

    TipoDeDocumento(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Funcion que retorna el nombre de cada documento
     * @return nombre de un documento
     */
    public String getNombre() {
        return nombre;
    }
}
