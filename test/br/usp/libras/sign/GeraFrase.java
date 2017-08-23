package br.usp.libras.sign;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.usp.libras.xml.SignXMLWriter;

/**
 * Gera a frase "VOCÊ OLHA FUTEBOL" em XML.
 * 
 * @author leonardo
 *
 */
class GeraFrase {

	public static void main(String[] args) {

		SignGenerator gen = new SignGenerator();
		List<Sign> frase = new ArrayList<Sign>();
		frase.add(gen.getSign("VOCÊ"));
		frase.add(gen.getSign("OLHAR"));
		frase.add(gen.getSign("FUTEBOL"));
		
		for (Sign s: frase)
			System.out.println(s);
		
		// gera XML
		try {
			Writer writer = new FileWriter("resources/test/frase.xml");
			SignXMLWriter.writeXML(frase, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done");
	}

}
