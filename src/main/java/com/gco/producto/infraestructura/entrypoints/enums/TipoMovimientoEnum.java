package com.gco.producto.infraestructura.entrypoints.enums;


public enum TipoMovimientoEnum {
    ENTRADA(1, "ENTRADA"),
    SALIDA(2, "SALIDA");

    private final int codigo;
    private final String valor;

    TipoMovimientoEnum(int codigo, String valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getValor() {
        return valor;
    }

}
