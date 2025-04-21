package io.ballerina.stdlib.time.nativeimpl;

import io.ballerina.runtime.api.values.BDecimal;
import io.ballerina.stdlib.time.util.Constants;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CustomDuration {
    int years;
    int months;
    int days;
    int hours;
    int minutes;
    int seconds;
    int nanoSeconds;

    public CustomDuration(long years, long months, long days, long hours, long minutes, BDecimal seconds) {
        this.years = Long.valueOf(years).intValue();
        this.months = Long.valueOf(months).intValue();
        this.days = Long.valueOf(days).intValue();
        this.hours = Long.valueOf(hours).intValue();
        this.minutes = Long.valueOf(minutes).intValue();
        this.seconds = seconds.decimalValue().setScale(0, RoundingMode.FLOOR).intValue();
        this.nanoSeconds = seconds.decimalValue().subtract(new BigDecimal(this.seconds)).multiply(Constants.ANALOG_GIGA)
                .setScale(0, RoundingMode.HALF_UP).intValue();
    }
}
