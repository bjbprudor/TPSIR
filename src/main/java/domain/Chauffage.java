package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Chauffage 
{
	
	private long id;
	
	private String reference;
	private String nom;
	private Residence residence;
		
	public Chauffage()
	{

	}
	
	public Chauffage(String reference, String nom) 
	{
		this.reference = reference;
		this.nom = nom;
	}
	
	@Id
	@GeneratedValue
	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getReference() 
	{
		return reference;
	}
	
	public void setReference(String reference) 
	{
		this.reference = reference;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	@ManyToOne
	public Residence getResidence() 
	{
		return residence;
	}

	public void setResidence(Residence residence) 
	{
		this.residence = residence;
	}

	@Override
	public String toString() 
	{
		return "Chauffage [id=" + id + ", reference=" + reference + ", nom=" + nom + "]";
	}
	
	
	
	
	
	
}
