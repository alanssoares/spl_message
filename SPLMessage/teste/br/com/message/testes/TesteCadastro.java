/**
 * 
 */
package br.com.message.testes;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.message.enums.EnumTipoComentario;
import br.com.message.facade.AjudaFacade;
import br.com.message.facade.AjudaFacadeImpl;
import br.com.message.facade.UsuarioFacade;
import br.com.message.facade.UsuarioFacadeImpl;
import br.com.message.model.Comentario;
import br.com.message.model.PoliticaPrivacidade;
import br.com.message.model.Sobre;
import br.com.message.model.Usuario;
import br.com.message.util.Constantes;

/**
 * @author alsoares
 *
 */
public class TesteCadastro {

	private EntityManager em;
	
	@Before
	public void iniciaConexaoBanco(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constantes.NAME_DB);
		this.em = factory.createEntityManager();
	}
	
	@Test
	public void cadastraNovaPoliticaPrivacidade(){
		EntityTransaction transaction = this.em.getTransaction();
		PoliticaPrivacidade politica = new PoliticaPrivacidade();
		politica.setDescricao("Teste Política");
		transaction.begin();
		this.em.persist(politica);
		transaction.commit();
	}
	
	@Test
	public void cadastraNovoSobre(){
		EntityTransaction transaction = this.em.getTransaction();
		Sobre sobre = new Sobre();
		sobre.setDescricao("Novo sobre cadastrado");
		transaction.begin();
		this.em.persist(sobre);
		transaction.commit();
	}
	
	@Test
	public void cadastraNovoUsuario(){
		UsuarioFacade fu = new UsuarioFacadeImpl();
		Usuario u = new Usuario();
		u.setDataInclusao(new Date());
		u.setNome("Carlos");
		u.setSenha("123");
		u.setEmail("carlos@email.com");
		u.setIdStatus(0);
		fu.inserir(u);
	}
	
	@Test
	public void cadastraNovoComentario(){
		AjudaFacade af = new AjudaFacadeImpl();
		Comentario c = new Comentario();
		c.setAssunto("Teste");
		c.setDataInclusao(new Date());
		c.setDescricao("Enviando comentário");
		c.setEmailUsuario("carlos@email.com");
		c.setTipo(EnumTipoComentario.DUVIDA.getId());
		af.inserirComentario(c);
	}
}
