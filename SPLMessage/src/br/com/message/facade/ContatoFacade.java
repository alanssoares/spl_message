//#if ${Contato} == "T" or ${RemoverContato} == "T" or ${AdicionarContato} == "T"
/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.model.Contato;
import br.com.message.model.Usuario;

/**
 * @author alsoares
 *
 */
public interface ContatoFacade {

	//#if ${AdicionarContato} == "T"
	/**
	 * Método responsável por inserir um contato
	 * @param contato a ser inserido
	 */
	public void inserir(Contato contato);
	//#endif
	
	//#if ${RemoverContato} == "T"
	/**
	 * Método responsável por remover um contato
	 * @param contato a ser removido
	 * @return Usuario
	 */
	public Usuario remover(Contato contato);
	//#endif
	
	//#if ${AlterarContato} == "T"
	/**
	 * Método responsável por alterar um contato
	 * @param contato a ser alterado
	 */
	public void update(Contato contato);
	//#endif
	
	/**
	 * Método responsável por listar todos os contatos do usuário 
	 * @param email do usuário logado
	 * @return List<Contato>
	 */
	public List<Contato> listar(String email);

	/**
	 * Método responsável por buscar um contato
	 * @param contato a ser buscado
	 * @return Contato
	 */
	public Contato buscar(Contato contato);
}
//#endif