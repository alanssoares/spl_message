//#if ${Contato} == "T" or ${RemoverContato} == "T" or ${AdicionarContato} == "T"
/**
 * 
 */
package br.com.message.dao;

import java.util.List;

import br.com.message.model.Contato;

/**
 * @author alsoares
 *
 */
public interface ContatoDao {

	//#if ${RemoverContato} == "T"
	/**
	 * Método responsável por remover um contato
	 * @param contato a ser removido
	 */
	void remover(Contato contato);
	//#endif
	
	//#if ${AdicionarContato} == "T"
	/**
	 * Método responsável por inserir um contato
	 * @param contato a ser inserido
	 */
	void inserir(Contato contato);
	//#endif
	
	//#if ${AlterarContato} == "T"
	/**
	 * Método responsável por atualizar os dados do contato
	 * @param contato a ser atualizado
	 */
	void alterar(Contato contato);
	//#endif
	
	/**
	 * Método responsável por buscar um contato
	 * @param contato a ser buscado
	 * @return Contato
	 */
	Contato buscar(Contato contato);
	
	/**
	 * Método responsável por listar os contatos
	 * @param email usado para busca de contatos
	 * @return List<Contato>
	 */
	List<Contato> listar(String email);
}
//#endif