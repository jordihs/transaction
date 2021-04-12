package com.docomo.transaction.data.adapter.jpa;

import com.docomo.transaction.data.service.TransactionDataService;
import com.docomo.transaction.data.domain.TransactionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class TransactionDataServiceJPATest {

    @Autowired
    private TransactionDataService service;


    @Test
    void testFindAllMerchantTransactions() {
        String merchantId = "1";
        List<TransactionEntity> result = service.findAllMerchantTransactions(merchantId);
        assertEquals(3, result.size(), "did not find the correct number of transactions");

        merchantId = "2";
        result = service.findAllMerchantTransactions(merchantId);
        assertEquals(1, result.size(), "did not find the correct number of transactions");


    }

    @Test
    void testFilterByMinAmountAndStatus() {
        String merchantId = "1";
        BigDecimal minValue = BigDecimal.valueOf(101);
        String status = "Pending";

        List<TransactionEntity> result = service.filterByMinAmountAndStatus(merchantId, minValue, status);

        assertEquals(1, result.size(), "transactions were not filtered correctly");

        minValue = BigDecimal.valueOf(99);
        result = service.filterByMinAmountAndStatus(merchantId, minValue, status);
        assertEquals(2, result.size(), "transactions were not filtered correctly");

        status = "Failure";
        result = service.filterByMinAmountAndStatus(merchantId, minValue, status);
        assertEquals(1, result.size(), "transactions were not filtered correctly by status");

        status = "Pending";
        merchantId = "2";
        result = service.filterByMinAmountAndStatus(merchantId, minValue, status);
        assertEquals(1, result.size(), "transactions were not filtered correctly by merchant id");


    }

}
