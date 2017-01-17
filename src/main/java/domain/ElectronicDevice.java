package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice 
{
	
	private long id;
	
	private String nom;	
	private float conso;
	private Residence residence;
		
	public ElectronicDevice()
	{
		
	}

	public ElectronicDevice(String nom, float conso) 
	{
		this.nom = nom;
		this.conso = conso;
	}

	@Id
	@GeneratedValue
	//@Column(name="idElectro")
	public long getId() 
	{
		return id;
	}

	public void setId(long id)
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

	public float getConso() 
	{
		return conso;
	}

	public void setConso(float conso) 
	{
		this.conso = conso;
	}

	
	
	@ManyToOne
	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

	@Override
	public String toString() 
	{
		return "ElectronicDevice [id=" + id + ", nom=" + nom + ", conso=" + conso + "]";
	}
	  
	
	
	
	
	
	
	

}
