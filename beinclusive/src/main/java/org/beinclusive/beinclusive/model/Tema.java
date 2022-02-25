package org.beinclusive.beinclusive.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.beinclusive.beinclusive.utils.EnumAvaliacao;

@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Enumerated(EnumType.STRING)
	private EnumAvaliacao avaliacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EnumAvaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(EnumAvaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

}
