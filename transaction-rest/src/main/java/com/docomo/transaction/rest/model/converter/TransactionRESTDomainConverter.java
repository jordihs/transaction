package com.docomo.transaction.rest.model.converter;

import com.docomo.transaction.core.common.converter.LocalDateTimeConverter;
import com.docomo.transaction.core.domain.PaymentStatus;
import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.generated.model.PaymentOperationStatus;
import com.docomo.transaction.generated.model.PaymentType;
import com.docomo.transaction.generated.model.TransactionAPIModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LocalDateTimeConverter.class})
public interface TransactionRESTDomainConverter {

    @Mapping(source = "transactionId",target = "id")
    @Mapping(source = "payment.amount.currency",target = "currency")
    @Mapping(source = "payment.amount.amount",target = "amount")
    @Mapping(source = "dateCreated",target = "creationDatetime", qualifiedByName = "fromLocalDateTime")
    @Mapping(source = "dateCreated",target = "creationTimestamp", qualifiedByName = "epochSecondsFromTimestamp")
    @Mapping(source = "dateUpdated",target = "updateDatetime", qualifiedByName = "fromLocalDateTime")
    @Mapping(source = "dateUpdated",target = "updateTimestamp", qualifiedByName = "epochSecondsFromTimestamp")
    @Mapping(source = "payment.status",target = "paymentOperationStatus")
    @Mapping(source = "payment.type",target = "paymentType")
    @Mapping(source = "payment.method",target = "paymentMethodName")
    @Mapping(source = "referencedTransaction.transactionId",target = "referencedPaymentOperationId")
    TransactionAPIModel fromTransaction(Transaction model);

    List<TransactionAPIModel> fromTransactionList(List<Transaction> transactions);


    default PaymentOperationStatus fromStatus(PaymentStatus status){
        return PaymentOperationStatus.fromValue(status.name());
    }

    default PaymentType fromPaymentType(com.docomo.transaction.core.domain.PaymentType type){
        return PaymentType.fromValue(type.name());
    }



}
