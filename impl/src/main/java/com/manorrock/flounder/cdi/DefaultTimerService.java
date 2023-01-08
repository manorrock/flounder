/*
 *  Copyright (c) 2002-2023, Manorrock.com. All Rights Reserved.
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
 *      3. Neither the name of the copyright holder nor the names of its 
 *         contributors may be used to endorse or promote products derived from
 *         this software without specific prior written permission.
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
package com.manorrock.flounder.cdi;

import jakarta.ejb.EJBException;
import jakarta.ejb.ScheduleExpression;
import jakarta.ejb.Timer;
import jakarta.ejb.TimerConfig;
import jakarta.ejb.TimerService;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * A CDI implementation of TimerService.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
@ApplicationScoped
public class DefaultTimerService implements TimerService {

    /**
     * Stores all the timers.
     */
    private final ArrayList<Timer> timers;

    /**
     * Constructor.
     */
    public DefaultTimerService() {
        timers = new ArrayList<>();
    }

    @Override
    public Timer createCalendarTimer(ScheduleExpression schedule, TimerConfig timerConfig) throws IllegalArgumentException, IllegalStateException, EJBException {
        DefaultCalendarTimer timer = new DefaultCalendarTimer(schedule, timerConfig);
        timers.add(timer);
        return timer;
    }

    @Override
    public Timer createCalendarTimer(ScheduleExpression schedule) throws IllegalArgumentException, IllegalStateException, EJBException {
        DefaultCalendarTimer timer = new DefaultCalendarTimer(schedule, null);
        timers.add(timer);
        return timer;
    }

    @Override
    public Timer createIntervalTimer(long initialDuration, long intervalDuration, TimerConfig timerConfig) throws IllegalArgumentException, IllegalStateException, EJBException {
        DefaultIntervalTimer timer = new DefaultIntervalTimer(intervalDuration, timerConfig);
        timers.add(timer);
        return timer;
    }

    @Override
    public Timer createIntervalTimer(Date initialExpiration, long intervalDuration, TimerConfig timerConfig) throws IllegalArgumentException, IllegalStateException, EJBException {
        DefaultIntervalTimer timer = new DefaultIntervalTimer(initialExpiration, intervalDuration, timerConfig);
        timers.add(timer);
        return timer;
    }

    @Override
    public Timer createTimer(Date initialExpiration, long intervalDuration, Serializable info) throws IllegalArgumentException, IllegalStateException, EJBException {
        DefaultTimer timer = new DefaultTimer(initialExpiration, intervalDuration, info);
        timers.add(timer);
        return timer;
    }

    @Override
    public Timer createSingleActionTimer(Date expiration, TimerConfig timerConfig) throws IllegalArgumentException, IllegalStateException, EJBException {
        DefaultTimer timer = new DefaultTimer(expiration, timerConfig);
        timers.add(timer);
        return timer;
    }

    @Override
    public Timer createTimer(Date expiration, Serializable info) throws IllegalArgumentException, IllegalStateException, EJBException {
        DefaultTimer timer = new DefaultTimer(expiration, info);
        timers.add(timer);
        return timer;
    }

    @Override
    public Timer createTimer(long initialDuration, long intervalDuration, Serializable info) throws IllegalArgumentException, IllegalStateException, EJBException {
        DefaultTimer timer = new DefaultTimer(initialDuration, intervalDuration, info);
        timers.add(timer);
        return timer;
    }

    @Override
    public Collection<Timer> getAllTimers() throws IllegalStateException, EJBException {
        return timers;
    }

    @Override
    public Collection<Timer> getTimers() throws IllegalStateException, EJBException {
        return timers;
    }

    @Override
    public Timer createTimer(long duration, Serializable info) throws IllegalArgumentException, IllegalStateException, EJBException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Timer createSingleActionTimer(long duration, TimerConfig timerConfig) throws IllegalArgumentException, IllegalStateException, EJBException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
