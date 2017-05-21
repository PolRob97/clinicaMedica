import java.io.FileNotFoundException;
import java.util.Vector;

import javax.xml.stream.XMLStreamException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		XMLReader reader = new XMLReader("clinica.xml");
		Vector<Paziente> listaPazienti = reader.getPazienti();
		Vector<Medico> listaMedici = reader.getMedici();
		Clinica clinica = new Clinica("Clinica di Qwertyteam", 
				listaPazienti, listaMedici);
		clinica.getTime();
		System.out.println(clinica.stampaPazienti());
		clinica.getTime();
		System.out.println(clinica.stampaMedici());
		clinica.getTime();
		
		
	}

}
