/**
 * 
 */
package br.com.message.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import br.com.message.model.PoliticaPrivacidade;
import br.com.message.model.Sobre;
import br.com.message.model.Status;
import br.com.message.util.Constantes;

/**
 * @author alsoares
 *
 */
public class CarregarDadosBanco {

	private EntityManager em;
	
	@Before
	public void iniciaConexaoBanco(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(Constantes.NAME_DB);
		this.em = factory.createEntityManager();
	}
	
	@Test
	public void carregaRegistrosDeStatusNoBanco(){
		Status status1 = new Status();
		status1.setDescricao("Disponível");
		Status status2 = new Status();
		status2.setDescricao("Ocupado");
		Status status3 = new Status();
		status3.setDescricao("Não Incomodar");
		Status status4 = new Status();
		status4.setDescricao("Volto Logo");
		Status status5 = new Status();
		status5.setDescricao("Ausente do Trabalho");
		Status status6 = new Status();
		status6.setDescricao("Aparecer como Ausente");
		EntityTransaction transaction = this.em.getTransaction();
		transaction.begin();
		this.em.persist(status1);
		this.em.persist(status2);
		this.em.persist(status3);
		this.em.persist(status4);
		this.em.persist(status5);
		this.em.persist(status6);
		transaction.commit();
	}
	
	@Test
	public void carregarRegistroPoliticaPrivacidade(){
		PoliticaPrivacidade politica = new PoliticaPrivacidade();
		politica.setDescricao("Coletamos informações para fornecer serviços "
				+ "melhores a todos os nossos usuários. O Message preza pela "
				+ "segurança e confiabilidade dos dados pessoais dos usuários "
				+ "do site. Para os usuários do Message pressupõe a aceitação "
				+ "deste Acordo de Privacidade. A equipe do Message "
				+ "reserva-se ao direito de modificar esta política sem aviso "
				+ "prévio. Assim, nossa recomendação é que você crie o hábito "
				+ "de consultar este acordo com regularidade para estar consciente "
				+ "das suas atualizações.");
		EntityTransaction transaction = this.em.getTransaction();
		transaction.begin();
		this.em.persist(politica);
		transaction.commit();
	}
	
	@Test
	public void carregarRegistroSobreOMessage(){
		Sobre sobre = new Sobre();
		sobre.setDescricao("Este protótipo não deve ser distribuído ou reproduzido. "
				+ "Ele foi criado para ilustrar uma SPL na disciplina de Reuso de Software "
				+ "da Universidade Federal da Bahia. É puramente acadêmico.");
		EntityTransaction transaction = this.em.getTransaction();
		transaction.begin();
		this.em.persist(sobre);
		transaction.commit();
	}
}
