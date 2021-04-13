package com.docomo.transaction.core.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * Representation of the payment domain object, with a data set that represents all the required information
 * to characterize a payment of any type.
 */
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Payment {

    /**
     * The current status of this payment
     */
    private PaymentStatus status;

    /**
     * The type of payment as it refers to how or why it is issued
     */
    private PaymentType type;

    /**
     * The money involved in the payment
     */
    private Money amount;

    /**
     * The name of the payment method used to execute the operation
     */
    private String method;

}
