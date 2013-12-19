package br.usp.libras.sign.symbol;

/**
 * Orientação da palma da mão Descrição na apostila de Signwriting, pg 21 e 22
 * (rotação no eixo paralelo aos dedos esticados)
 * 
 * @author leonardo
 * 
 */
public enum HandOrientation {

    WHITE("Palma para o emissor", 0), // palma da mão voltada para o emissor
    HALF("Palma de lado", Math.PI/2), // palma virada pela metade
    BLACK("Palma contra o emissor", Math.PI); // palma da mão voltada para o receptor

    private String string;
    private double angule;

    private HandOrientation(String string, double angule) {
        this.string = string;
        this.angule = angule;
    }

    @Override
    public String toString() {
        return this.string;
    }

    public String getString() {
        return this.string;
    }

	public double getAngule() {
		return angule;
	}
	
}
