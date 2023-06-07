package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io;

	public DiaDia(Labirinto l,IO io) {
		this.partita = new Partita(l);
		this.io=io;
	}
	
	public void gioca() throws Exception {
		String istruzione; 
		//		Scanner scannerDiLinee;
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			istruzione = io.leggiRiga();

		}while (!processaIstruzione(istruzione) );

	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 * @throws Exception 
	 */
	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva(this.io);
		try {
			comandoDaEseguire = factory.costruisciComando(istruzione);
		} catch (NullPointerException npe) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		}
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}

	// implementazioni dei comandi dell'utente:

	
	/**
	 * Stampa informazioni di aiuto.
	 */
	/**
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/**
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println(partita.getGiocatore().getBorsa().toString());
	}

	/**
	 * Comando "Fine".
	 */
	/**
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	/**
	 * Comando "Prendi"
	 * si occupa di prendere un attrezzo nella stanza corrente e di aggiungerlo alla borsa
	 */
	/**
	public void prendi(String nomeAttrezzo) {
		Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo)==null) {
			System.out.println("non puoi prendere niente");
		}
		else {
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);
			this.partita.getStanzaCorrente().removeAttrezzo(a);
			System.out.println("oggetto preso e messo nella borsa");
		}
	}


	/**
	 * Comando "Posa"
	 * si occupa di posare l'attrezzo che hai nella borsa nella stanza corrente
	 * @param argc
	 */
	/**
	public void posa(String nomeAttrezzo) {
		Attrezzo a=this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo)==null) {
			System.out.println("non puoi posare niente");
		}else {
			this.partita.getStanzaCorrente().addAttrezzo(a);
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			System.out.println("oggetto posato nella stanza");
		}
	}
	*/
	

	public static void main(String[] argc) throws Exception {
		Scanner scanner = new Scanner(System.in);
		IO io = new IOConsole(scanner);
		Labirinto labirinto =  Labirinto.newBuilder("labirinto5.txt").getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();
	}


}
