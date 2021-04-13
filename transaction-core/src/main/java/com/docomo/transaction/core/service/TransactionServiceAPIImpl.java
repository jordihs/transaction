package com.docomo.transaction.core.service;

import com.docomo.transaction.core.adapters.api.TransactionsServiceAPI;
import com.docomo.transaction.core.adapters.datasource.TransactionDataQuery;
import com.docomo.transaction.core.domain.AppError;
import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.core.exception.TransactionCoreException;
import com.docomo.transaction.core.exception.TransactionDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class TransactionServiceAPIImpl implements TransactionsServiceAPI {


    @Autowired
    private TransactionDataQuery dataQuery;

    /* (non-Javadoc)
     * @see TransactionsServiceAPI#getTransactionsByStatusAndMinAmount()
     */
    @Override
    public List<Transaction> getAllTransactions(String merchantId)  throws TransactionCoreException {
        log.debug("Starting core getAllTransactions with merchantId: %s", merchantId);
        List<Transaction> result;
        try {
            result = dataQuery.findAllMerchantTransactions(merchantId);
            log.debug("Retrieved %n results after query", result.size());
        } catch (TransactionDataException e) {
            log.error("Error getting transactions", e);
            throw new TransactionCoreException(AppError.DATA_ACCESS,e);
        }
        log.debug("Finished getAllTransactions succesfully");
        return result;
    }

    /* (non-Javadoc)
     * @see com.docomo.transaction.core.adapters.datasource.TransactionsServiceAPI#getTransactionsByStatusAndMinAmount()
     */
    @Override
    public List<Transaction> getTransactionsByStatusAndMinAmount(String merchantId,
                                                                 BigDecimal amount,
                                                                 String paymentOperationStatus)
            throws TransactionCoreException {
        log.debug("Starting core getTransactionsByStatusAndMinAmount with merchantId:%s, amount %d, status: %s",
                merchantId,
                amount.longValue(),
                paymentOperationStatus);

        List<Transaction> result;
        try {
            result = dataQuery.filterByMinAmountAndStatus(merchantId,amount,paymentOperationStatus);
            log.debug("Retrieved %n results after query", result.size());
        } catch (TransactionDataException e) {
            log.error("Error getting transactions", e);
            throw new TransactionCoreException(AppError.DATA_ACCESS,e);
        }
        log.debug("Finished getAllTransactions succesfully");
        return result;
    }
}
