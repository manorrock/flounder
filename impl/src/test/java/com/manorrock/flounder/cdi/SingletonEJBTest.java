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
package com.manorrock.flounder.cdi;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.CDI;
import javax.naming.InitialContext;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 * The JUnit tests for the SingletonEJB class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class SingletonEJBTest {

    /**
     * Stores the Weld SE container.
     */
    private SeContainer weld;

    /**
     * Before testing.
     */
    @Before
    public void before() {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        this.weld = initializer.initialize();
    }

    /**
     * After testing.
     */
    @After
    public void after() {
        if (this.weld != null) {
            this.weld.close();
        }
    }

    /**
     * Test getting @Singleton annotated EJB as a CDI bean.
     *
     * @throws Exception when a serious error occurs.
     */
    @Test
    public void testSingletonEJB() throws Exception {
        System.setProperty("java.naming.factory.initial",
                "com.manorrock.herring.DefaultInitialContextFactory");
        SingletonEJB ejb = CDI.current().select(SingletonEJB.class).get();
        assertNotNull(ejb);
        assertEquals("Hello World", ejb.helloWorld());
        InitialContext context = new InitialContext();
        assertNotNull(context.lookup("java:module/SingletonEJB"));
    }

    /**
     * Test @Inject with a @Singleton EJB.
     *
     * @throws Exception when a serious error occurs.
     */
    @Test
    public void testInjectSingletonEJB() throws Exception {
        System.setProperty("java.naming.factory.initial",
                "com.manorrock.herring.DefaultInitialContextFactory");
        SingletonApplicationBean applicationBean = CDI.current()
                .select(SingletonApplicationBean.class).get();
        assertNotNull(applicationBean);
        assertEquals("Hello World", applicationBean.getEjb().helloWorld());
    }
}
