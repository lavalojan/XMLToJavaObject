package Task;

import javax.xml.bind.annotation.XmlAttribute;

public class Identifier {
	private String enmsg;
	private String stpos;
	private String expval;

	public Identifier() {
	}

	public Identifier(String enmsg, String stpos, String expval) {
		super();
		this.enmsg = enmsg;
		this.stpos = stpos;
		this.expval = expval;
	}

	@XmlAttribute(name = "ENMSG")
	public String getenmsg() {
		return enmsg;
	}

	public void setenmsg(String enmsg) {
		this.enmsg = enmsg;
	}

	@XmlAttribute(name = "ST_POS")
	public String getstpos() {
		return stpos;
	}

	public void setstpos(String stpos) {
		this.stpos = stpos;
	}

	@XmlAttribute(name = "EXP_VALUE")
	public String getexpval() {
		return expval;
	}

	public void setexpval(String expval) {
		this.expval = expval;
	}

}