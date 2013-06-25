package br.usp.libras.sign.symbol;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.usp.libras.sign.face.Face;

/**
 * Classe que modela os sinais (de uma língua de sinais) No caso de sinais compostos, cada um dos "sub-sinais" é um
 * objeto desta classe Modelagem baseada em: SUTTON V., Lições sobre o SignWrite; tradução de STUMPF M. (vulgo apostila
 * de Signwriting) QUADROS, R.M.; KARNOPP, L.B. Língua de Sinais Brasileira - Estudos Linguísticos (pg. 56-59)
 * 
 * @author leonardo
 * 
 */
@Entity
public class Symbol implements Serializable, Cloneable {

	private static final long serialVersionUID = -479227135055391469L;

	@Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    private Face face;

    @OneToOne(cascade=CascadeType.ALL)
    private Hand rightHand; // seta preta 

    @OneToOne(cascade=CascadeType.ALL)
    private Hand leftHand; // seta branca

    @Enumerated(EnumType.STRING)
    private Location location; // ponto de articulação

    @Enumerated(EnumType.STRING)
    private Contact contact;
    
    private int contactQuantity;

    private boolean handsInUnity; // as duas mãos fazem o mesmo movimento juntas
    							  // implica que leftRight.movment == null
    
    @Enumerated(EnumType.STRING)
    private HandSide handOver;

    private int sequence; // TODO: deveria ser transient ou XMLTransient?
    

    public Symbol() {

    	// default values
    	this.location = Location.ESPACO_NEUTRO;
    	this.contact = Contact.NENHUM;
    	this.contactQuantity = 0;
    }

    public Symbol(Face face, Hand leftHand, Hand rightHand, 
            Location location, Contact contact, 
            int contatcQuantity, boolean handsInUnity, HandSide handOver) {

        this.face = face;
        this.rightHand = rightHand;
        this.leftHand = leftHand;
        this.location = location;
        this.handsInUnity = handsInUnity;
        this.contactQuantity = contatcQuantity;
        this.handOver = handOver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public Hand getRightHand() {
        return rightHand;
    }

    public void setRightHand(Hand rightHand) {
        this.rightHand = rightHand;
    }

    public Hand getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Hand leftHand) {
        this.leftHand = leftHand;
    }

    /**
     * {@code handsInUnity} says the two hands will be united in make the same movement.
     * 
     * This imply if {@code handsInUnity == true}, so {@code leftHand.movement == null}
     * to avoid inconsistencies 
     * 
     * @return {@code handsInUnity} property
     */
    public boolean isHandsInUnity() {
        return handsInUnity;
    }

    public void setHandsInUnity(boolean handsInUnity) {
        this.handsInUnity = handsInUnity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    
    public int getContactQuantity() {
		return contactQuantity;
	}

	public void setContactQuantity(int contactQuantity) {
		this.contactQuantity = contactQuantity;
	}
		
	public HandSide getHandOver() {
		return handOver;
	}

	public void setHandOver(HandSide handOver) {
		this.handOver = handOver;
	}

	/**
	 * Doesn't consider {@code id} and {@code sequence}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + contactQuantity;
		result = prime * result + ((face == null) ? 0 : face.hashCode());
		result = prime * result
				+ ((handOver == null) ? 0 : handOver.hashCode());
		result = prime * result + (handsInUnity ? 1231 : 1237);
		result = prime * result
				+ ((leftHand == null) ? 0 : leftHand.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result
				+ ((rightHand == null) ? 0 : rightHand.hashCode());
		return result;
	}

	/**
	 * Doesn't consider {@code id} and {@code sequence}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Symbol other = (Symbol) obj;
		if (contact != other.contact)
			return false;
		if (contactQuantity != other.contactQuantity)
			return false;
		if (face == null) {
			if (other.face != null)
				return false;
		} else if (!face.equals(other.face))
			return false;
		if (handOver != other.handOver)
			return false;
		if (handsInUnity != other.handsInUnity)
			return false;
		if (leftHand == null) {
			if (other.leftHand != null)
				return false;
		} else if (!leftHand.equals(other.leftHand))
			return false;
		if (location != other.location)
			return false;
		if (rightHand == null) {
			if (other.rightHand != null)
				return false;
		} else if (!rightHand.equals(other.rightHand))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Symbol [id=" + id + ", face=" + face + ", rightHand="
				+ rightHand + ", leftHand=" + leftHand + ", location="
				+ location + ", contact=" + contact + ", contactQuantity="
				+ contactQuantity + ", handsInUnity=" + handsInUnity
				+ ", handOver=" + handOver + ", sequence=" + sequence + "]";
	}

	@Override
    public Symbol clone() {
    	
    	try {
			Symbol s = (Symbol) super.clone();
			if (this.face != null)
				s.face = this.face.clone();
			if (this.rightHand != null)
				s.rightHand = this.rightHand.clone();
			if (this.leftHand != null)
				s.leftHand = this.leftHand.clone();
			return s;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }

}
