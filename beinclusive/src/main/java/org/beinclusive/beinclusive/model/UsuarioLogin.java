package org.beinclusive.beinclusive.model;

import org.beinclusive.beinclusive.utils.EnumCategoria;

public class UsuarioLogin {
	
	private long id;
	
	private String nome;
	
	private String email;
	
	private String senha;

	private String foto;
	
	private String token;

	private EnumCategoria categoria;
	
	public String getNome() {
		return nome;
	}

	public EnumCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(EnumCategoria categoria) {
		this.categoria = categoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
