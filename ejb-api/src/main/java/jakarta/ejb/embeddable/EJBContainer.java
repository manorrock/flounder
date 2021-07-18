/*
 *  Copyright (c) 2002-2021, Manorrock.com. All Rights Reserved.
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
package jakarta.ejb.embeddable;

import jakarta.ejb.EJBException;
import jakarta.ejb.spi.EJBContainerProvider;
import java.io.Closeable;
import java.util.Map;
import java.util.ServiceLoader;
import javax.naming.Context;

/**
 * The EJB container.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public abstract class EJBContainer implements Closeable {

    /**
     * Stores the APP_NAME constant.
     */
    public static final String APP_NAME = "jakarta.ejb.embeddable.appName";

    /**
     * Stores the MODULES constant.
     */
    public static final String MODULES = "jakarta.ejb.embeddable.modules";

    /**
     * Stores the PROVIDER constant.
     */
    public static final java.lang.String PROVIDER = "jakarta.ejb.embeddable.provider";

    /**
     * Constructor.
     */
    public EJBContainer() {
    }

    /**
     * Shutdown the EJB container.
     */
    @Override
    public abstract void close();

    /**
     * Create the EJB container.
     *
     * @return the EJB container.
     */
    public static EJBContainer createEJBContainer() {
        return createEJBContainer(null);
    }

    /**
     * Create the EJB container.
     *
     * @param properties the properties.
     * @return the EJB container.
     */
    public static EJBContainer createEJBContainer(Map<?, ?> properties) {
        EJBContainer result = null;
        ServiceLoader<EJBContainerProvider> providers
                = ServiceLoader.load(EJBContainerProvider.class);
        for (EJBContainerProvider provider : providers) {
            try {
                result = provider.createEJBContainer(properties);
                if (result != null) {
                    break;
                }
            } catch (EJBException ee) {
            }
        }
        return result;
    }

    /**
     * Get the naming context.
     *
     * @return the naming context.
     */
    public abstract Context getContext();
}
