package com.docomo.transaction.data.domain.converter;

import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.data.domain.TransactionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TransactionDomainConverterTest {

    @Autowired
    private TransactionJPADomainConverter converter;


    @Test
    void testSimpleConversion(){
        TransactionEntity entity = new TransactionEntity();
        LocalDateTime now = LocalDateTime.now();
        entity.setId("0ad422e9-7791-11fb-8177-97461e390074");
        entity.setAmount(BigDecimal.valueOf(100));
        entity.setCurrency("KRW");
        entity.setBillingDescriptor("Billing descriptor");
        entity.setCountryCode("KR");
        entity.setCreationDateTime(now);
        entity.setMerchantTransactionId("1d2de348-2889-4ea3-a935-ce2b131b9039");
        entity.setPaymentOperationStatus("Success");
        entity.setPaymentType("Debit");
        entity.setUpdateDatetime(now);
        entity.setMerchantId("1");
        entity.setPaymentMethodName("method4");
        entity.setReferencedPaymentOperationId("test");

        Transaction result = converter.fromTransactionEntity(entity);

        assertEquals(entity.getId(), result.getTransactionId(), "Transaction ID not converted correctly");
        assertNotNull(result.getReferencedTransaction(), "Nested transaction not created correctly");
        assertEquals("test", result.getReferencedTransaction().getTransactionId(),
                "The nested transaction id is not correct");

        List<TransactionEntity> asList = Collections.singletonList(entity);
        List<Transaction> response = converter.fromTransactionEntityList(asList);

        assertEquals(1, response.size(), "Converter did not return same size list");
        result = response.get(0);
        assertEquals(entity.getId(), result.getTransactionId(), "Transaction ID not converted correctly");

    }


}
