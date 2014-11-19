package br.fjn.edu.parkingsys.intercepts;

import javax.inject.Inject;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.fjn.edu.parkingsys.anotations.Public;
import br.fjn.edu.parkingsys.components.UserSession;
import br.fjn.edu.parkingsys.controller.LoginController;

@Intercepts
public class AuthenticationIntercept implements Interceptor {

	private UserSession userSession;
	private Result result;

	@Inject
	public AuthenticationIntercept(UserSession userSession, Result result) {
		super();
		this.userSession = userSession;
		this.result = result;
	}

	// Necessário para o CDI
	AuthenticationIntercept() {

	}

	@Override
	public boolean accepts(ControllerMethod cm) {
		return !(cm.getMethod().isAnnotationPresent(Public.class) || cm
				.getController().getType().isAnnotationPresent(Public.class));
	}

	@Override
	public void intercept(InterceptorStack is, ControllerMethod cm,
			Object object) throws InterceptionException {

		if (userSession.isLogged()) {
			is.next(cm, object);
		} else {
			result.redirectTo(LoginController.class).loginForm();
		}

	}

}
