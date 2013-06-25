package br.usp.libras.sign;

public enum VerbType {
    
    NAO_VERBO("Não é verbo"), NAO_FLEXIONA("Não flexiona"), 
    CONCORDA_COM_SUJEITO_E_OBJETO("Concorda com o sujeito e com o objeto"),
    FLEXIONA_COM_LOCALIZACAO("Flexiona com a localização");
    
    private String string;
    
    private VerbType (String string) {
        this.string = string;
    }

    public String toString() {
        return this.string;
    }
    
    public String getString() {
        return this.toString();
    }
}
