package com.docomo.transaction.core.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Transaction {

    private String transactionId;

    private String billingDescriptor;

    private String countryCode;

    private LocalDateTime dateCreated;

    private LocalDateTime dateUpdated;

    private String merchantTransactionId;

    private Payment payment;

    private Merchant merchant;

    private Transaction referencedTransaction;



}
