package Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXBException;

public class Output {
	private String inputfile;
	public String printResult() throws NumberFormatException, JAXBException, IOException {
		ReadFile rf=new ReadFile();
		rf.setXmlFile("values.xml");
		rf.setMsgId("idSelector.xml");
		rf.setInputFile(inputfile);
		String out = "";
		
		ArrayList<HashMap> hashmap =rf.createhashmap();
		//System.out.println("\n"+hashmap);

		for (int n = 0; n < hashmap.size(); n++) {
			
			//System.out.println("line " + (n + 1) + ":");
			out+="line "+(n+1)+":\n";
			for (Object objname : hashmap.get(n).keySet()) {
				out+="		"+objname + " : ";
				out+=hashmap.get(n).get(objname)+"\n";
				//System.out.print(objname + " : ");
				//System.out.println(hashmap.get(n).get(objname));
				
			}
		}
		return out;
	}
	public String setInput(){
		return inputfile;
	}
	public void getInput(String file){
		this.inputfile=file;
	}

}
