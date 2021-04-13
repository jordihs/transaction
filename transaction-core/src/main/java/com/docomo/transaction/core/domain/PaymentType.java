package com.docomo.transaction.core.domain;

/**
 * An enumeration of the possible types of payment
 */
public enum PaymentType {

    /**
     * A payment executed with a debit card
     */
    Debit,
    /**
     * A refund issued to a customer
     */
    Refund,
    /**
     * A payment executed with a credit card
     */
    Credit;

}
