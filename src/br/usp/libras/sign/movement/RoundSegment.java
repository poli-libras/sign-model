package br.usp.libras.sign.movement;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class RoundSegment extends Segment implements Serializable, Cloneable {

	private static final long serialVersionUID = -1414095797333799279L;

	private RoundPlane plane;
	private RoundLength length;
	
	public RoundSegment() {
		super();
	}
	
	public RoundPlane getPlane() {
		return plane;
	}
	
	public void setPlane(RoundPlane plane) {
		this.plane = plane;
	}
	
	public RoundLength getLength() {
		return length;
	}
	
	public void setLength(RoundLength length) {
		this.length = length;
	}
	
    /**
     * Only the directions {@code HORARIO_PARA_DENTRO}, {@code HORARIO_PARA_FORA},
     * {@code ANTI_HORÁRIO_PARA_DENTRO} and {@code ANTI_HORARIO_PARA_FORA}
     * are allowed
     * 
     * @param direction
     */
	@Override
    public void setDirection(Direction direction) {
        
    	switch (direction) {
	    	case HORARIO_PARA_FORA:
	    	case HORÁRIO_PARA_DENTRO:
	    	case ANTI_HORARIO_PARA_FORA:
	    	case ANTI_HORÁRIO_PARA_DENTRO:
	    		break;
    		default:
	    		throw new IllegalArgumentException();
    	}
    	
    	super.direction = direction;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((plane == null) ? 0 : plane.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoundSegment other = (RoundSegment) obj;
		if (length != other.length)
			return false;
		if (plane != other.plane)
			return false;
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "RoundSegment [plane=" + plane + ", length=" + length
				+ ", direction=" + direction + ", magnitude=" + magnitude + "]";
	}
	
}
