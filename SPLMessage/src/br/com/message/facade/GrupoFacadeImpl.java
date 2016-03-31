//#if ${Grupo} == "T" or ${CadastrarGrupo} == "T" or ${RemoverGrupo} == "T"
/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.dao.GrupoDao;
import br.com.message.dao.GrupoDaoImpl;
import br.com.message.model.Grupo;

/**
 * @author alsoares
 *
 */
public class GrupoFacadeImpl implements GrupoFacade {

	private GrupoDao grupoDao = new GrupoDaoImpl();

	//#if ${CadastrarGrupo} == "T"
	@Override
	public void inserir(Grupo grupo) {
		this.grupoDao.inserir(grupo);
	}
	//#endif
	
	@Override
	public Grupo buscar(Grupo grupo) {
		return this.grupoDao.buscar(grupo);
	}

	//#if ${RemoverGrupo} == "T"
	@Override
	public void remover(Grupo grupo) {
		this.grupoDao.remover(grupo);
	}
	//#endif
	
	@Override
	public List<Grupo> listar() {
		return this.grupoDao.listar();
	}
}
//#endif