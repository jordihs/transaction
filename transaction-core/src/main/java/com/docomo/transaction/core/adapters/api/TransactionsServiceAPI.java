package com.docomo.transaction.core.adapters.api;

import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.core.exception.TransactionCoreException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Core logic interface for the transactions module.
 */
public interface TransactionsServiceAPI {

    /**
     * Retrieve all the transactions for a specified merchant ID.
     *
     * @param merchantId The merchan identifier.
     * @return List of all the transactions of the merchant
     * @throws TransactionCoreException
     */
    List<Transaction> getAllTransactions(String merchantId) throws TransactionCoreException;

    /**
     * Retrieve transactions for a given merchant, filtered by the payment status and a
     * minimum payment amount.
     *
     * @param merchantId The merchant identifier
     * @param amount Minimum amount
     * @param paymentOperationStatus Status for operations to retrieve
     * @return List of filtered transactions
     * @throws TransactionCoreException
     */
    List<Transaction> getTransactionsByStatusAndMinAmount(String merchantId,
                                                          BigDecimal amount,
                                                          String paymentOperationStatus)
            throws TransactionCoreException;

}
