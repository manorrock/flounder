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
package jakarta.ejb;

import java.security.Principal;
import java.util.Map;
import jakarta.transaction.UserTransaction;

/**
 * The EJBContext API.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public interface EJBContext {

    /**
     * Get the caller principal.
     *
     * @return the caller principal.
     */
    Principal getCallerPrincipal();

    /**
     * Get the context data.
     *
     * @return the context data.
     */
    Map<String, Object> getContextData();

    /**
     * Get the EJB home.
     *
     * @return the EJB home.
     */
    EJBHome getEJBHome();

    /**
     * Get the EJB local home.
     *
     * @return the EJB local home.
     */
    EJBLocalHome getEJBLocalHome();

    /**
     * Get the rollback only.
     *
     * @return the rollback only.
     */
    boolean getRollbackOnly();

    /**
     * Get the timer service.
     *
     * @return the timer service.
     */
    TimerService getTimerService();
    
    /**
     * Get the user transaction.
     * 
     * @return the user transaction.
     */
    UserTransaction getUserTransaction();

    /**
     * Is the caller in role.
     *
     * @param roleName the name of the role.
     * @return true if it is, false is otherwise.
     */
    @Deprecated
    boolean isCallerInRole(String roleName);

    /**
     * Lookup the object.
     *
     * @param name the name (within the <pre>java:</pre> namespace)
     * @return the object.
     */
    Object lookup(String name);
    
    /**
     * Set the rollback only.
     */
    void setRollbackOnly();
}
