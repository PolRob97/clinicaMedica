import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Vector;

import javax.xml.stream.XMLStreamException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		XMLReader reader = new XMLReader("clinica.xml");
		Vector<Paziente> listaPazienti = reader.getPazienti();
		Vector<Medico> listaMedici = reader.getMedici();
		Clinica clinica = new Clinica("Clinica di Qwertyteam", 
				listaPazienti, listaMedici);
		
		System.out.println(clinica);
		
		Paziente paziente = listaPazienti.get(0);
		/*Medico medico = listaMedici.get(0);
		Appuntamento appuntamento1 = new Appuntamento(Appuntamento.Urgenza.MARRONE,
				LocalDateTime.of(2017, 5, 22, 17, 30),LocalDateTime.of(2017, 5, 22, 18, 30));
		Vector<Appuntamento> listaAppuntamentiMedico = new Vector<>();
		listaAppuntamentiMedico.add(appuntamento1);
		medico.orariAppuntamenti.put(appuntamento1.getInizio().getYear()+ appuntamento1.getInizio()
		.getMonth().getValue() + appuntamento1.getInizio().getDayOfMonth(), listaAppuntamentiMedico);
		
		Appuntamento appuntamento = new Appuntamento(Appuntamento.Urgenza.MARRONE,
				LocalDateTime.of(2017, 5, 22, 17, 30),LocalDateTime.of(2017, 5, 22, 18, 30)) ;
		
		paziente.prendiAppuntamento(clinica, medico, appuntamento);*/
		
	}

}
