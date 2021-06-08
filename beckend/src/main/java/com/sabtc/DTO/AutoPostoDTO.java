package com.sabtc.DTO;

import java.io.Serializable;
import com.sabtc.entities.AutoPosto;

public class AutoPostoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nomeFantasia;
	private String telefone;
	private String email;
	private String CNPJ;
	private String endereco;
	
	public AutoPostoDTO() {}

	public AutoPostoDTO(Long id, String nomeFantasia, String telefone, String email, String cNPJ, String endereco) {
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		this.email = email;
		CNPJ = cNPJ;
		this.endereco = endereco;
	} 
	public AutoPostoDTO(AutoPosto entity) {
		this.id = entity.getId();
		this.nomeFantasia = entity.getNomeFantasia();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
		CNPJ = entity.getCNPJ();
		this.endereco = entity.getEndereco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	} 
}
