package br.com.planef.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_relatorio")
public class Relatorio implements Serializable {

	private static final long serialVersionUID = 9040911904730160015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "periodicidade", nullable = false)
	private String periodicidade;

	@Column(name = "data_periodicidade", nullable = false)
	private String data_periodicidade;

	@Column(name = "divulgacao", nullable = false)
	private String divulgacao;

	@Column(name = "local_divulgacao", nullable = false)
	private String local_divulgacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produto", referencedColumnName = "id", nullable = false)
	private Produto produto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(String periodicidade) {
		this.periodicidade = periodicidade;
	}

	public String getData_periodicidade() {
		return data_periodicidade;
	}

	public void setData_periodicidade(String data_periodicidade) {
		this.data_periodicidade = data_periodicidade;
	}

	public String getDivulgacao() {
		return divulgacao;
	}

	public void setDivulgacao(String divulgacao) {
		this.divulgacao = divulgacao;
	}

	public String getLocal_divulgacao() {
		return local_divulgacao;
	}

	public void setLocal_divulgacao(String local_divulgacao) {
		this.local_divulgacao = local_divulgacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Relatorio [id=" + id + ", descricao=" + descricao + ", status="
				+ status + ", periodicidade=" + periodicidade
				+ ", data_periodicidade=" + data_periodicidade
				+ ", divulgacao=" + divulgacao + ", local_divulgacao="
				+ local_divulgacao + ", produto=" + produto + "]";
	}

}
