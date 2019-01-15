/*
 *  Copyright (c) 2002-2019, Manorrock.com. All Rights Reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *      1. Redistributions of source code must retain the above copyright
 *         notice, this list of conditions and the following disclaimer.
 *
 *      2. Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 *  AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 *  IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 *  ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 *  LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 *  SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 *  INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 *  CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 *  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 *  POSSIBILITY OF SUCH DAMAGE.
 */
package javax.ejb;

import java.io.Serializable;
import java.util.Date;

/**
 * The schedule expression.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class ScheduleExpression implements Serializable {

    /**
     * Stores the day of the month.
     */
    private String dayOfMonth;

    /**
     * Stores the day of the week.
     */
    private String dayOfWeek;

    /**
     * Stores the end date.
     */
    private Date endDate;

    /**
     * Stores the hours.
     */
    private String hours;

    /**
     * Stores the minutes.
     */
    private String minutes;

    /**
     * Stores the month.
     */
    private String month;

    /**
     * Stores the seconds.
     */
    private String seconds;

    /**
     * Stores the start date.
     */
    private Date startDate;

    /**
     * Stores the timezoneID;
     */
    private String timezoneID;

    /**
     * Stores the year.
     */
    private String year;

    /**
     * Set the day of the month.
     *
     * @param dayOfMonth the day of the month.
     * @return the expression.
     */
    public ScheduleExpression dayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
        return this;
    }

    /**
     * Set the day of the month.
     *
     * @param dayOfMonth the day of the month.
     * @return the expression.
     */
    public ScheduleExpression dayOfMonth(int dayOfMonth) {
        this.dayOfMonth = Integer.toString(dayOfMonth);
        return this;
    }

    /**
     * Set the day of the week.
     *
     * @param dayOfWeek the day of the week.
     * @return the expression.
     */
    public ScheduleExpression dayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        return this;
    }

    /**
     * Set the day of the week.
     *
     * @param dayOfWeek the day of week.
     * @return the expression.
     */
    public ScheduleExpression dayOfWeek(int dayOfWeek) {
        this.dayOfWeek = Integer.toString(dayOfWeek);
        return this;
    }

    /**
     * Set the end date.
     *
     * @param endDate the end date.
     * @return the expression.
     */
    public ScheduleExpression end(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get the day of the month.
     *
     * @return the day of the month.
     */
    public String getDayOfMonth() {
        return dayOfMonth;
    }

    /**
     * Get the day of the week.
     *
     * @return the day of the week.
     */
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Get the end date.
     *
     * @return the end date.
     */
    public Date getEnd() {
        return endDate;
    }

    /**
     * Get the hours.
     *
     * @return the hours.
     */
    public String getHour() {
        return hours;
    }

    /**
     * Get the minutes.
     *
     * @return the minutes.
     */
    public String getMinute() {
        return minutes;
    }

    /**
     * Get the month.
     *
     * @return the month.
     */
    public String getMonth() {
        return month;
    }

    /**
     * Get the seconds.
     *
     * @return the seconds.
     */
    public String getSecond() {
        return seconds;
    }

    /**
     * Get the start date.
     *
     * @return the start date.
     */
    public Date getStart() {
        return startDate;
    }

    /**
     * Get the time zone.
     *
     * @return the time zone.
     */
    public String getTimezone() {
        return timezoneID;
    }

    /**
     * Get the year.
     *
     * @return the year.
     */
    public String getYear() {
        return year;
    }

    /**
     * Set the hours.
     *
     * @param hours the hours.
     * @return the expression.
     */
    public ScheduleExpression hour(String hours) {
        this.hours = hours;
        return this;
    }

    /**
     * Set the hours.
     *
     * @param hours the hours.
     * @return the expression.
     */
    public ScheduleExpression hour(int hours) {
        this.hours = Integer.toString(hours);
        return this;
    }

    /**
     * Set the minutes.
     *
     * @param minutes the minutes.
     * @return the expression.
     */
    public ScheduleExpression minute(String minutes) {
        this.minutes = minutes;
        return this;
    }

    /**
     * Set the minutes.
     *
     * @param mminutes the minutes.
     * @return the expression.
     */
    public ScheduleExpression minute(int mminutes) {
        this.minutes = Integer.toString(mminutes);
        return this;
    }

    /**
     * Set the month.
     *
     * @param month the month.
     * @return the expression.
     */
    public ScheduleExpression month(String month) {
        this.month = month;
        return this;
    }

    /**
     * Set the month.
     *
     * @param month the month.
     * @return the expression.
     */
    public ScheduleExpression month(int month) {
        this.month = Integer.toString(month);
        return this;
    }

    /**
     * Set the seconds.
     *
     * @param seconds the seconds.
     * @return the expression.
     */
    public ScheduleExpression second(String seconds) {
        this.seconds = seconds;
        return this;
    }

    /**
     * Set the seconds.
     *
     * @param seconds the seconds.
     * @return the expression.
     */
    public ScheduleExpression second(int seconds) {
        this.seconds = Integer.toString(seconds);
        return this;
    }

    /**
     * Set the start date.
     *
     * @param startDate the start date.
     * @return the expression.
     */
    public ScheduleExpression start(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Set the time zone.
     *
     * @param timezoneID the time zone.
     * @return the expression.
     */
    public ScheduleExpression timezone(String timezoneID) {
        this.timezoneID = timezoneID;
        return this;
    }

    /**
     * Set the year.
     *
     * @param year the year.
     * @return the expression.
     */
    public ScheduleExpression year(String year) {
        this.year = year;
        return this;
    }

    /**
     * Set the year.
     *
     * @param year the year.
     * @return the expression.
     */
    public ScheduleExpression year(int year) {
        this.year = Integer.toString(year);
        return this;
    }
}
