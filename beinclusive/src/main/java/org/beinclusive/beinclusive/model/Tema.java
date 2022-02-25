package org.beinclusive.beinclusive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_tema")
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private boolean acessoAzul;
	
	@NotNull
	private boolean acessoVerde;
	
	@NotNull
	private boolean acessoAmarelo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isAcessoAzul() {
		return acessoAzul;
	}

	public void setAcessoAzul(boolean acessoAzul) {
		this.acessoAzul = acessoAzul;
	}

	public boolean isAcessoVerde() {
		return acessoVerde;
	}

	public void setAcessoVerde(boolean acessoVerde) {
		this.acessoVerde = acessoVerde;
	}

	public boolean isAcessoAmarelo() {
		return acessoAmarelo;
	}

	public void setAcessoAmarelo(boolean acessoAmarelo) {
		this.acessoAmarelo = acessoAmarelo;
	}

}
