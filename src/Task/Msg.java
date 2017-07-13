package Task;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;



public class Msg {
	private String id;
	private List<Elements> elements;
 
	public Msg() {
	}

	public Msg(String id, List<Elements> elements) {
		super();
		this.id = id;
		this.elements = elements;
	}

	@XmlAttribute(name = "id")
	String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "ELEMENTS")

	public List<Elements> getelements() {
		return elements;
	}

	public void setelements(List<Elements> elements) {
		this.elements = elements;
	}
}