/*
 *  Copyright (c) 2002-2018, Manorrock.com. All Rights Reserved.
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
import java.util.Collection;
import java.util.Date;

/**
 * The TimerService API.
 *
 * @author manfred
 */
public interface TimerService {

    /**
     * Create a timer.
     *
     * @param duration the duration in milliseconds.
     * @param info the information passed along.
     * @return the timer.
     * @throws IllegalArgumentException when the duration is negative.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createTimer(long duration, Serializable info)
            throws IllegalArgumentException, IllegalStateException,
            EJBException;

    /**
     * Create a single action timer.
     *
     * @param duration the duration in milliseconds.
     * @param timerConfig the timer configuration.
     * @return the timer.
     * @throws IllegalArgumentException when the duration is negative.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createSingleActionTimer(long duration, TimerConfig timerConfig)
            throws IllegalArgumentException, IllegalStateException,
            EJBException;

    /**
     * Create a timer.
     *
     * @param initialDuration the initial duration in milliseconds.
     * @param intervalDuration the duration for each interval in milliseconds.
     * @param info the information passed along.
     * @return the timer.
     * @throws IllegalArgumentException when the duration is negative.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createTimer(long initialDuration, long intervalDuration,
            Serializable info) throws IllegalArgumentException,
            IllegalStateException, EJBException;

    /**
     * Create an interval timer.
     *
     * @param initialDuration the initial duration in milliseconds.
     * @param intervalDuration the duration for each interval in milliseconds.
     * @param timerConfig the timer configuration.
     * @return the timer.
     * @throws IllegalArgumentException when the duration is negative.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createIntervalTimer(long initialDuration, long intervalDuration,
            TimerConfig timerConfig) throws IllegalArgumentException,
            IllegalStateException, EJBException;

    /**
     * Create a timer.
     *
     * @param expiration the expiration date.
     * @param info the info passed along.
     * @return the timer.
     * @throws IllegalArgumentException when the duration date is invalid.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createTimer(Date expiration, Serializable info)
            throws IllegalArgumentException, IllegalStateException,
            EJBException;

    /**
     * Create a single action timer.
     *
     * @param expiration the expiration date.
     * @param timerConfig the timer configuration.
     * @return the timer.
     * @throws IllegalArgumentException when the expiration date is invalid.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createSingleActionTimer(Date expiration, TimerConfig timerConfig)
            throws IllegalArgumentException, IllegalStateException,
            EJBException;

    /**
     * Create a timer.
     *
     * @param initialExpiration the initial expiration date.
     * @param intervalDuration the duration for each interval in milliseconds.
     * @param info the info passed along.
     * @return the timer.
     * @throws IllegalArgumentException when initialExpiration or
     * intervalDuration is invalid.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createTimer(Date initialExpiration, long intervalDuration,
            Serializable info) throws IllegalArgumentException,
            IllegalStateException, EJBException;

    /**
     * Create an interval timer.
     *
     * @param initialExpiration the initial expiration date.
     * @param intervalDuration the duration for each interval in milliseconds.
     * @param timerConfig the timer configuration.
     * @return the timer.
     * @throws IllegalArgumentException when initialExpiration or
     * intervalDuration is invalid.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createIntervalTimer(Date initialExpiration, long intervalDuration,
            TimerConfig timerConfig) throws IllegalArgumentException,
            IllegalStateException, EJBException;

    /**
     * Create a calendar timer.
     *
     * @param schedule the schedule expression.
     * @return the timer.
     * @throws IllegalArgumentException when the schedule is invalid.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createCalendarTimer(ScheduleExpression schedule)
            throws IllegalArgumentException, IllegalStateException,
            EJBException;

    /**
     * Create a calendar timer.
     *
     * @param schedule the schedule expression.
     * @param timerConfig the timer configuration.
     * @return the timer.
     * @throws IllegalArgumentException when the schedule or timerConfig is
     * invalid.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Timer createCalendarTimer(ScheduleExpression schedule, TimerConfig timerConfig)
            throws IllegalArgumentException, IllegalStateException, EJBException;

    /**
     * Get the timers.
     *
     * @return the timers.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Collection<Timer> getTimers() throws IllegalStateException, EJBException;
    
    /**
     * Get all timers (in same module as caller).
     * 
     * @return the timers.
     * @throws IllegalStateException when not allowed at this moment.
     * @throws EJBException when a system error occurs.
     */
    Collection<Timer> getAllTimers() throws IllegalStateException, EJBException;
}
