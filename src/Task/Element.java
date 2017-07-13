package Task;

import javax.xml.bind.annotation.XmlAttribute;

public class Element {
	private int enmsg;
	private String stpos;
	private String elname;

	public Element() {
	}

	public Element(int enmsg, String stpos, String elname) {
		super();
		this.enmsg = enmsg;
		this.stpos = stpos;
		this.elname = elname;
	}

	@XmlAttribute(name = "ENMSG")
	public int getenmsg() {
		return enmsg;
	}

	public void setenmsg(int enmsg) {
		this.enmsg = enmsg;
	}

	@XmlAttribute(name = "ST_POS")
	public String getstpos() {
		return stpos;
	}

	public void setstpos(String stpos) {
		this.stpos = stpos;
	}

	@XmlAttribute(name = "EL_NAME")
	public String getelname() {
		return elname;
	}

	public void setelname(String elname) {
		this.elname = elname;
	}

}