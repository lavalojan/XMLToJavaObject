package Task;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RD_CONFIG")
public class RdConfig {
	private List<Selectors> selectors;
	String msgId;
	int n;
	
	public String getMsgIdforMatchingStr(String sLine){
		this.msgId="";
		for (Selector s : selectors.get(0).getSelector()) {
			n=0;
			for (Identifier ident : s.getIdentifiers().get(0).getIdentifier()) {
				
				if (Integer.parseInt(ident.getexpval()) == Integer.parseInt(sLine
						.substring(Integer.parseInt(ident.getstpos()), Integer.parseInt(ident.getenmsg())))) {
					n=n+1;
					if(n==s.getIdentifiers().get(0).getIdentifier().size()){
						this.msgId = s.getId();
					}
					
					
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

