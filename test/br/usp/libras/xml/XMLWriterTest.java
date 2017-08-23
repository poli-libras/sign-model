package br.usp.libras.xml;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import br.usp.libras.sign.Sign;
import br.usp.libras.sign.SignGenerator;

public class XMLWriterTest {

	private static final String OUPUT_XML_FILE = "resources/test/bola.xml";

    // This is not an automated test!
	public static void main(String[] args) throws Exception {

		SignGenerator gen = new SignGenerator();
		Sign sign1 = gen.getRandomSign();
		
		List<Sign> signs = new ArrayList<Sign>();
		signs.add(sign1);
		
		Writer writer = new FileWriter(OUPUT_XML_FILE);
		SignXMLWriter.writeXML(signs, writer);
		writer.close();
		
		System.out.println("XML generated in " + OUPUT_XML_FILE + ".");
	}
}
