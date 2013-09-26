package br.usp.libras.sign.movement;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CircularHandMovement")
public class CircularHandMovement extends HandMovement {

	private static final long serialVersionUID = -3175170767793197304L;

	public CircularHandMovement() {

    	// default values
    	this.speed = Speed.NORMAL;
    	this.frequency = Frequency.SIMPLES;
    	this.locationAt = MovementLocationAt.INICIO;
    	this.interpolation = InterpolationType.NORMAL;
    }

    public CircularHandMovement(Direction direction, Speed speed, 
    		Frequency frequency, MovementLocationAt locationAt, InterpolationType interpolation) {

        this.addSegment(direction);
        this.speed = speed;
        this.frequency = frequency;
        this.locationAt = locationAt;
        this.interpolation = interpolation;
    }
	
	@Override
	public void addSegment(Direction direction) {
		RoundSegment segment = new RoundSegment();
		addSegmentToHandMovement(segment, direction);
	}

	@Override
	public HandMovement copy() {
		CircularHandMovement copia = new CircularHandMovement();
        copyHandMovementAttributes(copia);
        return copia;
	}

}
