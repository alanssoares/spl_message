//#if ${Contato} == "T"
/**
 * 
 */
package br.com.message.features;

import java.awt.Component;

/**
 * @author alsoares
 *
 */
public class FContato {

	private Component parent;

	public FContato(Component parent) {
		this.parent = parent;
	}

	//#if ${RemoverContato} == "T"
	/**
	 * Método responsável por remover um contato
	 */
	public void removerContato() {
		// TODO Auto-generated method stub
	}
	//#endif
	
	//#if ${AdicionarContato} == "T"
	/**
	 * Método responsável por adicionar um novo contato
	 */
	public void adicionarContato() {
		// TODO Auto-generated method stub
	}
	//#endif
	
	//#if ${AlterarContato} == "T"
	/**
	 * Método responsável por alterar os dados de um contato
	 */
	public void alterarContato(){
		
	}
	//#endif
	
	//#if ${VisualizarCartaoVisita} == "T"
	public void visualizarCartaoVisita(){
		// TODO Auto-generated method stub
	}
	//#endif
}
//#endif