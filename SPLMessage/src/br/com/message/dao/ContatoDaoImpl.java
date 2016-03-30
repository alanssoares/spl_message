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

	@Override
	public void remover(Contato contato) {
		remove(contato.getContatoPK());
	}

	@Override
	public void inserir(Contato contato) {
		insert(contato);
	}

	@Override
	public Contato buscar(Contato contato) {
		return find(contato.getContatoPK());
	}
}