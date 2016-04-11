//#if ${Ajuda} == "T"
/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.model.Comentario;
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
	
	//#if ${EnviaComentario} == "T"
	/**
	 * Insere um novo comentário
	 * @param comentario
	 */
	public void inserirComentario(Comentario comentario);
	//#endif
	
	//#if ${ListaComentario} == "T"
	/**
	 * Lista todos os comentarios
	 * @return List<Comentario>
	 */
	public List<Comentario> listarComentarios();
	//#endif
}
//#endif