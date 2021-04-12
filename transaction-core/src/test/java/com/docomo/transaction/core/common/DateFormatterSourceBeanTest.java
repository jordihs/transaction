package com.docomo.transaction.core.common;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.*;


public class DateFormatterSourceBeanTest {

    @Test
    void testDateFormatterSourceBean(){
        DateFormattersSourceBean sourceBean = new DateFormattersSourceBean();
        DateTimeFormatter formatter = sourceBean.getFormatter();

        String expectedDate = "2021-03-08 13:22:47.843088";
        LocalDateTime time = LocalDateTime.of(2021,
                Month.MARCH,
                8,
                13,
                22,
                47,
                843088000);

        LocalDateTime parsed = LocalDateTime.parse(expectedDate,formatter);

        assertEquals(time, parsed, "The parsed date does not match");

        String timeString = formatter.format(time);
        assertEquals(expectedDate, timeString, "The date formatting does not match");


    }



}
