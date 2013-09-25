package br.usp.libras.sign.symbol;

public enum ContactType {
	
	NENHUM("Nenhum"), 
    CONTATO("Contato"), // * 
    PEGAR("Pegar"), // + (agarrar)
    ENTRE("Entre"), // |*|
    BATER("Bater"), // #
    ESCOVAR("Escovar"), // passar de raspão (um ponto preto dentro de um círculo)
    ESFREGAR("Esfregar"); // @
	
	private String string;
    
    private ContactType(String string) {
        this.string = string;
    }
    
    @Override
    public String toString() {
        return this.string;
    }
    
    public String getString() {
        return this.toString();
    }
}
