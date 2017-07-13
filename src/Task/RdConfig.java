package Task;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RD_CONFIG")
public class RdConfig {
	private List<Selectors> selectors;
	String msgId;
	
	
	public String getMsgIdforMatchingStr(String sLine){
		
		for (Selector s : selectors.get(0).getSelector()) {
			for (Identifier ident : s.getIdentifiers().get(0).getIdentifier()) {
				
				if (Integer.parseInt(ident.getexpval()) == Integer.parseInt(sLine
						.substring(Integer.parseInt(ident.getstpos()), Integer.parseInt(ident.getenmsg())))) {

					this.msgId = s.getId();
					
				}
			}
		}	
		return msgId;
	}

	
	@XmlElement(name = "SELECTORS")
	public List<Selectors> getSelectors() {
		return selectors;
	}

	public void setSelectors(List<Selectors> selectors) {
		this.selectors = selectors;
	}

}

