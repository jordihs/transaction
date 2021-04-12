package com.docomo.transaction.core.service;

import com.docomo.transaction.core.adapters.api.TransactionsServiceAPI;
import com.docomo.transaction.core.adapters.datasource.TransactionDataQuery;
import com.docomo.transaction.core.domain.AppError;
import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.core.exception.TransactionCoreException;
import com.docomo.transaction.core.exception.TransactionDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceAPIImpl implements TransactionsServiceAPI {

    @Autowired
    private TransactionDataQuery dataQuery;


    @Override
    public List<Transaction> getAllTransactions(String merchantId)  throws TransactionCoreException {
        List<Transaction> result = null;
        try {
            result = dataQuery.findAllMerchantTransactions(merchantId);
        } catch (TransactionDataException e) {
            throw new TransactionCoreException(AppError.DATA_ACCESS,e);
        }
        return result;
    }

    @Override
    public List<Transaction> getTransactionsByStatusAndMinAmount(String merchantId,
                                                                 BigDecimal amount,
                                                                 String paymentOperationStatus)
            throws TransactionCoreException {
        List<Transaction> result = null;
        try {
            result = dataQuery.filterByMinAmountAndStatus(merchantId,amount,paymentOperationStatus);
        } catch (TransactionDataException e) {
            throw new TransactionCoreException(AppError.DATA_ACCESS,e);
        }
        return result;
    }
}
