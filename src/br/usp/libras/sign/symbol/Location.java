package br.usp.libras.sign.symbol;

/**
 * Indica a locação do sinal
 * Se handsInUnity = true // atributo da classe Sign
 *    ambas as mãos se localizam próxima à localização
 * se não
 *    apenas a mão dominante vai para a localização, enquanto que a outra permanece em espaço neutro
 * Descrição em QUADROS, R.M. Língua de Sinais Brasileira - Estudos Linguísticos pg. 56-59
 * 
 * @author leonardo
 *
 */
public enum Location {
    
    ESPACO_NEUTRO(LocationGroup.ESPACO_NEUTRO, "Espaço Neutro"), 
    ESPACO_NEUTRO_DIREITO(LocationGroup.ESPACO_NEUTRO, "Espaço Neutro Direito"), 
    ESPACO_NEUTRO_ESQUERDO(LocationGroup.ESPACO_NEUTRO, "Espaço Neutro Esquerdo"),
    ESPACO_NEUTRO_ACIMA(LocationGroup.ESPACO_NEUTRO, "Àcima do Espaço Neutro"), 
    ESPACO_NEUTRO_ABAIXO(LocationGroup.ESPACO_NEUTRO, "Abaixo do Espaço Neutro"),
    ESPACO_NEUTRO_A_FRENTE(LocationGroup.ESPACO_NEUTRO, "À frente do Espaço Neutro"), 
    ESPACO_NEUTRO_ATRAS(LocationGroup.ESPACO_NEUTRO, "Atrás do Espaço Neutro"),
	
    TESTA(LocationGroup.CABECA, "Centro da testa"), 
    TESTA_DIREITA(LocationGroup.CABECA, "Parte direita da testa"), 
    TESTA_ESQUERDA(LocationGroup.CABECA, "Parte esquerda da testa"),
    TESTA_A_FRENTE(LocationGroup.CABECA, "À frente da testa"), 
    ROSTO_SUPERIOR(LocationGroup.CABECA, "Parte superior do rosto"), 
    ROSTO_INFERIOR(LocationGroup.CABECA, "Parte inferior do rosto"), 
    ORELHA(LocationGroup.CABECA, "Orelha"),
	OLHOS(LocationGroup.CABECA, "Olhos"), 
	OLHOS_A_DIREITA(LocationGroup.CABECA, "À direita dos olhos"),
	OLHOS_A_ESQUERDA(LocationGroup.CABECA, "À esquerda dos olhos"),
    OLHOS_ABAIXO(LocationGroup.CABECA, "Abaixo dos olhos"),
    OLHOS_ACIMA(LocationGroup.CABECA, "Acimas dos olhos"),
    OLHOS_A_FRENTE(LocationGroup.CABECA, "À frente dos olhos"),
    NARIZ(LocationGroup.CABECA, "Nariz"), 
    BOCA(LocationGroup.CABECA, "Boca"), 
	BOCHECHAS(LocationGroup.CABECA, "Bochechas"), 
    TOPO_DA_CABECA(LocationGroup.CABECA, "Topo da Cabeça"), 
    ROSTO(LocationGroup.CABECA, "Centro do rosto"),
	QUEIXO(LocationGroup.CABECA, "Centro do queixo"), 
    QUEIXO_DIREITO(LocationGroup.CABECA, "Parte direita do queixo"), 
    QUEIXO_ESQUERDO(LocationGroup.CABECA, "Parte esquerda do queixo"),
	
	PESCOCO(LocationGroup.TRONCO, "Pescoço"), 
	PESCOCO_A_FRENTE(LocationGroup.TRONCO, "À frente do pescoço"),
    OMBRO(LocationGroup.TRONCO, "Centro do ombro"), 
    OMBRO_DIREITO(LocationGroup.TRONCO, "Parte direita do ombro"),
	OMBRO_ESQUERDO(LocationGroup.TRONCO, "Parte esquerda do ombro"), 
    BUSTO(LocationGroup.TRONCO, "Busto"), 
    BUSTO_DIREITO(LocationGroup.TRONCO, "Parte direita do busto"),
	BUSTO_ESQUERDO(LocationGroup.TRONCO, "Parte esquerda do busto"), 
    BUSTO_A_FRENTE(LocationGroup.TRONCO, "À frente do busto"),
    BUSTO_ATRAS(LocationGroup.TRONCO, "Atrás do busto"),
	ESTOMAGO(LocationGroup.TRONCO, "Estômago"), 
    CINTURA(LocationGroup.TRONCO, "Cintura"), 
	BRACO(LocationGroup.TRONCO, "Braço"), 
    ANTEBRACO(LocationGroup.TRONCO, "Antebraço"), 
    COTOVELO(LocationGroup.TRONCO, "Cotovelo"), 
	PULSO(LocationGroup.TRONCO, "Pulso"), 
    QUADRIL(LocationGroup.TRONCO, "Quadril"),
	
	PALMA(LocationGroup.MAO, "Palma da mão"), 
    COSTAS_DA_MAO(LocationGroup.MAO, "Costas da mão"), 
    LADO_DEDO_INDICADOR(LocationGroup.MAO, "Lateral da mão (lado dedo indicador)"),
	LADO_DEDO_MINIMO(LocationGroup.MAO, "Lateral da mão (lado dedo mínimo)"), 
    DEDOS(LocationGroup.MAO, "Região dos dedos da mão"), 
    PONTA_DOS_DEDOS(LocationGroup.MAO, "Ponta dos dedos da mão"),
	DEDO_MINIMO(LocationGroup.MAO, "Dedo mínimo"), 
    ANULAR(LocationGroup.MAO, "Dedo anular"), 
    DEDO_MEDIO(LocationGroup.MAO, "Dedo médio"), 
	INDICADOR(LocationGroup.MAO, "Dedo indicador"), 
    POLEGAR(LocationGroup.MAO, "Dedo polegar");
		
	private final LocationGroup group;
	private String string;
	
	private Location(LocationGroup group, String string) {
		
		this.group = group;
		this.string = string;
	}
	
	public LocationGroup locationGroup() {
		return this.group;
	}
	
	public String getString() {
		return this.string;
	}
	
}
