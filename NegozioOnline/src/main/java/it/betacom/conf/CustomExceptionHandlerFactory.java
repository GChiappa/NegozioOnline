package it.betacom.conf;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory exceptionHandlerFactory;

	public CustomExceptionHandlerFactory(ExceptionHandlerFactory exceptionHandlerFactory) {
		super(exceptionHandlerFactory);
		this.exceptionHandlerFactory = exceptionHandlerFactory;
	}

	@Override
	public ExceptionHandler getExceptionHandler() {
		return new CustomErrorHandler(exceptionHandlerFactory.getExceptionHandler());
	}

}
