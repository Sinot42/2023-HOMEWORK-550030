package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{

	@Override
	public void esegui(Partita p) {
		Attrezzo attrezzo = p.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		getIo().mostraMessaggio(p.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, p));
		p.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
	}
	
}
