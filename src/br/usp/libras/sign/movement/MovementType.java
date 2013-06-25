package br.usp.libras.sign.movement;

/**
 * Descrito em QUADROS, R.M. Língua de Sinais Brasileira - Estudos Linguísticos pg. 56
 * Modificado de acordo com a conciliação dessa fonte com a apostila de \sw
 * 
 * @author leonardo
 *
 */
public enum MovementType {

        RETILINIO,     // ângulos retos entre os segmentos
        CURVO,         // "amacia" os ângulos entre os segmentos 
        HELICOIDAL,    // cada segmento é helicoidal
        SINUOSO,       // cada segmento é sinuoso
        CIRCULAR;      // usar apenas CIRCULAR_HORIZONTAL e CIRCULAR_VERTICAL nos segmentos
}
