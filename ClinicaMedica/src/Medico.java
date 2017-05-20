import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TreeMap;
import java.util.Vector;

public class Medico {
	private String nome;
	private final String MD_OCCUPATO = "Il medico "+ nome +" � occupato in tale occasione";//adesso lo sistemo
	private String cognome;
	private int ID;
	private LocalDate annoLaurea;
	private LocalDate annoAssunzione;
	private Vector<Appuntamento> appuntamenti;
	private TreeMap<Integer, Vector<Appuntamento>> orariAppuntamenti;
	//private Vector<LocalDateTime> fissi;
	private TreeMap<Integer, Vector<LocalDateTime>> orariFissi;
	
	public Medico(){
		
	}
	
	public Medico(String nome, String cognome, LocalDate annoLaurea, LocalDate annoAssunzione){
		this.nome = nome;
		this.cognome = cognome;
		this.annoLaurea = annoLaurea;
		this.annoAssunzione = annoAssunzione;
		this.appuntamenti = new Vector<>();
		this.orariAppuntamenti = new TreeMap<Integer, Vector<Appuntamento>>();
		//this.fissi = new Vector<>();
		this.orariFissi = new TreeMap<Integer, Vector<LocalDateTime>>();
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setCognome(String cognome){
		this.cognome = cognome;
	}
	public void setID(int id){
		this.ID = id;
	}
	public void setLaurea(LocalDate giorno){
		this.annoLaurea = giorno;
	}
	public void setAssunzione(LocalDate assunzione){
		this.annoAssunzione = assunzione;
	}

	public boolean getAppuntamenti(Appuntamento ap){//Added inizio and fine respect to the UML to verify if the doctor is free
		if(orariAppuntamenti.get(ap.getInizio())==null){
			appuntamenti.add(ap);//Volendo aggiunge l'appuntamento direttamente qua anziche farlo fare alla clinica
			return true;
		}
		else{
			System.out.println(MD_OCCUPATO);
			return false;
		}
	}
	public String getNome(){
		return nome;
	}
	public String getCognome(){
		return cognome;
	}
	public int getID(){
		return ID;
	}
	public LocalDate getAnnoLaurea(){
		return annoLaurea;
	}
	public LocalDate getAnnoAssunzione(){
		return annoAssunzione;
	}
	public TreeMap<Integer, Vector<Appuntamento>> getOrarioAppuntamenti(){
		return orariAppuntamenti;
	}
	public TreeMap<Integer, Vector<LocalDateTime>> getOrariFissi(){
		return orariFissi;
	}
	
	public String toString(){
		StringBuilder desc_medico = new StringBuilder();
		desc_medico.append("Nome: "+nome+"\nCognome: "+cognome+"\nID: "+ID+"\nAnno laurea: "+annoLaurea+"\nAnno assunzione: "+annoAssunzione);
		return desc_medico.toString();
	}

	public boolean equals(Medico medico) {
		if(medico == null)
			return false;
		if(this == medico)
			return true;
		if(ID == medico.ID && nome.equals(medico.nome) && cognome.equals(medico.cognome))
			return true;
		return false;
	}
	
	
}
