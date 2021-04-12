package com.docomo.transaction.core.common;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Component
public class DateFormattersSourceBean {

    private static final String DATE_FORMAT = "yyyy-MM-dd kk:mm:ss";
    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern(DATE_FORMAT)
            .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 9, true)
            .toFormatter();

    @Bean
    @Qualifier("standard")
    public DateTimeFormatter getFormatter(){
        return formatter;
    }

}
