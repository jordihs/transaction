package com.docomo.transaction.data.adapter;

import com.docomo.transaction.core.adapters.datasource.TransactionDataQuery;
import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.core.exception.TransactionDataException;
import com.docomo.transaction.data.domain.TransactionEntity;
import com.docomo.transaction.data.domain.converter.TransactionJPADomainConverter;
import com.docomo.transaction.data.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Component
@Repository
public class TransactionDataQueryJSONJPA implements TransactionDataQuery {

    @Autowired
    private TransactionDataService service;

    @Autowired
    private TransactionJPADomainConverter converter;

    @Override
    public List<Transaction> findAllMerchantTransactions(String merchantId) throws TransactionDataException {
        List<TransactionEntity> entities = service.findAllMerchantTransactions(merchantId);

        return converter.fromTransactionEntityList(entities);
    }

    @Override
    public List<Transaction> filterByMinAmountAndStatus(String merchantId,
                                                        BigDecimal amount,
                                                        String paymentOperationStatus)
            throws TransactionDataException {
        List<TransactionEntity> entities = service.filterByMinAmountAndStatus(merchantId, amount, paymentOperationStatus);
        return converter.fromTransactionEntityList(entities);
    }
}
