//#if ${Ajuda} == "T" or ${Sobre} == "T" or ${PoliticaPrivacidade} == "T" or ${EnviaComentario} == "T" or ${ListaComentarios} == "T"
/**
 * 
 */
package br.com.message.facade;

import java.util.Date;
import java.util.List;

import br.com.message.dao.ComentarioDao;
import br.com.message.dao.ComentarioDaoImpl;
import br.com.message.dao.PoliticaPrivacidadeDao;
import br.com.message.dao.PoliticaPrivacidadeDaoImpl;
import br.com.message.dao.SobreDao;
import br.com.message.dao.SobreDaoImpl;
import br.com.message.model.Comentario;
import br.com.message.model.PoliticaPrivacidade;
import br.com.message.model.Sobre;
import br.com.message.util.DataStore;

/**
 * @author alsoares
 *
 */
public class AjudaFacadeImpl implements AjudaFacade {
	
	//#if ${PoliticaPrivacidade} == "T"
	private PoliticaPrivacidadeDao politicaPrivacidadeDao = new PoliticaPrivacidadeDaoImpl();
	//#endif
	
	//#if ${Sobre} == "T"
	private SobreDao sobreDao = new SobreDaoImpl();
	//#endif
	
	//#if ${Sobre} == "T"
	@Override
	public Sobre buscarSobre() {
		return this.sobreDao.buscar();
	}
	//#endif
	
	//#if ${PoliticaPrivacidade} == "T"
	@Override
	public PoliticaPrivacidade buscarPolitica() {
		return this.politicaPrivacidadeDao.buscar();
	}
	//#endif
	
	//#if ${EnviaComentario} == "T" or ${ListaComentarios} == "T"
	private ComentarioDao comentarioDao = new ComentarioDaoImpl();
	//#endif
	
	//#if ${EnviaComentario} == "T"
	@Override
	public void inserirComentario(Comentario comentario) {
		comentario.setEmailUsuario(DataStore.getInstance().getUsuario().getEmail());
		comentario.setDataInclusao(new Date());
		this.comentarioDao.inserir(comentario);
	}
	//#endif
	
	//#if ${ListaComentarios} == "T"
	@Override
	public List<Comentario> listarComentarios() {
		return this.comentarioDao.listar();
	}
	//#endif
}
//#endif