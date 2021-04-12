package com.docomo.transaction.rest.api;

import com.docomo.transaction.core.adapters.api.TransactionsServiceAPI;
import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.core.exception.TransactionCoreException;
import com.docomo.transaction.generated.api.MerchantsApi;
import com.docomo.transaction.generated.model.TransactionAPIModel;
import com.docomo.transaction.generated.model.TransactionsResponse;
import com.docomo.transaction.rest.model.converter.TransactionRESTDomainConverter;
import com.docomo.transaction.rest.model.exception.TransactionCoreExceptionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class MerchantsAPIController implements MerchantsApi {

    @Autowired
    private TransactionsServiceAPI serviceAPI;

    @Autowired
    private TransactionRESTDomainConverter converter;

    @Override
    public ResponseEntity<TransactionsResponse> getAllTransactions(String merchantId) {
        List<Transaction> allTransactions = null;
        try {
            allTransactions = serviceAPI.getAllTransactions(merchantId);
        } catch (TransactionCoreException exception) {
            throw new TransactionCoreExceptionWrapper(exception);
        }
        List<TransactionAPIModel> response = converter.fromTransactionList(allTransactions);
        TransactionsResponse body = new TransactionsResponse();
        body.addAll(response);

        return ResponseEntity.of(Optional.of(body));
    }

    @Override
    public ResponseEntity<TransactionsResponse> getAllTransactions(String merchantId, String status, Double minAmount) {
        List<Transaction> transactions =
                null;
        try {
            transactions = serviceAPI.getTransactionsByStatusAndMinAmount(merchantId, BigDecimal.valueOf(minAmount),status);
        } catch (TransactionCoreException exception) {
            throw new TransactionCoreExceptionWrapper(exception);
        }

        List<TransactionAPIModel> response = converter.fromTransactionList(transactions);
        TransactionsResponse body = new TransactionsResponse();
        body.addAll(response);

        return ResponseEntity.of(Optional.of(body));
    }
}
