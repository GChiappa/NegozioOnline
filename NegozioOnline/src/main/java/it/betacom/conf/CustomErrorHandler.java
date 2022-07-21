package it.betacom.conf;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class CustomErrorHandler extends ExceptionHandlerWrapper {

	private ExceptionHandler exceptionHandler;

	public CustomErrorHandler(ExceptionHandler wrapper) {
		super(wrapper);
		exceptionHandler = wrapper;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return exceptionHandler;
	}

	@Override
	public void handle() throws FacesException {
		final Iterator<ExceptionQueuedEvent> coda = getUnhandledExceptionQueuedEvents().iterator();

		while (coda.hasNext()) {
			ExceptionQueuedEvent elemento = coda.next();
			ExceptionQueuedEventContext exceptionQueuedEventContext = elemento.getContext();

			try {
				Throwable eccezione = exceptionQueuedEventContext.getException();
				System.err.println("Exception: " + eccezione.getMessage());

				FacesContext facesContext = FacesContext.getCurrentInstance();
				Map<String, Object> mappa = facesContext.getExternalContext().getRequestMap();

				NavigationHandler nav = facesContext.getApplication().getNavigationHandler();
				mappa.put("error-message", eccezione.getMessage());
				mappa.put("error-stack", eccezione.getStackTrace());

				nav.handleNavigation(facesContext, null, "/error");
				facesContext.renderResponse();
			} finally {
				coda.remove();
			}

		}

	}

}
