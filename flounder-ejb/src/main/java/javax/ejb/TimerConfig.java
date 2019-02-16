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

/**
 * The TimerConfig class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class TimerConfig {

    /**
     * Stores the timer information.
     */
    private Serializable info;

    /**
     * Stores if the timer is persistent.
     */
    private boolean persistent;

    /**
     * Constructor.
     */
    public TimerConfig() {
    }

    /**
     * Constructor.
     *
     * @param info the timer information.
     * @param persistent is the timer persistent.
     */
    public TimerConfig(Serializable info,
            boolean persistent) {
        this.info = info;
        this.persistent = persistent;
    }

    /**
     * Get the timer information.
     *
     * @return the timer information.
     */
    public Serializable getInfo() {
        return info;
    }

    /**
     * Is the timer persistent?
     *
     * @return true if it is, false otherwise.
     */
    public boolean isPersistent() {
        return persistent;
    }

    /**
     * Set the timer information.
     *
     * @param info the timer information.
     */
    public void setInfo(Serializable info) {
        this.info = info;
    }

    /**
     * Set if the timer is persistent.
     *
     * @param persistent true if the timer is persistent, false otherwise.
     */
    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
    }

    /**
     * Get a string representation.
     * 
     * @return the string representation.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("javax.ejb.TimerConfig[info=\"").
                append(info.toString()).
                append("\", persistent=").
                append(persistent).
                append("]");
        return builder.toString();
    }
}
