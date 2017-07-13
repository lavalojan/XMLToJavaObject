package Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ReadFile {
	private String xmlFile;
	private String inputFile;
	private ArrayList<HashMap> hashmap;
	private String msgFile;
	private String msgId;

	public void setMsgId(String file) {
		this.msgFile = file;
	}

	public void setXmlFile(String file) {
		this.xmlFile = file;
	}

	public void setInputFile(String file) {
		this.inputFile = file;
	}

	public ArrayList<HashMap> createhashmap() throws JAXBException, NumberFormatException, IOException {
		ArrayList<HashMap> hashmap = new ArrayList<HashMap>();
		ArrayList<String> error = new ArrayList<String>();

		
		try {
			File file = new File(xmlFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(Msgs.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Msgs msgs = (Msgs) jaxbUnmarshaller.unmarshal(file);

			File file2 = new File(msgFile);
			JAXBContext jaxbContext2 = JAXBContext.newInstance(RdConfig.class);
			Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
			RdConfig rdConfig = (RdConfig) jaxbUnmarshaller2.unmarshal(file2);
			
			FileReader fr = new FileReader(inputFile);
			BufferedReader br = new BufferedReader(fr);
			
			
			String sCurrentLine;
			List<Msg> listmsg = msgs.getmsg();
			int a = 0;

			while ((sCurrentLine = br.readLine()) != null) {
				a=a+1;
				this.msgId=rdConfig.getMsgIdforMatchingStr(sCurrentLine);
						for (Msg m : listmsg) {
							List<Element> list = m.getelements().get(0).getElement();
							if (msgId.equals(m.getId())) {
								HashMap<String, String> hm = new HashMap<String, String>();

								for (Element e : list) {
									try {
										hm.put(" " + e.getelname(),
												sCurrentLine.substring(Integer.parseInt(e.getstpos()), e.getenmsg()));
									} catch (Exception err) {
										error.add("line " + a + " " + e.getelname() + " " + e.getenmsg() + " "
												+ e.getstpos());
										System.out.println(err);
									}
								}
								if(hashmap.contains(hm)){
									
								}
								else{
									hashmap.add(hm);
								}
							}
						}				
						msgId = null;		
			}
			System.out.print(error);
			
		} catch (Exception err) {
			System.err.println(err);
		}
		return hashmap;		
	}

}
