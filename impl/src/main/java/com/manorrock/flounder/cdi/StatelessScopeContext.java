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

import java.lang.annotation.Annotation;
import java.util.Set;
import javax.ejb.Stateless;
import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A CDI scope for @Stateless beans.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class StatelessScopeContext implements Context {

    /**
     * Stores our scope manager.
     */
    private StatelessScopeManager manager;

    /**
     * Check if our context is active, if not throw ContextNotActiveException.
     */
    private void checkActive() {
        if (!isActive()) {
            throw new ContextNotActiveException();
        }
    }

    /**
     * Get the instance.
     *
     * @param <T> the type.
     * @param contextual the contextual.
     * @param context the creational context.
     * @return the instance.
     */
    @Override
    public <T> T get(Contextual<T> contextual, CreationalContext<T> context) {
        T instance = get(contextual);
        return (instance != null) ? instance : manager.createBean(contextual, context);
    }

    /**
     * Get the instance.
     *
     * @param <T> the type.
     * @param contextual the contextual.
     * @return the instance.
     */
    @Override
    public <T> T get(Contextual<T> contextual) {
        checkActive();
        return manager.getBean(contextual);
    }

    /**
     * Get the manager.
     *
     * @param clazz the manager class.
     */
    private StatelessScopeManager getManager(Class<StatelessScopeManager> clazz) {
        StatelessScopeManager result = null;
        BeanManager beanManager = null;
        try {
            beanManager = CDI.current().getBeanManager();
        } catch (Throwable t) {
        }
        if (beanManager == null) {
            try {
                InitialContext context = new InitialContext();
                beanManager = (BeanManager) context.lookup("java:comp/BeanManager");
            } catch (NamingException ne) {
            }
        }
        if (beanManager != null) {
            Set<Bean<?>> beans = beanManager.getBeans(clazz);
            Bean resolvedBean = beanManager.resolve(beans);
            result = (StatelessScopeManager) beanManager.getReference(
                    resolvedBean, clazz,
                    beanManager.createCreationalContext(resolvedBean));
        }
        return result;
    }

    /**
     * Get the scope.
     *
     * @return the scope.
     */
    @Override
    public Class<? extends Annotation> getScope() {
        return Stateless.class;
    }

    /**
     * We are always active.
     *
     * @return true.
     */
    @Override
    public boolean isActive() {
        if (manager == null) {
            manager = getManager(StatelessScopeManager.class);
        }
        return manager != null;
    }
}
