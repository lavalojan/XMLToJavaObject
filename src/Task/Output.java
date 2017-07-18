package Task;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXBException;

public class Output {
	private String inputfile;
	public ArrayList<HashMap> printResult() throws NumberFormatException, JAXBException, IOException {
		ReadFile rf=new ReadFile();
		rf.setXmlFile("values.xml");
		rf.setMsgId("idSelector.xml");
		rf.setInputFile(inputfile);
		ArrayList<HashMap> hashmap =rf.createhashmap();
		return hashmap;
	}
	public String setInput(){
		return inputfile;
	}
	public void getInput(String file){
		this.inputfile=file;
	}

}
