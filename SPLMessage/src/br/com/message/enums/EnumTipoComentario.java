/**
 * 
 */
package br.com.message.enums;

/**
 * @author alsoares
 *
 */
public enum EnumTipoComentario {

	DUVIDA(1, "Dúvida"), 
	ELOGIO(2, "Elogio"), 
	SOLICITACAO(3, "Solicitação"), 
	SUGESTAO(4, "Sugestão"), 
	RECLAMACAO(5, "Reclamação");

	private EnumTipoComentario(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	private Integer id;
	private String descricao;
	
	/**
	 * Return the id
	 * @return the id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 * Return the descricao
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Retorna o id de acordo com a descricao
	 * @param descricao
	 * @return
	 */
	static public Integer getIdByDescricao(String descricao){
		for(EnumTipoComentario t : values()){
			if(t.getDescricao().equals(descricao)) return t.getId();
		}
		return 0;
	}
	
	/**
	 * Return the enum by id
	 * @param id
	 * @return 
	 */
	static public String getById(Integer id){
		for(EnumTipoComentario t : values()){
			if(t.id.equals(id)) return t.descricao;
		}
		return null;
	}
}
