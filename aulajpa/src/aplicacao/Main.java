package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Main {

	public static void main(String[] args) {
		
		Pessoa pessoa1 = new Pessoa(null, "Joao", "joao@gmail.com");
		Pessoa pessoa2 = new Pessoa(null, "Pedro", "pedro@gmail.com");
		Pessoa pessoa3 = new Pessoa(null, "Bandeira", "bandeira@gmail.com");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	/*
	 * Transação para persistir no banco de dados, incluindo os dados dos atributos	
		entityManager.getTransaction().begin();
		entityManager.persist(pessoa1);
		entityManager.persist(pessoa2);
		entityManager.persist(pessoa3);
		entityManager.getTransaction().commit();
	*/
		Pessoa pessoa = entityManager.find(Pessoa.class, 1);
		System.out.println(pessoa);
		
		entityManagerFactory.close();
		entityManager.close();
	}

}
