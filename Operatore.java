package logica_5;

import java.io.Serializable;

import dominio_5.Categoria;
import dominio_5.Risorsa;

/**
 * Questa classe rappresenta il modello di un Operatore
 */
public class Operatore extends Utente implements Serializable
{
	private static final long serialVersionUID = 1L;

	/**
     * Metodo costruttore della classe Operatore
     * @param n : nome dell'operatore
     * @param c : cognome dell'operatore
     * @param u : username dell'operatore
     * @param p : password dell'operatore
     */
    public Operatore(String n, String c, String u, String p)
    {
   	     super(n, c, u, p);
    }
    
    /**
     * Metodo che permette la visualizzazione dell'elenco di Fruitori con relative caratteristiche
     * 
     * @pre : e != null
     * 
     * @param e : l'oggetto indicato dove e' depositato il Vector di Fruitori su cui poter invocare il metodo toString()
     * @return la stringa descrittiva dell'anagrafica dei fruitori
     */
    public String visualizzaElencoFruitori(AnagraficaFruitori e)
    {
   	     return e.toString();
    }
    
    /**
     * Metodo che permette l'aggiunta di una risorsa ad una (sotto)categoria dell'archivio
     * 
     * @pre: (r != null) && (s != null) && !(r in s) 
     * @post: r in s
     * 
     * @param r: la risorsa da aggiungere
     * @param s: la (sotto)categoria a cui aggiungere la risorsa
     */
    public void aggiungiRisorsaCategoria(Risorsa r, Categoria s)
    {
    	    s.aggiungiRisorsa(r);
    }
    
    /**
     * Metodo che permette la rimozione di una risorsa da una (sotto)categoria dell'archivio
     * 
     * @pre: (r != null) && (s != null) && (r in s)
     * @post: !(r in s)
     * 
     * @param r: la risorsa da rimuovere
     * @param s: la (sotto)categoria da cui rimuovere la risorsa
     */
    public void rimuoviRisorsaCategoria(Risorsa r, Categoria s)
    {
    	    s.rimuoviRisorsa(r);
    }
    
    /**
     * Metodo che consente la visualizzazione del contenuto dell'archivio
     * 
     * @pre: a != null
     * 
     * @param a: l'archivio da visualizzare
     * @return la stringa descrittiva del contenuto dell'archivio
     */
    public String visualizzaArchivio(Archivio a)
    {
    	     return a.toString();
    }
    
    /**
     * Metodo che consente la visualizzazione del numero di prestiti per un
     * dato anno
     * 
     * @pre: as != null
     * 
     * @param as: l'archivio storico
     * @param anno: l'anno di cui visualizzare il numero di prestiti
     * @return il numero di prestiti durante anno
     */
    public int visualizzaPrestitiPerAnno(ArchivioStorico as, int anno)
    {
    	     return as.numeroPrestitiPerAnno(anno);
    }
    
    /**
     * Metodo che consente la visualizzazione del numero di proroghe per un
     * dato anno
     * 
     * @pre: as != null
     * 
     * @param as: l'archivio storico
     * @param anno: l'anno di cui visualizzare il numero di proroghe
     * @return il numero di proroghe durante anno
     */
    public int visualizzaProroghePerAnno(ArchivioStorico as, int anno)
    {
	     	return as.numeroProroghePerAnno(anno);
    }
    
    /**
     * Metodo che consente la visualizzazione del titolo della risorsa col maggior
     * numero di prestiti in un anno
     * 
     * @pre: as != null
     * 
     * @param as: l'archivio storico
     * @param anno: l'anno 
     * @return il titolo della risorsa con più prestiti durante anno
     */
    public String visualizzaRisorsaPiuRichiesta(ArchivioStorico as, int anno)
    {
    	
    	     return as.getRisorsaPiuRichiesta(anno);
    }
    
    /**
     * Metodo che consente la visualizzazione del numero di prestiti per un
     * fruitore per un dato anno
     * 
     * @pre: (as != null) && (f != null)
     * 
     * @param as: l'archivio storico
     * @param f: il fruitore di cui visualizzare il numero di prestiti
     * @param anno: l'anno 
     * @return il numero di prestiti per il fruitore f durante anno
     */
    public int visualizzaNumeroPrestitiPerFruitorePerAnno(ArchivioStorico as, Fruitore f, int anno)
    {
    	     return as.numeroPrestitiPerFruitorePerAnno(f, anno);
    }
    
}