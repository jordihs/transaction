package com.docomo.transaction.core.domain;

/**
 * An enumeration containing standardized errors with associated messages and codes
 */
public enum AppError {

    /**
     * Data acces error
     * Code: 1
     */
    DATA_ACCESS(1L, "Error de acceso a datos"),
    /**
     * Runtime error
     * Code: 2
     */
    RUNTIME(2L, "Error no esperado");


    private final String description;

    private final Long code;

    AppError(Long code, String description){
        this.code = code;
        this.description = description;
    }

    /**
     * Get an error description, use to enrich an exception message or
     * as the exception message altogether.
     * @return
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Error code, can be used to effectively log and record failures.
     * @return
     */
    public Long getCode() {
        return code;
    }
}
