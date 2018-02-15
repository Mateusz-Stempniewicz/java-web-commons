/**
 * 
 */
package com.java.web.commons.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**
 * @author mateusz.stempniewicz
 *
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = {})
@Pattern(regexp = Password.regexp)
public @interface Password {
	
	static final String regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}";
	
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "Password regex error";
	
	@OverridesAttribute(constraint = Pattern.class, name = "groups")
	Class<?>[] groups() default {};
	
	@OverridesAttribute(constraint = Pattern.class, name = "payload")
	Class<? extends Payload>[] payload() default {};
}
