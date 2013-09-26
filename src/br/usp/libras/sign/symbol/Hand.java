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
    
    @Enumerated(EnumType.STRING)
    private Location location; // ponto de articulação

    @OneToOne(cascade=CascadeType.ALL)
    private Contact contact;
    
    
    private double yaw;
    private double pitch;
    private double roll;
    private boolean shakeYaw;

    //// construtores, getters & setters

    public Hand() {

    	// default values
        this.fingers = FingersMovement.NENHUM;
        // (orientation, plane, rotation, side) => o padrão é a "soletração" 
        this.orientation = HandOrientation.BLACK;
        this.plane = HandPlane.VERTICAL;
        this.rotation = HandRotation.ZERO;
        this.side = HandSide.RIGHT;
        this.location = Location.ESPACO_NEUTRO;
        yaw = 0;
        pitch = 0;
        roll = 0;
        shakeYaw = false;
        contact = new Contact();
    }

    public Hand(HandSide side, HandShape shape, HandOrientation orientation, HandPlane plane, FingersMovement fingers,
            HandMovement movement, Location location, Contact contact, double yaw, double pitch, double roll, boolean shakeYaw) {

        this.side = side;
        this.shape = shape;
        this.orientation = orientation;
        this.plane = plane;
        this.fingers = fingers;
        this.movement = movement;
        this.yaw = yaw;
        this.pitch = pitch;
        this.roll = roll;
        this.shakeYaw = shakeYaw;
        this.location = location;
        this.contact = contact;
    }
    
    public void invertMovement(){
        this.movement.invert();
        this.orientation = this.orientation.invert();
    }
    
    
    public Hand copy(){
        HandMovement movcopy = this.movement==null ? null:movement.copy();
        Hand copia = new Hand(side,shape,orientation,plane,fingers,movcopy,location,contact,yaw, pitch, roll, shakeYaw);
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
    
	public double getYaw() {
		return yaw;
	}

	public double getPitch() {
		return pitch;
	}

	public double getRoll() {
		return roll;
	}

	public boolean isShakeYaw() {
		return shakeYaw;
	}

    public Location getLocation() {
		return location;
	}

	public Contact getContact() {
		return contact;
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
    
	public void setYaw(double yaw) {
		this.yaw = yaw;
	}

	public void setPitch(double pitch) {
		this.pitch = pitch;
	}

	public void setRoll(double roll) {
		this.roll = roll;
	}

	public void setShakeYaw(boolean shakeYaw) {
		this.shakeYaw = shakeYaw;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((fingers == null) ? 0 : fingers.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((movement == null) ? 0 : movement.hashCode());
		result = prime * result
				+ ((orientation == null) ? 0 : orientation.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pitch);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((plane == null) ? 0 : plane.hashCode());
		temp = Double.doubleToLongBits(roll);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((rotation == null) ? 0 : rotation.hashCode());
		result = prime * result + (shakeYaw ? 1231 : 1237);
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		temp = Double.doubleToLongBits(yaw);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (fingers != other.fingers)
			return false;
		if (location != other.location)
			return false;
		if (movement == null) {
			if (other.movement != null)
				return false;
		} else if (!movement.equals(other.movement))
			return false;
		if (orientation != other.orientation)
			return false;
		if (Double.doubleToLongBits(pitch) != Double
				.doubleToLongBits(other.pitch))
			return false;
		if (plane != other.plane)
			return false;
		if (Double.doubleToLongBits(roll) != Double
				.doubleToLongBits(other.roll))
			return false;
		if (rotation != other.rotation)
			return false;
		if (shakeYaw != other.shakeYaw)
			return false;
		if (shape != other.shape)
			return false;
		if (side != other.side)
			return false;
		if (Double.doubleToLongBits(yaw) != Double.doubleToLongBits(other.yaw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hand [id=" + id + ", shape=" + shape + ", orientation="
				+ orientation + ", rotation=" + rotation + ", plane=" + plane
				+ ", fingers=" + fingers + ", movement=" + movement + ", side="
				+ side + ", location=" + location + ", contact=" + contact
				+ ", yaw=" + yaw + ", pitch=" + pitch + ", roll=" + roll
				+ ", shakeYaw=" + shakeYaw + "]";
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
