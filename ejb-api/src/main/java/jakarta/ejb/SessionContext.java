/*
 *  Copyright (c) 2002-2023, Manorrock.com. All Rights Reserved.
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

/**
 * The SessionContext API.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public interface SessionContext extends EJBContext {

    /**
     * Get the business object.
     *
     * @param <T> the type.
     * @param businessInterface the business interface.
     * @return the business object.
     * @throws IllegalStateException when the method cannot be called.
     */
    <T> T getBusinessObject(Class<T> businessInterface) throws IllegalStateException;

    /**
     * Get the EJB local object.
     *
     * @return the EJB local object.
     * @throws IllegalStateException when the method cannot be called.
     */
    EJBLocalObject getEJBLocalObject() throws IllegalStateException;

    /**
     * Get the EJB object.
     *
     * @return the EJB object.
     * @throws IllegalStateException when the method cannot be called.
     */
    EJBObject getEJBObject() throws IllegalStateException;

    /**
     * Get the invoked business interface.
     *
     * @return the class.
     * @throws IllegalStateException when the method cannot be called.
     */
    Class getInvokedBusinessInterface() throws IllegalStateException;

    /**
     * Was cancel called?
     *
     * @return true if it was, false otherwise.
     * @throws IllegalStateException when the method cannot be called.
     */
    boolean wasCancelCalled() throws IllegalStateException;
}
