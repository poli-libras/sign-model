package br.usp.libras.sign.symbol;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.usp.libras.sign.body.Body;
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
    private Body body;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Hand rightHand; // seta preta 

    @OneToOne(cascade=CascadeType.ALL)
    private Hand leftHand; // seta branca

    private int sequence; // TODO: deveria ser transient ou XMLTransient?
    

    public Symbol() {
    	
    }

    public Symbol(Face face, Hand leftHand, Hand rightHand) {

        this.face = face;
        this.rightHand = rightHand;
        this.leftHand = leftHand;
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
    
    public Hand getHand (HandSide side) {
    	if (side == HandSide.RIGHT)
    		return getRightHand();
    	else
    		return getLeftHand();
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((face == null) ? 0 : face.hashCode());
		result = prime * result
				+ ((leftHand == null) ? 0 : leftHand.hashCode());
		result = prime * result
				+ ((rightHand == null) ? 0 : rightHand.hashCode());
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
		Symbol other = (Symbol) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (face == null) {
			if (other.face != null)
				return false;
		} else if (!face.equals(other.face))
			return false;
		if (leftHand == null) {
			if (other.leftHand != null)
				return false;
		} else if (!leftHand.equals(other.leftHand))
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
		return "Symbol [id=" + id + ", face=" + face + ", body=" + body
				+ ", rightHand=" + rightHand + ", leftHand=" + leftHand
				+ ", sequence=" + sequence + "]";
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
