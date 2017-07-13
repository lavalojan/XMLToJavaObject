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

		// public void xmlToObject(){
		try {
			File file = new File(xmlFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(Msgs.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Msgs msgs = (Msgs) jaxbUnmarshaller.unmarshal(file);

			File file2 = new File(msgFile);
			JAXBContext jaxbContext2 = JAXBContext.newInstance(RdConfig.class);
			Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
			RdConfig rdConfig = (RdConfig) jaxbUnmarshaller2.unmarshal(file2);
			List<Selectors> se = rdConfig.getSelectors();
			FileReader fr = new FileReader(inputFile);
			int i = 0;
			BufferedReader br = new BufferedReader(fr);
			String sCurrentLine;
			// System.out.print(se.get(0).getSelector().get(0).getIdentifiers().get(0).getIdentifier().get(0).getstpos());

			List<Msg> listmsg = msgs.getmsg();
			int a = 0;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(rdConfig.getMsgIdforMatchingStr(sCurrentLine)+"testing");
				this.msgId=rdConfig.getMsgIdforMatchingStr(sCurrentLine);
				for (Selector s : se.get(0).getSelector()) {
					for (Identifier ident : s.getIdentifiers().get(0).getIdentifier()) {
						
//						if (Integer.parseInt(ident.getexpval()) == Integer.parseInt(sCurrentLine
//								.substring(Integer.parseInt(ident.getstpos()), Integer.parseInt(ident.getenmsg())))) {
//
//							//this.msgId = s.getId();
//							
//						}
						msgs.getMsgfromInput(sCurrentLine);
						for (Msg m : listmsg) {
							a = a + 1;
							//System.out.print(m.getId());
							List<Elements> list = m.getele();

							if (m.getId().equals(msgId)) {
								// hashmap.add(String.valueOf(i));
								HashMap<String, String> hm = new HashMap<String, String>();
								i = i + 1;

								for (Elements e : list) {
									try {
										hm.put(" " + e.getelname(),
												sCurrentLine.substring(Integer.parseInt(e.getstpos()), e.getenmsg()));
									} catch (Exception err) {
										error.add("line " + i + " " + e.getelname() + " " + e.getenmsg() + " "
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
							//hashmap.add(hm);

							
							// return hashmap;
						}
						
						msgId = null;

					}
				}
				
			}
			System.out.print(error);
		} catch (Exception err) {
			System.err.println(err);
			

		}
		return hashmap;
		
	}
	//return hashmap;
}
