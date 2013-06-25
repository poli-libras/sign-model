package br.usp.libras.xml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.usp.libras.sign.Sign;

/**
 * Writes a XML file for a list of Sign objects.
 * 
 * @author Leonardo Leite
 */
public class XMLWriter {
    
    /**
     * 
     * @param signs
     * @param writer
     * @throws JAXBException
     */
    public static void writeXML(List<Sign> signs, Writer writer) throws JAXBException {

    	SignList signList = new SignList(signs);
    	
        // create JAXB context , instantiate marshaller and write the XML
        JAXBContext context = JAXBContext.newInstance(SignList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(signList, writer);
    }
    
    /**
     * 
     * @param signs
     * @param fileName
     * @throws JAXBException
     * @throws IOException
     */
    public static void writeXMLFile(List<Sign> signs, String fileName) throws JAXBException, IOException {

    	SignList signList = new SignList(signs);
    	
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(SignList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // write to the file
        Writer writer = new FileWriter(fileName);
        marshaller.marshal(signList, writer);
        writer.close();
    }    
    
}
