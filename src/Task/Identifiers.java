package Task;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

//import javax.xml.bind.annotation.XmlElement;



public class Identifiers {

	private List<Identifier> identifier;
 


	@XmlElement(name = "IDENTIFIER")

	public List<Identifier> getIdentifier() {
		return identifier;
	}

	public void setIdentifier(List<Identifier> identifier) {
		this.identifier = identifier;
	}
}