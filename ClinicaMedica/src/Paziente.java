import java.util.Vector;

/**
 * Classe che rappresenta il concetto di paziente ospedaliero.  
 * @author qwertyteam
 * @version 1.0
 */

public class Paziente {
	
	private String nome;
    private String cognome;
    private Vector<Appuntamento> storiaAppuntamenti;
    
    /**
     * Costruttore vuoto della classe Paziente. 
     */
    
    public Paziente (){
	
    }
    
    /**
     * Secondo costruttore della classe paziente. Da utilizzare se si è già in possesso
     * del nominativo del nuovo paziente. 
     * @param nome Nome del paziente
     * @param cognome Cognome del paziente
     */
    
    public Paziente(String nome, String cognome){
    	this.nome = nome;
    	this.cognome = cognome;
    }
    
    /**
     * Metodo che permette di restituire il nome del paziente. 
     * @return Nome del paziente
     */
    
    public String getNome(){
        return nome;
    }
    
    /**
     * Metodo che permette di restituire il cognome del paziente.
     * @return Cognome del paziente
     */
    
    public String getCognome(){
        return nome;
    }
     
    /**
     * Metodo che permette di impostare il nome del paziente.
     * @param nome Nome da impostare del paziente
     */
    
    public void setNome(String nome){
        this.nome = nome;
    }
     
    /**
     * Metodo che permette di impostare il cognome del paziente.
     * @param cognome Cognome da impostare del paziente
     */
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    
    /**
     * Metodo che permette di restituire lo storico degli appuntamenti presi
     * dal paziente. 
     * @return Storico degli appuntamenti
     */
    
    public Vector<Appuntamento> getStoriaAppuntamenti(){
    	return storiaAppuntamenti;
    }
    
    /**
     * Metodo che permette di consultare la clinica per determinare se è possibile 
     * prendere appuntamento presso un certo medico ad una determinata data.
     * @param clinica Clinica medica ospitante
     * @param medico Medico 
     * @param appuntamento Appuntamento da prendere
     */
    
    public void prendiAppuntamento(Clinica clinica, Medico medico, Appuntamento appuntamento){
    	if(clinica.controllaAppuntamento(medico, appuntamento))
    		storiaAppuntamenti.add(appuntamento);
    }
    
    /**
     * Metodo toString della classe paziente che restituisce le principali informazioni
     * riguardo ad esso.
     */
    
    public String toString(){
    	return String.join(",", "Nome: " + nome, " Cognome: " + cognome );
    }
}
