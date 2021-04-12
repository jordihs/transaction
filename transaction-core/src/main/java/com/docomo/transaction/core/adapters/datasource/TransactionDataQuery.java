package com.docomo.transaction.core.adapters.datasource;

import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.core.exception.TransactionDataException;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionDataQuery {

    List<Transaction> findAllMerchantTransactions(String merchantId) throws TransactionDataException;

    List<Transaction> filterByMinAmountAndStatus(String merchantId,
                                                 BigDecimal amount,
                                                 String paymentOperationStatus) throws TransactionDataException;

}
