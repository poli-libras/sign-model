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
import br.usp.libras.sign.transition.Transition;

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
	private HandSide side;

	@Enumerated(EnumType.STRING)
    private HandShape shape;

    @Enumerated(EnumType.STRING)
    private FingersMovement fingers;

    @OneToOne(cascade=CascadeType.ALL)
    private HandMovement movement;
    
    @Enumerated(EnumType.STRING)
    private Location location; // ponto de articulação

    @OneToOne(cascade=CascadeType.ALL)
    private Contact contact;
    
    // raw, pitch, raw em radianos
    private double rotY; // antiga orientação
    private double rotX; // antigo plano 
    private double rotZ; // antiga rotação
    
    private boolean shakeYaw;
    
    private Transition transition = new Transition();

    //// construtores, getters & setters

    public Hand() {
    	// default values
        this.fingers = FingersMovement.NENHUM;
        // (orientation, plane, rotation, side) => o padrão é a "soletração" 
        this.side = HandSide.RIGHT;
        this.location = Location.ESPACO_NEUTRO;
        rotY = 0;
        rotX = 0;
        rotZ = 0;
        shakeYaw = false;
        contact = new Contact();
    }

    public Hand(HandSide side, HandShape shape, FingersMovement fingers,
            HandMovement movement, Location location, Contact contact, 
            double rotY, double rotX, double rotZ, boolean shakeYaw) {

        this.side = side;
        this.shape = shape;
        this.fingers = fingers;
        this.movement = movement;
        this.rotY = rotY;
        this.rotX = rotX;
        this.rotZ = rotZ;
        this.shakeYaw = shakeYaw;
        this.location = location;
        this.contact = contact;
    }
    
    public void invertMovement(){
        this.movement.invert();
        invertYaw();
    }

	private void invertYaw() {
		this.rotY = (( this.rotY + Math.PI ) % (2*Math.PI));
	}
    
    
    public Hand copy(){
        HandMovement movcopy = this.movement==null ? null:(HandMovement) movement.copy();
        Hand copia = new Hand(side,shape,fingers,movcopy,location,contact,rotY, rotX, rotZ, shakeYaw);
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

    public FingersMovement getFingers() {
        return fingers;
    }

    public HandMovement getMovement() {
        return movement;
    }

    public HandSide getSide() {
        return this.side;
    }
    
	public double getRotY() {
		return rotY;
	}

	public double getRotX() {
		return rotX;
	}

	public double getRotZ() {
		return rotZ;
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

    public void setFingers(FingersMovement fingers) {
        this.fingers = fingers;
    }

    public void setMovement(HandMovement movement) {
        this.movement = movement;
    }

    public void setSide(HandSide side) {
        this.side = side;
    }
    
	public void setRotY(double rotY) {
		this.rotY = rotY;
	}

	public void setRotX(double rotX) {
		this.rotX = rotX;
	}

	public void setRotZ(double rotZ) {
		this.rotZ = rotZ;
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
	
	
	
	public Transition getTransition() {
		return transition;
	}

	public void setTransition(Transition transition) {
		this.transition = transition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((fingers == null) ? 0 : fingers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((movement == null) ? 0 : movement.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rotX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rotY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rotZ);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (shakeYaw ? 1231 : 1237);
		result = prime * result + ((shape == null) ? 0 : shape.hashCode());
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((transition == null) ? 0 : transition.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (location != other.location)
			return false;
		if (movement == null) {
			if (other.movement != null)
				return false;
		} else if (!movement.equals(other.movement))
			return false;
		if (Double.doubleToLongBits(rotX) != Double.doubleToLongBits(other.rotX))
			return false;
		if (Double.doubleToLongBits(rotY) != Double.doubleToLongBits(other.rotY))
			return false;
		if (Double.doubleToLongBits(rotZ) != Double.doubleToLongBits(other.rotZ))
			return false;
		if (shakeYaw != other.shakeYaw)
			return false;
		if (shape != other.shape)
			return false;
		if (side != other.side)
			return false;
		if (transition == null) {
			if (other.transition != null)
				return false;
		} else if (!transition.equals(other.transition))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [id=");
		builder.append(id);
		builder.append(", side=");
		builder.append(side);
		builder.append(", shape=");
		builder.append(shape);
		builder.append(", fingers=");
		builder.append(fingers);
		builder.append(", movement=");
		builder.append(movement);
		builder.append(", location=");
		builder.append(location);
		builder.append(", contact=");
		builder.append(contact);
		builder.append(", rotY=");
		builder.append(rotY);
		builder.append(", rotX=");
		builder.append(rotX);
		builder.append(", rotZ=");
		builder.append(rotZ);
		builder.append(", shakeYaw=");
		builder.append(shakeYaw);
		builder.append(", transition=");
		builder.append(transition);
		builder.append("]");
		return builder.toString();
	}

	@Override
    public Hand clone() {
    	try {
			Hand h = (Hand) super.clone();
			if (this.movement != null)
				h.movement = (HandMovement) this.movement.clone();
			return h;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }
	
}
