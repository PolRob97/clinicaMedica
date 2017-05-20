import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		Vector<Paziente> listaPazienti = new Vector<>();
		Paziente paziente = new Paziente("Roberto", "Poletti");
		Paziente paziente2 = new Paziente("Mario", "Rossi");
		Paziente paziente3 = new Paziente("Andrea", "Rossi");
		
		listaPazienti.add(paziente);
		listaPazienti.add(paziente2);
		listaPazienti.addElement(paziente3);
		Clinica clinica = new Clinica("Clinica di Qwertyteam", listaPazienti);
		System.out.println(clinica);
		System.out.println(clinica.stampaPazienti());
		//System.out.println(clinica.stampaMedici()); // TODO Implementare classe Medico
	}

}
