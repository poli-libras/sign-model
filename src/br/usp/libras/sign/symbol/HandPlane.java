package br.usp.libras.sign.symbol;

/**
 * Plano no qual se encontra a mão
 * Descrição na apostila de Signwriting
 * 
 * @author leonardo
 *
 */
public enum HandPlane {

	VERTICAL(0),	// sinal por inteiro no SignWrite
	HORIZONTAL (Math.PI/2); // sinal "cortado" no SignWrite
	
	private double angule;

	private HandPlane(double angule) {
		this.angule = angule;
	}

	public double getAngule() {
		return angule;
	}

}
