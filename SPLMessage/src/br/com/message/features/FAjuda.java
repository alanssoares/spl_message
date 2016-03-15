//#if ${Ajuda} == "T"
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
		// TODO Auto-generated method stub
	}
	//#endif
	
	//#if ${PoliticaPrivacidade} == "T"
	public void politicaPrivacidade() {
		// TODO Auto-generated method stub
	}
	//#endif
	
	//#if ${EnviaComentario} == "T"
	public void comentario() {
		// TODO Auto-generated method stub
	}
	//#endif
}
//#endif