package br.usp.libras.sign.movement;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("StraightHandMovement")
public class StraightHandMovement extends HandMovement {

	private static final long serialVersionUID = 4002990094833486084L;
	
	@Enumerated(EnumType.STRING)
    private MovementType type;

    public StraightHandMovement() {

    	// default values
    	this.type = MovementType.RETILINIO;
    	this.speed = Speed.NORMAL;
    	this.frequency = Frequency.SIMPLES;
    	this.locationAt = MovementLocationAt.INICIO;
    	this.interpolation = InterpolationType.NORMAL;
    }

    public StraightHandMovement(MovementType type, Direction direction, Speed speed, 
    		Frequency frequency, MovementLocationAt locationAt, InterpolationType interpolation) {

        this.type = type;
        this.addSegment(direction);
        this.speed = speed;
        this.frequency = frequency;
        this.locationAt = locationAt;
        this.interpolation = interpolation;
    }
    
    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		StraightHandMovement other = (StraightHandMovement) obj;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StraightHandMovement [type=" + type + "]";
	}

	@Override
	public void addSegment(Direction direction) {
		Segment segment = new Segment();
		addSegmentToHandMovement(segment, direction);
	}
	
    @Override
    public HandMovement copy(){
    	StraightHandMovement copia = new StraightHandMovement();
        copia.type=this.type;
        copyHandMovementAttributes(copia);
        return copia;
    }
    
    
}
