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
package javax.ejb;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The JUnit tests for the EJBException class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class EJBExceptionTest {

    /**
     * Test getCausedByException method.
     */
    @Test
    public void testGetCausedByException() {
        EJBException exception = new EJBException();
        assertNull(exception.getCausedByException());
    }

    /**
     * Test getCausedByException method.
     */
    @Test
    public void testGetCausedByException2() {
        EJBException exception = new EJBException("this is my message");
        assertEquals("this is my message", exception.getMessage());
    }

    /**
     * Test getCausedByException method.
     */
    @Test
    public void testGetCausedByException3() {
        EJBException exception = new EJBException("this is my message", new RuntimeException());
        assertEquals("this is my message", exception.getMessage());
        assertTrue(exception.getCausedByException() instanceof RuntimeException);
    }

    /**
     * Test getCausedByException method.
     */
    @Test
    public void testGetCausedByException4() {
        EJBException exception = new EJBException(new RuntimeException());
        assertTrue(exception.getCausedByException() instanceof RuntimeException);
    }
}