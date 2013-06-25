package br.usp.libras.sign.movement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


/**
 * Classe que modela o movimento direcional de uma mão dentro de um sinal Descrição de suas enumerações em QUADROS, R.M.
 * Língua de Sinais Brasileira - Estudos Linguísticos pg. 56
 * 
 * @author leonardo
 * 
 */
@Entity
public class HandMovement implements Serializable, Cloneable {

	private static final long serialVersionUID = 120206039218764315L;
	
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private MovementType type;
    
    @OneToMany(cascade={CascadeType.ALL})
    @OrderBy(value="sequence")
    private List<Segment> segments = new ArrayList<Segment>();
    
    @Enumerated(EnumType.STRING)
    private Speed speed;
    
    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Enumerated(EnumType.STRING)
    private MovementLocationAt locationAt;
    
    private boolean strength;
    
    public HandMovement() {

    	// default values
    	this.type = MovementType.RETILINIO;
    	this.speed = Speed.NORMAL;
    	this.frequency = Frequency.SIMPLES;
    	this.locationAt = MovementLocationAt.INICIO;
    }

    public HandMovement(MovementType type, Direction direction, Speed speed, 
    		Frequency frequency, MovementLocationAt locationAt, boolean strength) {

        this.type = type;
        this.addSegment(direction);
        this.speed = speed;
        this.frequency = frequency;
        this.locationAt = locationAt;
        this.strength = strength;
    }
    
    public HandMovement copy(){
        HandMovement copia = new HandMovement();
        copia.type=this.type;
        copia.speed=this.speed;
        copia.frequency=this.frequency;
        copia.locationAt=this.locationAt;
        copia.segments=new ArrayList<Segment>();
        copia.strength=this.strength;
        for(Segment seg:this.segments)
            copia.segments.add(seg.clone());
        
        return copia;
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
    
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    /**
     * It's used in signs like PODE
     * @return {@strength} property
     */
    public boolean isStrength() {
		return strength;
	}

	public void setStrength(boolean strength) {
		this.strength = strength;
	}

	public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
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

    public void addSegment(Direction direction) {
        Segment segment = new Segment();
        segment.setDirection(direction);        
        segment.setSequence(this.segments.size());
        this.segments.add(segment);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result
				+ ((locationAt == null) ? 0 : locationAt.hashCode());
		result = prime * result
				+ ((segments == null) ? 0 : segments.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		result = prime * result + (strength ? 1231 : 1237);
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
		if (locationAt != other.locationAt)
			return false;
		if (segments == null) {
			if (other.segments != null)
				return false;
		} else if (!segments.equals(other.segments))
			return false;
		if (speed != other.speed)
			return false;
		if (strength != other.strength)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HandMovement [id=" + id + ", type=" + type + ", segments="
				+ segments + ", speed=" + speed + ", frequency=" + frequency
				+ ", locationAt=" + locationAt + ", strength="
				+ strength + "]";
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

}
