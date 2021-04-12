package com.docomo.transaction.data.service;

import com.docomo.transaction.data.domain.TransactionEntity;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionDataService {

    List<TransactionEntity> findAllMerchantTransactions(String merchantId);

    List<TransactionEntity> filterByMinAmountAndStatus(String merchantId, BigDecimal amount, String paymentOperationStatus);

}
