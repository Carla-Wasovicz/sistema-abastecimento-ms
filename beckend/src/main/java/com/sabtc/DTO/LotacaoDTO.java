package com.sabtc.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sabtc.entities.Lotacao;

public class LotacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank
	private String descricao;
	@Email
	private String email;
	@NotBlank(message = "O campo é obrigatório")
	private String site;
	@NotBlank(message = "O campo é obrigatório")
	private String telefone;
	@NotBlank(message = "O campo é obrigatório")
	private String endereco;
	
	public LotacaoDTO() {}

	public LotacaoDTO(Long id, String descricao, String email, String site, String telefone, String endereco) {
		this.id = id;
		this.descricao = descricao;
		this.email = email;
		this.site = site;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	public LotacaoDTO(Lotacao entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.email = entity.getEmail();
		this.site = entity.getSite();
		this.telefone = entity.getTelefone();
		this.endereco = entity.getEndereco();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	

}
