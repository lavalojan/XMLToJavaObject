package Task;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXBException;

public class Output {
	private String inputfile;
	private String idSelector;
	private String values;
	// public ArrayList<HashMap> printResult() throws NumberFormatException,
	// JAXBException, IOException {
	// ReadFile rf=new ReadFile();
	// rf.setXmlFile(values);
	// rf.setMsgId(idSelector);
	// rf.setInputFile(inputfile);
	// ArrayList<HashMap> hashmap =rf.createhashmap();
	// return hashmap;
	// }

	public String setInput() {
		return inputfile;
	}

	public void getInput(String file) {
		this.inputfile = file;
	}

	public void setValue(String val) {
		this.values = val + "FileFormat.xml";
	}

	public void setidSelector(String idSelector) {
		this.idSelector = idSelector + "FileSelector.xml";
	}

}
