//#if ${Ajuda} == "T" or ${Sobre} == "T" or ${PoliticaPrivacidade} == "T" or ${EnviaComentario} == "T" 
/**
 * 
 */
package br.com.message.features;

import java.awt.Component;

/**
 * @author alsoares
 *
 */
public class FAjuda {

	private Component parent;
	
	public FAjuda(Component parent) {
		this.parent = parent;
	}

	//#if ${Sobre} == "T"
	public void sobre() {
		new FSobre(this.parent);
	}
	//#endif
	
	//#if ${PoliticaPrivacidade} == "T"
	public void politicaPrivacidade() {
		new FPoliticaPrivacidade(this.parent);
	}
	//#endif
	
	//#if ${EnviaComentario} == "T"
	public void comentario() {
		new FComentario(this.parent);
	}
	//#endif
	
}
//#endif