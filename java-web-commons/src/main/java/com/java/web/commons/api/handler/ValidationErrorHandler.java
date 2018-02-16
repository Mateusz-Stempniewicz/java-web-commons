package com.java.web.commons.api.handler;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.java.web.commons.api.response.Response;
import com.java.web.commons.dto.validation.FieldErrorDto;
import com.java.web.commons.dto.validation.ObjectErrorDto;
import com.java.web.commons.dto.validation.ValidationErrorDto;
import com.java.web.commons.exception.ObjectNotValidException;
/**
 * Kontroler działający aspektowo <br />
 * Zwraca wyjątki jeśli: <br />
 * <ol>
 * <li>obiekt DTO przychodzący z klienta do serwera nie spełnia walidacji, np.
 * brak jakiegoś wymaganego pola<br />
 * zwraca wtedy response z błędnymi polami.</li>
 * <li>wystąpił jakiś nie obsłużony w kodzie błąd, wtedy do klienta zwracana
 * jest informacja z prośbą o kontakt z administratorem</li>
 * </ol>
 * 
 * @author mateusz.stempniewicz
 */
@ControllerAdvice
public class ValidationErrorHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationErrorHandler.class);
	
	@ExceptionHandler(ObjectNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ValidationErrorDto invalidObjectException(ObjectNotValidException exception) {
		Errors errors = exception.getErrors();
		ValidationErrorDto validationErrorDto = processFieldErrors(errors.getFieldErrors());
		
		return validationErrorDto;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ValidationErrorDto methodArgumentNotValidException(
	    MethodArgumentNotValidException exception) {
		Errors errors = exception.getBindingResult();
		ValidationErrorDto validationErrorDto = processFieldErrors(errors.getFieldErrors());
		
		return validationErrorDto;
	}
	
	@ExceptionHandler(Exception.class)
	public Response<String> customException(Exception exception) {
		LOGGER.warn("Unexpected error: ", exception);
		return new Response<>("Please contact system administrator",
		    com.java.web.commons.api.response.ResponseStatus.FAILURE,
		    HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private ValidationErrorDto processFieldErrors(List<FieldError> fieldErrors) {
		Map<String, List<FieldError>> objectErrors = fieldErrors.stream()
		    .collect(Collectors.groupingBy(FieldError::getObjectName));
		
		List<ObjectErrorDto> objectErrorDtos = objectErrors.entrySet().stream()
		    .map(o -> convert(o))
		    .collect(Collectors.toList());
		
		ValidationErrorDto validationErrorDto = new ValidationErrorDto();
		validationErrorDto.setErrors(objectErrorDtos);
		
		return validationErrorDto;
	}
	
	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);
		
		return localizedErrorMessage;
	}
	
	private ObjectErrorDto convert(Map.Entry<String, List<FieldError>> entry) {
		List<FieldErrorDto> fieldErrorDtos = entry.getValue()
		    .stream()
		    .map(f -> convert(f))
		    .collect(Collectors.toList());
		
		ObjectErrorDto objectErrorDto = new ObjectErrorDto();
		objectErrorDto.setObject(entry.getKey());
		objectErrorDto.setFields(fieldErrorDtos);
		
		return objectErrorDto;
	}
	
	private FieldErrorDto convert(FieldError fieldError) {
		String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
		
		FieldErrorDto fieldErrorDto = new FieldErrorDto();
		fieldErrorDto.setName(fieldError.getField());
		fieldErrorDto.setCode(fieldError.getCode());
		fieldErrorDto.setMessage(localizedErrorMessage);
		fieldErrorDto.setRejectedValue(fieldError.getRejectedValue());
		
		return fieldErrorDto;
	}
}
