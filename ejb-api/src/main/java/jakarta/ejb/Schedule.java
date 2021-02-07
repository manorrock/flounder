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
package jakarta.ejb;

import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * The Schedule annotation is used to define a timer with the given schedule,
 * which will call the annotated method.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
@Target(value = METHOD)
@Retention(value = RUNTIME)
public @interface Schedule {
    
    /**
     * Get the seconds.
     * 
     * @return the seconds
     */
    String second() default "0";
    
    /**
     * Get the minutes.
     * 
     * @return the minutes.
     */
    String minute() default "0";
    
    /**
     * Get the hour.
     * 
     * @return the hour.
     */
    String hour() default "0";
    
    /**
     * Get the day of the month.
     * 
     * @return the day of the month.
     */
    String dayOfMonth() default "*";
    
    /**
     * Get the month.
     * 
     * @return the month.
     */
    String month() default "*";
    
    /**
     * Get the day of the week.
     * 
     * @return the day of the week.
     */
    String dayOfWeek() default "*";
    
    /**
     * Get the year.
     * 
     * @return the year.
     */
    String year() default "*";
    
    /**
     * Get the timezone.
     * 
     * @return the timezone.
     */
    String timezone() default "";
    
    /**
     * Get the info.
     * 
     * @return the info.
     */
    String info() default "";
    
    /**
     * Is timer persistent.
     * 
     * @return true if it is, false otherwise.
     */
    boolean persistent() default true;
}
