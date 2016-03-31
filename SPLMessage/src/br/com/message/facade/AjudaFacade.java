//#if ${Ajuda} == "T" or ${Sobre} == "T" or ${PoliticaPrivacidade} == "T"
/**
 * 
 */
package br.com.message.facade;

import br.com.message.model.PoliticaPrivacidade;
import br.com.message.model.Sobre;

/**
 * @author alsoares
 *
 */
public interface AjudaFacade {

	//#if ${Sobre} == "T"
	public Sobre buscarSobre();
	//#endif
	
	//#if ${PoliticaPrivacidade} == "T"
	public PoliticaPrivacidade buscarPolitica();
	//#endif
}
//#endif