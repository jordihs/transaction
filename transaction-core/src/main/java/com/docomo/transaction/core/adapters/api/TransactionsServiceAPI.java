package com.docomo.transaction.core.adapters.api;

import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.core.exception.TransactionCoreException;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionsServiceAPI {

    List<Transaction> getAllTransactions(String merchantId) throws TransactionCoreException;

    List<Transaction> getTransactionsByStatusAndMinAmount(String merchantId,
                                                          BigDecimal amount,
                                                          String paymentOperationStatus)
            throws TransactionCoreException;

}
