package Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.JAXBException;

public class Output {
	public void printResult() throws NumberFormatException, JAXBException, IOException {
		ReadFile rf=new ReadFile();
		rf.setXmlFile("question.xml");
		rf.setInputFile("input.txt");
		rf.setMsgId("msgId.xml");
		ArrayList<HashMap> hashmap =rf.createhashmap();
		System.out.println("\n"+hashmap);

		for (int n = 0; n < hashmap.size(); n++) {
			
			System.out.println("line " + (n + 1) + ":");
			for (Object objname : hashmap.get(n).keySet()) {

				System.out.print(objname + " : ");
				System.out.println(hashmap.get(n).get(objname));
				
			}
		}
	}

}
