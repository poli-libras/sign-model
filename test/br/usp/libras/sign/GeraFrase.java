package br.usp.libras.sign;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.usp.libras.xml.XMLWriter;

/**
 * Gera a frase "VOCÊ OLHA FUTEBOL" em XMl e em forma serializada
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
			XMLWriter.writeXML(frase, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		// gera forma serializada
		
		try {
			FileOutputStream fos = new FileOutputStream("resources/test/frase.txt");
			ObjectOutputStream objw = new ObjectOutputStream(fos);
			Sign[] signs = frase.toArray(new Sign[0]);
			objw.writeObject(signs);
			objw.close();
			fos.close();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Done");
	}

}
