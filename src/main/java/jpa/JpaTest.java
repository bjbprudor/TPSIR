package jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Chauffage;
import domain.ElectronicDevice;
import domain.Person;
import domain.Residence;


public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) 
	{
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		EntityManagerFactory factory =   
	              Persistence.createEntityManagerFactory("example");
	        EntityManager manager = factory.createEntityManager();
	        JpaTest test = new JpaTest(manager);

	        EntityTransaction tx = manager.getTransaction();
	        tx.begin();
	        try {
	            test.createPersons();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        tx.commit();

	        test.listPerson();
	            
	        manager.close();
	        System.out.println(".. done");
	}

    private void createPersons() 
    {
        int numOfEmployees = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
        if (numOfEmployees == 0) 
        {
        	
        	Chauffage ch1 = new Chauffage("150CH", "ch1");
        	Chauffage ch2 = new Chauffage("149Z","ch2");
        	manager.persist(ch1);
        	manager.persist(ch2);   	

        	ElectronicDevice ed1 = new ElectronicDevice("TV", 18f);
        	ElectronicDevice ed2 = new ElectronicDevice("Fridge", 25f);
        	manager.persist(ed1);
        	manager.persist(ed2);
        	
        	Collection<Chauffage> cch = new ArrayList<Chauffage>();
        	cch.add(ch1);
        	cch.add(ch2);
        	Collection<ElectronicDevice> ced = new ArrayList<ElectronicDevice>();
        	ced.add(ed1);
        	ced.add(ed2);
        	
        	Residence re1 = new Residence(20f, 2, cch, ced);
        	Residence re2 = new Residence(42, 5, cch,ced);
        	manager.persist(re1);
        	manager.persist(re2);

        	Collection<Residence> cre = new ArrayList<Residence>();
        	cre.add(re1);
        	cre.add(re2);        	
        	
        	Person p1 = new Person("Elkamali", "Youssef", cre, new ArrayList<Person>());
        	Person p2 = new Person("Prudor", "Bastien", cre, new ArrayList<Person>());        	
        	manager.persist(p1);
        	manager.persist(p2);

        }
    }

    private void listPerson() 
    {
        Collection<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
        System.out.println("num of persons:" + resultList.size());
        for (Person next : resultList) 
        {
            System.out.println("next person: " + next);
        }
        Collection<Residence> resultRe = manager.createQuery("Select a From Residence a", Residence.class).getResultList();
        System.out.println("num of persons:" + resultList.size());
        for (Residence next : resultRe) 
        {
            System.out.println("next Residence: " + next);
        }
    }

}
