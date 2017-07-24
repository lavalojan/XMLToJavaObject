package Task;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SELECTORS")
public class Selectors_2 {

	private List<Selector_2> selector_2;

	
	@XmlElement(name = "SELECTOR")
	public List<Selector_2> getselector_2() {
		return selector_2;
	}

	public void setselector_2(List<Selector_2> selector_2) {
		this.selector_2 = selector_2;
	}

}
