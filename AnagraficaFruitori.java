package logica_5;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Questa classe contiene i dati dei vari fruitori e permette il controllo e la verifica di specifiche condizioni necessarie per il mantenimento e l'aggiornamento dei dati
 */
public class AnagraficaFruitori extends Anagrafica implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	public static final String INTESTAZIONE_ELENCO = "Elenco degli attuali fruitori: \n";
    public static final String ANAGRAFICA_VUOTA = "Al momento non sono presenti fruitori.\n";
	
    /**
     * Metodo costruttore della classe AnagraficaFruitori
     * 
     * @post : elenco != null
     */    
    public AnagraficaFruitori()
    {
   	    super();
    }
    
    /**
     * Metodo che restituisce il fruitore avente lo username uguale a quello passato come parametro 
     * altrimenti null
     * @param usef : username del fruitore
     * @return il fruitore con username usef altrimenti null
     */
    public Fruitore getFruitore(String usef)
    {
      	for(int i = 0; i < elenco.size(); i++)
	    {
	    	  Fruitore f = (Fruitore) elenco.get(i);
	    	  
	    	  if(f.getUsername().equals(usef))
	    			   return f;
	    }
	    
	    return null;
    }
    
    /**
     * Metodo che permette l'aggiunta di un fruitore all'elenco dei fruitori
     * 
     * @pre: (f != null) && !(elenco.contains(f)
     * @post : elenco.contains(f)
     * 
     * @param f : l'oggetto fruitore che si desidera aggiungere
     */
    public void aggiungiFruitore(Fruitore f)  
    {
   	    elenco.add(f);
    }
    
	/**
	 * Metodo che verifica se il fruitore che intende iscriversi e' in realta' gia' iscritto all'applicazione
	 * 
	 * @pre : (elenco != null) && (dn != null)
	 * 
	 * @param n : nome del fruitore
	 * @param c : cognome del fruitore
	 * @param dn : data di nascita del fruitore
	 * @return boolean : true se il fruitore con nome n, cognome c e data di nascita dn e' in realta' gia' iscritto
	 */
	public boolean verificaPresenza(String n, String c, LocalDate dn) 
	{
		for (int i = 0; i < elenco.size(); i++) 
		{
			Fruitore f = (Fruitore) elenco.get(i);

			if ((f.getNome()).equalsIgnoreCase(n) && (f.getCognome().equalsIgnoreCase(c))
					&& (f.getDataDiNascita().isEqual(dn)))
				return true;
		}

		return false;
	}
    
    /**
     * Metodo che verifica se il fruitore che intende iscriversi ha lo stesso username di almeno uno dei fruitori gia' iscritti
     * 
     * @pre : elenco != null
     * 
     * @param u : username del nuovo fruitore
     * @return boolean : true se la condizione di uguaglianza e' verificata
     */
    public boolean verificaStessoUsername(String u) 
    {
   	    for(int i = 0; i < elenco.size() ; i++)
   	    {
   	       Fruitore f = (Fruitore) elenco.get(i);
   	    	   
   	    	   if((f.getUsername()).equals(u))
   	    		      return true;
   	    }
   	    
   	    return false;
    }
   
    /**
     * Metodo che verifica se la data corrente sia successiva rispetto alla data di scadenza del servizio prevista per uno specifico fruitore;
     * in tal caso procede con la rimozione del suddetto fruitore dall'elenco dei fruitori iscritti
     * 
     * @pre : elenco != null
     * @post : elenco.contains(f) == false
     * 
     * @param as : l'archivio storico
     */
    public void decadenzaFruitore(ArchivioStorico as)
    {
   	 	for(int i = 0; i < elenco.size() ; i++)
   	 	{
   	 		Fruitore f = (Fruitore) elenco.get(i);	
   	 		
   	 	    if ((LocalDate.now().equals(f.getDataDiScadenza())) || (LocalDate.now().isAfter(f.getDataDiScadenza())))
   	 	    {
   	 	    	elenco.remove(f);
   	 	    	as.getDecadenzeFruitoriStoriche().aggiungiFruitore(f);
   	 	    }
   	 	}
	   
    }
    
    /**
     * Metodo toString() ereditato dalla classe String per la creazione di una stringa descrittiva contenente l'elenco ordinato dei vari fruitori
     * 
     * @pre : elenco != null
     * 
     * @return la stringa descrittiva
     */    
    public String toString()		
    {
   	    StringBuffer ris = new StringBuffer();
   	    
   	    if(elenco.size() == 0)
   	    {
   	    	ris.append(ANAGRAFICA_VUOTA);
   	    }
   	    else
   	    {
   	   	    ris.append(INTESTAZIONE_ELENCO);

   	   	    for(int i = 0; i < elenco.size(); i++)
   	   	    {
   	   	    	    Fruitore f = (Fruitore) elenco.get(i);
   	   	    	    ris.append(i+1 + ")" + f.toString() + "\n");
   	   	    }
   	    }

   	    return ris.toString();
    }
        
}
