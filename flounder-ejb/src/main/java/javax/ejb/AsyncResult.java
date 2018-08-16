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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * An async result.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 * @param <V> the type of the result.
 */
public class AsyncResult<V> implements Future<V> {
    
    /**
     * Stores the result.
     */
    private final V result;
    
    /**
     * Constructor.
     * 
     * @param result the result.
     */
    public AsyncResult(V result) {
        this.result = result;
    }

    /**
     * Cancel the request.
     * 
     * @param mayInterruptIfRunning if allowed to interrupt.
     * @return true if interrupted, false otherwise.
     */
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        throw new IllegalStateException();
    }

    /**
     * Is the request cancelled?
     * 
     * @return false
     */
    @Override
    public boolean isCancelled() {
        return false;
    }

    /**
     * Is the request done?
     * 
     * @return true
     */
    @Override
    public boolean isDone() {
        return true;
    }

    /**
     * Get the result.
     * 
     * @return the result.
     * @throws InterruptedException when interrupted.
     * @throws ExecutionException when an execution error occurs.
     */
    @Override
    public V get() throws InterruptedException, ExecutionException {
        return result;
    }

    /**
     * Get the result.
     * 
     * @param timeout the timeout.
     * @param unit the time unit.
     * @return the result.
     * @throws InterruptedException when interrupted.
     * @throws ExecutionException when an execution error occurs.
     * @throws TimeoutException when the request times out.
     */
    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return result;
    }
}
