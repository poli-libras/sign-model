package br.usp.libras.sign;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import br.usp.libras.sign.symbol.Symbol;

@Entity
public class Sign implements Serializable, Cloneable {

	private static final long serialVersionUID = -1463417736334778557L;

	@Id
    @GeneratedValue
    private Long id;

    private String name;

    private Date inserted;

    @ManyToMany(cascade={CascadeType.ALL})
    private Set<Word> words = new HashSet<Word>(); 

    @ManyToMany(cascade={CascadeType.ALL})
    private Set<Literal> literals = new HashSet<Literal>(); 
    
    @ManyToMany(cascade={CascadeType.ALL})
    private Set<Inherence> inherences = new HashSet<Inherence>();

    @OneToMany(cascade={CascadeType.ALL})
    @OrderBy(value="sequence")
    private List<Symbol> symbols = new ArrayList<Symbol>();
    
    @Enumerated(EnumType.STRING)
    private VerbType verbType;

    public Sign() {
    	
    	// default values
    	this.inserted = new Date(); // today
    	this.verbType = VerbType.NAO_VERBO;
    }
    
    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInserted() {
        return inserted;
    }

    public void setInserted(Date inserted) {
        this.inserted = inserted;
    }

    public Set<Literal> getLiterals() {
        return literals;
    }

    public void setLiterals(Set<Literal> literals) {
        this.literals = literals;
    }

    public Set<Inherence> getInherences() {
        return inherences;
    }

    public void setInherences(Set<Inherence> inherences) {
        this.inherences = inherences;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }
    
    public void addLiteral(String s) {
        Literal lit = new Literal();
        lit.setLiteral(s);
        this.literals.add(lit);
    }

    public void addInherence(String s) {
        Inherence inh = new Inherence();
        inh.setInherence(s);
        this.inherences.add(inh);
    }

    public void addSymbol(Symbol symbol) {
        this.symbols.add(symbol);
    }

    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> words) {
        this.words = words;
    }    

    public void addWord(String s) {
        Word w = new Word();
        w.setWord(s);
        this.words.add(w);
    }
    

    public VerbType getVerbType() {
        return verbType;
    }

    public void setVerbType(VerbType verbType) {
        this.verbType = verbType;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((inherences == null) ? 0 : inherences.hashCode());
		result = prime * result
				+ ((inserted == null) ? 0 : inserted.hashCode());
		result = prime * result
				+ ((literals == null) ? 0 : literals.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((symbols == null) ? 0 : symbols.hashCode());
		result = prime * result
				+ ((verbType == null) ? 0 : verbType.hashCode());
		result = prime * result + ((words == null) ? 0 : words.hashCode());
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
		Sign other = (Sign) obj;
		if (inherences == null) {
			if (other.inherences != null)
				return false;
		} else if (!inherences.equals(other.inherences))
			return false;
		if (inserted == null) {
			if (other.inserted != null)
				return false;
		} else if (!inserted.equals(other.inserted))
			return false;
		if (literals == null) {
			if (other.literals != null)
				return false;
		} else if (!literals.equals(other.literals))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (symbols == null) {
			if (other.symbols != null)
				return false;
		} else if (!symbols.equals(other.symbols))
			return false;
		if (verbType == null) {
			if (other.verbType != null)
				return false;
		} else if (!verbType.equals(other.verbType))
			return false;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}

    @Override
	public String toString() {
		return "Sign [id=" + id + ", inherences=" + inherences + ", inserted="
				+ inserted + ", literals=" + literals + ", name=" + name
				+ ", symbols=" + symbols + ", verbType=" + verbType
				+ ", words=" + words + "]";
	}

	@Override
    public Sign clone() {
    	
    	try {
			
    		Sign s = (Sign) super.clone();

    		if (this.inserted != null)
    			s.inserted = new Date(s.inserted.getTime());

    		if (this.words != null) {
				s.words = new HashSet<Word>();
				for (Word w: this.words)
					s.words.add(w.clone());
    		}

    		if (this.literals != null) {
				s.literals = new HashSet<Literal>();
				for (Literal l: this.literals)
					s.literals.add(l.clone());
    		}

    		if (this.inherences != null) { 
				s.inherences = new HashSet<Inherence>();
				for (Inherence in: this.inherences)
					s.inherences.add(in.clone());
    		}

    		if (this.symbols != null) {
				s.symbols = new ArrayList<Symbol>();
				for (Symbol sym: this.symbols)
					s.symbols.add(sym.clone());
    		}
    		
			return s;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }
}
