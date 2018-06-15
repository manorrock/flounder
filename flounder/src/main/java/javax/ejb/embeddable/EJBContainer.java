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
package javax.ejb.embeddable;

import java.util.Map;
import javax.naming.Context;

/**
 * The EJB container.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public abstract class EJBContainer {

    /**
     * Stores the APP_NAME constant.
     */
    public static final String APP_NAME = "javax.ejb.embeddable.appName";

    /**
     * Stores the MODULES constant.
     */
    public static final String MODULES = "javax.ejb.embeddable.modules";

    /**
     * Stores the PROVIDER constant.
     */
    public static final java.lang.String PROVIDER = "javax.ejb.embeddable.provider";

    /**
     * Constructor.
     */
    public EJBContainer() {
    }

    /**
     * Shutdown the EJB container.
     */
    public abstract void close();

    /**
     * Create the EJB container.
     *
     * @return the EJB container.
     */
    public static EJBContainer createEJBContainer() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    /**
     * Create the EJB container.
     *
     * @param properties the properties.
     * @return the EJB container.
     */
    public static EJBContainer createEJBContainer(Map<?, ?> properties) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    /**
     * Get the naming context.
     *
     * @return the naming context.
     */
    public abstract Context getContext();
}
