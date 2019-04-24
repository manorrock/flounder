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

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The default EJB container.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class DefaultEJBContainer extends EJBContainer implements EnterpriseBeanContainer {
    
    /**
     * Stores the closed flag.
     */
    private boolean closed;

    /**
     * Stores the context.
     */
    private Context context;
    
    /**
     * Stores the list of stateless beans.
     */
    private List<Class> statelessBeans;
    
    /**
     * Constructor.
     */
    public DefaultEJBContainer() {
        statelessBeans = new ArrayList<>();
    }

    /**
     * Shutdown the EJB container.
     */
    @Override
    public void close() {
        this.closed = true;
    }

    /**
     * Get the naming context.
     *
     * @return the naming context.
     */
    @Override
    public Context getContext() {
        if (context == null) {
            try {
                context = new InitialContext();
            } catch (NamingException ne) {
                throw new RuntimeException(ne);
            }
        }
        return context;
    }

    /**
     * Bind EJB.
     *
     * @param ejb the EJB to bind.
     * @param name the name to bind it to.
     * @return true if bound, false otherwise.
     */
    public boolean bind(Object ejb, String name) {
        boolean result = true;
        try {
            getContext().bind(name, ejb);
        } catch (NamingException ne) {
            result = false;
        }
        return result;
    }

    /**
     * Add a stateless bean.
     * 
     * @param clazz the class.
     */
    @Override
    public void addStatelessBean(Class clazz) {
        statelessBeans.add(clazz);
    }
}
