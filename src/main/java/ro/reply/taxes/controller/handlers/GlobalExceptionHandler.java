package ro.reply.taxes.controller.handlers;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ro.reply.taxes.controller.util.ResponseWrapper.ErrorWrapper;
import ro.reply.taxes.exceptions.BadRequestException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = BadRequestException.class)
	@ResponseBody
	public ErrorWrapper handleBadRequestException(HttpServletRequest req, BadRequestException e) {
		log.warn(e.getMessage());
		return new ErrorWrapper(e.getCode());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = PropertyValueException.class)
	@ResponseBody
	public ErrorWrapper handleBadRequestException(HttpServletRequest req, PropertyValueException e) {
		log.warn(e.getMessage());
		return new ErrorWrapper("Invalid value for attribute" + e.getPropertyName() + " of model " + e.getEntityName());
	}
}