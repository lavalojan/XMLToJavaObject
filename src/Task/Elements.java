package Task;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;



public class Elements {
	//private String id;
	private List<Element> element;
 


	@XmlElement(name = "ELEMENT")

	public List<Element> getElement() {
		return element;
	}

	public void setElement(List<Element> element) {
		this.element = element;
	}
}