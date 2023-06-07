package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{

	@Override
	public void esegui(Partita p) {
		if(p.getStanzaCorrente().getPersonaggio()!=null) {
			getIo().mostraMessaggio(p.getStanzaCorrente().getPersonaggio().saluta());
		}
		else {
			getIo().mostraMessaggio("Non c'è nessun personaggio in questa stanza!");
		}
	}
	
	
	
}
