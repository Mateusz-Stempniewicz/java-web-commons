/**
 * 
 */
package com.java.web.commons.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author mateusz.stempniewicz
 *
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
@RequestMapping(method = RequestMethod.GET)
public @interface Get {
	
	@AliasFor(annotation = RequestMapping.class)
	String name() default "";
	
	@AliasFor(annotation = RequestMapping.class)
	String[] value() default {};
	
	@AliasFor(annotation = RequestMapping.class)
	String[] path() default {};
	
	@AliasFor(annotation = RequestMapping.class)
	String[] params() default {};
	
	@AliasFor(annotation = RequestMapping.class)
	String[] headers() default {};
	
	@AliasFor(annotation = RequestMapping.class)
	String[] consumes() default { MediaType.APPLICATION_JSON_VALUE };
	
	@AliasFor(annotation = RequestMapping.class)
	String[] produces() default { MediaType.APPLICATION_JSON_VALUE };
}
