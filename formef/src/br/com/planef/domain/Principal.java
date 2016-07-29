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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tab_principal")
public class Principal implements Serializable {

	private static final long serialVersionUID = 9040911904730160015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_principal")
	private Integer id_principal;

	@Column(name = "produto_principal", nullable = false)
	private String produto_principal;

	@Column(name = "relevancia_principal", nullable = false)
	private String relevancia_principal;

	@Column(name = "nome_relatorio_principal", unique = true, nullable = false)
	private String nome_relatorio_principal;

	@Column(name = "cod_chamado_principal", nullable = false)
	private String cod_chamado_principal;

	@Column(name = "descricao_principal", nullable = false)
	private String descricao_principal;

	@Column(name = "modulo_grafico_principal", nullable = false)
	private String modulo_grafico_principal;

	@Column(name = "descricao_grafico_principal")
	private String descricao_grafico_principal;

	@Column(name = "periodicidade_principal", nullable = false)
	private String periodicidade_principal;

	@Column(name = "periodicidade_dia_principal", nullable = false)
	private String periodicidade_dia_principal;

	@Column(name = "divulgacao_principal", nullable = false)
	private String divulgacao_principal;

	@Column(name = "divulgacao_endereco_principal", nullable = false)
	private String divulgacao_endereco_principal;

	@Column(name = "vinculo_pltf_principal", nullable = false)
	private String vinculo_pltf_principal;

	public Integer getId_principal() {
		return id_principal;
	}

	public void setId_principal(Integer id_principal) {
		this.id_principal = id_principal;
	}

	public String getProduto_principal() {
		return produto_principal;
	}

	public void setProduto_principal(String produto_principal) {
		this.produto_principal = produto_principal;
	}

	public String getRelevancia_principal() {
		return relevancia_principal;
	}

	public void setRelevancia_principal(String relevancia_principal) {
		this.relevancia_principal = relevancia_principal;
	}

	public String getNome_relatorio_principal() {
		return nome_relatorio_principal;
	}

	public void setNome_relatorio_principal(String nome_relatorio_principal) {
		this.nome_relatorio_principal = nome_relatorio_principal;
	}

	public String getCod_chamado_principal() {
		return cod_chamado_principal;
	}

	public void setCod_chamado_principal(String cod_chamado_principal) {
		this.cod_chamado_principal = cod_chamado_principal;
	}

	public String getDescricao_principal() {
		return descricao_principal;
	}

	public void setDescricao_principal(String descricao_principal) {
		this.descricao_principal = descricao_principal;
	}

	public String getModulo_grafico_principal() {
		return modulo_grafico_principal;
	}

	public void setModulo_grafico_principal(String modulo_grafico_principal) {
		this.modulo_grafico_principal = modulo_grafico_principal;
	}

	public String getDescricao_grafico_principal() {
		return descricao_grafico_principal;
	}

	public void setDescricao_grafico_principal(
			String descricao_grafico_principal) {
		this.descricao_grafico_principal = descricao_grafico_principal;
	}

	public String getPeriodicidade_principal() {
		return periodicidade_principal;
	}

	public void setPeriodicidade_principal(String periodicidade_principal) {
		this.periodicidade_principal = periodicidade_principal;
	}

	public String getPeriodicidade_dia_principal() {
		return periodicidade_dia_principal;
	}

	public void setPeriodicidade_dia_principal(
			String periodicidade_dia_principal) {
		this.periodicidade_dia_principal = periodicidade_dia_principal;
	}

	public String getDivulgacao_principal() {
		return divulgacao_principal;
	}

	public void setDivulgacao_principal(String divulgacao_principal) {
		this.divulgacao_principal = divulgacao_principal;
	}

	public String getDivulgacao_endereco_principal() {
		return divulgacao_endereco_principal;
	}

	public void setDivulgacao_endereco_principal(
			String divulgacao_endereco_principal) {
		this.divulgacao_endereco_principal = divulgacao_endereco_principal;
	}

	public String getVinculo_pltf_principal() {
		return vinculo_pltf_principal;
	}

	public void setVinculo_pltf_principal(String vinculo_pltf_principal) {
		this.vinculo_pltf_principal = vinculo_pltf_principal;
	}

	@Override
	public String toString() {
		return "Principal [id_principal=" + id_principal
				+ ", produto_principal=" + produto_principal
				+ ", relatorio_principal=" + ", relevancia_principal="
				+ relevancia_principal + ", nome_relatorio_principal="
				+ nome_relatorio_principal + ", cod_chamado_principal="
				+ cod_chamado_principal + ", descricao_principal="
				+ descricao_principal + ", modulo_grafico_principal="
				+ modulo_grafico_principal + ", descricao_grafico_principal="
				+ descricao_grafico_principal + ", periodicidade_principal="
				+ periodicidade_principal + ", periodicidade_dia_principal="
				+ periodicidade_dia_principal + ", divulgacao_principal="
				+ divulgacao_principal + ", divulgacao_endereco_principal="
				+ divulgacao_endereco_principal + ", vinculo_pltf_principal="
				+ vinculo_pltf_principal + "]";
	}

}
