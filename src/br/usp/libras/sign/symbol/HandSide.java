package br.usp.libras.sign.symbol;

/**
 * Diz se a mão é direita ou esquerda
 * 
 * @author leonardo
 *
 */
public enum HandSide {

	RIGHT("direita"), LEFT("esquerda");
	
	private String string;
	
	private HandSide (String string) {
		this.string = string;
	}
	
	public HandSide invert(){
	    if(this == RIGHT)return LEFT;
	    return RIGHT;
	}
	
	@Override
	public String toString() {
		return string;
	}
	
	public String getString() {
		return string;
	}
}
