package br.usp.libras.sign.movement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Segment implements Serializable, Cloneable {
	
	private static final long serialVersionUID = -3526564305137423514L;
	
    @Id
    @GeneratedValue
    private Long id;
    
    private int sequence; // TODO: deveria ser transient ou XMLTransient?
    
    @Enumerated(EnumType.STRING)
    protected Direction direction;
    
    @Enumerated(EnumType.STRING)
    protected Magnitude magnitude;

    public Segment(){
 
    	// default value
    	this.magnitude = Magnitude.NORMAL;
    }
    
    public void invert(){
        this.direction = this.direction.getInverse();
    }
    
    public Long getId() {
        return id;
    }
    
    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * The directions {@code HORARIO_PARA_DENTRO}, {@code HORARIO_PARA_FORA},
     * {@code ANTI_HORÁRIO_PARA_DENTRO} and {@code ANTI_HORARIO_PARA_FORA}
     * are not allowed
     * 
     * @param direction
     */
    public void setDirection(Direction direction) {
        
    	switch (direction) {
	    	case HORARIO_PARA_FORA:
	    	case HORÁRIO_PARA_DENTRO:
	    	case ANTI_HORARIO_PARA_FORA:
	    	case ANTI_HORÁRIO_PARA_DENTRO:
	    		throw new IllegalArgumentException();
    	}
    	
    	this.direction = direction;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result
				+ ((magnitude == null) ? 0 : magnitude.hashCode());
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
		Segment other = (Segment) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (magnitude == null) {
			if (other.magnitude != null)
				return false;
		} else if (!magnitude.equals(other.magnitude))
			return false;
		return true;
	}
    
    @Override
	public String toString() {
		return "Segment [direction=" + direction + ", id=" + id
				+ ", magnitude=" + magnitude + ", sequence=" + sequence + "]";
	}

	@Override
    public Segment clone() {
    	
    	try {
			return (Segment) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }
    
}
