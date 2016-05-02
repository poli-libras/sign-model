package br.usp.libras.sign.movement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.InheritanceType;


/**
 * Classe que modela o movimento direcional de uma mão dentro de um sinal Descrição de suas enumerações em QUADROS, R.M.
 * Língua de Sinais Brasileira - Estudos Linguísticos pg. 56
 * 
 * @author leonardo
 * 
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="handmovementtype",
    discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue("HandMovement")
public class HandMovement implements Serializable, Cloneable {

	private static final long serialVersionUID = 120206039218764315L;
	
    @Id
    @GeneratedValue
    protected Long id;
    
    @Enumerated(EnumType.STRING)
    protected Speed speed;
    
    @Enumerated(EnumType.STRING)
    protected Frequency frequency;

    @Enumerated(EnumType.STRING)
    protected MovementLocationAt locationAt;
    
    @Enumerated(EnumType.STRING)
    protected MovementType type;
    
    protected boolean startsInLocation;
    
    @OneToMany(cascade={CascadeType.ALL})
    @OrderBy(value="sequence")
    protected List<Segment> segments = new ArrayList<Segment>();
    
    @Enumerated(EnumType.STRING)
    protected InterpolationType interpolation;
    
    public Long getId() {
        return id;
    }
    
    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public MovementLocationAt getLocationAt() {
        return locationAt;
    }

    public void setLocationAt(MovementLocationAt locationAt) {
        this.locationAt = locationAt;
    }
    
	public boolean isStartsInLocation() {
        return startsInLocation;
    }

    public void setStartsInLocation(boolean startsInLocation) {
        this.startsInLocation = startsInLocation;
    }
    
	public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }
    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }
    
    public void invert(){
        //must invert segments order and also each segment
        ArrayList<Segment> listainversa = new ArrayList<Segment>();
        while(this.segments.size()>0)
            listainversa.add(this.segments.remove(this.segments.size()-1));
        this.segments=listainversa;
        
        
        for(Segment seg:this.segments)
            seg.invert();
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result
				+ ((interpolation == null) ? 0 : interpolation.hashCode());
		result = prime * result
				+ ((locationAt == null) ? 0 : locationAt.hashCode());
		result = prime * result
				+ ((segments == null) ? 0 : segments.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		HandMovement other = (HandMovement) obj;
		if (frequency != other.frequency)
			return false;
		if (interpolation != other.interpolation)
			return false;
		if (locationAt != other.locationAt)
			return false;
		if (segments == null) {
			if (other.segments != null)
				return false;
		} else if (!segments.equals(other.segments))
			return false;
		if (speed != other.speed)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "HandMovement [id=" + id + ", speed=" + speed + ", frequency="
				+ frequency + ", locationAt=" + locationAt + ", segments="
				+ segments + ", type=" + type +", interpolation=" + interpolation + "]";
	}

	@Override
    public HandMovement clone() {
		try {
			HandMovement mov = (HandMovement) super.clone();
			
			if (this.segments != null) {
				mov.segments = new ArrayList<Segment>();
				for (Segment seg: this.segments)
					mov.segments.add(seg.clone());
			}
			
			return mov;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
	}
	
	protected void copyHandMovementAttributes (HandMovement copia)
	{
        copia.speed=this.speed;
        copia.frequency=this.frequency;
        copia.locationAt=this.locationAt;
        copia.segments=new ArrayList<Segment>();
        copia.type=this.type;
        copia.interpolation=this.interpolation;
        for(Segment seg:this.segments)
            copia.segments.add(seg.clone());
	}
	
	protected void addSegmentToHandMovement (Segment segment, Direction direction)
	{
        segment.setDirection(direction);        
        segment.setSequence(this.segments.size());
        this.segments.add(segment);
	}
	
	public void addSegment(Direction direction) {
	}
    
    public HandMovement copy() {
		return null;
	}
}
