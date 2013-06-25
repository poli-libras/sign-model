package br.usp.libras.sign.symbol;

/**
 * Classificação das configurações de mão
 * 
 * @author leonardo
 *
 */
public enum ShapeGroup {

        GRUPO1("Grupo 1"), GRUPO2("Grupo 2"), GRUPO3("Grupo 3"), GRUPO4("Grupo 4"), 
        GRUPO5_P1("Grupo 5-1"), GRUPO5_P2("Grupo 5-2"), GRUPO5_P3("Grupo 5-3"), 
        GRUPO6("Grupo 6"), GRUPO7("Grupo 7"), GRUPO8("Grupo 8"), 
        GRUPO9_P1("Grupo 9-1"), GRUPO9_P2("Grupo 9-2"), GRUPO10("Grupo 10");
        
        private String string;
        
        private ShapeGroup(String string) {
            this.string = string;
        }
        
        public String toString() {
            return string;
        }
        
        public String getString() {
            return string;
        }
}
