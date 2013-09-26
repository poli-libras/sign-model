package br.usp.libras.xml;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import br.usp.libras.sign.Sign;
import br.usp.libras.sign.SignGenerator;
import br.usp.libras.sign.Word;
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
import br.usp.libras.sign.movement.InterpolationType;
import br.usp.libras.sign.movement.MovementLocationAt;
import br.usp.libras.sign.movement.MovementType;
import br.usp.libras.sign.movement.Speed;
import br.usp.libras.sign.movement.StraightHandMovement;
import br.usp.libras.sign.symbol.Contact;
import br.usp.libras.sign.symbol.Hand;
import br.usp.libras.sign.symbol.HandOrientation;
import br.usp.libras.sign.symbol.HandPlane;
import br.usp.libras.sign.symbol.HandRotation;
import br.usp.libras.sign.symbol.HandShape;
import br.usp.libras.sign.symbol.HandSide;
import br.usp.libras.sign.symbol.Symbol;

/**
 * Teste de Writer + Parser
 * 
 * @author Marcelo Li Koga
 * 
 */
public class XMLWriterParserTest {

    private static final String FILENAME = "resources/test/teste.xml";

    @Test
    public void simpleTest() throws JAXBException, IOException {

        Sign sign = new Sign();
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

        StraightHandMovement movement = new StraightHandMovement(MovementType.RETILINIO, Direction.PARA_BAIXO, Speed.NORMAL,
                Frequency.SIMPLES,  MovementLocationAt.INICIO, InterpolationType.NORMAL);
        movement.addSegment(Direction.PARA_DIREITA);
        rightHand.setMovement(movement);

        Face face = new Face(20l, Chin.NADA, Eyebrow.NADA, Eyes.BEM_ABERTOS, Forehead.FRANZIDA, Gaze.NADA, Mounth.NADA,
                Nose.NADA, Teeth.NADA, Tongue.NADA, Others.EXPRESSAO_RADIANTE);

        List<Symbol> symbols = new ArrayList<Symbol>();
        Symbol symbol = new Symbol();
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
        symbol2.setSequence(1);
        symbol2.setRightHand(rightHand2);
        symbols.add(symbol2);

        sign.setSymbols(symbols);

        List<Sign> signs = new ArrayList<Sign>();
        signs.add(sign);

        File file = new File(FILENAME);
        if (file.exists()) {
            file.delete();
        }
        XMLWriter.writeXMLFile(signs, FILENAME);
        
        Sign generatedSign = XMLParser.parseXMLFile(FILENAME).get(0);
        
        assertEquals(sign.getName(), generatedSign.getName());

        assertEquals(sign.getWords().size(), generatedSign.getWords().size());
//        words.add(new Word(1l, "bola"));
//        words.add(new Word(2l, "pelota"));

        assertEquals(sign.getSymbols().size(), generatedSign.getSymbols().size());
        
        Symbol genSymbol1 = sign.getSymbols().get(0);
        Hand genLeftHand = genSymbol1.getLeftHand();
        assertEquals(leftHand.getOrientation(), genLeftHand.getOrientation());
        assertEquals(leftHand.getPlane(), genLeftHand.getPlane());
        assertEquals(leftHand.getRotation(), genLeftHand.getRotation());
        assertEquals(leftHand.getShape(), genLeftHand.getShape());
        assertEquals(leftHand.getSide(), genLeftHand.getSide());
        assertNull(leftHand.getMovement());

        Hand genRightHand = genSymbol1.getRightHand();
        
        assertEquals(rightHand.getOrientation(), genRightHand.getOrientation());
        assertEquals(rightHand.getPlane(), genRightHand.getPlane());
        assertEquals(rightHand.getRotation(), genRightHand.getRotation());
        assertEquals(rightHand.getShape(), genRightHand.getShape());
        assertEquals(rightHand.getSide(), genRightHand.getSide());
        
        StraightHandMovement genMovement = (StraightHandMovement) genRightHand.getMovement();
        assertNotNull(genMovement);
        assertEquals(movement.getFrequency(), genMovement.getFrequency());
        assertEquals(movement.getSpeed(), genMovement.getSpeed());
        assertEquals(movement.getType(), genMovement.getType());
        assertEquals(movement.getSegments(), genMovement.getSegments());
        
        Face genFace = genSymbol1.getFace();
        
        assertNotNull(genFace);
        assertEquals(face.getChin(), genFace.getChin());
        assertEquals(face.getEyes(), genFace.getEyes());
        assertEquals(face.getOthers(), genFace.getOthers());

        assertEquals(symbol.getRightHand().getContact(), genSymbol1.getRightHand().getContact());
        assertEquals(symbol.getRightHand().getLocation(), genSymbol1.getRightHand().getLocation());
        
        Symbol genSymbol2 = sign.getSymbols().get(1);
        assertEquals(symbol2.getRightHand().getContact(), genSymbol2.getRightHand().getContact());
        assertEquals(symbol2.getRightHand().getLocation(), genSymbol2.getRightHand().getLocation());
        
        Hand genRightHand2 = genSymbol2.getRightHand();
        
        assertEquals(rightHand2.getOrientation(), genRightHand2.getOrientation());
        assertEquals(rightHand2.getPlane(), genRightHand2.getPlane());
        assertEquals(rightHand2.getRotation(), genRightHand2.getRotation());
        assertEquals(rightHand2.getShape(), genRightHand2.getShape());
        assertEquals(rightHand2.getSide(), genRightHand2.getSide());
        assertNull(genRightHand2.getMovement());
        
        assertNull(genSymbol2.getLeftHand());
    }
    
    @Test
    public void twoSigns() throws JAXBException, IOException {
    	
    	SignGenerator gen = new SignGenerator();
    	List<Sign> signs = new ArrayList<Sign>();
    	signs.add(gen.getRandomSign());
    	signs.add(gen.getRandomSign());

        File file = new File(FILENAME);
        if (file.exists()) {
            file.delete();
        }
        XMLWriter.writeXMLFile(signs, FILENAME);
        List<Sign> retrieved = XMLParser.parseXMLFile(FILENAME);

        assertEquals(signs, retrieved);
    }

}
