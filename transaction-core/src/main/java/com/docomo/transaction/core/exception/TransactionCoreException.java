package com.docomo.transaction.core.exception;

import com.docomo.transaction.core.domain.AppError;

public class TransactionCoreException extends Exception {

    private final AppError error;

    public TransactionCoreException(AppError error){
        super(error.getDescription());
        this.error = error;
    }

    public TransactionCoreException(AppError error, Throwable cause){
        super(error.getDescription(), cause);
        this.error = error;
    }

    public TransactionCoreException(String message,AppError error, Throwable cause){
        super(error.getDescription() + ":" + message, cause);
        this.error = error;
    }

    public AppError getError(){
        return this.error;
    }
}
