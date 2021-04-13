package com.docomo.transaction.core.common;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * This shared component may be used to obtain date formatting objects for different uses
 * throughout all adapters, so that formatting is reused effectively and there are no
 * collisions if there is a date formatting policy change.
 * All formats must be tagged with a qualifier so that clients may specify which type
 * of format is required.
 */
@Component
public class DateFormattersSourceBean {

    private static final String DATE_FORMAT = "yyyy-MM-dd kk:mm:ss";
    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern(DATE_FORMAT)
            .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 9, true)
            .toFormatter();

    @Bean
    @Qualifier("standard")
    public DateTimeFormatter getStandardFormatter(){
        return formatter;
    }

}
