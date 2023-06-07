package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando{

	private static final String MESSAGGIO_CON_CHI =
			"Con chi dovrei interagire?...";
	private String messaggio;

	@Override
	public void esegui(Partita p) {
		AbstractPersonaggio personaggio;
		personaggio = p.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(p);
			getIo().mostraMessaggio(this.messaggio);

		} else getIo().mostraMessaggio(MESSAGGIO_CON_CHI);
	}

	public String getMessaggio() {
		return this.messaggio;
	}

}
