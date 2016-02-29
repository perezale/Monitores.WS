package net.pladema.monitoresws.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Initializer implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		System.err.println("runn");
		sc.setInitParameter("primefaces.THEME", "bootstrap");
		sc.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
	}
}