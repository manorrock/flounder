/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.ejb;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * The AccessTimeout annotation.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
@Target(value={METHOD,TYPE})
@Retention(value=RUNTIME)
public @interface AccessTimeout {
    
    /**
     * The time unit.
     * 
     * @return the time unit.
     */
    TimeUnit unit() default MILLISECONDS;
    
    /**
     * The access timeout in the unit specified by unit.
     * 
     * <ul>
     *  <li>Value > 0 is the access timeout specified by the unit element.</li>
     *  <li>Value == 0 no concurrent access allowed.</li>
     *  <li>Value -1 block indefinitely until finished.</li>
     *  <li>No other values allowed.</li>
     * </ul>
     * 
     * @return the access timeout.
     */
    long value();
}
