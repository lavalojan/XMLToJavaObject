package Task;

import javax.xml.bind.annotation.XmlAttribute;

public class Selector_2 {

	private String id;
	private String name;

	public Selector_2() {
	}

	public Selector_2( String id, String name) {
		super();
		this.id = id;
		this.name = name;
	
	}

	@XmlAttribute(name = "NAME")
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	@XmlAttribute(name = "ID")
	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}



}