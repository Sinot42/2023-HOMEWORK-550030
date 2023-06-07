package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai extends AbstractComando{
	
	private final static String NOME = "vai";
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.getParametro() == null) {
			this.getIo().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		}
		if(this.getParametro()!=null )// && (Direzione.valueOf(this.getParametro()).getClass() != Direzione.class))
			try {
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
			} catch(IllegalArgumentException e) {
				this.getIo().mostraMessaggio("Direzione inesistente");
			}
			
			if (prossimaStanza == null) {
				this.getIo().mostraMessaggio("Direzione inesistente");
				return;
		}

		partita.setStanzaCorrente(prossimaStanza);
		getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
	}
	

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return NOME;
	}

}
