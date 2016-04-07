//#if ${Contato} == "T" or ${RemoverContato} == "T" or ${AdicionarContato} == "T"
/**
 * 
 */
package br.com.message.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.message.model.Contato;
import br.com.message.model.ContatoPK;

/**
 * @author alsoares
 *
 */
public class ContatoDaoImpl extends GenericDao<Contato, ContatoPK> implements ContatoDao {

	public ContatoDaoImpl() {
		super(Contato.class);
	}

	//#if ${RemoverContato} == "T"
	@Override
	public void remover(Contato contato) {
		remove(contato.getContatoPK());
	}
	//#endif
	
	//#if ${AdicionarContato} == "T"
	@Override
	public void inserir(Contato contato) {
		insert(contato);
	}
	//#endif
	
	//#if ${AlterarContato} == "T"
	@Override
	public void alterar(Contato contato) {
		update(contato);
	}
	//#endif
	
	@Override
	public Contato buscar(Contato contato) {
		return find(contato.getContatoPK());
	}
	
	@Override
	public List<Contato> listar(String email) {
		List<Contato> result = getList();
		List<Contato> contatos = new ArrayList<Contato>();
		for(Contato c : result){
			if(email.equals(c.getEmailUsuario())){
				contatos.add(c);
			}
		}
		return contatos;
	}
}
//#endif