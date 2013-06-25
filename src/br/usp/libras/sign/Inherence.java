package br.usp.libras.sign;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inherence implements Serializable, Cloneable {

	private static final long serialVersionUID = 7613264718546444188L;

	@Id
    @GeneratedValue
    private Long id;

    private String inherence;

    public Inherence() {
        
    }
    
    public Inherence(Long id, String inherence) {
        this.id = id;
        this.inherence = inherence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInherence() {
        return inherence;
    }

    public void setInherence(String inherence) {
        this.inherence = inherence;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((inherence == null) ? 0 : inherence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inherence other = (Inherence) obj;
		if (inherence == null) {
			if (other.inherence != null)
				return false;
		} else if (!inherence.equals(other.inherence))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Inherence [id=" + id + ", inherence=" + inherence + "]";
    }

    @Override
    public Inherence clone() {
    	
    	try {
			return (Inherence) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }
    
}
