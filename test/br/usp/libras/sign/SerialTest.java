package br.usp.libras.sign;


import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import br.usp.libras.sign.face.Chin;
import br.usp.libras.sign.face.Eyebrow;
import br.usp.libras.sign.face.Eyes;
import br.usp.libras.sign.face.Face;
import br.usp.libras.sign.face.Forehead;
import br.usp.libras.sign.face.Gaze;
import br.usp.libras.sign.face.Mounth;
import br.usp.libras.sign.face.Nose;
import br.usp.libras.sign.face.Others;
import br.usp.libras.sign.face.Teeth;
import br.usp.libras.sign.face.Tongue;
import br.usp.libras.sign.movement.Direction;
import br.usp.libras.sign.movement.Frequency;
import br.usp.libras.sign.movement.HandMovement;
import br.usp.libras.sign.movement.MovementLocationAt;
import br.usp.libras.sign.movement.MovementType;
import br.usp.libras.sign.movement.Speed;
import br.usp.libras.sign.symbol.Contact;
import br.usp.libras.sign.symbol.Hand;
import br.usp.libras.sign.symbol.HandOrientation;
import br.usp.libras.sign.symbol.HandPlane;
import br.usp.libras.sign.symbol.HandRotation;
import br.usp.libras.sign.symbol.HandShape;
import br.usp.libras.sign.symbol.HandSide;
import br.usp.libras.sign.symbol.Location;
import br.usp.libras.sign.symbol.Symbol;

public class SerialTest {

	private Sign sign;
	private Sign[] signs;
	
	@Before
	public void setUp() throws Exception {
		
		// gera um sinal para teste 1
		
        sign = new Sign();
        sign.setName("BOLA");

        Set<Word> words = new HashSet<Word>();
        words.add(new Word(1l, "bola"));
        words.add(new Word(2l, "pelota"));
        sign.setWords(words);

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

        HandMovement movement = new HandMovement(MovementType.RETILINIO, Direction.PARA_BAIXO, Speed.NORMAL,
                Frequency.SIMPLES, MovementLocationAt.INICIO, false);
        movement.addSegment(Direction.PARA_DIREITA);
        rightHand.setMovement(movement);

        Face face = new Face(20l, Chin.NADA, Eyebrow.NADA, Eyes.BEM_ABERTOS, Forehead.FRANZIDA, Gaze.NADA, Mounth.NADA,
                Nose.NADA, Teeth.NADA, Tongue.NADA, Others.EXPRESSAO_RADIANTE);

        List<Symbol> symbols = new ArrayList<Symbol>();
        Symbol symbol = new Symbol();
        symbol.setContact(Contact.NENHUM);
        symbol.setHandsInUnity(true);
        symbol.setLocation(Location.ESPACO_NEUTRO);
        symbol.setSequence(0);
        symbol.setLeftHand(leftHand);
        symbol.setRightHand(rightHand);
        symbol.setFace(face);
        symbols.add(symbol);

        Hand rightHand2 = new Hand();
        rightHand2.setOrientation(HandOrientation.BLACK);
        rightHand2.setPlane(HandPlane.VERTICAL);
        rightHand2.setRotation(HandRotation.ZERO);
        rightHand2.setShape(HandShape.MAO_C);
        rightHand2.setSide(HandSide.RIGHT);

        Symbol symbol2 = new Symbol();
        symbol2.setContact(Contact.NENHUM);
        symbol2.setLocation(Location.ESPACO_NEUTRO);
        symbol2.setSequence(1);
        symbol2.setRightHand(rightHand2);
        symbols.add(symbol2);

        sign.setSymbols(symbols);
        
        // gera lista de sinais para o segundo teste 
        
        SignGenerator gen = new SignGenerator();
        signs = new Sign[]{gen.getRandomSign(), gen.getRandomSign()};        
	}
	
	@Test
	public void serialTest() throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("resources/test/serial.txt");
		ObjectOutputStream objw = new ObjectOutputStream(fos);
		objw.writeObject(this.sign);
		objw.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("resources/test/serial.txt");
		ObjectInputStream objr = new ObjectInputStream(fis);
		Sign retrieved = (Sign) objr.readObject();
		objr.close();
		fis.close();
		
		assertTrue(sign.equals(retrieved));
	}
	
	@Test
	public void serialArrayTest() throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("resources/test/serialArray.txt");
		ObjectOutputStream objw = new ObjectOutputStream(fos);
		objw.writeObject(this.signs);
		objw.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("resources/test/serialArray.txt");
		ObjectInputStream objr = new ObjectInputStream(fis);
		Sign[] retrieved =	(Sign[]) objr.readObject();
		objr.close();
		fis.close();

		assertArrayEquals(signs, retrieved);
	}

}
