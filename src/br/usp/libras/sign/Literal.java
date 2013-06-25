package br.usp.libras.sign;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Literal implements Serializable, Cloneable {

	private static final long serialVersionUID = 8609891170777022808L;

	@Id
    @GeneratedValue
    private Long id;

    private String literal;

    public Literal() {
        
    }
    
    public Literal(Long id, String literal) {
        this.id = id;
        this.literal = literal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((literal == null) ? 0 : literal.hashCode());
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
		Literal other = (Literal) obj;
		if (literal == null) {
			if (other.literal != null)
				return false;
		} else if (!literal.equals(other.literal))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Literal [id=" + id + ", literal=" + literal + "]";
    }
    
    @Override
    public Literal clone() {
    	
    	try {
			return (Literal) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }    
}
