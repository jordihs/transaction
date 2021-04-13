package com.docomo.transaction.core.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

/**
 * A representation of the money domain object, used for payments and related monetary operations
 *
 */
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Money {

    /**
     * Amount of money represented by this instance
     */
    private final BigDecimal amount;

    /**
     * Currency in which the amount of money is represented
     */
    private final String currency;

}
