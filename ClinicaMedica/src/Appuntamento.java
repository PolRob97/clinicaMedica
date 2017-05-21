import java.time.LocalDateTime;

public class Appuntamento {
	private static final String INIZIO = "Inizio appuntamento: ";
	private static final String FINE = "Fine appuntamento: ";
	private static final String URGENZA = "Livello urgenza: ";
	public enum Urgenza {
		ROSSO,
		GIALLO,
		NERO,
		MARRONE,
	}
	private Urgenza urgenza;
	private LocalDateTime inizio;
	private LocalDateTime fine;
	
	public Appuntamento(){
		
	}
	
	public Appuntamento (Urgenza urgenza, LocalDateTime inizio, LocalDateTime fine){
		this.urgenza = urgenza;
		this.inizio = inizio;
		this.fine = fine;
	}
	
	public LocalDateTime getInizio(){
		return inizio;
	}
	
	public LocalDateTime getFine(){
		return fine;
	}
	
	public Urgenza getUrgenza(){
		return urgenza;
	}
	
	public String toString(){
		StringBuffer descrizione = new StringBuffer();
		descrizione.append(INIZIO+inizio+FINE+fine+URGENZA+urgenza);
		return descrizione.toString();
	}
	

}
