package com.docomo.transaction.data.domain.converter;


import com.docomo.transaction.core.domain.Transaction;
import com.docomo.transaction.data.domain.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TransactionJPADomainConverter {


    @Mapping(target = "transactionId", source = "id")
    @Mapping(target = "payment.amount.currency", source = "currency")
    @Mapping(target = "payment.amount.amount", source = "amount")
    @Mapping(target = "dateCreated", source = "creationDateTime")
    @Mapping(target = "dateUpdated", source = "updateDatetime")
    @Mapping(target = "payment.status", source = "paymentOperationStatus")
    @Mapping(target = "payment.type", source = "paymentType")
    @Mapping(target = "payment.method", source = "paymentMethodName")
    @Mapping(target = "referencedTransaction", source = "referencedPaymentOperationId")
    Transaction fromTransactionEntity(TransactionEntity entity);

    List<Transaction> fromTransactionEntityList(List<TransactionEntity> entities);

    default Transaction fromString(String id){
        return Transaction.builder().transactionId(id).build();
    }


}
