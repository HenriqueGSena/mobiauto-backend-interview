package com.mobiauto.backend_interview.entities.enums;

public enum Cargos {

    ADMIN("admin"),
    PROPRIETARIO("proprietario"),
    GERENTE("gerente"),
    ASSISTENTE("assistente");

    private String cargo;

    Cargos(String carga) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }
}
