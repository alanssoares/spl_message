//#if ${Ajuda} == "T" and ${PoliticaPrivacidade} == "T"
/**
 * 
 */
package br.com.message.dao;

import br.com.message.model.PoliticaPrivacidade;

/**
 * @author alsoares
 *
 */
public interface PoliticaPrivacidadeDao {

	/**
	 * Método responsável por buscar a política de privacidade
	 * @return PoliticaPrivacidade
	 */
	PoliticaPrivacidade buscar();

}
//#endif