package br.usp.libras.sign.symbol;

/**
 * Rotação da mão no eixo perpendicular à palma
 * 
 */
public enum HandRotation {
    
    ZERO(0),
    RETO(Math.PI/2), 
    RASO(Math.PI),   
    INCLINADO_PARA_DENTRO(Math.PI/4), 
    INCLINADO_PARA_FORA(-Math.PI/4);   
    
    private double angule;

	private HandRotation(double angule) {
		this.angule = angule;
	}

	public double getAngule() {
		return angule;
	}
    
}
