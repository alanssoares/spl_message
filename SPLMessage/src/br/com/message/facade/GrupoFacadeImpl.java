//#if ${Grupo} == "T" or ${CadastrarGrupo} == "T" or ${RemoverGrupo} == "T"
/**
 * 
 */
package br.com.message.facade;

import java.util.List;

import br.com.message.dao.GrupoDao;
import br.com.message.dao.GrupoDaoImpl;
import br.com.message.model.Grupo;
import br.com.message.util.DataStore;

/**
 * @author alsoares
 *
 */
public class GrupoFacadeImpl implements GrupoFacade {

	private GrupoDao grupoDao = new GrupoDaoImpl();

	//#if ${CadastrarGrupo} == "T"
	@Override
	public Grupo inserir(Grupo grupo) {
		grupo.setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
		if(buscar(grupo.getDescricao()) != null){
			return null;
		}
		return grupoDao.inserir(grupo);
	}
	//#endif
	
	@Override
	public Grupo buscar(Grupo grupo) {
		grupo.setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
		return this.grupoDao.buscar(grupo);
	}

	//#if ${RemoverGrupo} == "T"
	@Override
	public void remover(Grupo grupo) {
		grupo.setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
		this.grupoDao.remover(grupo);
	}
	//#endif
	
	@Override
	public List<Grupo> listar() {
		return this.grupoDao.listar(DataStore.getInstance().getUsuario().getEmail());
	}

	@Override
	public Grupo buscar(String descricao) {
		return this.grupoDao.buscar(descricao);
	}
}
//#endif