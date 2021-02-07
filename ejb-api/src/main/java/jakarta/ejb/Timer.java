/*
 *  Copyright (c) 2002-2020, Manorrock.com. All Rights Reserved.
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
package jakarta.ejb;

import java.io.Serializable;
import java.util.Date;

/**
 * The Timer API.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public interface Timer {

    /**
     * Cancel the timer.
     *
     * @throws IllegalStateException when state does not allow this call.
     * @throws NoSuchObjectLocalException when the timer is not active.
     * @throws EJBException when an EJB error occurs.
     */
    void cancel() throws IllegalStateException, NoSuchObjectLocalException,
            EJBException;

    /**
     * Get the time remaining.
     *
     * @return the time remaining.
     * @throws IllegalStateException when state does not allow this call.
     * @throws NoSuchObjectLocalException when the timer is not active.
     * @throws NoMoreTimeoutsException when no more future timeouts are
     * scheduled.
     * @throws EJBException when an EJB error occurs.
     */
    long getTimeRemaining() throws IllegalStateException,
            NoSuchObjectLocalException, NoMoreTimeoutsException, EJBException;

    /**
     * Get the next timeout.
     *
     * @return the next timeout.
     * @throws IllegalStateException when state does not allow this call.
     * @throws NoSuchObjectLocalException when the timer is not active.
     * @throws NoMoreTimeoutsException when no more future timeouts are
     * scheduled.
     * @throws EJBException when an EJB error occurs.
     */
    Date getNextTimeout() throws IllegalStateException,
            NoSuchObjectLocalException, NoMoreTimeoutsException, EJBException;

    /**
     * Get the schedule.
     *
     * @return the schedule expression.
     * @throws IllegalStateException when state does not allow this call.
     * @throws NoSuchObjectLocalException when the timer is not active.
     * @throws EJBException when an EJB error occurs.
     */
    ScheduleExpression getSchedule() throws IllegalStateException,
            NoSuchObjectLocalException, EJBException;

    /**
     * Is the timer persistent.
     *
     * @return true if it is, false otherwise.
     * @throws IllegalStateException when state does not allow this call.
     * @throws NoSuchObjectLocalException when the timer is not active.
     * @throws EJBException when an EJB error occurs.
     */
    boolean isPersistent() throws IllegalStateException,
            NoSuchObjectLocalException, EJBException;

    /**
     * Is this a calendar timer.
     *
     * @return true if it is, false otherwise.
     * @throws IllegalStateException when state does not allow this call.
     * @throws NoSuchObjectLocalException when the timer is not active.
     * @throws EJBException when an EJB error occurs.
     */
    boolean isCalendarTimer() throws IllegalStateException,
            NoSuchObjectLocalException, EJBException;

    /**
     * Get the timer info.
     *
     * @return the timer info, or null if not passed.
     * @throws IllegalStateException when state does not allow this call.
     * @throws NoSuchObjectLocalException when the timer is not active.
     * @throws EJBException when an EJB error occurs.
     */
    Serializable getInfo() throws IllegalStateException,
            NoSuchObjectLocalException, EJBException;

    /**
     * Get the timer handle.
     *
     * @return the timer handle.
     * @throws IllegalStateException when state does not allow this call.
     * @throws NoSuchObjectLocalException when the timer is not active.
     * @throws EJBException when an EJB error occurs.
     */
    TimerHandle getHandle() throws IllegalStateException,
            NoSuchObjectLocalException, EJBException;
}
