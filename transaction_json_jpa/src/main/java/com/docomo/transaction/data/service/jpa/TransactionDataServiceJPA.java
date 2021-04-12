package com.docomo.transaction.data.service.jpa;

import com.docomo.transaction.data.domain.TransactionEntity;
import com.docomo.transaction.data.repository.TransactionRepository;
import com.docomo.transaction.data.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class TransactionDataServiceJPA implements TransactionDataService {

    @Autowired
    private TransactionRepository repository;

    @Override
    public List<TransactionEntity> findAllMerchantTransactions(String merchantId) {
        return repository.findByMerchantId(merchantId);
    }

    @Override
    public List<TransactionEntity> filterByMinAmountAndStatus(String merchantId, BigDecimal amount, String paymentOperationStatus) {
        return repository.findByMerchantIdAndAmountGreaterThanEqualAndPaymentOperationStatus(merchantId, amount, paymentOperationStatus);
    }
}
