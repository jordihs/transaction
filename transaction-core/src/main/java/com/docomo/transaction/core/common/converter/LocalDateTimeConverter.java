package com.docomo.transaction.core.common.converter;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateTimeConverter {

    @Autowired
    protected DateTimeFormatter formatter;


    @Named("fromLocalDateTime")
    public String fromLocalDateTime(LocalDateTime time){
        return formatter.format(time);
    }

    @Named("epochSecondsFromTimestamp")
    public Long epochSecondFromTimestamp(LocalDateTime timestamp) {
        ZoneId zoneId = ZoneId.systemDefault();
        return timestamp.atZone(zoneId).toEpochSecond();
    }

}
