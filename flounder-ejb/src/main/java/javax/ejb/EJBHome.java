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

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The EJB home API.
 *
 * @author Manfred Riem (mriem@veneni.com)
 */
public interface EJBHome extends Remote {

    /**
     * Get the EJB meta-data.
     *
     * @return the EJB meta-data.
     * @throws RemoteException when a serious error occurs.
     */
    EJBMetaData getEJBMetaData() throws RemoteException;

    /**
     * Get the Home handle.
     *
     * @return the Home handle.
     * @throws RemoteException when a serious error occurs.
     */
    HomeHandle getHomeHandle() throws RemoteException;

    /**
     * Remove the EJB.
     *
     * @param handle the handle of the EJB to remove.
     * @throws RemoteException when a serious error occurs.
     * @throws RemoveException when not allowed to remove the EJB.
     */
    void remove(Handle handle) throws RemoteException, RemoveException;

    /**
     * Remove the EJB.
     *
     * @param primaryKey the primary key of the EJB to remove.
     * @throws RemoteException when a serious error occurs.
     * @throws RemoveException when not allowed to remove the EJB.
     */
    void remove(Object primaryKey) throws RemoteException, RemoveException;
}
