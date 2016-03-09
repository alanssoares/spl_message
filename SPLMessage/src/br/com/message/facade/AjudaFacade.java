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

	public Sobre buscarSobre();
	
	public PoliticaPrivacidade buscarPolitica();
}
