package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquin Balhs", "joaquin@gmail.com");
		Pessoa p3 = new Pessoa(null, "Andre Perro", "andre@gmail.com");
		
		//Ver o nome em persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
        em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto");
		

	}

}
