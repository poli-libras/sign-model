package br.usp.libras.sign;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Word implements Serializable, Cloneable {

	private static final long serialVersionUID = -824270922968519957L;

	@Id
    @GeneratedValue
    private Long id;

    private String word;
    
    public Word() {
        
    }

    public Word(Long id, String word) {
        super();
        this.id = id;
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Word [id=" + id + ", word=" + word + "]";
    }

    @Override
    public Word clone() {
    	
    	try {
			return (Word) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }
}
