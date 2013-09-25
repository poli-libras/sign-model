package br.usp.libras.sign.symbol;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Possibilidades de tipos de contados
 * Descrição na apostila de Signwriting, pg 99
 * 
 * @author leonardo
 *
 */
@Entity
public class Contact implements Serializable, Cloneable {

	private static final long serialVersionUID = 3831114644134525280L;

	@Id
    @GeneratedValue
    private Long id;
	
	@Enumerated(EnumType.STRING)
    private ContactType type;

    @Enumerated(EnumType.STRING)
    private Location location; // ponto de articulação
	
	private int quantity;

	public Contact() {
		type = ContactType.NENHUM;
		location = Location.ESPACO_NEUTRO;
		quantity = 0;
	}

	public Contact(ContactType type, Location location, int quantity) {
		this.type = type;
		this.location = location;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public ContactType getType() {
		return type;
	}

	public Location getLocation() {
		return location;
	}

	public int getQuantity() {
		return quantity;
	}

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

	public void setType(ContactType type) {
		this.type = type;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + quantity;
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
		Contact other = (Contact) obj;
		if (location != other.location)
			return false;
		if (quantity != other.quantity)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", type=" + type + ", location="
				+ location + ", quantity=" + quantity + "]";
	}
	
	
}
