package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Giocatore giocatore;
	private boolean finita;
	private Stanza stanzaCorrente;
	
	public Partita(Labirinto l){
		this.labirinto=l;
		giocatore=new Giocatore();
		this.finita = false;
		this.stanzaCorrente=labirinto.getIngresso();
	}
	
	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaCorrente=stanza;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**setter e getter LABIRINTO */
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto=labirinto;
	}
	
	public Labirinto getLabirinto() {
		return labirinto;
	}
	
	/**setter e getter GIOCATORE*/
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	public Giocatore getGiocatore() {
		return giocatore;
	}


	
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente== labirinto.getUscita();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public boolean giocatoreIsVivo() {
		// TODO Auto-generated method stub
		return this.giocatore.getCfu()>0;
	}


	
}

