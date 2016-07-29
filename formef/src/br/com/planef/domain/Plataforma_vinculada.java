package br.com.planef.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_plataforma_vinculada")
public class Plataforma_vinculada implements Serializable {

	private static final long serialVersionUID = 9040911904730160015L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "cod_chamado", nullable = false, length = 50)
	private String cod_chamado;

	@Column(name = "plataforma", nullable = false, length = 1)
	private String plataforma;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCod_chamado() {
		return cod_chamado;
	}

	public void setCod_chamado(String cod_chamado) {
		this.cod_chamado = cod_chamado;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	@Override
	public String toString() {
		return "Plataforma_vinculada [id=" + id + ", id_relatorio="
				+ cod_chamado + ", plataforma=" + plataforma + "]";
	}

}
