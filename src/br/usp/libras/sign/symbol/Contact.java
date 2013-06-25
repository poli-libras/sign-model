package br.usp.libras.sign.symbol;

/**
 * Possibilidades de tipos de contados
 * Descrição na apostila de Signwriting, pg 99
 * 
 * @author leonardo
 *
 */
public enum Contact {

        NENHUM("Nenhum"), 
        CONTATO("Contato"), // * 
        PEGAR("Pegar"), // + (agarrar)
        ENTRE("Entre"), // |*|
        BATER("Bater"), // #
        ESCOVAR("Escovar"), // passar de raspão (um ponto preto dentro de um círculo)
        ESFREGAR("Esfregar"); // @
        
        private String string;
        
        private Contact(String string) {
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
