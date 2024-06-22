package com.mobiauto.backend_interview.entities.enums;

public enum Status {

    NOVO("novo"),
    EM_ATENDIMENTO("em_atendimento"),
    CONCLUIDO("concluido");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
