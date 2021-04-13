package com.docomo.transaction.core.domain;

/**
 * An enumeration of all possible status for a payment operation
 */
public enum PaymentStatus {
    /**
     * Operation is succesful
      */
    Success,
    /**
     * Operation has failed
     */
    Failure,
    /**
     * Operation is in progress and is yet to finish
     */
    Pending;
}
