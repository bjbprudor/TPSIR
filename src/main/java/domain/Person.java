package domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person 
{
	
    private Long id;

    private String nom;
    private String prenom;
    
    private Collection<Residence> residences ;
    private Collection<Person> amis;

    private Person person;
    
    public Person() 
    {
    	
    }

    public Person(String nom, String prenom, Collection<Residence> residences, Collection<Person> amis)
    {
		this.nom = nom;
		this.prenom = prenom;
		this.residences = residences;
		this.amis = amis;
    }

	@Id
    @GeneratedValue
    public Long getId() 
	{
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }
   
    public String getNom() 
    {
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public String getPrenom() 
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public Collection<Residence> getResidences() 
	{
		return residences;
	}

	public void setResidences(Collection<Residence> residences) 
	{
		this.residences = residences;
	}

	//@ManyToOne
	public Person getPerson() 
	{
		return person;
	}

	public void setPerson(Person person) 
	{
		this.person = person;
	}

	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public Collection<Person> getAmis()
	{
		return amis;
	}

	public void setAmis(Collection<Person> amis)
	{
		this.amis = amis;
	}

	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", residences=" + residences + "]";
	}

	
}
