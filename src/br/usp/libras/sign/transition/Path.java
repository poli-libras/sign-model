package br.usp.libras.sign.transition;

// TODO documentar com figura
/**
 * XY é o plano da tela.
 * Oz é perpendicular à tela.
 * Sentido (horário vs anti-horário) é do ponto de vista do emissor.
 * Em XY: horário pro emissor é anti-horário pro receptor.
 * Em XZ: horário vs anti-horário é definido olhando-se de cima; 
 *        horário pro emissor é horário pro receptor também.
 * Em YZ: anti-horário = ponteiro "atacando ao meio-dia"
 *        ou seja, face do relógio está para a direita.;
 *        horário pro emissor é anti-horário pro receptor.
 */
public enum Path {

    LINEAR, 
    CIRCULAR_HORARIO_EM_XY, 
    CIRCULAR_ANTI_HORARIO_EM_XY, 
    CIRCULAR_HORARIO_EM_XZ, 
    CIRCULAR_ANTI_HORARIO_EM_XZ, 
    CIRCULAR_HORARIO_EM_YZ, 
    CIRCULAR_ANTI_HORARIO_EM_YZ;

    public boolean horario() {
        return this == CIRCULAR_HORARIO_EM_XY || this == Path.CIRCULAR_HORARIO_EM_XZ
                || this == Path.CIRCULAR_HORARIO_EM_YZ;
    }

    public boolean antiHorario() {
        return this == CIRCULAR_ANTI_HORARIO_EM_XY || this == Path.CIRCULAR_ANTI_HORARIO_EM_XZ
                || this == Path.CIRCULAR_ANTI_HORARIO_EM_YZ;
    }
    
    public boolean planoXY() {
        return this == CIRCULAR_HORARIO_EM_XY || this == CIRCULAR_ANTI_HORARIO_EM_XY;
    }
    
    public boolean planoXZ() {
        return this == CIRCULAR_HORARIO_EM_XZ || this == CIRCULAR_ANTI_HORARIO_EM_XZ;
    }

    public boolean planoYZ() {
        return this == CIRCULAR_HORARIO_EM_YZ || this == CIRCULAR_ANTI_HORARIO_EM_YZ;
    }
    
    public boolean isCircular() {
        return this == CIRCULAR_HORARIO_EM_XY || this == CIRCULAR_ANTI_HORARIO_EM_XY || 
                this == CIRCULAR_HORARIO_EM_XZ || this == CIRCULAR_ANTI_HORARIO_EM_XZ || 
                this == CIRCULAR_HORARIO_EM_YZ|| this ==CIRCULAR_ANTI_HORARIO_EM_YZ;
    }

}
