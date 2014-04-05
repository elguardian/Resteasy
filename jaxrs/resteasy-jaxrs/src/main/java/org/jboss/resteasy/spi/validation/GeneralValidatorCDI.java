package org.jboss.resteasy.spi.validation;

import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.InjectorFactory;

/**
 * 
 * @author <a href="ron.sigal@jboss.com">Ron Sigal</a>
 * @version $Revision: 1.1 $
 * 
 * If CDI is enabled, validation will be invoked from an interceptor,
 * rather than from ResourceMethodInvoker and MethodInjectorImpl.
 *
 * Copyright Feb 12, 2014
 */
public interface GeneralValidatorCDI extends GeneralValidator
{
   public boolean isValidatable(Class<?> clazz, InjectorFactory injectorFactory);
   
   /**
    * Indicates if validation is turned on for a class.
    * This method should be called only from a CDI interceptor
    * 
    * @param clazz Class to be examined
    * @return true if and only if validation is turned on for clazz
    */
   public abstract boolean isValidatableFromCDI(Class<?> clazz);
  
   /**
    * Throws a ResteasyViolationException if any validation violations have been detected.
    * The method should be called only when CDI is active.
    * @param request
    */
   public void checkViolationsfromCDI(HttpRequest request);
   
   /**
    * Throws a ResteasyViolationException if either a ConstraintViolationException or a
    * ResteasyConstraintViolationException is embedded in the cause hierarchy of e.
    * 
    * @param request
    * @param e
    */
   public void checkForConstraintViolations(HttpRequest request, Exception e);
}