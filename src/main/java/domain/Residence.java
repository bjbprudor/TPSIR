package domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Residence
{
	
    private Long id;

    private float taille;
    private int nbpiece;
    private Collection<Chauffage> chauffages ;
    private Collection<ElectronicDevice> devices ;
    
    private Person person;
    
    public Residence() 
    {
    	
    }

    public Residence(float taille, int nbpiece, Collection<Chauffage> chauffages, Collection<ElectronicDevice> devices)
    {
    	this.taille = taille;
    	this.nbpiece = nbpiece;
    	this.chauffages = chauffages;
    	this.devices = devices;
    }

	@Id
    @GeneratedValue
	@Column(name="idResidence")
    public Long getId() 
	{
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

	public float getTaille()
	{
		return taille;
	}

	public void setTaille(float taille) 
	{
		this.taille = taille;
	}

	public int getNbpiece() 
	{
		return nbpiece;
	}

	public void setNbpiece(int nbpiece) 
	{
		this.nbpiece = nbpiece;
	}

	@OneToMany(mappedBy = "residence", cascade = CascadeType.PERSIST)
	public Collection<Chauffage> getChauffages() 
	{
		return chauffages;
	}

	public void setChauffages(Collection<Chauffage> chauffages)
	{
		this.chauffages = chauffages;
	}

	@OneToMany(mappedBy = "residence", cascade = CascadeType.PERSIST)
	public Collection<ElectronicDevice> getDevices() 
	{
		return devices;
	}

	public void setDevices(Collection<ElectronicDevice> devices)
	{
		this.devices = devices;
	}

	@ManyToOne
	public Person getPerson() 
	{
		return person;
	}

	public void setPerson(Person person) 
	{
		this.person = person;
	}

	@Override
	public String toString() 
	{
		return "Residence [id=" + id + ", taille=" + taille + ", nbpiece=" + nbpiece + ", chauffages=" + chauffages
				+ ", devices=" + devices + "]";
	}

  


    
   
   
}
