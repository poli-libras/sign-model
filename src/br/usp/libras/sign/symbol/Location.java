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
    
        ESPACO_NEUTRO(LocationGroup.ESPACO_NEUTRO),
	
	TOPO_DA_CABECA(LocationGroup.CABECA), TESTA(LocationGroup.CABECA), ROSTO(LocationGroup.CABECA),
	ROSTO_SUPERIOR(LocationGroup.CABECA), ROSTO_INFERIOR(LocationGroup.CABECA), ORELHA(LocationGroup.CABECA),
	OLHOS(LocationGroup.CABECA), NARIZ(LocationGroup.CABECA), BOCA(LocationGroup.CABECA), 
	BOCHECHAS(LocationGroup.CABECA), QUEIXO(LocationGroup.CABECA),
	
	PESCOCO(LocationGroup.TRONCO), OMBRO(LocationGroup.TRONCO), BUSTO(LocationGroup.TRONCO),
	ESTOMAGO(LocationGroup.TRONCO), CINTURA(LocationGroup.TRONCO), BRACOS(LocationGroup.TRONCO),
	ANTEBRACO(LocationGroup.TRONCO), COTOVELO(LocationGroup.TRONCO), PULSO(LocationGroup.TRONCO),
	
	PALMA(LocationGroup.MAO), COSTAS_DA_MAO(LocationGroup.MAO), LADO_INDICADOR(LocationGroup.MAO),
	LADO_DEDO_MINIMO(LocationGroup.MAO), DEDOS(LocationGroup.MAO), PONTA_DOS_DEDOS(LocationGroup.MAO),
	DEDO_MINIMO(LocationGroup.MAO), ANULAR(LocationGroup.MAO), DEDO_MEDIO(LocationGroup.MAO), 
	INDICADOR(LocationGroup.MAO), POLEGAR(LocationGroup.MAO);
		
	private final LocationGroup group;
	
	private Location(LocationGroup group) {
		
		this.group = group;
	}
	
	public LocationGroup locationGroup() {
		return this.group;
	}
	

}