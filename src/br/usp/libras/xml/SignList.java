package br.usp.libras.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.usp.libras.sign.Sign;

/**
 * Encapsula uma lista de sinais para ser manipulada pelo JAXB
 * @author leonardo
 *
 */
@XmlRootElement(namespace = "br.usp.libras.xml")
@XmlAccessorType(XmlAccessType.FIELD) 
class SignList {

	private List<Sign> signs;

	public SignList() {
	}
	
	public SignList(List<Sign> signs) {
		this.signs = signs;
	}

	public List<Sign> getSigns() {
		return signs;
	}

	public void setSigns(List<Sign> signs) {
		this.signs = signs;
	} 
}
