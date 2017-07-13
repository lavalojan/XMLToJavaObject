package Task;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;



public class Selector {
	private String id;
	private List<Identifiers> identifiers;
 


	@XmlAttribute(name = "MSG_ID")
	String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "IDENTIFIERS")

	public List<Identifiers> getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(List<Identifiers> identifiers) {
		this.identifiers = identifiers;
	}
}