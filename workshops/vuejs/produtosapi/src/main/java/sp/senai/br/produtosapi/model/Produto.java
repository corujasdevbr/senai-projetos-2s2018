package sp.senai.br.produtosapi.model;

import java.util.Date;

public class Produto {

	private Long id;
	private String descricao;
	private String urlImagem;
	private Date dataCadastro;
	
	public Produto() {
		
	}
	
	public Produto(Long id, String descricao, String urlImagem, Date dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.urlImagem = urlImagem;
		this.dataCadastro = dataCadastro;
	}



	public Date getDataCadastro() {
		return dataCadastro;
	}



	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}



	public Produto(Long id, String descricao, String urlImagem) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.urlImagem = urlImagem;
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

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

}
