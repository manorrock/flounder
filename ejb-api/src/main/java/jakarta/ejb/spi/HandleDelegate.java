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
package jakarta.ejb.spi;

import jakarta.ejb.EJBHome;
import jakarta.ejb.EJBObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The HandleDelegate API.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public interface HandleDelegate {

    /**
     * Write the EJB object to a stream.
     * 
     * @param ejbObject the EJB object.
     * @param outputStream the output stream.
     * @throws IOException when an I/O error occurs.
     */
    public void writeEJBObject(EJBObject ejbObject, 
            ObjectOutputStream outputStream) throws IOException;

    /**
     * Read the EJB object from a stream.
     * 
     * @param inputStream the input stream.
     * @return the EJB object.
     * @throws IOException when an I/O error occurs.
     * @throws ClassNotFoundException when a class was not found.
     */
    public EJBObject readEJBObject(ObjectInputStream inputStream) 
            throws IOException, ClassNotFoundException;

    
    /**
     * Write the EJB home.
     * 
     * @param ejbHome the EJB home.
     * @param ostream the output stream.
     * @throws IOException when an I/O error occurs.
     */
    public void writeEJBHome(EJBHome ejbHome, ObjectOutputStream ostream)
            throws IOException;

    /**
     * Read the EJB home.
     * 
     * @param inputStream the input stream.
     * @return the EJB home.
     * @throws IOException when an I/O error occurs.
     * @throws ClassNotFoundException when a class was not found.
     */
    public EJBHome readEJBHome(ObjectInputStream inputStream)
            throws IOException, ClassNotFoundException;
}
