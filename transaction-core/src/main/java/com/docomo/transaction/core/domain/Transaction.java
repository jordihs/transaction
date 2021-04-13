package com.docomo.transaction.core.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * Representation of the transaction domain object. Contains data about a merchant payment operation.
 */
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Transaction {

    /**
     * Transaction unique identifier.
     */
    private String transactionId;

    /**
     * A description of the bill
     */
    private String billingDescriptor;

    /**
     * Country code for the transaction origin
     */
    private String countryCode;

    /**
     * Date of creation of the transaction
     */
    private LocalDateTime dateCreated;

    /**
     * Date of the last update of the transaction
     */
    private LocalDateTime dateUpdated;

    /**
     * The merchant's own transaction identifier
     */
    private String merchantTransactionId;

    /**
     * Payment data
     */
    private Payment payment;

    /**
     * Data of the merchant involved in the transaction
     */
    private Merchant merchant;

    /**
     * A reference to a parent transaction related to this one
     */
    private Transaction referencedTransaction;



}
