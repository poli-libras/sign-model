package br.usp.libras.sign.symbol;

/**
 * Configuração de mão (forma da mão)
 * Descrição na apostila de Signwriting, pg 40-90
 * 
 * @author leonardo
 *
 */
public enum HandShape {
                
        // Grupo 1: dedo indicador
        INDICADOR(ShapeGroup.GRUPO1, "Indicador"), FLEXIONADO1(ShapeGroup.GRUPO1, "Flexionado 1"),
        CURVADO_X(ShapeGroup.GRUPO1, "Curvado X"), MAO_D(ShapeGroup.GRUPO1, "Mão D"),
        
        // Grupo 2: dedo indicador
        MAO_2(ShapeGroup.GRUPO2, "Mão 2"), FLEXIONADO2(ShapeGroup.GRUPO2, "Flexionado 2"), 
        MAO_U(ShapeGroup.GRUPO2, "Mão U"), CURVADO_U(ShapeGroup.GRUPO2, "Curvado U"), 
        MAO_N(ShapeGroup.GRUPO2, "Mão N"), MAO_R(ShapeGroup.GRUPO2, "Mão R"),
        
        // Grupo 3: polegar, indicador, e dedos médios
        MAO_3(ShapeGroup.GRUPO3, "Mão 3"), FLEXIONADO3(ShapeGroup.GRUPO3, "Flexionado 3"), 
        _3DEDOS_O(ShapeGroup.GRUPO3, "3 dedos O"), U_COM_POLEGAR(ShapeGroup.GRUPO3, "U com polegar"), 
        MAO_PATO_ABERTA(ShapeGroup.GRUPO3, "Mão pato aberta"), MAO_K(ShapeGroup.GRUPO3, "Mão K"), 
        MAO_PATO_FECHADA(ShapeGroup.GRUPO3, "Mão pato fechada"),
        
        // Grupo 4: quatro dedos
        MAO_4(ShapeGroup.GRUPO4, "Mão 4"), MAO_B(ShapeGroup.GRUPO4, "Mão B"), 
        MAO_E(ShapeGroup.GRUPO4, "Mão E"),
        
        // Grupo 5, parte 1: mão plana
        MAO_5(ShapeGroup.GRUPO5_P1, "Mão 5"), CURVADOS(ShapeGroup.GRUPO5_P1, "Curvados"), 
        CURVADOS_COM_POLEGAR(ShapeGroup.GRUPO5_P1, "Curvados com polegar"), 
        MAO_5_COM_POLEGAR_PARA_FRENTE(ShapeGroup.GRUPO5_P1, "Mão 5 com polegar para frente"), 
        MAO_ESTICADA(ShapeGroup.GRUPO5_P1, "Mão esticada"), 
        MAO_ESTENDIDA_COM_POLEGAR(ShapeGroup.GRUPO5_P1, "Mão estendida com polegar"),
        
        // Grupo 5, parte 2: mão em ângulo , cinco dedos flexionados estendidos
        ANGULO_FECHADO(ShapeGroup.GRUPO5_P2, "Ângulo fechado"), 
        ANGULO_ABERTO(ShapeGroup.GRUPO5_P2, "Ângulo aberto"), 
        ANGULO_ABERTO_AFASTADO(ShapeGroup.GRUPO5_P2, "Ângulo aberto afastado"), 
        ANGULO_COM_POLEGAR(ShapeGroup.GRUPO5_P2, "Ângulo com polegar"), 
        ANGULO_SEM_POLEGAR(ShapeGroup.GRUPO5_P2, "Ângulo sem polegar"),
        
        // Grupo 5, parte 3: a mão C, cinco dedos flexionados ou curvados nas três articulações
        MAO_C(ShapeGroup.GRUPO5_P3, "Mão C"), C_AFASTADO(ShapeGroup.GRUPO5_P3, "C afastado"), 
        MAO_C_COM_POLEGAR_PARA_O_LADO(ShapeGroup.GRUPO5_P3, "Mão C com polegar para o lado"), 
        MAO_O(ShapeGroup.GRUPO5_P3, "Mão O"), O_CARACOL(ShapeGroup.GRUPO5_P3, "O caracol"), 
        O_CURVADO(ShapeGroup.GRUPO5_P3, "O curvado"),
        
        // Grupo 6: dedo mínimo
        MAO_W(ShapeGroup.GRUPO6, "Mão W"), MAO_3_6(ShapeGroup.GRUPO6, "Mão 3"), 
        MAO_TERCA(ShapeGroup.GRUPO6, "Mão terça"), MAO_3_PARA_FRENTE(ShapeGroup.GRUPO6, "Mão 3 para frente"), 
        MAO_I_AMANTE(ShapeGroup.GRUPO6, "Mão I amante"), MAO_I(ShapeGroup.GRUPO6, "Mão I"), 
        MAO_Y(ShapeGroup.GRUPO6, "Mão Y"), 
        MAO_I_LOVE_YOU(ShapeGroup.GRUPO6, "Mão I love you"), MAO_BANHEIRO(ShapeGroup.GRUPO6, "Mão banheiro"),
        
        // Grupo 7: dedo anelar
        MAO_DROGA(ShapeGroup.GRUPO7, "Mão droga"),
        
        // Grupo 8: dedo médio
        MAO_SO(ShapeGroup.GRUPO8, "Mão só"), MAO_DOENTE(ShapeGroup.GRUPO8, "Mão doente"), 
        MAO_JESUS(ShapeGroup.GRUPO8, "Mão jesus"), MAO_PROFISSAO(ShapeGroup.GRUPO8, "Mão profissão"),
        
        // Grupo 9, parte 1: polegar e indicador se tocam e outros dedos para cima
        MAO_CERTO(ShapeGroup.GRUPO9_P1, "Mão certo"), 
        MAO_CERTO_ABERTA(ShapeGroup.GRUPO9_P1, "Mão certo aberta"), 
        MAO_CERTO_RETA(ShapeGroup.GRUPO9_P1, "Mão certo reta"), 
        MAO_T(ShapeGroup.GRUPO9_P1, "Mão T"), MAO_F(ShapeGroup.GRUPO9_P1, "Mão F"), 
        
        // Grupo 9, parte 2: polegar e indicador afastados, outros dedos para baixo
        MAO_L(ShapeGroup.GRUPO9_P2, "Mão L"), MAO_G(ShapeGroup.GRUPO9_P2, "Mão G"), 
        MAO_REVOLVER(ShapeGroup.GRUPO9_P2, "Mão revólver"), 
        SEM_NOME(ShapeGroup.GRUPO9_P2, "Sem nome"), MAO_L_COM_O(ShapeGroup.GRUPO9_P2, "Mão L com O"), 
        MAO_L_COM_C(ShapeGroup.GRUPO9_P2, "Mão L com C"), 
        MAO_PASSARINHO_ABERTA(ShapeGroup.GRUPO9_P2, "Mão passarinho aberta"), 
        MAO_PASSARINHO_FECHADA(ShapeGroup.GRUPO9_P2, "Mão passarinho fechada"), 
        MAO_SETE(ShapeGroup.GRUPO9_P2, "Mão Sete"), 
        // tem uma configuração sem nome!
        
        // Grupo 10: polegar
        MAO_ONZE(ShapeGroup.GRUPO10, "Mão Onze"), 
        MAO_ONZE_APERTA(ShapeGroup.GRUPO10, "Mão Onze aberta"), 
        MAO_A(ShapeGroup.GRUPO10, "Mão A"), 
        MAO_S(ShapeGroup.GRUPO10, "Mão S"), MAO_FIGA(ShapeGroup.GRUPO10, "Mão Figa");
        
        private final ShapeGroup group;
        private final String string;
        
        private HandShape(ShapeGroup group, String string) {
                
                this.group = group;
                this.string = string;
        }
        
        public ShapeGroup handGroup() {
                return this.group;
        }
        
        @Override
        public String toString() {
                return this.string;
        }
        
        public String getString() {
                return this.string;
        }
}
