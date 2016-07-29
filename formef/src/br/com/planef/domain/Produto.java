package br.com.planef.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_produto")
@NamedQuery(name = "Produto.listar", query = "SELECT p FROM Produto p WHERE p.status = 'A' ORDER BY p.descricao")
public class Produto implements Serializable {

	private static final long serialVersionUID = 9040911904730160015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "status", nullable = false, length = 1)
	private String status;

	@Column(name = "chave_email", nullable = false, length = 100)
	private String chave_email;

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

	public String getChave_email() {
		return chave_email;
	}

	public void setChave_email(String chave_email) {
		this.chave_email = chave_email;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", status="
				+ status + ", chave_email=" + chave_email + "]";
	}

}
