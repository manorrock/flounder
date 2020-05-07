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

import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * The manager for @Singleton beans.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
@ApplicationScoped
public class SingletonScopeManager {

    /**
     * Stores the beans.
     */
    private final ConcurrentHashMap<String, Object> beans = new ConcurrentHashMap<>();

    /**
     * Create the bean.
     *
     * @param <T> the type.
     * @param contextual the contextual.
     * @param context the context.
     * @return the instance.
     */
    public <T> T createBean(Contextual<T> contextual, CreationalContext<T> context) {
        T bean = contextual.create(context);
        beans.put(contextual.toString(), bean);
        try {
            InitialContext initialContext = new InitialContext();
            Singleton singleton = bean.getClass().getAnnotation(Singleton.class);
            if (!singleton.mappedName().equals("")) {
                initialContext.bind(singleton.mappedName(), bean);
            }
            if (singleton.name().equals("")) {
                initialContext.bind("java:module/" + bean.getClass().getSimpleName(), bean);
            } else {
                initialContext.bind("java:module/" + singleton.name(), bean);
            }
        } catch (NamingException ne) {
        }
        return bean;
    }

    /**
     * Get the bean.
     *
     * @param <T> the type.
     * @param contextual the contextual.
     * @return the instance.
     */
    public <T> T getBean(Contextual<T> contextual) {
        return (T) beans.get(contextual.toString());
    }
}