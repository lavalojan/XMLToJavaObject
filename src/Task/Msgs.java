package Task;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MSGS")
public class Msgs {
	RdConfig rdconfig=new RdConfig();
	String keymsg;
	private List<Msg> msgs;
	
	public String getMsgfromInput(String sLine){
		for (Msg m : msgs){
			for(Elements ele :m.getelements()){
				//if( m.getId().equals(rdconfig.getMsgIdforMatchingStr(sLine))){
					//keymsg=sLine.substring(Integer.parseInt(ele.getstpos()), ele.getenmsg());
				//}
					
				
			}
		}
		return keymsg;
	}
	
	@XmlElement(name = "MSG")
	public List<Msg> getmsg() {
		return msgs;
	}

	public void setmsg(List<Msg> msgs) {
		this.msgs = msgs;
	}

}
