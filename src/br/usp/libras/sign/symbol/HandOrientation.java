package br.usp.libras.sign.symbol;

/**
 * Orientação da palma da mão Descrição na apostila de Signwriting, pg 21 e 22
 * (rotação no eixo paralelo aos dedos esticados)
 * 
 * @author leonardo
 * 
 */
public enum HandOrientation {

    WHITE("Palma para o emissor"), // palma da mão voltada para o emissor
    HALF("Palma de lado"), // palma virada pela metade
    BLACK("Palma contra o emissor"); // palma da mão voltada para o receptor

    private String string;

    private HandOrientation(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return this.string;
    }

    public String getString() {
        return this.string;
    }

    public HandOrientation invert() {
        switch(this) {
            case WHITE:
                return BLACK;
            case BLACK:
                return WHITE;
            default:
                return this;
        }
    }

}
