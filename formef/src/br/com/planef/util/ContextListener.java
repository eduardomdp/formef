package br.com.planef.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Chama quando para o tomcat
		HibernateUtil.getSessionFactory().close();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// Chama quando da play no tomcat
		HibernateUtil.getSessionFactory().openSession();

	}

}
