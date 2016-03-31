//#if ${Grupo} == "T" or ${CadastrarGrupo} == "T" or ${RemoverGrupo} == "T"
/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.model.Grupo;

/**
 * @author alsoares
 *
 */
public interface GrupoFacade {

	//#if ${CadastrarGrupo} == "T"
	public void inserir(Grupo grupo);
	//#endif
	
	public Grupo buscar(Grupo grupo);
	
	//#if ${RemoverGrupo} == "T"
	public void remover(Grupo grupo);
	//#endif
	
	public List<Grupo> listar();
}
//#endif