package br.com.planef.bean;

import org.junit.Test;

import br.com.planef.util.HibernateUtil;

public class Teste {

	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}
}