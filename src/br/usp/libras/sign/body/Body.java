package br.usp.libras.sign.body;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Classe que modela a expressão facial de línguas de sinais A descrição de suas enumerações está na apostila de
 * Signwriting, pg 165
 * 
 * @author leonardo
 * 
 */
@Entity
public class Body implements Serializable, Cloneable {

	private static final long serialVersionUID = 6565503743172684392L;

	@Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Shoulder shoulder;

    @Enumerated(EnumType.STRING)
    private Head head;
    
    public Body(){
        shoulder = Shoulder.NADA;
        head = Head.NADA;
    }

    public Body(Long id, Shoulder shoulder, Head head) {
        this.shoulder = shoulder;
        this.head = head;
    }

    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

	public Shoulder getShoulder() {
		return shoulder;
	}

	public void setShoulder(Shoulder shoulder) {
		this.shoulder = shoulder;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result
				+ ((shoulder == null) ? 0 : shoulder.hashCode());
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
		Body other = (Body) obj;
		if (head != other.head)
			return false;
		if (shoulder != other.shoulder)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Body [id=" + id + ", shoulder=" + shoulder + ", head=" + head
				+ "]";
	}
	
	@Override
    public Body clone() {
    	
    	try {
			return (Body) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }
}
