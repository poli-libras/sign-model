package br.usp.libras.xml;

import java.io.FileReader;
import java.io.Reader;

import br.usp.libras.sign.Sign;

public class XMLParserTest {

	private static final String INPUT_XML_FILE = "resources/test/bola.xml";

    public static void main(String[] args) throws Exception {
		
		// This is not an automated test!
		
		Reader reader = new FileReader(INPUT_XML_FILE);
		Sign sign = XMLParser.parseXML(reader).get(0);
		
		System.out.println("Object read from " + INPUT_XML_FILE + ":");
		System.out.println(sign.toString());
	}
}
