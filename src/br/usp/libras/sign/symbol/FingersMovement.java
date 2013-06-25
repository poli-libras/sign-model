package br.usp.libras.sign.symbol;

/**
 * Possibilidades de movimentos dos dedos
 * Descritos em termos do movimento das articulações dos dedos
 * Descrição na apostila de Signwriting, pg 108
 * 
 * @author leonardo
 *
 */
public enum FingersMovement {

	    //   |
		//   |          1 - articulação média
		//  1|
		//   |_____     2 - articulação proximal
		//  2| | | |
	    //   |     |
	    //   |_____|
	    //
	
        NENHUM("Nenhum"),
        MEDIA_FECHA("Média fecha"), MEDIA_ABRE("Média abre"), 
        PROXIMAL_FECHA("Proximal fecha"), PROXIMAL_ABRE("Proximal abre"),
        PROXIMAIS_ABREM_E_FECHAM_JUNTAS("Proximais abrem e fecham juntas"), 
        SE_ESFREGAM("Se esfregam"), OSCILAM("Oscilam"); // Proximais abrem e fecham alternadamente
        
        private String string;
        
        private FingersMovement(String string) {
            
            this.string = string;
        }
        
        public String toString() {
            
            return this.string;
        }

        public String getString() {
            
            return this.toString();
        }
}
