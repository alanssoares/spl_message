//#if ${Ajuda} == "T" or ${Sobre} == "T" or ${PoliticaPrivacidade} == "T" or ${EnviaComentario} == "T" 
/**
 * 
 */
package br.com.message.features;

import java.awt.Component;

import br.com.message.util.Constantes;

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
		new FComentario(this.parent, Constantes.FEATURE_SEND_COMMENT).enviaComentario();
	}
	//#endif

	//#if ${ListaComentario} == "T"
	public void listaComentarios() {
		new FComentario(this.parent, Constantes.FEATURE_LIST_COMMENTS).listaComentarios();
	}
	//#endif
}
//#endif