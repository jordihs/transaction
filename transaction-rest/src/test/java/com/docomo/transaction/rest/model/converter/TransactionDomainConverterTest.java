package com.docomo.transaction.rest.model.converter;

import com.docomo.transaction.core.adapters.api.TransactionsServiceAPI;
import com.docomo.transaction.core.adapters.datasource.TransactionDataQuery;
import com.docomo.transaction.core.domain.*;
import com.docomo.transaction.generated.model.PaymentOperationStatus;
import com.docomo.transaction.generated.model.TransactionAPIModel;
import com.docomo.transaction.rest.factory.TransactionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionDomainConverterTest {


    @MockBean
    private TransactionsServiceAPI serviceAPI;

    @MockBean
    private TransactionDataQuery dataQuery;


    @Autowired
    TransactionRESTDomainConverter converter;

    @Test
    void testBasicFeatures(){

        Transaction model = TransactionFactory.buildTransaction();
        LocalDateTime time = model.getDateCreated();

        TransactionAPIModel result = converter.fromTransaction(model);

        assertEquals(TransactionFactory.EXPECTED_DATE_STRING, result.getCreationDatetime(), "The date in the output does not match");
        assertEquals(TransactionFactory.EXPECTED_DATE_STRING, result.getUpdateDatetime());

        Long epochTime = time.atZone(ZoneId.systemDefault()).toEpochSecond();
        assertEquals(epochTime, result.getCreationTimestamp(), "the millis amount of time is incorrect");
        assertEquals(epochTime, result.getUpdateTimestamp(), "the millis amount of time is incorrect");

        assertEquals(50L, result.getAmount(), "The amount is incorrectly mapped");
        assertEquals("SGD", result.getCurrency(), "The currency is incorrectly mapped");

        assertEquals("method3", result.getPaymentMethodName(),
                "The payment method is incorrectly mapped");

        assertEquals(com.docomo.transaction.generated.model.PaymentType.REFUND, result.getPaymentType(),
                "The payment type is incorrectly mapped");

        assertEquals(PaymentOperationStatus.SUCCESS, result.getPaymentOperationStatus(),
                "The payment status is incorrectly mapped");

        assertEquals("0ad421e3-77d3-1f92-8178-120123d406a0", result.getId(),
                "The transaction ID is incorrectly mapped");

        assertEquals("0ad421e3-77d3-1f92-8178-11ff15d2069a", result.getReferencedPaymentOperationId(),
                "Referenced payment id is incorrectly mapped");

        assertEquals("Testing descriptor", result.getBillingDescriptor(),
                "Billing descriptor is incorrectly mapped");

        assertEquals("SG", result.getCountryCode(), "Country coded is incorrectly mapped");

        assertEquals("2ce06d18-87b3-4627-817e-c5f5dee917c6", result.getMerchantTransactionId(),
                "Merchant transaction ID is incorrectly mapped");



    }


}
