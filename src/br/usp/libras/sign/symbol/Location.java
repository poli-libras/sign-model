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
    
    ESPACO_NEUTRO(LocationGroup.ESPACO_NEUTRO, "Espaço Neutro", "espaco_neutro"), ESPACO_NEUTRO_DIREITO(LocationGroup.ESPACO_NEUTRO, "Espaço Neutro Direito", "espaco_neutro_direito"), ESPACO_NEUTRO_ESQUERDO(LocationGroup.ESPACO_NEUTRO, "Espaço Neutro Esquerdo", "espaco_neutro_esquerdo"),
	
    TESTA(LocationGroup.CABECA, "Centro da testa", "testa"), TESTA_DIREITA(LocationGroup.CABECA, "Parte direita da testa", "testa_direita"), TESTA_ESQUERDA(LocationGroup.CABECA, "Parte esquerda da testa", "testa_esquerda"),
	ROSTO_SUPERIOR(LocationGroup.CABECA, "Parte superior do rosto", "rosto_superior"), ROSTO_INFERIOR(LocationGroup.CABECA, "Parte inferior do rosto", "rosto_inferior"), ORELHA(LocationGroup.CABECA, "Orelha", "orelha"),
	OLHOS(LocationGroup.CABECA, "Olhos", "olhos"), NARIZ(LocationGroup.CABECA, "Nariz", "nariz"), BOCA(LocationGroup.CABECA, "Boca", "boca"), 
	BOCHECHAS(LocationGroup.CABECA, "Bochechas", "bochechas"), TOPO_DA_CABECA(LocationGroup.CABECA, "Topo da Cabeça", "topo_da_cabeca"), ROSTO(LocationGroup.CABECA, "Centro do rosto", "rosto"),
	QUEIXO(LocationGroup.CABECA, "Centro do queixo", "queixo"), QUEIXO_DIREITO(LocationGroup.CABECA, "Parte direita do queixo", "queixo_direito"), QUEIXO_ESQUERDO(LocationGroup.CABECA, "Parte esquerda do queixo", "queixo_esquerdo"),
	
	PESCOCO(LocationGroup.TRONCO, "Pescoço", "pescoco"), OMBRO(LocationGroup.TRONCO, "Centro do ombro", "ombro"), OMBRO_DIREITO(LocationGroup.TRONCO, "Parte direita do ombro", "ombro_direito"),
	OMBRO_ESQUERDO(LocationGroup.TRONCO, "Parte esquerda do ombro", "ombro_esquerdo"), BUSTO(LocationGroup.TRONCO, "Busto", "busto"), BUSTO_DIREITO(LocationGroup.TRONCO, "Parte direita do busto", "busto_direito"),
	BUSTO_ESQUERDO(LocationGroup.TRONCO, "Parte esquerda do busto", "busto_esquerdo"), ESTOMAGO(LocationGroup.TRONCO, "Estômago", "estomago"), CINTURA(LocationGroup.TRONCO, "Cintura", "cintura"), 
	BRACO(LocationGroup.TRONCO, "Braço", "braco"), ANTEBRACO(LocationGroup.TRONCO, "Antebraço", "antebraco"), COTOVELO(LocationGroup.TRONCO, "Cotovelo", "cotovelo"), 
	PULSO(LocationGroup.TRONCO, "Pulso", "pulso"), QUADRIL(LocationGroup.TRONCO, "Quadril", "quadril"),
	
	PALMA(LocationGroup.MAO, "Palma da mão", "palma"), COSTAS_DA_MAO(LocationGroup.MAO, "Costas da mão", "costas_da_mao"), LADO_DEDO_INDICADOR(LocationGroup.MAO, "Lateral da mão (lado dedo indicador)", "lado_dedo_indicador"),
	LADO_DEDO_MINIMO(LocationGroup.MAO, "Lateral da mão (lado dedo mínimo)", "lado_dedo_minimo"), DEDOS(LocationGroup.MAO, "Região dos dedos da mão", "dedos"), PONTA_DOS_DEDOS(LocationGroup.MAO, "Ponta dos dedos da mão", "ponta_dos_dedos"),
	DEDO_MINIMO(LocationGroup.MAO, "Dedo mínimo", "dedo_minimo"), ANULAR(LocationGroup.MAO, "Dedo anular", "dedo_anular"), DEDO_MEDIO(LocationGroup.MAO, "Dedo médio", "dedo_medio"), 
	INDICADOR(LocationGroup.MAO, "Dedo indicador", "dedo_indicador"), POLEGAR(LocationGroup.MAO, "Dedo polegar", "dedo_polegar");
		
	private final LocationGroup group;
	private String string;
	private String filename;
	
	private Location(LocationGroup group, String string, String filename) {
		
		this.group = group;
		this.string = string;
		this.filename = filename;
	}
	
	public LocationGroup locationGroup() {
		return this.group;
	}
	
	public String getString() {
		return this.string;
	}
	
	public String getFilename() {
		return filename;
	}
}
