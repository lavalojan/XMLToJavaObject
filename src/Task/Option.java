package Task;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Option {
	HashMap<String, Object> hamap = new HashMap<String, Object>();

	public HashMap<String, Object> selectOption() throws JAXBException {

		File file = new File("files/Finder.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Selectors_2.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Selectors_2 selectors_2 = (Selectors_2) jaxbUnmarshaller.unmarshal(file);

		for (Selector_2 se2 : selectors_2.getselector_2()) {

			hamap.put(se2.getid(), se2.getname());
		}
		return hamap;

	}
}
