package br.usp.libras.sign.movement;

/**
 * Descrito em QUADROS, R.M. Língua de Sinais Brasileira - Estudos Linguísticos pg. 56
 * 
 * @author leonardo
 *
 */
public enum Direction {

    
        // plano vertical (hastes duplas)
        PARA_CIMA, PARA_BAIXO, DIAGONAL_PARA_CIMA_DIREITA, DIAGONAL_PARA_BAIXO_DIREITA, 
        DIAGONAL_PARA_CIMA_ESQUERDA, DIAGONAL_PARA_BAIXO_ESQUERDA,
        

        // plano horizontal (hastes simples)
        PARA_FRENTE, PARA_TRAS, DIAGONAL_PARA_FRENTE_DIREITA, DIAGONAL_PARA_TRAS_DIREITA,
        DIAGONAL_PARA_FRENTE_ESQUERDA, DIAGONAL_PARA_TRAS_ESQUERDA,
        
        // lados (horizontal = vertical, dá na mesma)
        PARA_DIREITA, PARA_ESQUERDA,
        
        // plano diagonal superior
        PARA_FRENTE_E_PARA_CIMA_NA_DIAGONAL, PARA_BAIXO_E_PARA_TRAS_NA_DIAGONAL,
        PARA_FRENTE_E_PARA_CIMA_DIREITA_NA_DIAGONAL, PARA_FRENTE_E_PARA_CIMA_ESQUERDA_NA_DIAGONAL,
        PARA_BAIXO_E_PARA_TRAS_DIREITA_NA_DIAGONAL, PARA_BAIXO_E_PARA_TRAS_ESQUERDA_NA_DIAGONAL,
        
        // Esses só valem para movimento tipo circular
        HORÁRIO_PARA_DENTRO, HORARIO_PARA_FORA,
        ANTI_HORÁRIO_PARA_DENTRO, ANTI_HORARIO_PARA_FORA;
        
        public Direction getInverse(){
            switch(this){
                
                case PARA_CIMA: return PARA_BAIXO;
                case PARA_BAIXO:return PARA_CIMA;
                
                /*DIAGONAL_PARA_CIMA_DIREITA
                DIAGONAL_PARA_BAIXO_DIREITA
                DIAGONAL_PARA_CIMA_ESQUERDA
                DIAGONAL_PARA_BAIXO_ESQUERDA
                */

                // plano horizontal (hastes simples)
                case PARA_FRENTE: return PARA_TRAS;
                case PARA_TRAS: return PARA_FRENTE;
//                DIAGONAL_PARA_FRENTE_DIREITA
//                DIAGONAL_PARA_TRAS_DIREITA
//                DIAGONAL_PARA_FRENTE_ESQUERDA
//                DIAGONAL_PARA_TRAS_ESQUERDA
                
                // lados (horizontal = vertical, dá na mesma)
                case PARA_DIREITA: return PARA_ESQUERDA;
                case PARA_ESQUERDA: return PARA_DIREITA;
                
                // plano diagonal superior
//                PARA_FRENTE_E_PARA_CIMA_NA_DIAGONAL
//                PARA_BAIXO_E_PARA_TRAS_NA_DIAGONAL
//                PARA_FRENTE_E_PARA_CIMA_DIREITA_NA_DIAGONAL
//                PARA_FRENTE_E_PARA_CIMA_ESQUERDA_NA_DIAGONAL
//                PARA_BAIXO_E_PARA_TRAS_DIREITA_NA_DIAGONAL
//                PARA_BAIXO_E_PARA_TRAS_ESQUERDA_NA_DIAGONAL
                
                // Esses só valem para movimento tipo circular
//                CIRCULAR_HORIZONTAL
//                CIRCULAR_VERTICAL;
                
                
                
                
            }            
            return this;
        }

}
