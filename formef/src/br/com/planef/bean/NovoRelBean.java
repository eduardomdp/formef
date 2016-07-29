package br.com.planef.bean;

import java.text.ParseException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.planef.dao.ComboDAO;
import br.com.planef.dao.NovoRelDAO;
import br.com.planef.domain.Combo2;
import br.com.planef.domain.Produto;
import br.com.planef.filter.NovoRelFilter;
import br.com.planef.util.FacesUtil;

@ManagedBean
@ViewScoped

public class NovoRelBean {

	private String mudagrafdet;

	public String getMudagrafdet() {
		return mudagrafdet;
	}

	public void setMudagrafdet(String mudagrafdet) {
		this.mudagrafdet = mudagrafdet;
	}

	/*--------------------------------------*/

	private List<Combo2> combo2;

	public List<Combo2> getCombo2() {
		return combo2;
	}

	public void setCombo2(List<Combo2> combo2) {
		this.combo2 = combo2;
	}

	/*--------------------------------------*/

	private List<Produto> comboproduto;

	public List<Produto> getComboproduto() {
		return comboproduto;
	}

	public void setComboproduto(List<Produto> comboproduto) {
		this.comboproduto = comboproduto;
	}

	/*--------------------------------------*/

	private String relassoc;

	public String getRelassoc() {
		return relassoc;
	}

	public void setRelassoc(String relassoc) {
		this.relassoc = relassoc;
	}

	/*--------------------------------------*/
	private String prodassoc;

	public String getProdassoc() {
		return prodassoc;
	}

	public void setProdassoc(String prodassoc) {
		this.prodassoc = prodassoc;
	}

	/*--------------------------------------*/

	private String nomsug;

	public String getNomsug() {
		return nomsug;
	}

	public void setNomsug(String nomsug) {
		this.nomsug = nomsug;
	}

	/*--------------------------------------*/

	private NovoRelFilter filtro;

	public NovoRelFilter getFiltro() {
		if (filtro == null) {
			filtro = new NovoRelFilter();
		}
		return filtro;
	}

	public void setFiltro(NovoRelFilter filtro) {
		this.filtro = filtro;
	}

	/*-------------------------------------------------*/

	private Combo2 combo;

	public Combo2 getCombo() {
		return combo;
	}

	public void setCombo(Combo2 combo) {
		this.combo = combo;
	}

	/*-------------------------------------------------*/

	public void Combo2() {
		combo2 = null;
		try {

			ComboDAO DAO = new ComboDAO();
			combo2 = DAO.combo2();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao obter 2º combo: "
					+ ex.getMessage());
		}
	}

	public void ComboProduto() {
		comboproduto = null;
		try {

			ComboDAO DAO = new ComboDAO();
			comboproduto = DAO.produtos();

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao obter 2º combo: "
					+ ex.getMessage());
		}
	}

	public void salvarRN() throws ParseException {

		if (filtro.getProdutoAssociadoNR().equals("-")) {
			FacesUtil.adicionarMsgErro("Selecione um produto.");
		} else if (filtro.getNomeSugeridoNR().length() < 10) {
			FacesUtil.adicionarMsgErro("Digite um nome para o relatório.");
		} else if (filtro.getRelevanciaNR().equals("-")) {
			FacesUtil
					.adicionarMsgErro("Selecione qual a relevência para a abertura do chamado.");
		} else if (filtro.getDetalheNR().length() < 100) {
			FacesUtil
					.adicionarMsgErro("Necessário, no mínimo, 100 caracteres na descrição do chamado.");
		} else if (filtro.getModuloGraficoNR().equals("")) {
			FacesUtil.adicionarMsgErro("Escolher se haverá módulo gráfico.");
		} else if (filtro.getModuloGraficoNR().equals("SIM")
				&& filtro.getModuloGraficoDetalheNR().length() < 20) {
			FacesUtil
					.adicionarMsgErro("Necessário, no mínimo, 20 caracteres na descrição dos modulos gráficos.");
		}

		try {

			NovoRelDAO DAO = new NovoRelDAO();
			DAO.salvarRN(filtro, combo);

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao obter filtros de combo: "
					+ ex.getMessage());
		}
	}

	public void GraficoDetalhe() {
		if (filtro.getModuloGraficoNR().equals("SIM")) {
			mudagrafdet = "true";
		} else {
			mudagrafdet = "false";
			filtro.setModuloGraficoDetalheNR(null);
		}
	}
}
