package com.docomo.transaction.data.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class TransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long privateId;

    @Column(unique = true)
    private String id;

    private String currency;

    private BigDecimal amount;

    @JsonProperty("billing_descriptor")
    private String billingDescriptor;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("creation_datetime")
    private LocalDateTime creationDateTime;

    @JsonProperty("merchant_transaction_id")
    private String merchantTransactionId;

    @JsonProperty("payment_operation_status")
    private String paymentOperationStatus; // TODO enum

    @JsonProperty("payment_type")
    private String paymentType; // TODO enum

    @JsonProperty("update_datetime")
    private LocalDateTime updateDatetime;

    @JsonProperty("merchant_id")
    private String merchantId;

    @JsonProperty("payment_method_name")
    private String paymentMethodName;

    @JsonProperty("referenced_payment_operation_id")
    private String referencedPaymentOperationId;

}
