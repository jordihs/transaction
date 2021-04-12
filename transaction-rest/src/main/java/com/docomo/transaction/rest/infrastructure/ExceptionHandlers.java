package com.docomo.transaction.rest.infrastructure;

import com.docomo.transaction.core.exception.TransactionCoreException;
import com.docomo.transaction.generated.model.ErrorResponse;
import com.docomo.transaction.rest.model.exception.TransactionCoreExceptionWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({TransactionCoreExceptionWrapper.class})
    @ResponseBody
    public ErrorResponse handleTransactionCoreException(TransactionCoreExceptionWrapper ex){
        ErrorResponse error = handleGeneric(ex.getException());
        error.setCode(ex.getException().getError().getCode().toString());
        return error;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Throwable.class})
    @ResponseBody
    public ErrorResponse handleThrowable(Throwable ex){
        return handleGeneric(ex);
    }


    private ErrorResponse handleGeneric(Throwable ex){
        ErrorResponse error = new ErrorResponse();
        error.setMessage(ex.getMessage());
        return error;
    }

}
