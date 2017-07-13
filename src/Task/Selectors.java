package Task;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;



public class Selectors {
	//private String id;
	private List<Selector> selector;
 


	@XmlElement(name = "SELECTOR")

	public List<Selector> getSelector() {
		return selector;
	}

	public void setSelector(List<Selector> selector) {
		this.selector = selector;
	}
}