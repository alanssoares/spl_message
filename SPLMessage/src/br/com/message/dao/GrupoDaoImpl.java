//#if ${Grupo} == "T" or ${CadastrarGrupo} == "T" or ${RemoverGrupo} == "T"
/**
 * 
 */
package br.com.message.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.message.model.Grupo;

/**
 * @author alsoares
 *
 */
@SuppressWarnings("unchecked")
public class GrupoDaoImpl extends GenericDao<Grupo, Integer> implements GrupoDao {

	public GrupoDaoImpl() {
		super(Grupo.class);
	}

	//#if ${CadastrarGrupo} == "T"
	@Override
	public Grupo inserir(Grupo grupo) {
		return insert(grupo);
	}
	//#endif
	
	//#if ${RemoverGrupo} == "T"
	@Override
	public void remover(Grupo grupo) {
		remove(grupo.getId());
	}
	//#endif
	
	@Override
	public Grupo buscar(Grupo grupo) {
		return find(grupo.getId());
	}
	
	@Override
	public List<Grupo> listar(String email) {
		List<Grupo> list = getList();
		List<Grupo> grupos = new ArrayList<Grupo>();
		for(Grupo g : list){
			if(g.getEmailUsuario().equals(email)){
				grupos.add(g);
			}
		}
		return grupos;
	}

	@Override
	public Grupo buscar(String descricao) {
		EntityManager em = getEntityManager();
		List<Grupo> grupos = em.createQuery(
				"FROM grupo g WHERE g.descricao = :descricao")
				.setParameter("descricao", descricao)
				.getResultList();
		em.close();
		if(grupos.isEmpty()) {
			return null;
		}
		return grupos.get(0);
	}
}
//#endif