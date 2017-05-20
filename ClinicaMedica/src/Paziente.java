import java.util.Vector;

public class Paziente {
	
	private String nome;
    private String cognome;
    private Vector<Appuntamento> storiaAppuntamenti;
     
    public Paziente(String nome, String cognome){
    	this.nome = nome;
    	this.cognome = cognome;
    }
    
    public String getNome(){
        return nome;
    }
     
    public String getCognome(){
        return nome;
    }
     
    public void setNome(String nome){
        this.nome = nome;
    }
     
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    
    public Vector<Appuntamento> getStoriaAppuntamenti(){
    	return storiaAppuntamenti;
    }
    
    public void prendiAppuntamento(){
    	
    }
    
    public String toString(){
    	return String.join(",", "Nome: " + nome, " Cognome: " + cognome );
    }
}
