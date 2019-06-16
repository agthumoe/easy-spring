package com.achromex.core.utils;

import org.joda.time.LocalDateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * To provide date time information.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
public class DateTimeProvider implements Serializable {

    private static final long serialVersionUID = -637305747884395052L;

    /**
     * Get the current date time.
     *
     * @return current date time.
     */
    public Date now() {
        return new Date();
    }

    public LocalDateTime joda() {
        return LocalDateTime.now();
    }

    /**
     * Get the date time from today.
     *
     * @param days from today.
     * @return date time of the day from today.
     */
    public Date fromNow(int days) {
        return this.fromNow(days, 0);
    }

    /**
     * Get the date time from today.
     *
     * @param days  from today.
     * @param hours from today.
     * @return date time of the day from today.
     */
    public Date fromNow(int days, int hours) {
        LocalDateTime dateTime = LocalDateTime.now();
        if (days < 0) {
            dateTime = dateTime.minusDays(Math.abs(days));
        } else {
            dateTime = dateTime.plusDays(days);
        }
        if (hours < 0) {
            dateTime = dateTime.minusHours(Math.abs(hours));
        } else {
            dateTime = dateTime.plusHours(hours);
        }
        return dateTime.toDate();
    }

    /**
     * Get the date time from today.
     *
     * @param years  of age.
     * @param months of age.
     * @param days   of age.
     * @return date of birth from age.
     */
    public Date getDateOfBirthFromAge(int years, int months, int days) {
        LocalDateTime dateTime = LocalDateTime.now().minusYears(years).minusMonths(months).minusDays(days);
        return dateTime.toDate();
    }

    /**
     * Check whether targetDate is expired or not, given the months, days and hours.
     *
     * @param targetDate to be checked.
     * @param months     of the lifespan.
     * @param days       of the lifespan.
     * @param hours      of the lifespan.
     * @return true if the targetDate is already expired, false otherwise.
     */
    public boolean isExpired(Date targetDate, int months, int days, int hours) {
        if (targetDate == null) {
            throw new NullPointerException("Parameter: date should not be null.");
        }
        LocalDateTime dateTime = LocalDateTime.now().plusMonths(months).plusDays(days)
            .plusHours(hours);
        return !targetDate.before(dateTime.toDate());
    }

    public Date getBeginningOfDay(Date date) {
        return new LocalDateTime(date).withMillisOfDay(0).toDate();
    }

    public Date getBeginningOfDay() {
        return this.getBeginningOfDay(new Date());
    }

    public Date getEndOfDay(Date date) {
        return new LocalDateTime(date).withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).withMillisOfSecond(999).toDate();
    }

    public Date getEndOfDay() {
        return this.getEndOfDay(new Date());
    }

    public Date getBeginningOfMonth(Date date) {
        return new LocalDateTime(date).withDayOfMonth(1).withMillisOfDay(0).toDate();
    }

    public Date getBeginningOfYear(Date date) {
        return new LocalDateTime(date).withMonthOfYear(1).withDayOfMonth(1).withMillisOfDay(0).toDate();
    }

    public Date getEndOfMonth(Date date) {
        return new LocalDateTime(date).dayOfMonth().withMaximumValue().hourOfDay().withMaximumValue().millisOfDay().withMaximumValue().toDate();
    }

    public Date getEndOfYear(Date date) {
        return this.getEndOfMonth(new LocalDateTime(date).monthOfYear().withMaximumValue().toDate());
    }

    public Date getRandomDate(Date from, Date to) {
        return this.getRandomDate(from.getTime(), to.getTime());
    }

    public Date getRandomDate(long from, long to) {
        long diff = to - from + 1;
        long date = from + (long) (Math.random() * diff);
        return new Date(date);
    }

    public Date getBeginningOfYear() {
        return this.getBeginningOfYear(new Date());
    }

    public Date getEndOfYear() {
        return this.getEndOfYear(new Date());
    }

    public Date getBeginningOfMonth() {
        return this.getBeginningOfMonth(new Date());
    }

    public Date getEndOfMonth() {
        return this.getEndOfMonth(new Date());
    }
}
