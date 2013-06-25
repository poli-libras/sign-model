package br.usp.libras.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.usp.libras.sign.Sign;
import br.usp.libras.sign.SignGenerator;

public class XMLWriterTest {

	// This is not an automated test!
	public static void main(String[] args) {

		SignGenerator gen = new SignGenerator();
		Sign sign1 = gen.getRandomSign();
		
		List<Sign> signs = new ArrayList<Sign>();
		signs.add(sign1);
		
		try {
			Writer writer = new FileWriter("resources/test/bola.xml");
			XMLWriter.writeXML(signs, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		System.out.println("XML Generated");
	}
}
