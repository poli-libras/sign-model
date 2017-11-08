package br.usp.libras.sign.transition;

// TODO documentar com figura
/**
 * Sentido (horário vs anti-horário) é do ponto de vista do emissor.
 * XY é o plano da tela.
 * Oz é perpendicular à tela.
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

}
