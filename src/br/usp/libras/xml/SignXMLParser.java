package br.usp.libras.xml;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.usp.libras.sign.Sign;

/**
 * Reads an XML file and returns a Sign object list
 * 
 * @author leonardo
 *
 */
public class SignXMLParser {
	
	public static List<Sign> parseXML(Reader reader) throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(SignList.class);		
		Unmarshaller um = context.createUnmarshaller();
		SignList signList = (SignList) um.unmarshal(reader);
		return signList.getSigns();
	}

	public static List<Sign> parseXMLFile(String fileName) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(SignList.class);		
		Unmarshaller um = context.createUnmarshaller();
		Reader reader = new FileReader(fileName);
		SignList signList = (SignList) um.unmarshal(reader);
		reader.close();
		return signList.getSigns();
	}

}
