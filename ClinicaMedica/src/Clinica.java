import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Classe che rappresenta il concetto di Clinica medica. È progettata attualmente per 
 * poter gestire gli appuntamenti tra pazienti e medici.
 * @author qwertyteam
 * @version 0.1
 */

public class Clinica implements Interfaccia{
	private String nomeClinica;
	private Vector<Double> tempi;
	private Vector<Medico> listaMedici;
	private Vector<Paziente> listaPazienti;
	
	private final static String LISTA_PAZIENTI_INFO = "La lista dei pazienti presenti in clinica:";
	private final static String LISTA_MEDICI_INFO = "La lista dei medici presenti in clinica:";
	
	public Clinica(String nomeClinica, Vector <Paziente> listaPazienti, Vector<Medico> listaMedici){
		this.nomeClinica = nomeClinica;
		this.listaPazienti = listaPazienti;
		this.listaMedici = listaMedici;
	}
	
	/**
	 * Metodo per modificare il nome della clinica medica.
	 * @param nome Nuovo nome per la clinica
	 */
	
	public void setNomeClinica(String nome){
		this.nomeClinica = nome;
	}
	
	/**
	 * Metodo per cercare un medico nella lista della clinica tramite ID.
	 * @param ID ID del medico da cercare
	 * @return Il medico che soddisfa il criterio di ricerca.
	 */
	
	public Medico cercaMedico(int ID){
		for(Medico medico : listaMedici){
			if(medico.getID() == ID){
				return medico;
			}
		}
		return null;
	}
	
	/**
	 * Metodo per controllare la possibilità di aggiungere un appuntamento richiesto
	 * dal paziente ad una data ora con un dato medico. Se la possibilità c'è, aggiungi
	 * l'appuntamento alla lista.
	 * @param m Medico richiesto per l'appuntamento
	 * @param inizio Data d'inizio (solitamente ora d'inizio)
	 * @param fine Data di fine (solitamente ora di fine)
	 * @return Vero se c'è la disponibilità da parte del medico, falso altrimenti
	 */
	
	/*public boolean controllaAppuntamento(Medico m, LocalDateTime inizio, LocalDateTime fine){
		boolean isDoctorExists = false;
		for(Medico medico : listaMedici){
			if(medico.equals(m)){
				isDoctorExists = true;
				break;
			}
		}
		
		if(!isDoctorExists)
			return false;
		Vector<Appuntamento> listaAppuntamentiMedico = m.getOrarioAppuntamenti()
				.get(inizio.getYear() + inizio.getMonth().getValue() + inizio.getDayOfMonth());
		
		for(Appuntamento appuntamento : listaAppuntamentiMedico){
			if(Util.checkifOccupied(appuntamento.getInizio(), appuntamento.getFine(), inizio, fine)){
				System.out.println("Occupato!");
				return false;
			}
		} 
		
		return true;
	}*/
	
	/**
	 * Metodo che restituisce tutti gli appuntamenti di un dato giorno.
	 * @param data Data per il filtro degli appuntamenti.
	 * @return Lista degli appuntamenti filtrati
	 */
	
	public Vector<Appuntamento> stampaAppuntamentiDatoGiorno(LocalDateTime data){
		return null;
	}
	
	/**
	 * Metodo che permette di stampare gli orari di tutti i medici.
	 * @return Lista di tutti gli orari di tutti i medici.
	 */
	
	public Vector<LocalDateTime> stampaOrariMedici(){
		
		return null;
	}

	
	/**
	 * Metodo toString per la rappresentazione visuale dello stato della clinica.
	 * @return Stato della clinica
	 */
	
	public String toString(){
		return String.join("\n", nomeClinica, stampaPazienti());
	}
	
	/**
	 * Metodo che permette di stampare tutta lista dei medici che lavorano nella clinica.
	 * @return Stringa che mostra a schermo la lista di tutti i medici
	 */
	
	@Override
	public String stampaMedici() {
		StringBuilder sb = new StringBuilder();
		sb.append(LISTA_MEDICI_INFO).append("\n");
		
		for(Medico medico : listaMedici){
			sb.append(medico.toString() + "\n");
		}
		return sb.toString();
	}
	
	/**
	 * Metodo che permette di restituire gli orari lavorativi di un dato medico.
	 * @return Lista contenente gli orari lavorativi, suddivisi anche in base alle 
	 * pause lavorative.
	 */
	
	@Override
	public TreeMap<Integer, Vector<LocalDateTime>> stampaOrari(Medico m) {
		for(Medico medico : listaMedici){
			if(m.equals(medico)){
				return m.getOrariFissi();
			}
		}
		return null;
	}
	
	/**
	 * Metodo che permette di restituire gli appuntamenti (compresi gli orari) di un
	 * dato medico dato il suo ID.
	 * @return Lista degli appuntamenti di un dato medico  
	 */
	
	@Override
	public TreeMap<Integer, Vector<LocalDateTime>> stampaAppuntamenti(int ID) {
		for(Medico medico: listaMedici)
			if(medico.getID() == ID){
				medico.getOrarioAppuntamenti();
			}
		
		return null;
	}

	/**
	 * Metodo che permette di stampare la lista di tutti i pazienti presenti attualmente
	 * in clinica.
	 * @return Lista di tutti i pazienti in clinica 
	 */
	
	@Override
	public String stampaPazienti() {
		StringBuilder sb = new StringBuilder();
		sb.append(LISTA_PAZIENTI_INFO).append("\n");
		for(Paziente paziente : listaPazienti){
			sb.append(paziente.toString() + "\n");
		}
		return sb.toString();
	}

	/**
	 * Metodo che permette di stampare il numero di appuntamenti in clinica presenti in
	 * un certo intervallo di tempo.
	 * @return Numero di appuntamenti 
	 */
	
	/**
	 * Metodo che permette di stampare il delay tra un'attività della clinica e l'altra.
	 * Deve tenere informato l'utente anche delle attività precedenti effettuate e 
	 * stampare ogni delay a schermo. 
	 */
	
	@Override
	public void getTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Appuntamento> stampaAppuntamenti(LocalDate inizio, LocalDate fine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String stampaNumAppuntamenti(int matricola) {
		// TODO Auto-generated method stub
		return null;
	}
}
