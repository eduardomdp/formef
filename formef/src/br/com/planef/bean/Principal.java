package br.com.planef.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.planef.dao.ComboDAO;
import br.com.planef.domain.Combo2;
import br.com.planef.domain.Produto;
import br.com.planef.filter.NovoRelFilter;
import br.com.planef.util.FacesUtil;

@ManagedBean
@ViewScoped
public class Principal {

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

	public void Relassoc() {
		if (filtro.getCombo1() == null || filtro.getCombo1() == ""
				|| filtro.getCombo1().equals("")) {
			relassoc = "F";
			prodassoc = "F";
		} else if (filtro.getCombo1().equals("1")) {
			relassoc = "F";
			prodassoc = "V";
		} else {
			relassoc = "V";
			prodassoc = "V";
		}
	}

	public void Prodassoc() {

		Integer num = Integer.parseInt(filtro.getComboproduto());

		if (filtro.getComboproduto() == null || filtro.getComboproduto() == ""
				|| filtro.getComboproduto().equals("")) {
			nomsug = "F";
		} else if (num > 0 && filtro.getCombo1().equals("1")) {
			nomsug = "V";
		} else {
			nomsug = "F";
		}
	}
}
