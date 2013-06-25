package br.usp.libras.xml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import javax.xml.bind.JAXBException;

import br.usp.libras.sign.Sign;
import br.usp.libras.xml.XMLParser;

public class XMLParserTest {

	public static void main(String[] args) {
		
		// This is not an automated test!
		
		Sign sign = null;
		try {
			Reader reader = new FileReader("resources/test/bola.xml");
			sign = XMLParser.parseXML(reader).get(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Writer writer = new FileWriter("resources/test/bola.txt");
			writer.write(sign.toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Object description generated");
	}
}
