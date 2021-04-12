package com.docomo.transaction.core.domain;

public enum AppError {

    DATA_ACCESS(1L, "Error de acceso a datos"),
    RUNTIME(2L, "Error no esperado");


    private final String description;

    private final Long code;

    AppError(Long code, String description){
        this.code = code;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public Long getCode() {
        return code;
    }
}
