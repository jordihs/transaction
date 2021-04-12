package com.docomo.transaction.rest.model.exception;

import com.docomo.transaction.core.exception.TransactionCoreException;

public class TransactionCoreExceptionWrapper extends RuntimeException {
    private final TransactionCoreException exception;

    public TransactionCoreExceptionWrapper(TransactionCoreException exception){
        this.exception = exception;
    }

    public TransactionCoreException getException(){
        return exception;
    }

}
