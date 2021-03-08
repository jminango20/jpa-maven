package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {

		
		//Ver o nome em persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
        //1) Paso: Salvar base de dados
		//Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Joaquin Balhs", "joaquin@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Andre Perro", "andre@gmail.com");
		//em.getTransaction().begin();
		//em.persist(p1);
		//em.persist(p2);
		//em.persist(p3);
		//em.getTransaction().commit();
		//System.out.println("Pronto");
		
		
		//2) Paso: Procura uma pessoa por ID no DB
		//Pessoa p = em.find(Pessoa.class, 2); //no id: 2
		//System.out.println("Procuando pesso no id: 2 ");
		//System.out.println(p);
		
		
		//3) Paso: Removendo dados do DB: ERROR
		//Pessoa p = new Pessoa(2, "Joaquin Balhs", "joaquin@gmail.com");
		//em.remove(p); //para remover o objeto p deve estar como monitorado
		//System.out.println("Pronto Removido");
		//O que eh monitorado: Obj que se acabou do inserir ou que se procuro mas ainda nao feche o em.close()
		
		//4) Paso: Removendo dados do DB: Sempre temos que colocar uma transacao quando nao eh uma simple consulta
		em.getTransaction().begin();
		Pessoa p = em.find(Pessoa.class, 2);
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Pronto Removido!");
		
		
		//Fechando o EM e EMF
		em.close();
		emf.close();
		

	}

}
