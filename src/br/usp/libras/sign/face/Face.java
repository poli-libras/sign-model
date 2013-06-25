package br.usp.libras.sign.face;

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
public class Face implements Serializable, Cloneable {

	private static final long serialVersionUID = 7536496737697636863L;

	@Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Chin chin;

    @Enumerated(EnumType.STRING)
    private Eyebrow eyebrow;

    @Enumerated(EnumType.STRING)
    private Eyes eyes;

    @Enumerated(EnumType.STRING)
    private Forehead forehead;

    @Enumerated(EnumType.STRING)
    private Gaze gaze;

    @Enumerated(EnumType.STRING)
    private Mounth mounth;

    @Enumerated(EnumType.STRING)
    private Nose nose;

    @Enumerated(EnumType.STRING)
    private Teeth teeth;

    @Enumerated(EnumType.STRING)
    private Tongue tongue;

    @Enumerated(EnumType.STRING)
    private Others others;
    
    public Face(){
        
    }

    public Face(Long id, Chin chin, Eyebrow eyebrow, Eyes eyes, Forehead forehead, Gaze gaze, Mounth mounth, Nose nose,
            Teeth teeth, Tongue tongue, Others others) {
        this.id = id;
        this.chin = chin;
        this.eyebrow = eyebrow;
        this.eyes = eyes;
        this.forehead = forehead;
        this.gaze = gaze;
        this.mounth = mounth;
        this.nose = nose;
        this.teeth = teeth;
        this.tongue = tongue;
        this.others = others;
    }

    public Long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

    public Chin getChin() {
        return chin;
    }

    public void setChin(Chin chin) {
        this.chin = chin;
    }

    public Eyebrow getEyebrow() {
        return eyebrow;
    }

    public void setEyebrow(Eyebrow eyebrow) {
        this.eyebrow = eyebrow;
    }

    public Eyes getEyes() {
        return eyes;
    }

    public void setEyes(Eyes eyes) {
        this.eyes = eyes;
    }

    public Forehead getForehead() {
        return forehead;
    }

    public void setForehead(Forehead forehead) {
        this.forehead = forehead;
    }

    public Gaze getGaze() {
        return gaze;
    }

    public void setGaze(Gaze gaze) {
        this.gaze = gaze;
    }

    public Mounth getMounth() {
        return mounth;
    }

    public void setMounth(Mounth mounth) {
        this.mounth = mounth;
    }

    public Nose getNose() {
        return nose;
    }

    public void setNose(Nose nose) {
        this.nose = nose;
    }

    public Teeth getTeeth() {
        return teeth;
    }

    public void setTeeth(Teeth teeth) {
        this.teeth = teeth;
    }

    public Tongue getTongue() {
        return tongue;
    }

    public void setTongue(Tongue tongue) {
        this.tongue = tongue;
    }

    public Others getOthers() {
        return others;
    }

    public void setOthers(Others others) {
        this.others = others;
    }
    
    /**
     * 
     * @return true se todos os atributos forem NADA
     */
    public boolean allIsNada() {
        
        if (chin == Chin.NADA && eyebrow == Eyebrow.NADA && eyes == Eyes.NADA
                && forehead == Forehead.NADA && gaze == Gaze.NADA && mounth == Mounth.NADA
                && nose == Nose.NADA && teeth == Teeth.NADA && tongue == Tongue.NADA
                && others == Others.NADA)
            return true;
        else
            return false;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chin == null) ? 0 : chin.hashCode());
		result = prime * result + ((eyebrow == null) ? 0 : eyebrow.hashCode());
		result = prime * result + ((eyes == null) ? 0 : eyes.hashCode());
		result = prime * result
				+ ((forehead == null) ? 0 : forehead.hashCode());
		result = prime * result + ((gaze == null) ? 0 : gaze.hashCode());
		result = prime * result + ((mounth == null) ? 0 : mounth.hashCode());
		result = prime * result + ((nose == null) ? 0 : nose.hashCode());
		result = prime * result + ((others == null) ? 0 : others.hashCode());
		result = prime * result + ((teeth == null) ? 0 : teeth.hashCode());
		result = prime * result + ((tongue == null) ? 0 : tongue.hashCode());
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
		Face other = (Face) obj;
		if (chin == null) {
			if (other.chin != null)
				return false;
		} else if (!chin.equals(other.chin))
			return false;
		if (eyebrow == null) {
			if (other.eyebrow != null)
				return false;
		} else if (!eyebrow.equals(other.eyebrow))
			return false;
		if (eyes == null) {
			if (other.eyes != null)
				return false;
		} else if (!eyes.equals(other.eyes))
			return false;
		if (forehead == null) {
			if (other.forehead != null)
				return false;
		} else if (!forehead.equals(other.forehead))
			return false;
		if (gaze == null) {
			if (other.gaze != null)
				return false;
		} else if (!gaze.equals(other.gaze))
			return false;
		if (mounth == null) {
			if (other.mounth != null)
				return false;
		} else if (!mounth.equals(other.mounth))
			return false;
		if (nose == null) {
			if (other.nose != null)
				return false;
		} else if (!nose.equals(other.nose))
			return false;
		if (others == null) {
			if (other.others != null)
				return false;
		} else if (!others.equals(other.others))
			return false;
		if (teeth == null) {
			if (other.teeth != null)
				return false;
		} else if (!teeth.equals(other.teeth))
			return false;
		if (tongue == null) {
			if (other.tongue != null)
				return false;
		} else if (!tongue.equals(other.tongue))
			return false;
		return true;
	}
    
    @Override
	public String toString() {
		return "Face [chin=" + chin + ", eyebrow=" + eyebrow + ", eyes=" + eyes
				+ ", forehead=" + forehead + ", gaze=" + gaze + ", id=" + id
				+ ", mounth=" + mounth + ", nose=" + nose + ", others="
				+ others + ", teeth=" + teeth + ", tongue=" + tongue + "]";
	}

	@Override
    public Face clone() {
    	
    	try {
			return (Face) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Should not happen");
		}
    }
    
}
