package com.docomo.transaction.data.repository;

import com.docomo.transaction.data.domain.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {

    List<TransactionEntity> findByMerchantId(String merchantId);

    List<TransactionEntity> findByMerchantIdAndAmountGreaterThanEqualAndPaymentOperationStatus(String merchantId,
                                                                                               BigDecimal minAmount,
                                                                                               String operationStatus);

}
