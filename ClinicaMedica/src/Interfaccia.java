import java.util.TreeMap;
import java.util.Vector;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Interfaccia {
	public String stampaMedici();
	public TreeMap<Integer, Vector<LocalDateTime>> stampaOrari(Medico m);
	public TreeMap<Integer, Vector<LocalDateTime>> stampaAppuntamenti(int ID);
	public String stampaPazienti();
	public Vector<Appuntamento> stampaAppuntamenti(LocalDate inizio, LocalDate fine);
	public String stampaNumAppuntamenti(int matricola);
	public void getTime();
}
