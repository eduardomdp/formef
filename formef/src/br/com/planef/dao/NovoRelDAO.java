package br.com.planef.dao;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.planef.domain.Combo2;
import br.com.planef.domain.Principal;
import br.com.planef.filter.NovoRelFilter;
import br.com.planef.util.HibernateUtil;

public class NovoRelDAO {

	public void salvarRN(NovoRelFilter filtro, Combo2 combo2)
			throws ParseException {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();

			Principal principal = new Principal();
			principal.setProduto_principal(filtro.getProdutoAssociadoNR());
			principal.setNome_relatorio_principal(filtro.getNomeSugeridoNR());
			principal.setRelevancia_principal(filtro.getRelevanciaNR());
			principal.setDescricao_principal(filtro.getDetalheNR());
			principal.setModulo_grafico_principal(filtro.getModuloGraficoNR());
			principal.setDescricao_grafico_principal(filtro
					.getModuloGraficoDetalheNR());
			principal.setPeriodicidade_principal(filtro
					.getPeriodoDivulgacaoNR());
			if (filtro.getPeriodoDivulgacaoNR().equals("SEMANAL")) {
				principal.setPeriodicidade_dia_principal(filtro
						.getPeriodoDivulgacaoDiaNR());
			} else if (filtro.getPeriodoDivulgacaoNR().equals("MENSAL")) {
				principal.setPeriodicidade_dia_principal(filtro
						.getPeriodoDivulgacaoDataNR());
			} else {
				principal.setPeriodicidade_dia_principal("DIARIO");
			}
			principal.setDivulgacao_principal(filtro.getFormatoDivulgacaoNR());
			principal.setDivulgacao_endereco_principal(filtro
					.getFormatoDivulgacaoTextoNR());
			if (filtro.getVinculoPlataformaNR().equals("1")) {
				principal.setVinculo_pltf_principal("NAO SE APLICA");
			} else {
				principal.setVinculo_pltf_principal(filtro
						.getVinculoPlataformaNR());
			}

			sessao.save(principal);

			transacao.commit();

		} catch (RuntimeException ex) {

			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}

	}

}
