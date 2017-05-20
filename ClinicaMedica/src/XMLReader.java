import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Classe di utility XML per la lettura di clinica.xml, necessaria per aggregare
 * i dati nelle strutture Java apposite.
 * @author qwertyteam
 * @version 1.0
 */

public class XMLReader {
	
	private Vector<Medico> listaMedici;
	private Vector<Paziente> listaPazienti;
	private File filename;
	private final static String START_DOC = "Start reading XML code...";
	private final static String START_ANALYSIS_CLINIC = "Inizio ad analizzare la clinica medica...";
	private final static String START_ANALYSIS_DOCTORS = "Inizio ad analizzare i medici...";
	private final static String START_ANALYSIS_PATIENTS = "Inizio ad analizzare i pazienti...";
	private final static String PATH_ERROR = "There is a path error. Check if the file exists.";
	private final static String END_DOC = "End reading XML code...";
	
	/**
	 * Metodo per la lettura del file XML. Viene utilizzata per lo scopo la libreria
	 * StAX. 
	 * @param filename Nome del file da leggere
	 * @throws FileNotFoundException File non trovato nella directory
	 * @throws XMLStreamException Errore nella lettura dello stream XML
	 */
	
	public XMLReader(String filename) throws FileNotFoundException, XMLStreamException{
		try{
			this.filename = new File(filename);
		}catch(Exception e){
			System.out.println(PATH_ERROR);
			return;
		}
		
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(this.filename));
		listaMedici = new Vector<>();
		listaPazienti = new Vector<>();
		Medico medico = null;
		Paziente paziente = null;
		String data = "";
		
		while(reader.hasNext()){
			switch(reader.next()){
				case XMLStreamConstants.START_DOCUMENT:
					System.out.println(START_DOC);
					break;
					
				case XMLStreamConstants.START_ELEMENT:
					if("clinicaMedica".equals(reader.getLocalName())){
						System.out.println(START_ANALYSIS_CLINIC);
					}
					
					if("medici".equals(reader.getLocalName())){
						System.out.println(START_ANALYSIS_DOCTORS);
					}
					
					if("medico".equals(reader.getLocalName())){
						medico = new Medico();
					}
					
					if("pazienti".equals(reader.getLocalName())){
						System.out.println(START_ANALYSIS_PATIENTS);
					}
					
					if("paziente".equals(reader.getLocalName())){
						paziente = new Paziente();
					}
						
					break;
				
				case XMLStreamConstants.CHARACTERS:
					if(reader.getText().trim().length()>0){
						data= reader.getText().trim();
					}
					break;
					
				case XMLStreamConstants.END_ELEMENT:
					switch(reader.getLocalName()){
						case "medico" :
							listaMedici.add(medico);
							medico = null;
							break;
						case "paziente" :
							listaPazienti.add(paziente);
							paziente = null;
							break;
						case "nomeMedico":
							medico.setNome(data);
							break;
						case "cognomeMedico":
							medico.setCognome(data);
							break;
						case "id":
							medico.setID(Integer.parseInt(data));
							break;
						case "annoLaurea":
							//TODO Gestire tramite util la lettura di localDate
							//medico.setLaurea(LocalDate.of);
							break;
						case "nomePaziente":
							paziente.setNome(data);
							break;
						case "cognomePaziente":
							paziente.setCognome(data);
							break;
					}
				case XMLStreamConstants.END_DOCUMENT:
					System.out.println(END_DOC);
					break;
				
			}
		}
	}
	
	/**
	 * Metodo che restituisce la lista dei medici analizzata dal file XML. 
	 * @return Lista dei medici
	 */
	
	public Vector<Medico> getMedici(){
		return listaMedici;
	}
	
	/**
	 * Metodo che restituisce la lista dei pazienti analizzata dal file XML. 
	 * @return Lista dei pazienti
	 */
	
	public Vector<Paziente> getPazienti(){
		return listaPazienti;
	}
}
