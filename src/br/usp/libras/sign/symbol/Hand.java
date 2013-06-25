package br.usp.libras.sign.symbol;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.usp.libras.sign.movement.HandMovement;

/**
 * Classe que modela uma mão de um sinal
 * 
 * @author leonardo
 * 
 */
@Entity
public class Hand implements Serializable, Cloneable {

	private static final long serialVersionUID = 7151130393783076319L;

	@Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private HandShape shape;

    @Enumerated(EnumType.STRING)
    private HandOrientation orientation;

    @Enumerated(EnumType.STRING)
    private HandRotation rotation;

    @Enumerated(EnumType.STRING)
    private HandPlane plane;

    @Enumerated(EnumType.STRING)
    private FingersMovement fingers;

    @OneToOne(cascade=CascadeType.ALL)
    private HandMovement movement;

    @Enumerated(EnumType.STRING)
    private HandSide side;
    
    private boolean shake;

    //// construtores, getters & setters

    public Hand() {

    	// default values
        this.fingers = FingersMovement.NENHUM;
        // (orientation, plane, rotation, side) => o padrão é a "soletração" 
        this.orientation = HandOrientation.BLACK;
        this.plane = HandPlane.VERTICAL;
        this.rotation = HandRotation.ZERO;
        this.side = HandSide.RIGHT;
    }

    public Hand(HandSide side, HandShape shape, HandOrientation orientation, HandPlane plane, FingersMovement fingers,
            HandMovement movement, boolean shake) {

        this.side = side;
        this.shape = shape;
        this.orientation = orientation;
        this.plane = plane;
        this.fingers = fingers;
        this.movement = movement;
        this.shake = shake;
    }
    
    public void invertMovement(){
        this.movement.invert();
        this.orientation = this.orientation.invert();
    }
    
    
    public Hand copy(){
        HandMovement movcopy = this.movement==null ? null:movement.copy();
        Hand copia = new Hand(side,shape,orientation,plane,fingers,movcopy,shake);
        copia.side = copia.side.invert();
        return copia;
    }
    
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

    /**
     * It's used in signs like Ç and OUTUBRO
     * 
     * @return {@code shake} property
     */
    public boolean isShake() {
		return shake;
	}

	public void setShake(boolean shake) {
		this.shake = shake;
	}

	public HandShape getShape() {
        return shape;
    }

    public HandOrientation getOrientation() {
        return orientation;
    }
    
    public HandRotation getRotation() {
        return rotation;
    }    

    public HandPlane getPlane() {
        return plane;
    }

    public FingersMovement getFingers() {
        return fingers;
    }

    public HandMovement getMovement() {
        return movement;
    }

    public HandSide getSide() {
        return this.side;
    }

    public void setShape(HandShape handShape) {
        this.shape = handShape;
    }

    public void setOrientation(HandOrientation orientation) {
        this.orientation = orientation;
    }

    public void setRotation(HandRotation rotation) {
        this.rotation = rotation;
    }

    public void setPlane(HandPlane plane) {
        this.plane = plane;
    }

    public void setFingers(FingersMovement fingers) {
        this.fingers = fingers;
    }

    public void setMovement(HandMovement movement) {
        this.movement = movement;
    }

    public void setSide(HandSide side) {
        this.side = side;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fingers == null) ? 0 : fingers.hashCode());
		result = prime * result
				+ ((movement == null) ? 0 : movement.hashCode());
		result = prime * result
				+ ((orientation == null) ? 0 : orientation.hashCode());
		result = prime * result + ((plane == null) ? 0 : plane.hashCode());
		result = prime * result
				+ ((rotation == null) ? 0 : rotation.hashCode());
		result = prime * result + (shake ? 1231 : 1237);
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		result = prime * result + ((side == null) ? 0 : side.hashCode());
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
		Hand other = (Hand) obj;
		if (fingers != other.fingers)
			return false;
		if (movement == null) {
			if (other.movement != null)
				return false;
		} else if (!movement.equals(other.movement))
			return false;
		if (orientation != other.orientation)
			return false;
		if (plane != other.plane)
			return false;
		if (rotation != other.rotation)
			return false;
		if (shake != other.shake)
			return false;
		if (shape != other.shape)
			return false;
		if (side != other.side)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hand [id=" + id + ", shape=" + shape + ", orientation="
				+ orientation + ", rotation=" + rotation + ", plane=" + plane
				+ ", fingers=" + fingers + ", movement=" + movement + ", side="
				+ side + ", shake=" + shake + "]";
	}

	@Override
    public Hand clone() {
    	
    	try {
			Hand h = (Hand) super.clone();
			if (this.movement != null)
				h.movement = this.movement.clone();
			return h;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }

}
