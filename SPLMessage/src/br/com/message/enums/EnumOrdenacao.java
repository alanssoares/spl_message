/**
 * 
 */
package br.com.message.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alsoares
 *
 */
public enum EnumOrdenacao {
	
	//#if ${Grupo} == "T" and ${OrdenarContatos} == "T"
	GRUPO(2, "Grupo"),
	//#endif
	
	//#if ${Status} == "T" and ${OrdenarContatos} == "T"
	STATUS(1, "Status"),
	//#endif
	
	EMAIL(0, "Email");
	
	private int id;
	private String descricao;
	
	private EnumOrdenacao(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	/**
	 * Return the id
	 * @return the id
	 */
	public int getId() {
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
	 * Return the list of enums
	 * @return List<String>
	 */
	public static List<String> getList(){
		List<String> list = new ArrayList<String>();
		for(EnumOrdenacao eo : values()){
			list.add(eo.getDescricao());
		}
		return list;
	}
}
