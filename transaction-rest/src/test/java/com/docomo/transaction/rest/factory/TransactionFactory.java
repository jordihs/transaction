package com.docomo.transaction.rest.factory;

import com.docomo.transaction.core.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

public class TransactionFactory {

    public static final String EXPECTED_DATE_STRING = "2021-03-08 13:22:47.843088";

    public static Transaction buildTransaction() {
        Merchant merchant = Merchant.builder().merchantID("2").build();

        Money amount = Money.builder()
                .amount(BigDecimal.valueOf(50l))
                .currency("SGD")
                .build();

        Payment payment = Payment.builder()
                .amount(amount)
                .method("method3")
                .status(PaymentStatus.Success)
                .type(PaymentType.Refund)
                .build();

        LocalDateTime time = LocalDateTime.of(2021,
                Month.MARCH,
                8,
                13,
                22,
                47,
                843088000);

        Transaction referenced = Transaction.builder().transactionId("0ad421e3-77d3-1f92-8178-11ff15d2069a").build();
        Transaction model = Transaction.builder().transactionId("0ad421e3-77d3-1f92-8178-120123d406a0")
                .payment(payment)
                .merchant(merchant)
                .billingDescriptor("Testing descriptor")
                .countryCode("SG")
                .merchantTransactionId("2ce06d18-87b3-4627-817e-c5f5dee917c6")
                .dateCreated(time)
                .dateUpdated(time)
                .referencedTransaction(referenced)
                .build();

        return model;
    }


}
