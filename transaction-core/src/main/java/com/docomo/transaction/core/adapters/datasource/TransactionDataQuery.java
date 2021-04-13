package com.docomo.transaction.core.adapters.datasource;

import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.core.exception.TransactionDataException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Datasource API for transaction operations
 */
public interface TransactionDataQuery {

    /**
     * Query the datasource for all the transactions for a specified merchant ID.
     *
     * @param merchantId The merchan identifier.
     * @return List of all the transactions of the merchant
     * @throws TransactionDataException
     */
    List<Transaction> findAllMerchantTransactions(String merchantId) throws TransactionDataException;

    /**
     * Query the datasource for transactions of a given merchant, filtered by the payment status and a
     * minimum payment amount.
     *
     * @param merchantId The merchant identifier
     * @param amount Minimum amount
     * @param paymentOperationStatus Status for operations to retrieve
     * @return List of filtered transactions
     * @throws TransactionDataException
     */
    List<Transaction> filterByMinAmountAndStatus(String merchantId,
                                                 BigDecimal amount,
                                                 String paymentOperationStatus) throws TransactionDataException;

}
