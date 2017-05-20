import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		XMLReader reader = new XMLReader("clinica.xml");
		Clinica clinica = new Clinica("Clinica di Qwertyteam", 
				reader.getPazienti(), reader.getMedici());
		
		System.out.println(clinica);
		//System.out.println(clinica.stampaPazienti());
		//System.out.println(clinica.stampaMedici()); // TODO Implementare classe Medico
	}

}
