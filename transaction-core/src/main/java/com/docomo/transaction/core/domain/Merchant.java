package com.docomo.transaction.core.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * An representation of the Merchant domain object, representing data about a merchant that
 * issues payment transactions on the plattform.
 */
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Merchant {

    /**
     * Unique merchant identifier
     */
    private String merchantID;

}
