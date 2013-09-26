package br.usp.libras.sign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import br.usp.libras.sign.face.Face;
import br.usp.libras.sign.face.Others;
import br.usp.libras.sign.movement.Direction;
import br.usp.libras.sign.movement.Frequency;
import br.usp.libras.sign.movement.Magnitude;
import br.usp.libras.sign.movement.MovementLocationAt;
import br.usp.libras.sign.movement.MovementType;
import br.usp.libras.sign.movement.Segment;
import br.usp.libras.sign.movement.Speed;
import br.usp.libras.sign.movement.StraightHandMovement;
import br.usp.libras.sign.symbol.Contact;
import br.usp.libras.sign.symbol.Hand;
import br.usp.libras.sign.symbol.HandOrientation;
import br.usp.libras.sign.symbol.HandPlane;
import br.usp.libras.sign.symbol.HandRotation;
import br.usp.libras.sign.symbol.HandShape;
import br.usp.libras.sign.symbol.HandSide;
import br.usp.libras.sign.symbol.Location;
import br.usp.libras.sign.symbol.Symbol;

/**
 * Package class to provide sign instances in order to help with the tests
 * @author leonardo
 *
 */
public class SignGenerator {

	private Map<String, Sign> signs = new HashMap<String, Sign>();
	private AtomicInteger atomInt = new AtomicInteger(0);
	
	// inicializador
	{
		
		// sign 1

        Sign bola = new Sign();
        bola.setName("BOLA");

        Set<Word> words = new HashSet<Word>();
        words.add(new Word(1l, "bola"));
        words.add(new Word(2l, "pelota"));
        bola.setWords(words);

        Hand leftHand = new Hand();
        leftHand.setOrientation(HandOrientation.HALF);
        leftHand.setPlane(HandPlane.VERTICAL);
        leftHand.setRotation(HandRotation.ZERO);
        leftHand.setShape(HandShape.MAO_C);
        leftHand.setSide(HandSide.LEFT);

        Hand rightHand = new Hand();
        rightHand.setOrientation(HandOrientation.HALF);
        rightHand.setPlane(HandPlane.VERTICAL);
        rightHand.setRotation(HandRotation.ZERO);
        rightHand.setShape(HandShape.MAO_C);
        rightHand.setSide(HandSide.RIGHT);

        List<Symbol> symbols = new ArrayList<Symbol>();
        Symbol symbol = new Symbol();
        symbol.setSequence(0);
        symbol.setLeftHand(leftHand);
        symbol.setRightHand(rightHand);
        symbols.add(symbol);
        bola.setSymbols(symbols);		

        // sign 2
        
        Sign voce = new Sign();
        voce.setName("VOCÊ");

        words = new HashSet<Word>();
        words.add(new Word(1l, "você"));
        words.add(new Word(2l, "tu"));
        voce.setWords(words);

        Segment seg = new Segment();
        seg.setDirection(Direction.PARA_FRENTE);
        seg.setMagnitude(Magnitude.NORMAL);
        seg.setSequence(0);
        List<Segment> segs = new ArrayList<Segment>();
        segs.add(seg);
        
        StraightHandMovement mov = new StraightHandMovement();
        mov.setFrequency(Frequency.SIMPLES);
        mov.setSpeed(Speed.NORMAL);
        mov.setLocationAt(MovementLocationAt.INICIO);
        mov.setType(MovementType.RETILINIO);
        mov.setSegments(segs);
        
        rightHand = new Hand();
        rightHand.setOrientation(HandOrientation.BLACK);
        rightHand.setPlane(HandPlane.HORIZONTAL);
        rightHand.setRotation(HandRotation.ZERO);
        rightHand.setShape(HandShape.INDICADOR);
        rightHand.setSide(HandSide.RIGHT);

        symbols = new ArrayList<Symbol>();
        symbol = new Symbol();
        symbol.setSequence(0);
        symbol.setRightHand(rightHand);
        symbols.add(symbol);
        voce.setSymbols(symbols);	        
        
        // sign 3
        
        Sign feliz = new Sign();
        bola.setName("FELIZ");

        words = new HashSet<Word>();
        words.add(new Word(1l, "feliz"));
        feliz.setWords(words);

        Face face = new Face();
        face.setOthers(Others.EXPRESSAO_RADIANTE);
        
        symbols = new ArrayList<Symbol>();        
        symbol = new Symbol();
        symbol.setFace(face);
        symbols.add(symbol);
        
        feliz.setSymbols(symbols);
        
        // sign 4
        
        Sign futebol = new Sign();
        futebol.setName("FUTEBOL");
        
        words = new HashSet<Word>();
        words.add(new Word(1l, "futebol"));
        words.add(new Word(2l, "pelada"));
        futebol.setWords(words);        
        
        symbols = new ArrayList<Symbol>();        
        symbol = new Symbol();
        
        rightHand = new Hand();
        leftHand = new Hand();
        
        rightHand.setSide(HandSide.RIGHT);
        rightHand.setRotation(HandRotation.ZERO);
        rightHand.setOrientation(HandOrientation.HALF);
        rightHand.setShape(HandShape.MAO_ONZE);
        rightHand.setPlane(HandPlane.HORIZONTAL);
        
        mov = new StraightHandMovement();
        mov.setSpeed(Speed.RAPIDO);
        segs = new ArrayList<Segment>();
        Segment seg1 = new Segment();
        seg1.setDirection(Direction.PARA_BAIXO);
        Segment seg2 = new Segment();
        seg2.setDirection(Direction.PARA_CIMA);
        Segment seg3 = new Segment();
        seg3.setDirection(Direction.PARA_CIMA);
        Segment seg4 = new Segment();
        seg4.setDirection(Direction.PARA_BAIXO);
        segs.add(seg1);
        segs.add(seg2);
        segs.add(seg3);
        segs.add(seg4);
        
        mov.setSegments(segs);
        rightHand.setMovement(mov);

        leftHand.setSide(HandSide.LEFT);
        leftHand.setRotation(HandRotation.ZERO);
        leftHand.setOrientation(HandOrientation.HALF);
        leftHand.setShape(HandShape.MAO_ONZE);
        leftHand.setPlane(HandPlane.HORIZONTAL);

        mov = new StraightHandMovement();
        mov.setSpeed(Speed.RAPIDO);
        segs = new ArrayList<Segment>();
        seg1 = new Segment();
        seg1.setDirection(Direction.PARA_CIMA);
        seg2 = new Segment();
        seg2.setDirection(Direction.PARA_BAIXO);
        seg3 = new Segment();
        seg3.setDirection(Direction.PARA_BAIXO);
        seg4 = new Segment();
        seg4.setDirection(Direction.PARA_CIMA);
        segs.add(seg1);
        segs.add(seg2);
        segs.add(seg3);
        segs.add(seg4);        
        mov.setSegments(segs);
        leftHand.setMovement(mov);

        symbol.setRightHand(rightHand);
        symbol.setLeftHand(leftHand);
        symbols.add(symbol);
        futebol.setSymbols(symbols);
        
        // sign 5
        Sign olhar = new Sign();
        olhar.setName("OLHAR");

        words = new HashSet<Word>();
        words.add(new Word(1l, "olhar"));
        words.add(new Word(2l, "ver"));
        olhar.setWords(words);     
        
        symbols = new ArrayList<Symbol>();        
        symbol = new Symbol();

        rightHand = new Hand();
        rightHand.setSide(HandSide.RIGHT);
        rightHand.setShape(HandShape.MAO_2);
        rightHand.setOrientation(HandOrientation.BLACK);
        rightHand.setPlane(HandPlane.VERTICAL);
        rightHand.setLocation(Location.OLHOS);
        
        mov = new StraightHandMovement();
        segs = new ArrayList<Segment>();
        seg = new Segment();
        seg.setDirection(Direction.PARA_FRENTE);
        segs.add(seg);
        mov.setSegments(segs);
        
        rightHand.setMovement(mov);
        symbol.setRightHand(rightHand);
        olhar.setWords(words);
        symbols.add(symbol);
        olhar.setSymbols(symbols);
        
        this.signs.put("BOLA", bola);
        this.signs.put("VOCÊ", voce);
        this.signs.put("FELIZ", feliz);
        this.signs.put("FUTEBOL", futebol);
        this.signs.put("OLHAR", olhar);
	}
	
	
	/**
	 * This method assures that two successive invocations will return different signs
	 * @return sign from the internal list
	 */
	public Sign getRandomSign() {
		
		List<String> keys = new ArrayList<String>(signs.keySet());
		int i = atomInt.getAndIncrement();
		atomInt.weakCompareAndSet(keys.size(), 0); // count reset		
		return signs.get(keys.get(i));
	}
	
	/**
	 * Retrieved a sign by the name
	 * @param name
	 * @return
	 */
	public Sign getSign(String name) {
		
		return signs.get(name);
	}
	
}
