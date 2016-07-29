package br.com.planef.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.planef.domain.Combo2;
import br.com.planef.domain.Produto;
import br.com.planef.util.HibernateUtil;

public class ComboDAO {

	@SuppressWarnings("unchecked")
	public List<Combo2> combo2() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Combo2> combo2 = null;

		try {
			Query consulta = sessao.getNamedQuery("Combo2.listar");
			combo2 = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}

		return combo2;
	}

	@SuppressWarnings("unchecked")
	public List<Produto> produtos() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Produto> produto = null;

		try {
			Query consulta = sessao.getNamedQuery("Produto.listar");
			produto = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}

		return produto;
	}

}
