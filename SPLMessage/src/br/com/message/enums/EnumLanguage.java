/**
 * 
 */
package br.com.message.enums;

/**
 * @author alsoares
 *
 */
public enum EnumLanguage {

	US(0, "English US"),
	PT_BR(1, "Portuguese");
	
	private Integer id;
	private String descricao;
	
	private EnumLanguage(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	/**
	 * Return the id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Return the descricao
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
}
