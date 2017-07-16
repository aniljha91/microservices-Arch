package com.org.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to make cobertura ignore the methods from code coverage metrics
 * 
 * @author bsakariboina
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PACKAGE})
public @interface CoberturaIgnore {

	
}
