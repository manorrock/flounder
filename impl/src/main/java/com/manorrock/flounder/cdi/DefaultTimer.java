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
import jakarta.ejb.NoMoreTimeoutsException;
import jakarta.ejb.NoSuchObjectLocalException;
import jakarta.ejb.ScheduleExpression;
import jakarta.ejb.Timer;
import jakarta.ejb.TimerConfig;
import jakarta.ejb.TimerHandle;
import java.io.Serializable;
import java.util.Date;

/**
 * The default Timer.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class DefaultTimer implements Timer {
    

    /**
     * Stores the not supported yet string constant.
     */
    private static final String NOT_SUPPORTED_YET = "Not supported yet.";
    
    /**
     * Constructor.
     * 
     * @param expiration the expiration date.
     * @param timerConfig the timer config.
     */
    public DefaultTimer(Date expiration, TimerConfig timerConfig) {
        // ignoring everything for now.
    }

    public DefaultTimer(Date initialExpiration, long intervalDuration, Serializable info) {
        // ignoring everything for now.
    }

    public DefaultTimer(Date expiration, Serializable info) {
        // ignoring everything for now.
    }

    public DefaultTimer(long initialDuration, long intervalDuration, Serializable info) {
        // ignoring everything for now.
    }

    @Override
    public void cancel() throws IllegalStateException, NoSuchObjectLocalException, EJBException {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }

    @Override
    public long getTimeRemaining() throws IllegalStateException, NoSuchObjectLocalException, NoMoreTimeoutsException, EJBException {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }

    @Override
    public Date getNextTimeout() throws IllegalStateException, NoSuchObjectLocalException, NoMoreTimeoutsException, EJBException {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }

    @Override
    public ScheduleExpression getSchedule() throws IllegalStateException, NoSuchObjectLocalException, EJBException {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }

    @Override
    public boolean isPersistent() throws IllegalStateException, NoSuchObjectLocalException, EJBException {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }

    @Override
    public boolean isCalendarTimer() throws IllegalStateException, NoSuchObjectLocalException, EJBException {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }

    @Override
    public Serializable getInfo() throws IllegalStateException, NoSuchObjectLocalException, EJBException {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }

    @Override
    public TimerHandle getHandle() throws IllegalStateException, NoSuchObjectLocalException, EJBException {
        throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
    }
    
}
