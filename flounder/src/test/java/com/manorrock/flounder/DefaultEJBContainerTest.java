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
package com.manorrock.flounder;

import javax.naming.Context;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * The JUnit tests for the DefaultEJBContainer class.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class DefaultEJBContainerTest {
    
    /**
     * Test close method.
     */
    @Test
    public void testClose() {
        DefaultEJBContainer container = new DefaultEJBContainer();
    }

    /**
     * Test getContext method.
     */
    @Test
    public void testGetContext() {
        DefaultEJBContainer container = new DefaultEJBContainer();
        assertNotNull(container.getContext());
    }

    /**
     * Test bind method.
     */
    @Test
    public void testBind() {
        DefaultEJBContainer container = new DefaultEJBContainer();
        assertFalse(container.bind("BIND", "NAME"));
    }
    
    /**
     * Test stateful bean.
     * 
     * @throws Exception when an error occurs.
     */
    @Test
    public void testStatefulBean() throws Exception {
        System.setProperty("java.naming.factory.initial", "com.manorrock.herring.DefaultInitialContextFactory");
        DefaultEJBContainer container = new DefaultEJBContainer();
        container.addStatefulBean(TestStatefulBean.class);
        Context context = container.getContext();
        TestStatefulBean bean = (TestStatefulBean) context.lookup("TestStatefulBean");
        assertEquals("test", bean.test());
    }
    
    /**
     * Test stateless bean.
     * 
     * @throws Exception when an error occurs.
     */
    @Test
    public void testStatelessBean() throws Exception {
        System.setProperty("java.naming.factory.initial", "com.manorrock.herring.DefaultInitialContextFactory");
        DefaultEJBContainer container = new DefaultEJBContainer();
        container.addStatelessBean(TestStatelessBean.class);
        Context context = container.getContext();
        TestStatelessBean bean = (TestStatelessBean) context.lookup("TestStatelessBean");
        assertEquals("test", bean.test());
    }
    
    /**
     * Test singleton bean.
     * 
     * @throws Exception when an error occurs.
     */
    @Test
    public void testSingletonBean() throws Exception {
        System.setProperty("java.naming.factory.initial", "com.manorrock.herring.DefaultInitialContextFactory");
        DefaultEJBContainer container = new DefaultEJBContainer();
        container.addSingletonBean(TestSingletonBean.class);
        Context context = container.getContext();
        TestSingletonBean bean = (TestSingletonBean) context.lookup("TestSingletonBean");
        assertEquals("test", bean.test());
    }
}
