package br.usp.libras.sign.symbol;

/**
 * Diz se a mão é direita ou esquerda
 * 
 * @author leonardo
 *
 */
public enum HandSide {

	RIGHT, 	LEFT;
	
	public HandSide invert(){
	    if(this == RIGHT)return LEFT;
	    return RIGHT;
	}
}
