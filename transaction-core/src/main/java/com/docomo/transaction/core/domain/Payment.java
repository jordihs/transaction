package com.docomo.transaction.core.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Payment {

    private PaymentStatus status;

    private PaymentType type;

    private Money amount;

    private String method;

}
