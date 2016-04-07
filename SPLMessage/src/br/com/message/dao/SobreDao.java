//#if ${Sobre} == "T"
/**
 * 
 */
package br.com.message.dao;

import br.com.message.model.Sobre;

/**
 * @author alsoares
 *
 */
public interface SobreDao {

	/**
	 * Método responsável por buscar a descrição do aplicativo
	 * @return Sobre
	 */
	Sobre buscar();
	
}
//#endif